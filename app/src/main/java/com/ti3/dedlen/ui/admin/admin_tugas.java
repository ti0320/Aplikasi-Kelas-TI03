package com.ti3.dedlen.ui.admin;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ti3.dedlen.R;

class admin_tugas extends RecyclerView.ViewHolder {
    public TextView tugas_matkul, tugas_jam, tugas_info, tugas_judul;
    private Context context;
    public LinearLayout btndelete;

    private int mCurrentPosition;


    public admin_tugas(View itemView) {
        super(itemView);
        tugas_matkul = itemView.findViewById(R.id.tugas_matkul);
        tugas_judul = itemView.findViewById(R.id.tugas_judul);
        tugas_jam = itemView.findViewById(R.id.tugas_jam);
        tugas_info = itemView.findViewById(R.id.tugas_info);
        btndelete = (LinearLayout) itemView.findViewById(R.id.main);
    }


    public void bindTonetwork(admintugas_network admintugas, View.OnLongClickListener onLongClickListener){
        tugas_matkul.setText(admintugas.tugas_matkul);
        tugas_judul.setText(admintugas.tugas_judul);
        tugas_info.setText("LINK info : "+admintugas.tugas_info);
        tugas_jam.setText(admintugas.tugas_jam);
        btndelete.setOnLongClickListener(onLongClickListener);
    }

}
