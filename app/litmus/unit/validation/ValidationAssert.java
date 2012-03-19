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

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

public class ValidationAssert<T> extends GenericAssert<ValidationAssert, T> {

	protected ValidationAssert(T actual) {
		super(ValidationAssert.class, actual);
	}

	public ValidationAssert<T> isValid() {
		Assertions.assertThat(Validator.isValid(actual)).isTrue();
		return this;
	}

	public ValidationAssert<T> isInvalid() {
		Assertions.assertThat(Validator.isValid(actual)).isFalse();
		return this;
	}

	public ValidationAssert<T> isInvalidBecause(String fieldName, String error) {
		Assertions.assertThat(Validator.getErrorMessagesForField(fieldName)).contains(error);
		return this;
	}

	public ValidationAssert<T> isInvalidBecause(String fieldName, BuiltInValidation error) {
		return isInvalidBecause(fieldName, error.getMessageKey());
	}

}
