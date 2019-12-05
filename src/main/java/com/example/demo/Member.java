package com.example.demo;

public class Member {
    private String anvandarNamn;
    private String losenord;
    private String emailAdress;

    public Member() {
    }

    public Member(String anvandarNamn, String losenord, String emailAdress) {
        this.anvandarNamn = anvandarNamn;
        this.losenord = losenord;
        this.emailAdress = emailAdress;
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
}
