package com.ti3.dedlen.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.ti3.dedlen.R;
import com.ti3.dedlen.ui.notifications.NotificationsViewModel;

import java.util.Calendar;

public class HomeFragment extends Fragment {

    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<networkhome, item_home> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

    private DatabaseReference mDatabase1;
    private FirebaseRecyclerAdapter<networkjadwal, item_jadwal> mAdapter1;
    private RecyclerView mRecycler1;
    private LinearLayoutManager mManager1;

    private Context context;

    private String hari;

    private TextView txtnull, selengkapnya;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        selengkapnya = (TextView) root.findViewById(R.id.selengkapnya);
        selengkapnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jadwal(v);
            }
        });

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mRecycler = root.findViewById(R.id.list_info);
        mRecycler.setHasFixedSize(true);
        mManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);
        Query query = getQuery(mDatabase);
        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<networkhome>()
                .setQuery(query, networkhome.class)
                .build();
        mAdapter = new FirebaseRecyclerAdapter<networkhome, item_home>(options) {
            @Override
            public item_home onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new item_home(inflater.inflate(R.layout.item_matkul, parent, false));
            }
            @Override
            protected void onBindViewHolder(@NonNull item_home holder, int position, @NonNull final networkhome model) {
                holder.bindTonetwork(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }
        };
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);

        mDatabase1 = FirebaseDatabase.getInstance().getReference();

        txtnull = (TextView) root.findViewById(R.id.texttugas);

        mRecycler1 = root.findViewById(R.id.list_jadwal);
        mRecycler1.setHasFixedSize(true);
        mManager1 = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        mManager1.setReverseLayout(true);
        mManager1.setStackFromEnd(true);
        mRecycler1.setLayoutManager(mManager1);
        Query query1 = getQuerys(mDatabase1);
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

        query1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    }
                    txtnull.setVisibility(View.INVISIBLE);
                    mRecycler1.setVisibility(View.VISIBLE);
                }
                else {
                    txtnull.setVisibility(View.VISIBLE);
                    mRecycler1.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw databaseError.toException();
            }
        });

        return root;
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
    }

    private Query getQuery(DatabaseReference mDatabase){
        Query query = mDatabase.child("info");
        return query;
    }

    private Query getQuerys(DatabaseReference mDatabase1){
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if (Calendar.MONDAY == dayOfWeek) {
            hari = "jadwal/senin";
        } else if (Calendar.TUESDAY == dayOfWeek) {
            hari = "jadwal/selasa";
        } else if (Calendar.WEDNESDAY == dayOfWeek) {
            hari = "jadwal/rabu";
        } else if (Calendar.THURSDAY == dayOfWeek) {
            hari = "jadwal/kamis";
        } else if (Calendar.FRIDAY == dayOfWeek) {
            hari = "jadwal/jumat";
        } else if (Calendar.SATURDAY == dayOfWeek) {
            hari = "jadwal/sabtu";
        } else if (Calendar.SUNDAY == dayOfWeek) {
            hari = "jadwal/minggu";
        }
        Query query1 = mDatabase.child(hari);
        return query1;
    }

    public void jadwal(View v){
        Intent intent = new Intent(HomeFragment.this.getActivity(), infomore.class);
        startActivity(intent);
    }

}