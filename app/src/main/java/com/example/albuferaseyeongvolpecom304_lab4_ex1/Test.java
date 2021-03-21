package com.example.albuferaseyeongvolpecom304_lab4_ex1;

public class Test {

    private int testId;
    private int patientId;
    private int nurseId;
    private float BPL;
    private float BPH;
    private float temperature;

    public Test()
    {
    }

    public Test(int testId, int patientId, int nurseId, float BPL, float BPH, float temperature)
    {
        this.testId = testId;
        this.patientId = patientId;
        this.nurseId = nurseId;
        this.BPL = BPL;
        this.BPH = BPH;
        this.temperature = temperature;
    }

    public int getTestId() { return testId; }

    public void setTestId(int testId) { this.testId = testId; }

    public int getPatientId() { return patientId;}

    public void setPatientId(int patientId) { this.patientId = patientId; }

    public int getNurseId() { return nurseId; }

    public void setNurseId(int nurseId) { this.nurseId = nurseId; }

    public float getBPL() {return BPL; }

    public void setBPL(float BPL) { this.BPL = BPL; }

    public float getBPH() {return BPH;}

    public void setBPH(float BPH) { this.BPH = BPH; }

    public float getTemperature() { return temperature;}

    public void setTemperature(int temperature) { this.temperature = temperature;
    }
}