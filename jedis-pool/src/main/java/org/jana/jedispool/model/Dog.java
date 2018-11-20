package org.jana.jedispool.model;

import java.io.Serializable;

public class Dog implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String breed;

    public Dog() {
    }

    public Dog(int id, String name, String breed) {
        this.id = id;
        this.name = name;
        this.breed = breed;
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        Dog dog = (Dog) obj;
        if (this == dog) return true;

        if (!this.name.equals(dog.name)) return false;
        if (!this.breed.equals(dog.breed)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hashNo = 7;
        hashNo = 13 * hashNo + (name == null ? 0 : name.hashCode());
        return hashNo;
    }

}
