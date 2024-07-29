package models;

import java.io.Serializable;

public class Customer implements Serializable {

    private final String name;
    private final String phone;
    private final String age;
    private final String job;
    private final boolean isIndividual;


    public Customer(String name, String phone, String age, String job, boolean isIndividual) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.job = job;
        this.isIndividual = isIndividual;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return  "  name = " + name + '\n' +
                "  phone = " + phone + '\n' +
                "  age = " + age + '\n' +
                "  job = " + job + '\n' +
                "  isIndividual = " + isIndividual + '\n';
    }
}

