package com.ti3.dedlen.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ti3.dedlen.R;

class item_jadwal extends RecyclerView.ViewHolder {
    public TextView jadwal_matkul, jadwal_jam, jadwal_dosen, jadwal_lokasi;
    private Context context;

    private int mCurrentPosition;


    public item_jadwal(View itemView) {
        super(itemView);
        jadwal_matkul = itemView.findViewById(R.id.jadwal_matkul);
        jadwal_jam = itemView.findViewById(R.id.jadwal_jam);
        jadwal_dosen = itemView.findViewById(R.id.jadwal_dosen);
        jadwal_lokasi = itemView.findViewById(R.id.jadwal_lokasi);
    }


    public void bindTonetworks(networkjadwal networkjadwals, View.OnClickListener onClickListener){
        jadwal_matkul.setText(networkjadwals.jadwal_matkul);
        jadwal_jam.setText(networkjadwals.jadwal_jam);
        jadwal_dosen.setText(networkjadwals.jadwal_dosen);
        jadwal_lokasi.setText(networkjadwals.jadwal_lokasi);
    }
}
