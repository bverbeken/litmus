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

package litmus.util;

import java.lang.reflect.Field;

import static org.junit.Assert.assertTrue;

@SuppressWarnings("unchecked")
public class ReflectionUtil {

	public static <T> T get(String fieldName, Object object) {
		try {
			Field field = findFieldInTheHierarchy(object.getClass(), fieldName);
			field.setAccessible(true);
			return (T) field.get(object);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void set(Object object, String fieldName, Object value) {
		try {
			assertFieldOnClass(object.getClass(), fieldName);
			Field field = findFieldInTheHierarchy(object.getClass(), fieldName);
			field.setAccessible(true);
			field.set(object, value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static Field findFieldInTheHierarchy(Class<?> clazz, String fieldName) {
		Field field = getDeclaredField(clazz, fieldName);
		while (field == null && clazz != Object.class) {
			clazz = clazz.getSuperclass();
			field = getDeclaredField(clazz, fieldName);
		}
		return field;
	}

	private static Field getDeclaredField(Class<?> clazz, String fieldName) {
		try {
			return clazz.getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			return null;
		}
	}

	public static boolean hasField(Class clazz, String fieldName) {
		return findFieldInTheHierarchy(clazz, fieldName) != null;
	}

	public static void assertFieldOnClass(Class clazz, String field) {
		assertTrue(
				"Class '" + clazz.getCanonicalName() + "' nor its superclasses have a declared field called '" + field + "'",
				hasField(clazz, field));
	}

	public static <T> T getStaticFieldValue(String fieldName, Class<?> clazz) {
		try {
			Field field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			return (T) field.get(clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
