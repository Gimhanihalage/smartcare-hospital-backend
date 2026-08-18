// File: oopconcept/OopConceptRunner.java
package com.smartcare.hospital.oopconcept;

/*
 * ================================================================
 *  Task 07 - OOP Concepts Demonstration
 *  Run this file's main() method to see all 5 concepts proven
 *  using YOUR existing 11 classes working together:
 *
 *   1. ENCAPSULATION -> private fields + public getters/setters
 *                        in every class (Patient, Doctor, Room, ...)
 *   2. ASSOCIATION     -> Admission has Patient/Room/Bed,
 *                        Appointment has Patient/Doctor,
 *                        Department has List<Doctor>,
 *                        Room has List<Bed>, Bill has List<BillItem>
 *   3. INHERITANCE      -> Patient & Doctor extend abstract Person
 *   4. POLYMORPHISM      -> Person.displayDetails() overridden
 *                        differently by Patient and Doctor;
 *                        Payable.calculateTotal()/printBill()
 *                        implemented by Bill
 *   5. ABSTRACTION       -> abstract class Person, interface Payable
 * ================================================================
 */
public class OopConceptRunner {

    public static void main(String[] args) {

        System.out.println("=== 1. ENCAPSULATION proof ===");
        Patient patient = new Patient("Nimal Perera", 32, "Male", "0771234567",
                "Colombo", "PAT001", "O+", "Fever, cough");
        // bloodGroup is private - reachable only through getter
        System.out.println("Access only via getter -> " + patient.getBloodGroup());

        Department cardiology = new Department("DEP001", "Cardiology");
        Doctor doctor = new Doctor("Kamal Silva", 45, "Male", "0779876543",
                "Kandy", "DOC001", "Cardiologist", 3000.0);
        // ASSOCIATION: Department "has-a" list of Doctors
        cardiology.addDoctor(doctor);

        System.out.println("\n=== 3. INHERITANCE proof ===");
        // Both Patient and Doctor inherited these fields/getters from Person
        System.out.println(patient.getFirstName() + " age=" + patient.getAge() + " (inherited from Person)");
        System.out.println(doctor.getFirstName() + " age=" + doctor.getAge() + " (inherited from Person)");

        System.out.println("\n=== 4. POLYMORPHISM proof (Person.displayDetails) ===");
        // Same static type (Person), different runtime behaviour
        Person[] people = { patient, doctor };
        for (Person p : people) {
            p.displayDetails(); // resolves to Patient's or Doctor's own version
            System.out.println();
        }

        System.out.println("=== 5. ABSTRACTION proof ===");
        System.out.println("Person is abstract - cannot do 'new Person(...)' directly.");
        System.out.println("Payable interface hides HOW a bill total is calculated, only WHAT it returns.");

        System.out.println("\n=== 2. ASSOCIATION proof (Appointment, Room/Bed, Admission) ===");
        Appointment appointment = new Appointment("APT001", "2026-08-12", "10:30 AM",
                patient, doctor, "Confirmed");
        appointment.displayAppointment();

        Room room = new Room("R101", "Private", 5000.0);
        Bed bed = new Bed("B01", "Electric");
        room.addBed(bed); // ASSOCIATION: Room "has-a" list of Beds

        Admission admission = new Admission("ADM001", "2026-08-01", "2026-08-05",
                patient, room, bed, 4);
        admission.displayAdmission();
        System.out.println("Bed occupied after admission? " + bed.isOccupied());

        System.out.println("\n=== Treatment & Laboratory (more ASSOCIATION) ===");
        Treatment treatment = new Treatment("TRT001", "ECG Test", "2026-08-02", 2500.0,
                patient, doctor);
        treatment.displayTreatment();

        Laboratory labTest = new Laboratory("LAB001", "Blood Test", "2026-08-02", 1200.0,
                "Normal", patient);
        labTest.displayLabTest();

        System.out.println("\n=== 4. POLYMORPHISM proof (Payable via Bill) ===");
        Bill bill = new Bill("BILL001", "2026-08-05", patient, 5.0, 10.0);
        // ASSOCIATION (composition): Bill "has-a" list of BillItems
        bill.addBillItem(new BillItem("ITM001", "Room Charge", admission.calculateRoomCharge()));
        bill.addBillItem(new BillItem("ITM002", "ECG Test", treatment.getTreatmentCost()));
        bill.addBillItem(new BillItem("ITM003", "Blood Test", labTest.getTestCost()));
        bill.addBillItem(new BillItem("ITM004", "Doctor Consultation", doctor.getConsultationFee()));

        // POLYMORPHISM: calling the Payable contract - Bill decides HOW
        bill.printBill();

        System.out.println("\n=== Department -> Doctors (ASSOCIATION, one-to-many) ===");
        cardiology.displayDepartment();
    }
}