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

package controllers;

import play.mvc.Controller;

@SuppressWarnings("UnusedDeclaration")
public class CookieController extends Controller {

	public static final boolean SECURE = true;
	public static final boolean INSECURE = false;

	public static void foo() {
		response.setCookie("foo", "bar", "localhost", "", 3600, false, true);
	}

	public static void secure() {
		response.setCookie("secure", "contentIsNotImportant", "not important", "not important", 3600, SECURE, true);
	}

	public static void insecure() {
		response.setCookie("insecure", "contentIsNotImportant", "not important", "", 3600, INSECURE, true);
	}

}
