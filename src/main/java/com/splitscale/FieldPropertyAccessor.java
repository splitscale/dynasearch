package com.splitscale;

import java.lang.reflect.Field;

public class FieldPropertyAccessor<T> implements PropertyAccessor<T> {
  private String fieldName;

  public FieldPropertyAccessor(String fieldName) {
    this.fieldName = fieldName;
  }

  public String getPropertyValue(T item) {
    try {
      Field field = item.getClass().getDeclaredField(fieldName);
      field.setAccessible(true);
      Object value = field.get(item);
      return (value != null) ? value.toString() : null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}