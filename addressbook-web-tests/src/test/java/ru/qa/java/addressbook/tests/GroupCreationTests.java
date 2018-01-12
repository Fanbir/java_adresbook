package ru.qa.java.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.GroupDate;
import ru.qa.java.addressbook.model.Groups;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.AssertJUnit.assertEquals;

public class GroupCreationTests extends TestBase{

  @DataProvider
  public Iterator<Object[]> validGroupsFromXml() throws IOException {
//    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line!=null) {
        xml+=line;
//      String[] split = line.split(";");
//      list.add(new Object[] {new GroupDate().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupDate.class);
    List<GroupDate> groups = (List<GroupDate>) xstream.fromXML(xml);
    return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  }

  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")));
    String json = "";
    String line = reader.readLine();
    while (line!=null) {
      json+=line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<GroupDate> groups = gson.fromJson(json, new TypeToken<List<GroupDate>>(){}.getType());
    return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validGroupsFromJson")
  public void testGroupCreation(GroupDate group) {
    app.goTo().GroupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().сount(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

//  @Test
//  public void testBadGroupCreation() {
//    app.goTo().GroupPage();
//    Groups before = app.group().all();
//    GroupDate group = new GroupDate().withName("test2'");
//    app.group().create(group);
//    assertThat(app.group().сount(), equalTo(before.size()));
//    Groups after = app.group().all();
//    assertThat(after, equalTo(before));
//  }
}
