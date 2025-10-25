package com.dsa.oops;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.springframework.util.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable, Cloneable {

    private String name;
    private int age;
    private transient String password;
}

class Main{
    public static void main(String[] args) {
        User user = new User("kunal", 12, "fsaasfsa");
        System.out.println(user);
        System.out.println(user.getPassword());

        byte[] bytes = SerializationUtils.serialize(user);
        User user1 = (User) SerializationUtils.deserialize(bytes);
        System.out.println(user1);
    }
}
