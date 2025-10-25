package com.dsa.java8;

public class UserDeep implements Cloneable{
    String name;
    Address address;

    public UserDeep(String name, Address address){
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Address clonedAddress = new Address(this.address.city);
        return new UserDeep(this.name, clonedAddress);
    }
}

class Address{
    String city;

    Address(String city){
        this.city = city;
    }
}
