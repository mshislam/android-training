package com.example.zee;

import android.service.autofill.FieldClassification;
import android.util.Patterns;
import android.widget.EditText;

import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.validation.Validator;

public class EmailValidator  {
    private Pattern pattern;
    public EmailValidator(){
        pattern=Pattern.compile(  "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+");
    }
    public boolean testvalidity(EditText email){
return pattern.matcher(email.getText()).matches();
    }
}
