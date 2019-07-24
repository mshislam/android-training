package com.example.zee.util;

import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtil {
    EditText emailtext;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String pattern = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";
    Matcher m;

    public static Boolean isValidEmailOrPhone(EditText e) {
        Pattern patternFromString = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+");
        return patternFromString.matcher(e.getText().toString()).matches();
    }

    public Boolean isValidEmail(EditText e) {

        if (emailtext.getText().toString().isEmpty()) {
            return false;
        } else {
            if (emailtext.getText().toString().trim().matches(emailPattern)) {
                return true;
            } else {
                return false;
            }
        }
    }

    //
//
    public Boolean isValidPhone(EditText emailtext) {
        Pattern r = Pattern.compile(pattern);
        if (!emailtext.getText().toString().isEmpty()) {
            m = r.matcher(emailtext.getText().toString().trim());
        }
        if (m.find()) {
            return true;
        } else {
            return false;
        }
    }
}
