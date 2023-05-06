package com.splitscale;

import java.util.ArrayList;
import java.util.List;

public class DynasearchEngine<T> {
  private Iterable<T> iterable;
  private List<PropertyAccessor<T>> propertyAccessors;

  public DynasearchEngine(Iterable<T> iterable, List<PropertyAccessor<T>> propertyAccessors) {
    this.iterable = iterable;
    this.propertyAccessors = propertyAccessors;
  }

  public List<T> search(String text) {
    List<T> result = new ArrayList<>();
    String searchTextLower = text.toLowerCase();

    for (T item : iterable) {
      if (isMatch(item, searchTextLower)) {
        result.add(item);
      }
    }

    return result;
  }

  private boolean isMatch(T item, String searchTextLower) {
    for (PropertyAccessor<T> propertyAccessor : propertyAccessors) {
      String propertyValue = propertyAccessor.getPropertyValue(item);
      if (propertyValue != null && propertyValue.toLowerCase().contains(searchTextLower)) {
        return true;
      }
    }

    return false;
  }
}
