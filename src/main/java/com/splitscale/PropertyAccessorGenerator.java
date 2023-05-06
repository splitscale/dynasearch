package com.splitscale;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PropertyAccessorGenerator<T> {
  private Class<T> clazz;

  public PropertyAccessorGenerator(Class<T> clazz) {
    this.clazz = clazz;
  }

  public List<PropertyAccessor<T>> generate() {
    List<PropertyAccessor<T>> propertyAccessors = new ArrayList<>();

    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      field.setAccessible(true);
      String fieldName = field.getName();
      PropertyAccessor<T> propertyAccessor = new FieldPropertyAccessor<>(fieldName);
      propertyAccessors.add(propertyAccessor);
    }

    return propertyAccessors;
  }
}
