package com.darlankenobi.webfluxapi.dto;

import java.util.List;

public class IssNotification {

    private Integer number;
    private String message;
    private List<Person> people;

    public IssNotification() {
    }

    public IssNotification(Integer number, String message, List<Person> people) {
        this.number = number;
        this.message = message;
        this.people = people;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "IssNotification{" +
                "number=" + number +
                ", message='" + message + '\'' +
                ", people=" + people +
                '}';
    }
}
