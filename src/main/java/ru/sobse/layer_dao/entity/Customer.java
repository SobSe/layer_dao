package ru.sobse.layer_dao.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "customers", schema = "public")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length =  50)
    private String name;
    @Column(length = 50)
    private String surname;
    private int age;
    @Column(name = "phone_number", length = 11)
    private String phoneNumber;

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customers = (Customer) o;
        return id == customers.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
