package com.example.kiran.mybuddy.Utils;

import android.content.Context;
import android.widget.EditText;

import com.example.kiran.mybuddy.dbhelper.DataBaseHelper;

/**
 * Created by Kiran on 25-04-2016.
 */
public class Utils {
    public static final String POSITION="Position";
    public static final String CONTACTS="Contacts";
    public static final String FROMSCREEN="FromScreen";
    public static final String USERID ="UserID" ;
    public static final String CONTACTID ="ContactId" ;

    public static DataBaseHelper dataBaseHelper(Context context){
        return new DataBaseHelper(context);
    }

    public static boolean isEditTextEmpty(EditText editText) {
        if (editText.getText().length() == 0) {
            return true;
        }
        return false;
    }

}
