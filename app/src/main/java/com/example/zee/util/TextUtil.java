package com.example.zee.util;

import android.util.Patterns;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtil {
    public static boolean isEmpty(EditText text) {
        if (text.getText().toString().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isValid(EditText input) {
        String myText = input.getText().toString();
        if (myText == null) {
            return false;
        }
        if (Patterns.PHONE.matcher(myText).matches()) {
            return true;
        }else if (Patterns.EMAIL_ADDRESS.matcher(myText).matches()) {
            return true;
        }else {
            return false;
        }
    }
    public static boolean passIsValid(EditText text){
        if (text.length() > 5)
            return true;
        else
            return false;
    }
    public static boolean isString(EditText text) {
        Pattern pattern = Pattern.compile("^[A-Za-z, ]++$");
        return pattern.matcher(text.getText().toString()).matches();
    }
}
