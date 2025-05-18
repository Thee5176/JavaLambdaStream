package com.thee5176.method_reference;

import java.util.Arrays;
import java.util.List;

public class FilterName {
    public static void main(String[] args){
        List<String> friends = Arrays.asList("Poonam","Sachin","Vicky");
        //Lambda式
        friends.forEach( (friend) -> System.out.println(friend) );

        //Method Reference
        friends.forEach(System.out::println);
    }
}
