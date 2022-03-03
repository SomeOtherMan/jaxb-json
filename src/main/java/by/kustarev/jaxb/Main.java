package by.kustarev.jaxb;

import by.kustarev.jaxb.model.Group;
import by.kustarev.jaxb.model.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {

    private static final String FILE_NAME = "./test.xml";

    private Group createJavaObject() {
        Group group = new Group();
        group.setName("firstGroup");
        group.getMembers().add(createPerson("Ivanov", "Ivan", "01/01/1970"));
        group.getMembers().add(createPerson("Alex", "Sik", "20/03/1980"));
        return group;
    }

    private Person createPerson(String lastName, String firstName, String birthDate) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setBirthDate(birthDate);
        return person;
    }

    private void marshall() {
        try {
            JAXBContext context = JAXBContext.newInstance(Group.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(createJavaObject(), new File(FILE_NAME));
        } catch (JAXBException e) {
            System.out.println("Something wrong while marshalling");
        }
    }

    private Group unmarshall() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Group.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Group) unmarshaller.unmarshal(new File(FILE_NAME));
    }

    public static void main(String[] args) throws JAXBException {
        Main instance = new Main();
        instance.marshall();
        System.out.println(instance.unmarshall());
        System.out.println("End!");
    }


}
