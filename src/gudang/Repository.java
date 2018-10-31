/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gudang;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author User
 */
public class Repository {

    private int lamaPenyimpanan, biayaPenyimpanan, jumlahMasuk, jumlahKeluar, jumlahTersedia, kapasitasPenyimpanan;
    private String kondisiPenyimpanan, namaProduk;

    private ArrayList riwayatJumlahMasuk = new ArrayList();
    private ArrayList riwayatJumlahKeluar = new ArrayList();

    private void updateJumlahTersedia() {
        jumlahTersedia += jumlahMasuk;
        jumlahTersedia -= jumlahKeluar;
    }

    public int getJumlahTersedia() {
        return jumlahTersedia;
    }

    private void updateRiwayatJumlahMasuk() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateFormat = simpleDateFormat.format(date);
        riwayatJumlahMasuk.add(jumlahMasuk + "  \t" + dateFormat);
    }

    private void updateRiwayatJumlahKeluar() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateFormat = simpleDateFormat.format(date);
        riwayatJumlahKeluar.add(jumlahKeluar + "  \t" + dateFormat);
    }

    public ArrayList getRiwayatJumlahMasuk() {
        return riwayatJumlahMasuk;
    }

    public ArrayList getRiwayatJumlahKeluar() {
        return riwayatJumlahKeluar;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

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

    public void setJumlahMasuk(int jumlahMasuk) {
        this.jumlahMasuk = jumlahMasuk;
        updateRiwayatJumlahMasuk();
        updateJumlahTersedia();
        this.jumlahMasuk = 0;
    }

    public void setJumlahKeluar(int jumlahKeluar) {
        this.jumlahKeluar = jumlahKeluar;
        updateRiwayatJumlahKeluar();
        updateJumlahTersedia();
        this.jumlahKeluar = 0;

    }

    public String getKondisiPenyimpanan() {
        return kondisiPenyimpanan;
    }

    public void setKondisiPenyimpanan(String kondisiPenyimpanan) {
        this.kondisiPenyimpanan = kondisiPenyimpanan;
    }

    public int getKapasitasPenyimpanan() {
        return kapasitasPenyimpanan;
    }

    public void setKapasitasPenyimpanan(int kapasitasPenyimpanan) {
        this.kapasitasPenyimpanan = kapasitasPenyimpanan;
    }

    public void reset() {
        lamaPenyimpanan = 0;
        biayaPenyimpanan = 0;
        jumlahMasuk = 0;
        jumlahKeluar = 0;
        jumlahTersedia = 0;
        kondisiPenyimpanan = null;
        namaProduk = null;
        riwayatJumlahMasuk.clear();
        riwayatJumlahKeluar.clear();
    }

}
