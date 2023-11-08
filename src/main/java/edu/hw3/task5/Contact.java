package edu.hw3.task5;

public class Contact {
    private String firstName;
    private String lastName;

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Contact(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        if (lastName != null) {
            return lastName;
        }
        return getFirstName();
    }

    public String toString() {
        if (lastName != null) {
            return firstName + " " + lastName;
        } else {
            return firstName;
        }
    }
}
