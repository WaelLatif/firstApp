package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = findViewById(R.id.txtName);
        Password = findViewById(R.id.txtPassword);
        Info = findViewById(R.id.tvInfo);
        Login = findViewById(R.id.btnLogin);

        Info.setText("No Of Attempets Remaining 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate(Name.getText().toString(), Password.getText().toString());

            }
        });

    }

    private void Validate(String userName, String userPassword) {
        if (userName.equals("Admin")  && userPassword.equals("12345") ) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        } else {
            counter--;
            Info.setText("No Of Attempets Remaining " + String.valueOf(counter));

            if (counter == 0) {
                Login.setEnabled(false);
            }
        }

    }
}



