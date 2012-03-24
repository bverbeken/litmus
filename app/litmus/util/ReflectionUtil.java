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
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;


/**
 * Utility class for reflection (get and set state on and from an object or class)
 *
 * @author Ben Verbeken
 */
public class ReflectionUtil {

	private static final Map<String, Class<?>> primitives = new HashMap<String, Class<?>>();

	static {
		primitives.put("boolean", java.lang.Boolean.class);
		primitives.put("char", java.lang.Character.class);
		primitives.put("byte", java.lang.Byte.class);
		primitives.put("short", java.lang.Short.class);
		primitives.put("int", java.lang.Integer.class);
		primitives.put("long", java.lang.Long.class);
		primitives.put("float", java.lang.Float.class);
		primitives.put("double", java.lang.Double.class);
		primitives.put("void", java.lang.Void.class);
	}

	@SuppressWarnings("unchecked")
	public static <T> T get(String fieldName, Object object) {
		try {
			Field field = findFieldInClassHierarchy(object.getClass(), fieldName);
			field.setAccessible(true);
			return (T) field.get(object);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void set(Object object, String fieldName, Object value) {
		try {
			assertFieldOnClass(object.getClass(), fieldName);
			Field field = findFieldInClassHierarchy(object.getClass(), fieldName);
			field.setAccessible(true);
			field.set(object, value);
		} catch (Exception e) {
			throw new RuntimeException("failed to set value " + e);
		}
	}


	@SuppressWarnings("unchecked")
	public static <T> T getStaticFieldValue(String fieldName, Class<?> clazz) {
		try {
			Field field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			return (T) field.get(clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static Field findFieldInClassHierarchy(Class<?> clazz, String fieldName) {
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

	private static boolean hasField(Class clazz, String fieldName) {
		return findFieldInClassHierarchy(clazz, fieldName) != null;
	}

	public static Class<?> getDeclaredFieldType(Class clazz, String field) {
		return getDeclaredField(clazz, field).getType();
	}

	public static Class<?> getDeclaredFieldTypeWithoutPrimitives(Class<?> clazz, String fieldName) {
		try {
			Class<?> type = clazz.getDeclaredField(fieldName).getType();
			return type.isPrimitive() ? primitives.get(type.getCanonicalName()) : type;
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		}
	}

	private static void assertFieldOnClass(Class clazz, String field) {
		assertTrue(
				"Class '" + clazz.getCanonicalName() + "' nor its superclasses have a declared field called '" + field + "'",
				hasField(clazz, field));
	}


	public static Number getTypedNumber(String number, Class<?> fieldType) {
		try {
			if (fieldType.equals(Number.class)) {
				return 0;
			} else if (primitives.values().contains(fieldType)) {
				Method valueOfMethod = fieldType.getDeclaredMethod("valueOf", String.class);
				return (Number) valueOfMethod.invoke(fieldType, number);
			} else if (fieldType.equals(BigInteger.class)) {
				return new BigInteger(number);
			} else if (fieldType.equals(BigDecimal.class)) {
				return new BigDecimal(number);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		throw new RuntimeException("Can't determine value [" + number + "] for type [" + fieldType + "]");
	}
}
