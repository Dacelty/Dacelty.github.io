package com.example.springOnTapDuLieu;

public class jsonArrayList {
    private String nationality;
    private long freq;

    public jsonArrayList() {
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public long getFreq() {
        return freq;
    }

    public void setFreq(long freq) {
        this.freq = freq;
    }

    public jsonArrayList(String nationality, long freq) {
        this.nationality = nationality;
        this.freq = freq;
    }
}
