package com.dsa.java8;

public class UserShallow implements Cloneable{
    String name;
    Address address;

    public UserShallow(String name, Address address){
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Address address1 = new Address("Delhi");
        UserShallow user1 = new UserShallow("John", address1);
        UserShallow user2 = (UserShallow) user1.clone();
        user2.address.city = "Mumbai";
        System.out.println(user1.address.city);
    }
}
