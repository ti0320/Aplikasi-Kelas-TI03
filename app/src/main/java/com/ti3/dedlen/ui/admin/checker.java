package com.ti3.dedlen.ui.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ti3.dedlen.MainActivity;
import com.ti3.dedlen.R;

public class checker extends AppCompatActivity {

    public Button login, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checker);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        final EditText idValidate = (EditText)findViewById(R.id.id);
        final EditText passwordValidate = (EditText)findViewById(R.id.password);

        login = findViewById(R.id.login_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idValidate.getText().toString();
                String password = passwordValidate.getText().toString();
                if (id.equals("admin"))
                {
                    if (password.equals("ihwibu"))
                    {
                        Toast.makeText(getApplicationContext(),"Login Berhasil",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(checker.this, AdminFragment.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Login Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });

        exit = findViewById(R.id.btn_exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(checker.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


}
