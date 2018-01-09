package ru.qa.java.addressbook.model;

public class GroupDate {
  private int id = Integer.MAX_VALUE;;
  private String name;
  private String header;
  private String footer;

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public int getId() {
    return id;
  }
  public String getFooter() {
    return footer;
  }

  public GroupDate withId(int id) {
    this.id = id;
    return this;
  }

  public GroupDate withName(String name) {
    this.name = name;
    return this;
  }

  public GroupDate withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupDate withFooter(String footer) {
    this.footer = footer;
    return this;
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

    if (id != groupDate.id) return false;
    return name != null ? name.equals(groupDate.name) : groupDate.name == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
