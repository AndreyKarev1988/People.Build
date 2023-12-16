package org.example;

public class PersonBuilder implements IPersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) throws IllegalStateException {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Вы не указали имя");
        } else {
            this.name = name;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) throws IllegalStateException {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalStateException("Вы не указали фамилию");
        } else {
            this.surname = surname;
        }
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным числом");
        } else {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() throws IllegalStateException {
        if (name == null) {
            throw new IllegalStateException("поле name обязательно для заполнения");
        } else if (surname == null) {
            throw new IllegalStateException("поле surname обязательно для заполнения");
        }
        Person person;
        if (age == -1) {
            person = new Person(name, surname);
        } else {
            person = new Person(name, surname, age);
        }
        if (address != null) {
            person.setAddress(address);
        }
        return person;
    }
}