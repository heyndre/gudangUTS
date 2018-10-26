/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gudang.AlatTulis;
import gudang.Makanan;
import gudang.Minuman;
import gudang.Perkakas;

/**
 *
 * @author User
 */
public class Main {

    static AlatTulis pensil2B = new AlatTulis();
    static AlatTulis buku48lbr = new AlatTulis();
    static AlatTulis penghapus = new AlatTulis();

    static Makanan cheetos = new Makanan();
    static Makanan chocolatos = new Makanan();
    static Makanan cadbury = new Makanan();

    static Minuman aqua = new Minuman();
    static Minuman cocacola = new Minuman();
    static Minuman ultramilk = new Minuman();

    static Perkakas lilin = new Perkakas();
    static Perkakas korekApi = new Perkakas();
    static Perkakas cableTie = new Perkakas();

    public static void main(String[] args) {
        pensil2B.setLamaPenyimpanan(5);
        pensil2B.setBiayaPenyimpanan(2);
        pensil2B.setJumlahMasuk(14);
        pensil2B.setJumlahKeluar(5);
        pensil2B.setKondisiPenyimpanan("Tidak Pecah Belah");
    }

}
