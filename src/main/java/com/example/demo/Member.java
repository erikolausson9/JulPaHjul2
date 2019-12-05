package com.example.demo;

import java.util.ArrayList;

public class Member {
    private int id;
    private String anvandarNamn;
    private String losenord;
    private String emailAdress;

    private ArrayList<String> members = new ArrayList<>();

    public Member() {
    }

    public Member(String anvandarNamn, String losenord, String emailAdress) {
        this.anvandarNamn = anvandarNamn;
        this.losenord = losenord;
        this.emailAdress = emailAdress;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getAnvandarNamn() {
        return anvandarNamn;
    }

    public void setAnvandarNamn(String anvandarNamn) {
        this.anvandarNamn = anvandarNamn;
    }

    public String getLosenord() {
        return losenord;
    }

    public void setLosenord(String losenord) {
        this.losenord = losenord;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public void clearMemberList() {
        members.clear();
    }
}
