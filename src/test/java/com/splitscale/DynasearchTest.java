package com.splitscale;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DynasearchTest {
  @Test
  public void search_ShouldReturnMatchingItems_WhenSearchingByFirstName() {
    // Arrange
    List<Person> people = Arrays.asList(
        new Person("John", "Doe", "Engineer"),
        new Person("Jane", "Smith", "Manager"),
        new Person("Bob", "Jason", "Engineer"),
        new Person("Alice", "Doe", "Designer"));

    Dynasearch<Person> dynasearch = new Dynasearch<Person>(Person.class, people);

    // Act
    List<Person> searchResults = dynasearch.search("John");

    // Assert
    assertEquals(1, searchResults.size());
    assertEquals("John", searchResults.get(0).getFirstName());
  }
}
