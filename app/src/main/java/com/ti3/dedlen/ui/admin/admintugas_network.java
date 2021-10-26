package com.ti3.dedlen.ui.admin;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

class admintugas_network {
    public String tugas_matkul, tugas_info, tugas_jam, tugas_judul;

    public admintugas_network() {
    }


    public admintugas_network(String tugas_matkul, String tugas_info, String tugas_jam, String tugas_judul) {
        this.tugas_matkul = tugas_matkul;
        this.tugas_judul = tugas_judul;
        this.tugas_info = tugas_info;
        this.tugas_jam = tugas_jam;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("tugas_matkul", tugas_matkul);
        result.put("tugas_judul", tugas_judul);
        result.put("tugas_uinfo", tugas_info);
        result.put("tugas_jam", tugas_jam);

        return result;
    }

}
