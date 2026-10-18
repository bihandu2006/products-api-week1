package uk.ac.westminster.products_api;


public class Person {

    private String name;
    private String email; // New email field

    public Person() {
    }

    public Person(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // New getter for email
    public String getEmail() {
        return email;
    }
}



