package testutil;

import java.lang.reflect.Field;

import static org.junit.Assert.assertTrue;

public class ReflectionUtil {

	@SuppressWarnings("unchecked")
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
}
