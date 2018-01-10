package ru.qa.java.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactDate> {

  private Set<ContactDate> delegate;

  public Contacts(Contacts contact) {
    this.delegate = new HashSet<ContactDate>(contact.delegate);
  }

  public Contacts() {
    this.delegate = new HashSet<>();
  }

  @Override
  protected Set<ContactDate> delegate() {
    return delegate;
  }

  public Contacts withAdded(ContactDate contact) {
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
}

  public Contacts withOut(ContactDate contact) {
    Contacts contacts = new Contacts(this);
    contacts.remove( contact);
    return contacts;
  }
}
