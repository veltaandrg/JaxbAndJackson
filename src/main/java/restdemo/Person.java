package restdemo;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Person {

    private String name;
    
    private int age;
    
    private List<Person> children;
    
    public Person() {
    }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    @XmlAttribute
    public void setAge(int age) {
        this.age = age;
    }
    
    public List<Person> getChildren() {
        return children;
    }
    
    @XmlElement(name = "child")
    public void setChildren(List<Person> list) {
        children = list;
    }
    
    @Override
    public String toString() {
        return String.format("(Person '%s' of age %d with %d children)", name, age,
            children != null ? children.size() : 0);
    }
}

