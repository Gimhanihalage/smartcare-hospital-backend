// File: oopconcept/Payable.java
package com.smartcare.hospital.oopconcept;

// ABSTRACTION: Interface defines a contract without implementation details
public interface Payable {
    // ABSTRACTION: Abstract method signature, no body - implementing class must define behavior
    double calculateTotal();

    // ABSTRACTION: Abstract method signature
    void printBill();
}