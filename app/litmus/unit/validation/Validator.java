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

package litmus.unit.validation;

import play.data.validation.Error;
import play.data.validation.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static play.data.validation.Validation.ValidationResult;
import static litmus.util.ReflectionUtil.get;

class Validator {

	public static boolean isValid(Object actual) {
		return validate(actual).ok;
	}

	public static List<String> getErrorsForField(Object actual, String fieldName) {
		validate(actual);
		return getErrorMessagesForField(fieldName);
	}

	private static ValidationResult validate(Object actual) {
		Validation.clear();
		return Validation.current().valid(actual);
	}

	public static List<String> getErrorMessagesForField(String field) {
		List<String> result = new ArrayList<String>();
		List<play.data.validation.Error> errors = Validation.current().errorsMap().get("." + field);
		if (errors != null && !errors.isEmpty()) {
			for (Error error : errors) {
				result.add(getErrorKey(error));
			}
		}
		return result;
	}

	private static String getErrorKey(Error error) {
		return get("message", error);
	}

	public static Map<String, List<Error>> getAllErrors() {
		return Validation.current().errorsMap();
	}
}
