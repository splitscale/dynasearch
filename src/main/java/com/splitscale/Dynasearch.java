package com.splitscale;

import java.util.List;

public class Dynasearch<T> {
  Iterable<T> list;
  DynasearchEngine<T> engine;

  public Dynasearch(Class<T> clazz, Iterable<T> iterable) {
    list = iterable;

    PropertyAccessorGenerator<T> generator = new PropertyAccessorGenerator<>(clazz);
    List<PropertyAccessor<T>> propertyAccessors = generator.generate();
    engine = new DynasearchEngine<T>(list, propertyAccessors);
  }

  public List<T> search(String searchItem) {
    return engine.search(searchItem);
  }
}
