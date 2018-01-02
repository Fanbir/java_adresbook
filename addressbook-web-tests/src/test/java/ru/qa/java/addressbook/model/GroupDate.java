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

  public GroupDate( String name, String header, String footer) {
    this.name = name;
    this.id = 0;
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupDate groupDate = (GroupDate) o;

    if (id != groupDate.id) return false;
    return name != null ? name.equals(groupDate.name) : groupDate.name == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + id;
    return result;
  }

  @Override
  public String toString() {
    return "GroupDate{" +
            "name='" + name + '\'' +
            ", id=" + id +
            '}';
  }
}
