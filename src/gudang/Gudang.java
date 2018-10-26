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
public class Gudang {
    private int lamaPenyimpanan, biayaPenyimpanan,jumlahMasuk,jumlahKeluar, jumlahTersedia;
    private String kondisiPenyimpanan;

    public int getLamaPenyimpanan() {
        return lamaPenyimpanan;
    }

    public void setLamaPenyimpanan(int lamaPenyimpanan) {
        this.lamaPenyimpanan = lamaPenyimpanan;
    }

    public int getBiayaPenyimpanan() {
        return biayaPenyimpanan;
    }

    public void setBiayaPenyimpanan(int biayaPenyimpanan) {
        this.biayaPenyimpanan = biayaPenyimpanan;
    }

    public int getJumlahMasuk() {
        return jumlahMasuk;
    }

    public void setJumlahMasuk(int jumlahMasuk) {
        this.jumlahMasuk = jumlahMasuk;
    }

    public int getJumlahKeluar() {
        return jumlahKeluar;
    }

    public void setJumlahKeluar(int jumlahKeluar) {
        this.jumlahKeluar = jumlahKeluar;
    }

    public String getKondisiPenyimpanan() {
        return kondisiPenyimpanan;
    }

    public void setKondisiPenyimpanan(String kondisiPenyimpanan) {
        this.kondisiPenyimpanan = kondisiPenyimpanan;
    }

    
    
}
