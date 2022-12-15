package com.bank.bank_of_lebanon;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Client {

    private int accNb;
    private SimpleStringProperty firstname;
    private SimpleStringProperty lastname;
    private SimpleStringProperty email;
    private SimpleStringProperty telephone;
    private SimpleStringProperty address;
    private SimpleStringProperty job;
    private SimpleStringProperty city;
    private SimpleStringProperty married;
    private SimpleStringProperty gender;
    private SimpleStringProperty birthdate;
    private SimpleStringProperty today;

    Client(){
        this.accNb = accNb;
        this.firstname = new SimpleStringProperty();
        this.lastname = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.telephone = new SimpleStringProperty();
        this.address = new SimpleStringProperty();
        this.job = new SimpleStringProperty();
        this.city = new SimpleStringProperty();
        this.married = new SimpleStringProperty();
        this.gender = new SimpleStringProperty();
        this.birthdate = new SimpleStringProperty();
        this.today = new SimpleStringProperty();
    }
    public Client(int accNb,
                  String firstname,
                  String lastname,
                  String email,
                  String telephone,
                  String address,
                  String job,
                  String city,
                  String married,
                  String gender,
                  String birthdate,
                  String today
                  ) {

        this.accNb = accNb;
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.email = new SimpleStringProperty(email);
        this.telephone = new SimpleStringProperty(telephone);
        this.address = new SimpleStringProperty(address);
        this.job = new SimpleStringProperty(job);
        this.city = new SimpleStringProperty(city);
        this.married = new SimpleStringProperty(married);
        this.gender = new SimpleStringProperty(gender);
        this.birthdate = new SimpleStringProperty(birthdate);
        this.today = new SimpleStringProperty(today);
    }

    public String getBirthdate() {
        return birthdate.get();
    }

    public SimpleStringProperty birthdateProperty() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate.set(birthdate);
    }

    public int getAccNb() {
        return accNb;
    }

    public void setAccNb(int accNb) {
        this.accNb = accNb;
    }

    public String getFirstname() {
        return firstname.get();
    }

    public SimpleStringProperty firstnameProperty() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }
    public String getLastname() {
        return lastname.get();
    }

    public SimpleStringProperty lastnameProperty() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }


    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }
    public void setEmail(String email) {
        this.email.set(email);
    }


    public String getTelephone() {
        return telephone.get();
    }

    public SimpleStringProperty telephoneProperty() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }


    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }
    public void setAddress(String address) {
        this.address.set(address);
    }


    public String getJob() {
        return job.get();
    }

    public SimpleStringProperty jobProperty() {
        return job;
    }
    public void setJob(String job) {
        this.job.set(job);
    }


    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }
    public void setCity(String city) {
        this.city.set(city);
    }


    public String getMarried() {
        return married.get();
    }

    public SimpleStringProperty marriedProperty() {
        return married;
    }
    public void setMarried(String married) {
        this.married.set(married);
    }


    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getToday() {
        return today.get();
    }

    public SimpleStringProperty todayProperty() {
        return today;
    }
    public void setToday(String today) {
        this.today.set(today);
    }

}
