package com.cleancoder.args;

public class TestingClass {
    public static void main(String[] args) {
        if (shouldSucceedWithOneStringSchemaAndInput()) {
            System.out.println("TEST SUCCEEDED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    public static boolean shouldSucceedWithOneStringSchemaAndInput() {
        try {
            Args argumentParser = new Args("s*", new String[]{"-s", "Stringu"});
            String parsedString = argumentParser.getString('s');
            if (parsedString.equals("Stringu")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
