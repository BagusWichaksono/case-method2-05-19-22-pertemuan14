public class TransaksiLayanan {
    Pasien pasien;
    Dokter dokter;
    int durasiLayanan;
    int biaya;

    public TransaksiLayanan(Pasien pasien, Dokter dokter, int durasi){
        this.pasien = pasien;
        this.dokter = dokter;
        this.durasiLayanan = durasi;
    }

    public int hitungBiaya(){
        return durasiLayanan * 50000;
    }

    public void tampilkantransaksi(){
        System.out.println(pasien.nama + " " + durasiLayanan + " jam : Rp " + biaya);
    }
}
