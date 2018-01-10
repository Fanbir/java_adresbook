package ru.qa.java.addressbook.model;

public class ContactDate {
  private  String firstName;
  private  String lastName;
  private  String address;
  private  String email;
  private  String mobilePhone;
  private  String workPhone;
  private  String homePhone;
  private int id =  Integer.MAX_VALUE;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactDate that = (ContactDate) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + id;
    return result;
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

  public String getMobilePhone() {
    return mobilePhone;
  }
  public String getWorkPhone() {
    return workPhone;
  }
  public String getHomePhone() {
    return homePhone;
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

  public ContactDate withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }
  public ContactDate withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactDate withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
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
