package com.ti3.dedlen.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ti3.dedlen.R;

class item_home extends RecyclerView.ViewHolder {
    public TextView info_dosen, info_matkul, info_peringatan, jadwal_matkul, jadwal_materi, jadwal_jam, jadwal_dosen, jadwal_lokasi;
    private Context context;

    private int mCurrentPosition;


    public item_home(View itemView) {
        super(itemView);
        info_matkul = itemView.findViewById(R.id.info_matkul);
    }


    public void bindTonetwork(networkhome networkhomes, View.OnClickListener onClickListener){
        info_matkul.setText(networkhomes.info_matkul);
    }
}
