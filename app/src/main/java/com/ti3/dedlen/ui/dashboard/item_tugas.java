package com.ti3.dedlen.ui.dashboard;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ti3.dedlen.R;

class item_tugas extends RecyclerView.ViewHolder {
    public TextView tugas_matkul, tugas_judul, tugas_jam;
    private Context context;
    public Button btn;

    private int mCurrentPosition;

    public item_tugas(View itemView) {
        super(itemView);
        tugas_matkul = itemView.findViewById(R.id.tugas_matkul);
        tugas_judul = itemView.findViewById(R.id.tugas_judul);
        tugas_jam = itemView.findViewById(R.id.tugas_jam);
        btn = itemView.findViewById(R.id.btn_info);
    }


    public void bindTonetwork(networktugas networktugass, View.OnClickListener onClickListener){
        tugas_matkul.setText(networktugass.tugas_matkul);
        tugas_judul.setText(networktugass.tugas_judul);
        tugas_jam.setText(networktugass.tugas_jam);
        btn.setOnClickListener(onClickListener);
    }
}
