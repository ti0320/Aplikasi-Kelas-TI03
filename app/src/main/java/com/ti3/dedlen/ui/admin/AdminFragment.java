package com.ti3.dedlen.ui.admin;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.ti3.dedlen.R;

import static android.text.TextUtils.isEmpty;

public class AdminFragment extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<admintugas_network, admin_tugas> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;
    private Context mContext;
    public Button exit, add;
    public String placeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mRecycler = findViewById(R.id.admin_tugas);
        mRecycler.setHasFixedSize(true);
        mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);
        Query query = getQuery(mDatabase);
        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<admintugas_network>()
                .setQuery(query, admintugas_network.class)
                .build();
        mAdapter = new FirebaseRecyclerAdapter<admintugas_network, admin_tugas>(options) {
            @Override
            public admin_tugas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new admin_tugas(inflater.inflate(R.layout.item_admintugas, parent, false));
            }
            protected void onBindViewHolder(@NonNull admin_tugas holder, int position, @NonNull final admintugas_network model) {
                holder.bindTonetwork(model, new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {

                        View popupView = getLayoutInflater().inflate(R.layout.delete_data, null);

                        PopupWindow popupWindow = new PopupWindow(popupView,
                                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                        popupWindow.setFocusable(true);
                        popupWindow.setBackgroundDrawable(new ColorDrawable());
                        popupWindow.showAtLocation(v, Gravity.CENTER,0,0);

                        Button hapusBtn = (Button) popupView.findViewById(R.id.hapus);

                        hapusBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mAdapter.getRef(position).removeValue();
                                popupWindow.dismiss();
                            }
                        });

                        return true;
                    }
                });
            }
        };
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);

        exit = findViewById(R.id.btn_exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminFragment.this, checker.class);
                startActivity(intent);
            }
        });

        add = findViewById(R.id.btn_tugasadd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminFragment.this, tugasFragment.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null) {
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

    private Query getQuery(DatabaseReference mDatabase){
        Query query = mDatabase.child("tugas");
        return query;
    }

    public void adddata(View v)
    {

        View popupView = getLayoutInflater().inflate(R.layout.add_data, null);

        PopupWindow popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.showAtLocation(v, Gravity.CENTER,0,0);


        final EditText matkul = (EditText) popupView.findViewById(R.id.admin_matkul);
        final EditText judul = (EditText) popupView.findViewById(R.id.admin_judul);
        final EditText info = (EditText) popupView.findViewById(R.id.admin_info);
        final EditText jam = (EditText) popupView.findViewById(R.id.admin_jam);

        String getMATKUL = matkul.getText().toString();
        String getJUDUL = judul.getText().toString();
        String getINFO = info.getText().toString();
        String getJAM = jam.getText().toString();

        Button add = (Button) popupView.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmpty(getMATKUL) && isEmpty(getINFO) && isEmpty(getJAM) && isEmpty(getJUDUL)){
                    Toast.makeText(AdminFragment.this, "Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
                }else {
                    mDatabase.child("tugas").push()
                            .setValue(new admintugas_network(getMATKUL, getINFO, getJAM, getJUDUL))
                            .addOnSuccessListener(AdminFragment.this, new OnSuccessListener() {
                                @Override
                                public void onSuccess(Object o) {
                                    Toast.makeText(AdminFragment.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
                popupWindow.dismiss();
            }
        });
    }

}
