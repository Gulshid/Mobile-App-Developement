package com.example.uiuserinterface;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RelativeLayoutActivity extends AppCompatActivity {

    private EditText etRelName;
    private EditText etRelEmail;
    private Button btnRelSubmit;
    private Button btnRelCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        initViews();
        setupListeners();
    }

    private void initViews() {
        etRelName    = findViewById(R.id.etRelName);
        etRelEmail   = findViewById(R.id.etRelEmail);
        btnRelSubmit = findViewById(R.id.btnRelSubmit);
        btnRelCancel = findViewById(R.id.btnRelCancel);
    }

    private void setupListeners() {
        btnRelSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name  = etRelName.getText().toString().trim();
                String email = etRelEmail.getText().toString().trim();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email)) {
                    Toast.makeText(RelativeLayoutActivity.this,
                            "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RelativeLayoutActivity.this,
                            "Hello, " + name + "!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnRelCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etRelName.setText("");
                etRelEmail.setText("");
                finish();
            }
        });
    }
}