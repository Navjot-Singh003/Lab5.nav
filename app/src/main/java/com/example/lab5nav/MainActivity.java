package com.example.lab5nav;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Navjot Singh
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity {

    /** TextView to display output or messages */
    private TextView tv = null;

    /** EditText for user input */
    private EditText et = null;

    /** Button to trigger actions */
    private Button btn = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.textView);
        EditText et = findViewById(R.id.editText);
        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(clk -> {
            String password = et.getText().toString();
            checkPasswordComplexity(password);
        });
    }

    /** This function checks the complexity of the password.
     *
     * @param pw The String object that we are checking
     * @return Returns true if the password meets all complexity requirements
     */
    private boolean checkPasswordComplexity(String pw) {
        boolean foundUpperCase = false, foundLowerCase = false, foundNumber = false, foundSpecial = false;

        // Loop through each character in the password and set flags based on character type
        for (char c : pw.toCharArray()) {
            if (Character.isUpperCase(c)) foundUpperCase = true;
            if (Character.isLowerCase(c)) foundLowerCase = true;
            if (Character.isDigit(c)) foundNumber = true;
            if (isSpecialCharacter(c)) foundSpecial = true;
        }

        if (!foundUpperCase) {
            Toast.makeText(this, "Password is missing an upper case letter.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundLowerCase) {
            Toast.makeText(this, "Password is missing a lower case letter.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundNumber) {
            Toast.makeText(this, "Password is missing a number.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundSpecial) {
            Toast.makeText(this, "Password is missing a special character.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true; // Only gets here if all conditions are met
        }
    }

    /**
     * This function checks if a character is a special character.
     *
     * @param c The character to check
     * @return Returns true if c is one of: #$%^&*!@?
     */
    boolean isSpecialCharacter(char c) {
        switch (c) {
            case '#':
            case '?':
            case '*':
                return true;
            default:
                return false;
        }
    }

}

