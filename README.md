# dynasearch

Dynasearch is a Java module that provides a generic implementation for full-text search on any iterable collection. It allows users to search for text in one or more properties of the items in the collection.

## Features

- Perform full-text search on an iterable collection
- Search for text in one or more properties of the items
- Case-insensitive search
- Supports searching multiple terms within a property
- Easily customizable with property accessors

## Usage

1. Create an iterable collection of objects that you want to search.
2. Implement the `PropertyAccessor` interface to specify how to access the properties to be searched.
3. Create an instance of the `GenericTextSearch` class, passing in the iterable collection and the list of property accessors.
4. Use the `search` method to perform the search, providing the search text.
5. Receive the search results as a list of matching items.

Here's an example usage:

```java
public class Main {
    public static void main(String[] args) {
        // Sample data
        List<Person> people = Arrays.asList(
                new Person("John", "Doe", "Engineer"),
                new Person("Jane", "Smith", "Manager"),
                new Person("Bob", "Johnson", "Engineer"),
                new Person("Alice", "Doe", "Designer")
        );

        // Generate PropertyAccessors for Person class properties
        PropertyAccessorGenerator<Person> generator = new PropertyAccessorGenerator<>(Person.class);
        List<PropertyAccessor<Person>> propertyAccessors = generator.generatePropertyAccessors();

        // Create a GenericTextSearch instance
        GenericTextSearch<Person> search = new GenericTextSearch<Person>(people, propertyAccessors);

        // Perform a free-text search
        List<Person> searchResults = search.search("Doe");

        // Print the search results
        for (Person person : searchResults) {
            System.out.println(person.getFirstName() + " " + person.getLastName() + " - " + person.getJobTitle());
        }
    }
}

```

## Case Sensitivity

The search performed by Dynasearch is case-insensitive. Both the search text and the property values are converted to lowercase for comparison.
