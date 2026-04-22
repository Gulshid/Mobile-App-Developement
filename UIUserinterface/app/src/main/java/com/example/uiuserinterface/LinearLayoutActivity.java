package com.example.uiuserinterface;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LinearLayoutActivity extends AppCompatActivity {

    private Button btnLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        btnLinear = findViewById(R.id.btnLinear);

        btnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        LinearLayoutActivity.this,
                        "Registered via LinearLayout screen!",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}