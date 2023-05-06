package com.splitscale;

class Person {
  private String firstName;
  private String lastName;
  private String jobTitle;

  public Person(String firstName, String lastName, String jobTitle) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.jobTitle = jobTitle;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getJobTitle() {
    return jobTitle;
  }
}
