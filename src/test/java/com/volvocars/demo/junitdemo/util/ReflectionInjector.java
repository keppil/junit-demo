package com.volvocars.demo.junitdemo.util;

import java.lang.reflect.Field;

public class ReflectionInjector {

    /**
     * Uses Reflection to replace the field {@code fieldName} in {@code targetObject} with the new value {@code newFieldValue}.
     * 
     * @param targetObject
     *            The Object to operate on
     * @param fieldName
     *            The field to be manipulated
     * @param newFieldValue
     *            The new value for {@code fieldName}
     * @throws Exception
     */
    public static void injectField(Object targetObject, String fieldName, Object newFieldValue) throws Exception {
        Field field = getField(targetObject.getClass(), fieldName);
        field.setAccessible(true);
        field.set(targetObject, newFieldValue);
    }

    /**
     * Uses Reflection to replace the static field {@code fieldName} in {@code targetClass} with the new value {@code newFieldValue}.
     * 
     * @param targetClass
     *            The Class to operate on
     * @param fieldName
     *            The field to be manipulated
     * @param newFieldValue
     *            The new value for {@code fieldName}
     * @throws Exception
     */
    public static void injectField(Class<?> targetClass, String fieldName, Object newFieldValue) throws Exception {
        Field field = getField(targetClass, fieldName);
        field.setAccessible(true);
        field.set(null, newFieldValue);
    }

    private static Field getField(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException nsfe) {
            Class<?> superClass = clazz.getSuperclass();
            if (superClass == null) {
                throw nsfe;
            } else {
                return getField(superClass, fieldName);
            }
        }
    }
}
