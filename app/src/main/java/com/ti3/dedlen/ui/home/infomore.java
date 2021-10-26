package com.ti3.dedlen.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.ti3.dedlen.MainActivity;
import com.ti3.dedlen.R;
import com.ti3.dedlen.ui.admin.checker;

public class infomore extends AppCompatActivity{

    private Context context;

    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<networkjadwal, item_jadwal> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

    private DatabaseReference mDatabase1;
    private FirebaseRecyclerAdapter<networkjadwal, item_jadwal> mAdapter1;
    private RecyclerView mRecycler1;
    private LinearLayoutManager mManager1;

    private DatabaseReference mDatabase2;
    private FirebaseRecyclerAdapter<networkjadwal, item_jadwal> mAdapter2;
    private RecyclerView mRecycler2;
    private LinearLayoutManager mManager2;

    private DatabaseReference mDatabase3;
    private FirebaseRecyclerAdapter<networkjadwal, item_jadwal> mAdapter3;
    private RecyclerView mRecycler3;
    private LinearLayoutManager mManager3;

    private DatabaseReference mDatabase4;
    private FirebaseRecyclerAdapter<networkjadwal, item_jadwal> mAdapter4;
    private RecyclerView mRecycler4;
    private LinearLayoutManager mManager4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mRecycler = findViewById(R.id.senin);
        mRecycler.setHasFixedSize(true);
        mManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);
        Query query = getQuery(mDatabase);
        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<networkjadwal>()
                .setQuery(query, networkjadwal.class)
                .build();
        mAdapter = new FirebaseRecyclerAdapter<networkjadwal, item_jadwal>(options) {
            @Override
            public item_jadwal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new item_jadwal(inflater.inflate(R.layout.item_jadwal, parent, false));
            }
            @Override
            protected void onBindViewHolder(@NonNull item_jadwal holder, int position, @NonNull final networkjadwal model) {
                holder.bindTonetworks(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }
        };
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);

        mRecycler1 = findViewById(R.id.selasa);
        mRecycler1.setHasFixedSize(true);
        mManager1 = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        mManager1.setReverseLayout(true);
        mManager1.setStackFromEnd(true);
        mRecycler1.setLayoutManager(mManager1);
        Query query1 = getQuery1(mDatabase);
        FirebaseRecyclerOptions options1 = new FirebaseRecyclerOptions.Builder<networkjadwal>()
                .setQuery(query1, networkjadwal.class)
                .build();
        mAdapter1 = new FirebaseRecyclerAdapter<networkjadwal, item_jadwal>(options1) {
            @Override
            public item_jadwal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new item_jadwal(inflater.inflate(R.layout.item_jadwal, parent, false));
            }
            @Override
            protected void onBindViewHolder(@NonNull item_jadwal holder, int position, @NonNull final networkjadwal model) {
                holder.bindTonetworks(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }
        };
        mAdapter1.notifyDataSetChanged();
        mRecycler1.setAdapter(mAdapter1);

        mRecycler2 = findViewById(R.id.rabu);
        mRecycler2.setHasFixedSize(true);
        mManager2 = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        mManager2.setReverseLayout(true);
        mManager2.setStackFromEnd(true);
        mRecycler2.setLayoutManager(mManager2);
        Query query2= getQuery2(mDatabase);
        FirebaseRecyclerOptions options2 = new FirebaseRecyclerOptions.Builder<networkjadwal>()
                .setQuery(query, networkjadwal.class)
                .build();
        mAdapter2 = new FirebaseRecyclerAdapter<networkjadwal, item_jadwal>(options2) {
            @Override
            public item_jadwal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new item_jadwal(inflater.inflate(R.layout.item_jadwal, parent, false));
            }
            @Override
            protected void onBindViewHolder(@NonNull item_jadwal holder, int position, @NonNull final networkjadwal model) {
                holder.bindTonetworks(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }
        };
        mAdapter2.notifyDataSetChanged();
        mRecycler2.setAdapter(mAdapter2);

        mRecycler3 = findViewById(R.id.kamis);
        mRecycler3.setHasFixedSize(true);
        mManager3 = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        mManager3.setReverseLayout(true);
        mManager3.setStackFromEnd(true);
        mRecycler3.setLayoutManager(mManager3);
        Query query3 = getQuery3(mDatabase);
        FirebaseRecyclerOptions options3 = new FirebaseRecyclerOptions.Builder<networkjadwal>()
                .setQuery(query, networkjadwal.class)
                .build();
        mAdapter3 = new FirebaseRecyclerAdapter<networkjadwal, item_jadwal>(options3) {
            @Override
            public item_jadwal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new item_jadwal(inflater.inflate(R.layout.item_jadwal, parent, false));
            }
            @Override
            protected void onBindViewHolder(@NonNull item_jadwal holder, int position, @NonNull final networkjadwal model) {
                holder.bindTonetworks(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }
        };
        mAdapter3.notifyDataSetChanged();
        mRecycler3.setAdapter(mAdapter3);

        mRecycler4 = findViewById(R.id.jumat);
        mRecycler4.setHasFixedSize(true);
        mManager4 = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        mManager4.setReverseLayout(true);
        mManager4.setStackFromEnd(true);
        mRecycler4.setLayoutManager(mManager4);
        Query query4 = getQuery4(mDatabase);
        FirebaseRecyclerOptions options4 = new FirebaseRecyclerOptions.Builder<networkjadwal>()
                .setQuery(query, networkjadwal.class)
                .build();
        mAdapter4 = new FirebaseRecyclerAdapter<networkjadwal, item_jadwal>(options4) {
            @Override
            public item_jadwal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new item_jadwal(inflater.inflate(R.layout.item_jadwal, parent, false));
            }
            @Override
            protected void onBindViewHolder(@NonNull item_jadwal holder, int position, @NonNull final networkjadwal model) {
                holder.bindTonetworks(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }
        };
        mAdapter4.notifyDataSetChanged();
        mRecycler4.setAdapter(mAdapter4);

        Button exit = findViewById(R.id.btn_exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(infomore.this, MainActivity.class);
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
        if (mAdapter1 != null) {
            mAdapter1.startListening();
        }
        if (mAdapter2 != null) {
            mAdapter2.startListening();
        }
        if (mAdapter3 != null) {
            mAdapter3.startListening();
        }
        if (mAdapter4 != null) {
            mAdapter4.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
        if (mAdapter1 != null) {
            mAdapter1.stopListening();
        }
        if (mAdapter2 != null) {
            mAdapter2.stopListening();
        }
        if (mAdapter3 != null) {
            mAdapter3.stopListening();
        }
        if (mAdapter4 != null) {
            mAdapter4.stopListening();
        }
    }

    private Query getQuery(DatabaseReference mDatabase){
        Query query = mDatabase.child("jadwal/senin");
        return query;
    }
    private Query getQuery1(DatabaseReference mDatabase){
        Query query1 = mDatabase.child("jadwal/selasa");
        return query1;
    }
    private Query getQuery2(DatabaseReference mDatabase){
        Query query2 = mDatabase.child("jadwal/rabu");
        return query2;
    }
    private Query getQuery3(DatabaseReference mDatabase){
        Query query3 = mDatabase.child("jadwal/kamis");
        return query3;
    }
    private Query getQuery4(DatabaseReference mDatabase){
        Query query4 = mDatabase.child("jadwal/jumat");
        return query4;
    }

}
