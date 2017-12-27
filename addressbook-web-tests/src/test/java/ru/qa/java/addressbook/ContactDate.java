package ru.qa.java.addressbook;

public class ContactDate {
  private final String firstName;
  private final String lastName;
  private final String nickName;
  private final String company;
  private final String address;
  private final String work;
  private final String email;
  private final String mobile;
  private final String byEar;
  private final String address2;
  private final String notes;
  private final String phone2;

  public ContactDate(String firstName, String lastName, String nickName, String company, String address, String work, String email, String mobile, String byEar, String address2, String notes, String phone2) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.company = company;
    this.address = address;
    this.work = work;
    this.email = email;
    this.mobile = mobile;
    this.byEar = byEar;
    this.address2 = address2;
    this.notes = notes;
    this.phone2 = phone2;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getWork() {
    return work;
  }

  public String getEmail() {
    return email;
  }

  public String getMobile() {
    return mobile;
  }

  public String getByEar() {
    return byEar;
  }

  public String getAddress2() {
    return address2;
  }

  public String getNotes() {
    return notes;
  }

  public String getPhone2() {
    return phone2;
  }
}
