package com.example.uiuserinterface;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * MainActivity.java
 *
 * Demonstrates all Android UI components:
 *  - TextView      : displays text
 *  - EditText      : accepts user input
 *  - Button        : handles click events
 *  - ImageView     : displays images
 *  - ScrollView    : wraps content in activity_main.xml
 *
 * Layout used: ConstraintLayout (flat, best performance)
 *
 * Lecture 5 — Android UI Development
 * Instructor: Spogmay Rafiq | UET Peshawar
 */
public class MainActivity extends AppCompatActivity {

    // ─── View declarations ────────────────────────────────────────────────────

    // TextView: displays text on screen
    private TextView tvTitle;
    private TextView tvSubtitle;
    private TextView tvResult;
    private TextView tvFooter;

    // EditText: allows user to type input
    private EditText etName;
    private EditText etEmail;
    private EditText etPassword;

    // Button: triggers an action on click
    private Button btnSubmit;
    private Button btnClear;

    // ImageView: displays an image resource
    private ImageView imageView;

    // ─── Activity Lifecycle ───────────────────────────────────────────────────

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setContentView links this Java file to activity_main.xml
        setContentView(R.layout.activity_main);

        // Step 1: Initialize all views by finding them via their XML IDs
        initViews();

        // Step 2: Attach click listeners to buttons
        setupClickListeners();
    }

    // ─── View Initialization ──────────────────────────────────────────────────

    /**
     * Finds every View in the layout using its android:id from XML.
     * Must be called AFTER setContentView().
     */
    private void initViews() {

        // TextViews
        tvTitle    = findViewById(R.id.tvTitle);
        tvSubtitle = findViewById(R.id.tvSubtitle);
        tvResult   = findViewById(R.id.tvResult);
        tvFooter   = findViewById(R.id.tvFooter);

        // EditTexts
        etName     = findViewById(R.id.etName);
        etEmail    = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        // Buttons
        btnSubmit  = findViewById(R.id.btnSubmit);
        btnClear   = findViewById(R.id.btnClear);

        // ImageView
        imageView  = findViewById(R.id.imageView);

        // Programmatically change a TextView's text (same as android:text in XML)
        tvSubtitle.setText("All UI components in one screen");
    }

    // ─── Click Listeners ──────────────────────────────────────────────────────

    /**
     * Attaches onClick behaviour to each button.
     */
    private void setupClickListeners() {

        // Submit button → validate inputs → show result
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSubmit();
            }
        });

        // Clear button → reset all fields
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleClear();
            }
        });

        // ImageView click → show a Toast message
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        MainActivity.this,
                        "ImageView clicked!",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }

    // ─── Business Logic ───────────────────────────────────────────────────────

    /**
     * Reads input from EditTexts, validates, then updates a TextView.
     */
    private void handleSubmit() {

        // Read text from EditText using getText().toString()
        String name     = etName.getText().toString().trim();
        String email    = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Validate — check for empty fields
        if (TextUtils.isEmpty(name)) {
            etName.setError("Name is required");
            etName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Enter a valid email");
            etEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password) || password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters");
            etPassword.requestFocus();
            return;
        }

        // All valid — show result in the result TextView
        String resultMessage = "Welcome, " + name + "!\nEmail: " + email;
        tvResult.setText(resultMessage);
        tvResult.setVisibility(View.VISIBLE);   // View.VISIBLE / INVISIBLE / GONE

        Toast.makeText(this, "Form submitted successfully!", Toast.LENGTH_LONG).show();
    }

    /**
     * Clears all EditText fields and hides the result TextView.
     */
    private void handleClear() {
        etName.setText("");
        etEmail.setText("");
        etPassword.setText("");
        tvResult.setText("");
        tvResult.setVisibility(View.GONE);   // GONE = no space; INVISIBLE = keeps space

        etName.requestFocus();

        Toast.makeText(this, "Fields cleared", Toast.LENGTH_SHORT).show();
    }
}