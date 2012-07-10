/*
 * Copyright 2012 Ben Verbeken
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package litmus.functional;

import play.mvc.Http;
import play.mvc.results.Result;

import java.util.HashMap;
import java.util.Map;

import static litmus.functional.HttpMethod.GET;
import static litmus.functional.HttpMethod.POST;
import static litmus.util.ReflectionUtil.getStaticFieldValue;

public class Request {

    private final Object url;
    private Map<String, String> params = new HashMap<String, String>();

    public Request(Object url) {
        this.url = url;
    }

    public Request with(String name, String value) {
        this.params.put(name, value);
        return this;
    }


    public Response get() {
        return wrapResponse(GET, url, new ResponseFetcher() {
            Http.Response fetch() {
                if (!params.isEmpty()) {
                    return play.test.FunctionalTest.GET(addParametersToUrl(url, params));
                }
                return play.test.FunctionalTest.GET(url);
            }
        });
    }

    private String addParametersToUrl(Object url, Map<String, String> params) {
        String result = url + "?";
        for (String key : params.keySet()) {
            result += key + "=" + params.get(key);
        }
        return result;
    }

    public Response post() {
        return wrapResponse(POST, url, new ResponseFetcher() {
            Http.Response fetch() {
                return play.test.FunctionalTest.POST(url, params);
            }
        });
    }

    public Response post(Map<String, String> parameters) {
        params.putAll(parameters);
        return post();
    }

    private static Response wrapResponse(HttpMethod httpMethod, Object request, ResponseFetcher fetcher) {
        Map<String, Object> renderArgs = getStaticFieldValue("renderArgs", play.test.FunctionalTest.class);
        return new Response(httpMethod, request, fetcher.fetchAndHandleException(), renderArgs);
    }


    private abstract static class ResponseFetcher {

        abstract Http.Response fetch();

        private Http.Response fetchAndHandleException() {
            try {
                return fetch();
            } catch (Exception e) {
                throw tryToFindNotFound(e);
            }
        }

        private static RuntimeException tryToFindNotFound(Throwable e) {
            if (e.getCause() != null) {
                if (e.getCause() instanceof Result) {
                    return (RuntimeException) e.getCause();
                } else {
                    return tryToFindNotFound(e.getCause());
                }
            } else {
                if (e instanceof RuntimeException) {
                    return (RuntimeException) e;
                } else {
                    return new RuntimeException(e);
                }
            }
        }
    }
}
