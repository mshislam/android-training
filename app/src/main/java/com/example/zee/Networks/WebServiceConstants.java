package com.example.zee.Networks;

public class WebServiceConstants {
    private static String baseURL = "http://eventi-do1.mideastsoft.com/staging/api/v2/fdc/";

    public static String API_TOKEN = "api_token";

    public static class Register {
        static String API_REGISTER = baseURL + "registration";
        public static String first_name = "first_name";
        public static String last_name = "last_name";
        public static String email = "email";
        public static String mobile = "email";
        public static String password = "email";
        public static String confirm_password = "email";
        public static String company = "email";
        public static String title = "email";
    }

    public static class Comments {
        static String API_LIST_COMMENTS = baseURL + "listComments";
        public static String post_id = "post_id";
    }
}
