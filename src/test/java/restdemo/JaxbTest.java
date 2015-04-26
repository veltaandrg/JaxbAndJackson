package restdemo;

import java.util.*;
import java.io.*;
import org.junit.*;
import javax.xml.bind.*;

public class JaxbTest {
    
    private void xmlToOutput(Object o) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(o.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(o, System.out);
    }
    
    @Test
    public void testUnmarshal() throws JAXBException {
        String xml = "<person age=\"13\"><name>Dima Lihoy</name></person>";
        JAXBContext context = JAXBContext.newInstance(Person.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Person person = (Person) unmarshaller.unmarshal(new StringReader(xml));
        System.out.println(person);
    }

    @Test
    public void testMarshal() throws JAXBException {
        Person person = new Person();
        person.setName("Vova Vasin");
        person.setAge(8);
        xmlToOutput(person);
    }

    @Test
    public void testMarshalWithChildren() throws JAXBException {
        Person person = new Person();
        person.setName("Vova Vasin");
        person.setAge(8);
        List<Person> children = Arrays.asList(new Person("Katia", 3), new Person("Valya", 5));
        person.setChildren(children);
        xmlToOutput(person);
    }

}

