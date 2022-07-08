package com.cleancoder.args;

public class Main {
    public static void main(String[] args) {
        try {
            Args arguments = new Args("f*,l*,a#,b", args);

            System.out.println(arguments.getString('f'));
            System.out.println(arguments.getString('l'));
            System.out.println(arguments.getInt('a'));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
