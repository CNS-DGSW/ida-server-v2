package com.daegusw.apply.core.excel.utils

import java.lang.reflect.Field

object SuperClassReflectionUtils {

    fun getAllFields(clazz: Class<*>): List<Field> {
        val fields = mutableListOf<Field>()
        for (clazzInClasses in getAllClassesIncludingSuperClasses(clazz, true)) {
            fields.addAll(clazzInClasses.declaredFields)
        }
        return fields
    }

    fun getAnnotation(clazz: Class<*>, targetAnnotation: Class<out Annotation>): Annotation? {
        for (clazzInClasses in getAllClassesIncludingSuperClasses(clazz, false)) {
            if (clazzInClasses.isAnnotationPresent(targetAnnotation)) {
                return clazzInClasses.getAnnotation(targetAnnotation)
            }
        }
        return null
    }

    fun getField(clazz: Class<*>, name: String): Field {
        for (clazzInClasses in getAllClassesIncludingSuperClasses(clazz, false)) {
            for (field in clazzInClasses.declaredFields) {
                if (field.name == name) {
                    return clazzInClasses.getDeclaredField(name)
                }
            }
        }
        throw NoSuchFieldException()
    }

    private fun getAllClassesIncludingSuperClasses(clazz: Class<*>, fromSuper: Boolean): List<Class<*>> {
        val classes = mutableListOf<Class<*>>()
        var currentClass: Class<*>? = clazz
        while (currentClass != null) {
            classes.add(currentClass)
            currentClass = currentClass.superclass
        }
        if (fromSuper) {
            classes.reverse()
        }
        return classes
    }
}
