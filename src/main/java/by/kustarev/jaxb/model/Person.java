package by.kustarev.jaxb.model;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "lastName", "firstName", "birthDate" }, name = "person" )
public class Person {

    private String birthDate;
    private String lastName;
    private String firstName;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
