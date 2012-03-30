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

package models;

import play.data.validation.Email;
import play.data.validation.MinSize;
import play.data.validation.Required;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;


public class Person {

	@Required
	public String firstName;

	@MinSize(4)
	public String lastName;

	@Email
	public String email;

	public Person(String firstName) {
		this(firstName, null);
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + "(" + email + ")";
	}

	@Override
	public boolean equals(Object that) {
		return reflectionEquals(this, that);
	}

	@Override
	public int hashCode() {
		return reflectionHashCode(this);
	}
}
