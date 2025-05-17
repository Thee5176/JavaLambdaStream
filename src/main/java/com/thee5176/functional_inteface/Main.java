package com.thee5176.functional_inteface;

public class Main {
    public static void main(String[] args){
        //通帳のインスタンス化
        IStringLength StringLengthInstance  = new IStringLength() {
            @Override
            public int stringToLength(String s) {
                return s.length();
            }
        };

        int length = StringLengthInstance.stringToLength("Hello, Functional Interface!");     //
        System.out.println("Functional Interface Instantiation: "+length);

        //Lambda式
        IStringLength stringLengthInstance = s -> s.length();
        int lambdaLength = stringLengthInstance.stringToLength("Hello, Functional Interface!");
        System.out.println("Lambda: "+lambdaLength);
    }
}
