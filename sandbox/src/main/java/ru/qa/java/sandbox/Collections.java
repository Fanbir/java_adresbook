package ru.qa.java.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {

//    String[] langs = {"Java", "C#", "Python", "Ruby"};
    // <можно не указывать>
    // в итерации Object
    List<String> languages = Arrays.asList("Java", "C#", "Python", "Ruby");

    for (String l: languages) {
      System.out.println("я хочу выучить " + l);
    }

//    for (int i = 0; i < languages.size(); i++) {
//      System.out.println("я хочу выучить " + languages.get(i));
//    }

//    List<String> languages = new ArrayList<String>();
//    languages.add("JAva");
//    languages.add("C#");
//    languages.add("Python");



//    for (String l: langs) {
//      System.out.println("я хочу выучить " + l);
//    }

//    for (int i = 0; i < langs.length; i++) {
//      System.out.println("я хочу выучить " + langs[i]);
//    }
//
//    вариант объявления
//    String[] langs = new String[4];
//    langs[0] = "Java";
//    langs[1]= "С#";
//    langs[2]= "Python";
//    langs[3]= "Ruby";
//    String[] langs = {"Java", "C#", "Python", "Ruby"};

  }
}
