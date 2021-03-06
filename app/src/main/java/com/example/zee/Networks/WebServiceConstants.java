package com.example.zee.Networks;

public class WebServiceConstants {
    private static String baseURL = "http://eventi-do1.mideastsoft.com/staging/api/v2/fdc/";

    public static String API_TOKEN = "api_token";
    public static String LIMIT = "limit";
    public static String PAGE = "page";

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

    public static class createPost {
        static String API_CREATEPOST = baseURL + "createPost";
        public static String text = "text";
    }

    public static class Posts {
        static String LIST_POSTS = baseURL + "listPosts";
    }

    public static class Comments {
        static String API_LIST_COMMENTS = baseURL + "listComments";
        static String API_CREATE_COMMENT = baseURL + "createComment";
        public static String post_id = "post_id";
        public static String text = "text";
    }
}
