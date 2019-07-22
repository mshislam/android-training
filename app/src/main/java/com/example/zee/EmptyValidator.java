package com.example.zee;

import android.text.TextUtils;
import android.widget.EditText;

public class EmptyValidator {
    public EmptyValidator(String message) {
        super(message);
    }

    public boolean isValid(EditText et) {
        return TextUtils.getTrimmedLength(et.getText()) > 0;
    }
}
