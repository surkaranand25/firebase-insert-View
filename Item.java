package com.example.fireinsert;

public class Item {
    String id;
    String name;
    String email;
    String contact;
    String spinner;
    String auto;
    String multi;

    public Item() {
    }

    public Item(String id, String name, String email, String contact, String spinner, String auto, String multi) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.spinner = spinner;
        this.auto = auto;
        this.multi = multi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSpinner() {
        return spinner;
    }

    public void setSpinner(String spinner) {
        this.spinner = spinner;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getMulti() {
        return multi;
    }

    public void setMulti(String multi) {
        this.multi = multi;
    }
}
