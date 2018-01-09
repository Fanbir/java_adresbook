package ru.qa.java.addressbook.model;

public class ContactDate {
  private  String firstName;
  private  String lastName;
  private  String address;
  private  String email;
  private  String phone2;
  private int id =  Integer.MAX_VALUE;

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

  public int getId() {
    return id;
  }

  public ContactDate withId(int id) {
    this.id = id;
    return this;
  }

  public ContactDate withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactDate withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactDate withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactDate withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactDate withPhone2(String phone2) {
    this.phone2 = phone2;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactDate that = (ContactDate) o;

    if (!firstName.equals(that.firstName)) return false;
    if (!lastName.equals(that.lastName)) return false;
    return address.equals(that.address);
  }

  @Override
  public int hashCode() {
    int result = firstName.hashCode();
    result = 31 * result + lastName.hashCode();
    result = 31 * result + address.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "ContactDate{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            ", id=" + id +
            '}';
  }
}
