package com.splitscale;

public interface PropertyAccessor<T> {
  String getPropertyValue(T item);
}
