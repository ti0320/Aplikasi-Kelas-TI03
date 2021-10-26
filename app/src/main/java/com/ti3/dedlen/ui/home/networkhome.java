package com.ti3.dedlen.ui.home;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

class networkhome {
    public String info_dosen, info_matkul, info_peringatan, jadwal_matkul, jadwal_materi, jadwal_jam, jadwal_dosen, jadwal_lokasi;

    public networkhome() {
    }


    public networkhome(String info_dosen, String info_matkul, String info_peringatan, String jadwal_matkul, String jadwal_materi, String jadwal_jam, String jadwal_dosen, String jadwal_lokasi) {
        this.info_dosen = info_dosen;
        this.info_matkul = info_matkul;
        this.info_peringatan = info_peringatan;
        this.jadwal_matkul = jadwal_matkul;
        this.jadwal_materi = jadwal_materi;
        this.jadwal_jam = jadwal_jam;
        this.jadwal_dosen = jadwal_dosen;
        this.jadwal_lokasi = jadwal_lokasi;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("info_dosen", info_dosen);
        result.put("info_matkul", info_matkul);
        result.put("info_peringatan", info_peringatan);
        result.put("jadwal_matkul", jadwal_matkul);
        result.put("jadwal_materi", jadwal_materi);
        result.put("jadwal_jam", jadwal_jam);
        result.put("jadwal_dosen", jadwal_dosen);
        result.put("jadwal_lokasi", jadwal_lokasi);

        return result;
    }
}
