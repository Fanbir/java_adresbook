package ru.qa.java.addressbook.model;

public class ContactDate {
  private final String firstName;
  private final String lastName;
  private final String address;
  private final String email;
  private final String phone2;
  private int id;


  public ContactDate(int id, String firstName, String lastName, String address, String email, String phone2) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.email = email;
    this.phone2 = phone2;
    this.id = id;
  }

  public ContactDate(String firstName, String lastName, String address, String email, String phone2) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.email = email;
    this.phone2 = phone2;
    this.id = Integer.MAX_VALUE;
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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
