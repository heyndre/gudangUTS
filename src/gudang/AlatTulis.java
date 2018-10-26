/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gudang;

/**
 *
 * @author User
 */
public class AlatTulis extends Gudang {

    private int lamaPenyimpanan, biayaPenyimpanan, jumlahMasuk, jumlahKeluar, jumlahTersedia;
    private String kondisiPenyimpanan;

    @Override
    public int getLamaPenyimpanan() {
        return lamaPenyimpanan;
    }

    @Override
    public void setLamaPenyimpanan(int lamaPenyimpanan) {
        this.lamaPenyimpanan = lamaPenyimpanan;
    }

    
    @Override
    public int getBiayaPenyimpanan() {
        return biayaPenyimpanan;
    }

    @Override
    public void setBiayaPenyimpanan(int biayaPenyimpanan) {
        this.biayaPenyimpanan = biayaPenyimpanan;
    }

    @Override
    public int getJumlahMasuk() {
        return jumlahMasuk;
    }

    @Override
    public void setJumlahMasuk(int jumlahMasuk) {
        this.jumlahMasuk = jumlahMasuk;
    }

    @Override
    public int getJumlahKeluar() {
        return jumlahKeluar;
    }

    @Override
    public void setJumlahKeluar(int jumlahKeluar) {
        this.jumlahKeluar = jumlahKeluar;
    }

    @Override
    public String getKondisiPenyimpanan() {
        return kondisiPenyimpanan;
    }

    @Override
    public void setKondisiPenyimpanan(String kondisiPenyimpanan) {
        this.kondisiPenyimpanan = kondisiPenyimpanan;
    }

}
