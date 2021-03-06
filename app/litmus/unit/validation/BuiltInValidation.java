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

/**
 * An enum containing all validation annotations that are available in Play 1.2.4.
 */
public enum BuiltInValidation {


	EMAIL("email"),
	EQUALS("equals"),
	IN_FUTURE("future"),
	AFTER("after"),
	IN_PAST("past"),
	BEFORE("before"),
	IP_V4_ADDRESS("ipv4"),
	IP_V6_ADDRESS("ipv6"),
	IS_TRUE("isTrue"),
	MATCH("match"),
	MAX("max"),
	MAX_SIZE("maxSize"),
	MIN("min"),
	MIN_SIZE("minSize"),
	PHONE("phone"),
	RANGE("range"),
	REQUIRED("required"),
	UNIQUE("unique"),
	URL("url"),
	VALID("object");


	private final String messageSuffix;

	BuiltInValidation(String messageSuffix) {
		this.messageSuffix = messageSuffix;
	}


	public String getMessageKey() {
		return "validation." + messageSuffix;
	}

}
