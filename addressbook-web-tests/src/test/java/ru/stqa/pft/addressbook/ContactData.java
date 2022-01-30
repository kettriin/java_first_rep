package ru.stqa.pft.addressbook;

import java.util.Objects;

public final class ContactData {
    private final String name;
    private final String middlename;
    private final String lastname;
    private final String company;
    private final String address;
    private final String mobilephonenum;
    private final String emailaddress;
    private final String birthday;
    private final String birthmonth;
    private final String birthyear;

    public ContactData(String name, String middlename, String lastname, String company, String address,
                       String mobilephonenum, String emailaddress, String birthday, String birthmonth,
                       String birthyear) {
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
        this.company = company;
        this.address = address;
        this.mobilephonenum = mobilephonenum;
        this.emailaddress = emailaddress;
        this.birthday = birthday;
        this.birthmonth = birthmonth;
        this.birthyear = birthyear;
    }

    public String name() {
        return name;
    }

    public String middlename() {
        return middlename;
    }

    public String lastname() {
        return lastname;
    }

    public String company() {
        return company;
    }

    public String address() {
        return address;
    }

    public String mobilephonenum() {
        return mobilephonenum;
    }

    public String emailaddress() {
        return emailaddress;
    }

    public String birthday() {
        return birthday;
    }

    public String birthmonth() {
        return birthmonth;
    }

    public String birthyear() {
        return birthyear;
    }

}