package com.ti3.dedlen.ui.home;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

class networkjadwal {

    public String jadwal_matkul, jadwal_materi, jadwal_jam, jadwal_dosen, jadwal_lokasi;

    public networkjadwal() {
    }


    public networkjadwal(String jadwal_matkul, String jadwal_materi, String jadwal_jam, String jadwal_dosen, String jadwal_lokasi) {
        this.jadwal_matkul = jadwal_matkul;
        this.jadwal_materi = jadwal_materi;
        this.jadwal_jam = jadwal_jam;
        this.jadwal_dosen = jadwal_dosen;
        this.jadwal_lokasi = jadwal_lokasi;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("jadwal_matkul", jadwal_matkul);
        result.put("jadwal_materi", jadwal_materi);
        result.put("jadwal_jam", jadwal_jam);
        result.put("jadwal_dosen", jadwal_dosen);
        result.put("jadwal_lokasi", jadwal_lokasi);

        return result;
    }
}
