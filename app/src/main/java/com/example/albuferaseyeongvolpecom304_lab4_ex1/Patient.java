package com.example.albuferaseyeongvolpecom304_lab4_ex1;

public class Patient {

    private int patientID;
    private String firstName;
    private String lastName;
    private String department;
    private int nurseID;
    private String room;

    public Patient()
    {

    }

    public Patient(int patientID, String firstName, String lastName, String department, int nurseID, String room){
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.nurseID = nurseID;
        this.room= room;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getNurseID() {
        return nurseID;
    }

    public void setNurseID(int nurseID) {
        this.nurseID = nurseID;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
