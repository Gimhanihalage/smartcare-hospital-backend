// File: oopconcept/Person.java
package com.smartcare.hospital.oopconcept;

// ABSTRACTION: Abstract class - cannot be instantiated directly, defines a common template for subclasses
public abstract class Person {
    // ENCAPSULATION: Private fields hidden from outside access
    private String firstName;
    private int age;
    private String gender;
    private String phone;
    private String address;

    // ENCAPSULATION: Constructor initializes private fields safely
    public Person(String firstName, int age, String gender, String phone, String address) {
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    // ENCAPSULATION: Public getter for private field 'firstName'
    public String getFirstName() {
        return firstName;
    }

    // ENCAPSULATION: Public setter for private field 'firstName'
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // ENCAPSULATION: Public getter for private field 'age'
    public int getAge() {
        return age;
    }

    // ENCAPSULATION: Public setter for private field 'age'
    public void setAge(int age) {
        this.age = age;
    }

    // ENCAPSULATION: Public getter for private field 'gender'
    public String getGender() {
        return gender;
    }

    // ENCAPSULATION: Public setter for private field 'gender'
    public void setGender(String gender) {
        this.gender = gender;
    }

    // ENCAPSULATION: Public getter for private field 'phone'
    public String getPhone() {
        return phone;
    }

    // ENCAPSULATION: Public setter for private field 'phone'
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // ENCAPSULATION: Public getter for private field 'address'
    public String getAddress() {
        return address;
    }

    // ENCAPSULATION: Public setter for private field 'address'
    public void setAddress(String address) {
        this.address = address;
    }

    // ABSTRACTION + POLYMORPHISM: Abstract method - subclasses MUST override this,
    // enabling dynamic method dispatch at runtime based on actual object type
    public abstract void displayDetails();
}