package model;

public class Person {

    private String lastName;
    private String firstName;
    private String middleName;

    public Person() {
        this.lastName = "";
        this.firstName = "";
        this.middleName = "";
    }

    public Person(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFullName() {
        return String.format("%s %s %s", lastName, firstName, middleName);
    }
}
