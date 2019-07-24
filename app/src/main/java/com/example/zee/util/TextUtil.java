package com.example.zee.util;

import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextUtil {

    public static boolean isValid(EditText input) {
        String myText = input.getText().toString();
        if (myText == null) {
            return false;
        }
        //check if myText is phoneNumber
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(myText);
        if (matcher.matches()) {
            return true;
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (pat.matcher(myText).matches()) {
            return true;
        }
        return false;

    }
    public static boolean isEmpty(EditText et){
        if(et.getText().toString().isEmpty()){
            return false;
        }else {
            return true;
        }

    }
    public static boolean isString(EditText et){
        Pattern pattern=Pattern.compile("^[A-Za-z, ]++$");
        return pattern.matcher(et.getText().toString()).matches();
    }

}
