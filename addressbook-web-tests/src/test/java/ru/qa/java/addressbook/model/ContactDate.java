package ru.qa.java.addressbook.model;

public class ContactDate {
  private final String firstName;
  private final String lastName;
  private final String address;
  private final String email;
  private final String phone2;

  public ContactDate(String firstName, String lastName, String address,  String email, String phone2) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.email = email;
    this.phone2 = phone2;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone2() {
    return phone2;
  }
}
