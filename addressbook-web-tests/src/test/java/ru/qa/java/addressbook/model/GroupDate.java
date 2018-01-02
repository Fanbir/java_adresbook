package ru.qa.java.addressbook.model;

public class GroupDate {
  private final String name;
  private int id;
  private final String header;
  private final String footer;

  public GroupDate(int id, String name, String header, String footer) {
    this.name = name;
    this.id = id;
    this.header = header;
    this.footer = footer;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }


  public String getFooter() {
    return footer;
  }

  @Override
  public String toString() {
    return "GroupDate{" +
            "name='" + name + '\'' +
            ", id=" + id +
            '}';
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupDate groupDate = (GroupDate) o;

    return name != null ? name.equals(groupDate.name) : groupDate.name == null;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

  public GroupDate(String name, String header, String footer) {
    this.name = name;
    this.id = Integer.MAX_VALUE;
    this.header = header;
    this.footer = footer;
  }
}
