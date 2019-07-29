package com.example.zee.Networks;

public class WebServiceConstants {
    private static String baseURL = "http://eventi-do1.mideastsoft.com/staging/api/v2/fdc/";

    public static class Register {
        static String API_REGISTER = baseURL + "registration";
        public static String first_name = "first_name";
        public static String last_name = "last_name";
        public static String email = "email";
        public static String mobile = "mobile";
        public static String password = "password";
        public static String confirm_password = "confirm_password";
        public static String company = "company";
        public static String title = "title";
    }

    public static class Comments {
        static String API_LIST_COMMENTS = baseURL + "listCommrnts";
        public static String post_id = "post_id";
    }
}
