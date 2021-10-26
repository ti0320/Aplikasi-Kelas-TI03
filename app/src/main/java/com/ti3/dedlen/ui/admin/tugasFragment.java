package com.ti3.dedlen.ui.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ti3.dedlen.R;

import static android.text.TextUtils.isEmpty;

public class tugasFragment extends AppCompatActivity {

    private DatabaseReference mDatabase;
    public Button exit, add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_data);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        mDatabase = FirebaseDatabase.getInstance().getReference();

        final EditText matkul = (EditText)findViewById(R.id.admin_matkul);
        final EditText judul = (EditText)findViewById(R.id.admin_judul);
        final EditText info = (EditText)findViewById(R.id.admin_info);
        final EditText jam = (EditText)findViewById(R.id.admin_jam);


        exit = findViewById(R.id.btn_exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tugasFragment.this, AdminFragment.class);
                startActivity(intent);
            }
        });

        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getMATKUL = matkul.getText().toString();
                String getJUDUL = judul.getText().toString();
                String getINFO = info.getText().toString();
                String getJAM = jam.getText().toString();

                if (isEmpty(getMATKUL) && isEmpty(getINFO) && isEmpty(getJAM) && isEmpty(getJUDUL)) {
                    Toast.makeText(tugasFragment.this, "Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
                } else {
                    mDatabase.child("tugas").push()
                            .setValue(new admintugas_network(getMATKUL, getINFO, getJAM, getJUDUL))
                            .addOnSuccessListener(tugasFragment.this, new OnSuccessListener() {
                                @Override
                                public void onSuccess(Object o) {
                                    matkul.setText("");
                                    judul.setText("");
                                    info.setText("");
                                    jam.setText("");
                                    Toast.makeText(tugasFragment.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });

    }
}