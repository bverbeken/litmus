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

import java.util.Date;

import static java.lang.System.currentTimeMillis;

/**
 * An enum containing all validation annotations that are available in Play 1.2.4.
 */
public enum BuiltInValidation {


	EMAIL("email") {
		@Override
		public Object getInvalidValue(Object... args) {
			return "this is not a valid email address";
		}
	},
	// EQUALS("equals"),
	IN_FUTURE("future") {
		@Override
		public Object getInvalidValue(Object... args) {
			return new Date(currentTimeMillis() - 100);
		}
	},
	AFTER("after") {
		@Override
		public Object getInvalidValue(Object... args) {
			throw new UnsupportedOperationException("not implemented! [" + this + "]");
		}
	},
	IN_PAST("past") {
		@Override
		public Object getInvalidValue(Object... args) {
			return new Date(currentTimeMillis() + 100);
		}
	},
	BEFORE("before") {
		@Override
		public Object getInvalidValue(Object... args) {
			throw new UnsupportedOperationException("not implemented! [" + this + "]");
		}
	},
	IP_V4_ADDRESS("ipv4") {
		@Override
		public Object getInvalidValue(Object... args) {
			return "this is not a valid ipv4 address";
		}
	},
	IP_V6_ADDRESS("ipv6"),
	IS_TRUE("isTrue") {
		@Override
		public Object getInvalidValue(Object... args) {
			return false;
		}
	},
	MATCH("match"),
	MAX("max"),
	MAX_SIZE("maxSize"),
	MIN("min"),
	MIN_SIZE("minSize"),
	// PASSWORD --> what is this used for? Not for validation, I guess..?
	PHONE("phone") {
		public Object getInvalidValue(Object... args) {
			return "this is not a valid phone";
		}
	},
	RANGE("range"),
	REQUIRED("required"),
	UNIQUE("unique"),
	URL("url") {
		public Object getInvalidValue(Object... args) {
			return "not a url";
		}
	},
	VALID("object");


	private final String messageSuffix;

	BuiltInValidation(String messageSuffix) {
		this.messageSuffix = messageSuffix;
	}


	public String getMessageKey() {
		return "validation." + messageSuffix;
	}


	public Object getInvalidValue(Object... args) {
		throw new UnsupportedOperationException("not implemented! [" + this + "]");
	}

}
