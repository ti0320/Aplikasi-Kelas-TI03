
package com.ti3.dedlen.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

public class DashboardFragment extends Fragment {

    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<networktugas, item_tugas> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;
    TextView txtnull;

    private Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        txtnull = (TextView) root.findViewById(R.id.texttugas);

        mRecycler = root.findViewById(R.id.list_tugas);
        mRecycler.setHasFixedSize(true);
        mManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);
        Query query = getQuery(mDatabase);
        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<networktugas>()
                .setQuery(query, networktugas.class)
                .build();
        mAdapter = new FirebaseRecyclerAdapter<networktugas, item_tugas>(options) {
            @Override
            public item_tugas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new item_tugas(inflater.inflate(R.layout.item_tugas, parent, false));
            }
            @Override
            protected void onBindViewHolder(@NonNull item_tugas holder, int position, @NonNull final networktugas model) {
                holder.bindTonetwork(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(model.tugas_info));
                        startActivity(browserIntent);
                    }
                });
            }
        };
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    }
                    txtnull.setVisibility(View.INVISIBLE);
                    mRecycler.setVisibility(View.VISIBLE);
                }
                else {
                    txtnull.setVisibility(View.VISIBLE);
                    mRecycler.setVisibility(View.INVISIBLE);
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

}