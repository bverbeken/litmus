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

public enum BuiltInValidation {

	/* TODO: add value for inverse of most of the built in validations so that a is() method is possible on FieldValidationAssert
	e.g. email -> invalid email, required -> null, past -> future date, is_true -> false, etc
	 */

	EMAIL,
	EQUALS,
	FUTURE,
	IS_TRUE("isTrue"),
	MATCH,
	MAX,
	MAX_SIZE("maxSize"),
	MIN,
	MIN_SIZE("minSize"),
	PAST,
	RANGE,
	REQUIRED,
	URL,
	PHONE,
	IP4ADDRESS("ipv4"),
	IP6ADDRESS("ipv6");

	private final String messageSuffix;

	BuiltInValidation() {
		this.messageSuffix = name().toLowerCase();
	}

	BuiltInValidation(String messageSuffix) {
		this.messageSuffix = messageSuffix;
	}


	public String getMessageKey() {
		return "validation." + messageSuffix;
	}
}
