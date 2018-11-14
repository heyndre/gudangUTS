/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gudang.Stationary;
import gudang.Food;
import gudang.Drink;
import gudang.Tool;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

/**
 *
 * @author User
 */
public class Main {

    private static void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    private static void garisTepi() {
        System.out.println("================================================================================");
    }

    private static void garisPutus() {
        System.out.println("--------------------------------------------------------------------------------");
    }

    private static void alertPilihanTidakTersedia() throws InterruptedException, IOException {
        garisTepi();
        System.out.println("Pilihan tidak tersedia");
        garisTepi();
        Thread.sleep(1000);
        clearScreen();
    }

    private static void alertInputTidakValid() throws InterruptedException, IOException {
        garisTepi();
        Thread.sleep(400);
        clearScreen();
        garisTepi();
        System.out.println("Input tidak valid");
        garisTepi();
        Thread.sleep(1000);
        clearScreen();
    }

    private static void alertSukses() throws InterruptedException, IOException {
        garisTepi();
        System.out.println("Data berhasil diperbarui");
        garisTepi();
        Thread.sleep(1500);
        clearScreen();
    }

    private static void alertMelebihiJumlahTersedia() throws InterruptedException, IOException {
        garisTepi();
        System.out.println("Tidak bisa");
        System.out.println("Melebihi jumlah barang tersedia");
        garisTepi();
        Thread.sleep(2500);
        clearScreen();
    }

    private static void alertMelebihiKapasitas() throws InterruptedException, IOException {
        garisTepi();
        System.out.println("Tidak bisa");
        System.out.println("Melibihi kapasitas penyimpanan");
        garisTepi();
        Thread.sleep(2500);
        clearScreen();
    }

    private static final Scanner scanner = new Scanner(System.in);

    private static final ArrayList<Stationary> stationarys = new ArrayList<>();
    private static final ArrayList<Food> foods = new ArrayList<>();
    private static final ArrayList<Drink> drinks = new ArrayList<>();
    private static final ArrayList<Tool> tools = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException, IOException {
        clearScreen();
        menuUtama();
    }

    private static void menuUtama() throws InterruptedException, IOException {
        boolean diMenuUtama = true;
        do {
            System.out.println("===================== Selamat Datang di Program WarMaS 1.0 =====================");
            System.out.println("===================================== MENU =====================================");
            System.out.println("1. Tambahkan Daftar Barang");
            System.out.println("2. Masukkan Jumlah barang");
            System.out.println("3. Keluarkan barang");
            System.out.println("4. Lihat Detail Daftar Barang");
            System.out.println("5. Hapus Daftar Barang");
            System.out.println("6. Keluar");
            System.out.print("Pilih: ");
            try {
                int pilih = Integer.parseInt(scanner.nextLine());
                garisTepi();
                Thread.sleep(400);
                clearScreen();
                switch (pilih) {
                    case 1:
                        menuTambahkanDaftarBarang();
                        break;
                    case 2:
                        menuMasukkanBarang();
                        break;
                    case 3:
                        menuKeluarkanBarang();
                        break;
                    case 4:
                        menuLihatDetailDaftarBarang();
                        break;
                    case 5:
                        menuHapusDaftarBarang();
                        break;
                    case 6:
                        diMenuUtama = false;
                        break;
                    default:
                        alertPilihanTidakTersedia();
                }

            } catch (Exception exception) {
                alertInputTidakValid();
            }
        } while (diMenuUtama);

    }

    private static void menuTambahkanDaftarBarang() throws InterruptedException, IOException {
        boolean diMenuTambahkanDaftarBarang = true;
        do {
            System.out.println("=========================== Tambahkan Daftar Barang ============================");
            System.out.println("Jenis: ");
            System.out.println("1. Makanan");
            System.out.println("2. Minuman");
            System.out.println("3. Alat Tulis");
            System.out.println("4. Perkakas");
            garisPutus();
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            try {
                int pilih = Integer.parseInt(scanner.nextLine());
                garisTepi();
                Thread.sleep(500);
                clearScreen();
                switch (pilih) {
                    case 1:
                        menuTambahkanDaftarMakanan();
                        diMenuTambahkanDaftarBarang = false;
                        break;
                    case 2:
                        menutTambahkanDaftarMinuman();
                        diMenuTambahkanDaftarBarang = false;
                        break;
                    case 3:
                        menuTambahkanDaftarAlatTulis();
                        diMenuTambahkanDaftarBarang = false;
                        break;
                    case 4:
                        menuTambahkanDaftarPerkakas();
                        diMenuTambahkanDaftarBarang = false;
                        break;
                    case 0:
                        diMenuTambahkanDaftarBarang = false;
                        break;
                    default:
                        alertPilihanTidakTersedia();
                }
            } catch (Exception e) {
                alertInputTidakValid();
            }
        } while (diMenuTambahkanDaftarBarang);

    }

    private static void menuTambahkanDaftarMakanan() throws InterruptedException, IOException {
        Food food = new Food();
        boolean diMenuTambahkanDaftarMakanan = true;
        do {
            try {
                System.out.println("=========================== Tambahkan Daftar Barang ============================");
                if (food.getNamaProduk() == null) {
                    System.out.print("Nama barang            : ");
                    food.setNamaProduk(scanner.nextLine());
                } else {
                    System.out.printf("Nama barang            : %s\n", food.getNamaProduk());
                }
                if (food.getKapasitasPenyimpanan() == 0) {
                    System.out.print("Kapasitas penyimpanan  : ");
                    food.setKapasitasPenyimpanan(Integer.parseInt(scanner.nextLine()));
                } else {
                    System.out.printf("Kapasitas penyimpanan  : %d\n", food.getKapasitasPenyimpanan());
                }
                if (food.getBiayaPenyimpanan() == 0) {
                    System.out.print("Biaya penyimpanan (Rp.): ");
                    food.setBiayaPenyimpanan(Integer.parseInt(scanner.nextLine()));
                } else {
                    System.out.printf("Biaya penyimpanan (Rp.): %d\n", food.getBiayaPenyimpanan());
                }
                if (food.getLamaPenyimpanan() == 0) {
                    System.out.print("Lama penyimpanan (hari): ");
                    food.setLamaPenyimpanan(Integer.parseInt(scanner.nextLine()));
                } else {
                    System.out.printf("Lama penyimpanan (hari): %d\n", food.getLamaPenyimpanan());
                }
                System.out.println("Kondisi Penyimpanan    :");
                System.out.println("1. Pecah belah");
                System.out.println("2. Bukan pecah belah");
                System.out.print("Pilih: ");
                int pilih = Integer.parseInt(scanner.nextLine());
                garisTepi();
                Thread.sleep(400);
                clearScreen();
                switch (pilih) {
                    case 1:
                        food.setKondisiPenyimpanan("Pecah belah");
                        alertSukses();
                        diMenuTambahkanDaftarMakanan = false;
                        break;
                    case 2:
                        food.setKondisiPenyimpanan("Bukan pecah belah");
                        alertSukses();
                        diMenuTambahkanDaftarMakanan = false;
                        break;
                    default:
                        alertPilihanTidakTersedia();
                }
            } catch (Exception e) {
                alertInputTidakValid();
            }

        } while (diMenuTambahkanDaftarMakanan);
        foods.add(food);
    }

    private static void menutTambahkanDaftarMinuman() throws InterruptedException, IOException {
        Drink drink = new Drink();
        boolean diMenuTambahkanMinuman = true;
        do {
            try {
                System.out.println("=========================== Tambahkan Daftar Barang ============================");
                if (drink.getNamaProduk() == null) {
                    System.out.print("Nama barang            : ");
                    drink.setNamaProduk(scanner.nextLine());
                } else {
                    System.out.printf("Nama barang            : %s\n", drink.getNamaProduk());
                }
                if (drink.getKapasitasPenyimpanan() == 0) {
                    System.out.print("Kapasitas penyimpanan  : ");
                    drink.setKapasitasPenyimpanan(Integer.parseInt(scanner.nextLine()));
                } else {
                    System.out.printf("Kapasitas penyimpanan  : %d\n", drink.getKapasitasPenyimpanan());
                }
                if (drink.getBiayaPenyimpanan() == 0) {
                    System.out.print("Biaya penyimpanan (Rp.): ");
                    drink.setBiayaPenyimpanan(Integer.parseInt(scanner.nextLine()));
                } else {
                    System.out.printf("Biaya penyimpanan (Rp.): %d\n", drink.getBiayaPenyimpanan());
                }
                if (drink.getLamaPenyimpanan() == 0) {
                    System.out.print("Lama penyimpanan (hari): ");
                    drink.setLamaPenyimpanan(Integer.parseInt(scanner.nextLine()));
                } else {
                    System.out.printf("Lama penyimpanan (hari): %d\n", drink.getLamaPenyimpanan());
                }
                System.out.println("Kondisi Penyimpanan    :");
                System.out.println("1. Pecah belah");
                System.out.println("2. Bukan pecah belah");
                System.out.print("Pilih: ");
                int pilih = Integer.parseInt(scanner.nextLine());
                garisTepi();
                Thread.sleep(400);
                clearScreen();
                switch (pilih) {
                    case 1:
                        drink.setKondisiPenyimpanan("Pecah belah");
                        alertSukses();
                        diMenuTambahkanMinuman = false;
                        break;
                    case 2:
                        drink.setKondisiPenyimpanan("Bukan pecah belah");
                        alertSukses();
                        diMenuTambahkanMinuman = false;
                        break;
                    default:
                        alertPilihanTidakTersedia();
                }
            } catch (Exception e) {
                alertInputTidakValid();
            }

        } while (diMenuTambahkanMinuman);
        drinks.add(drink);
    }

    private static void menuTambahkanDaftarAlatTulis() throws InterruptedException, IOException {
        Stationary stationary = new Stationary();
        boolean diMenuTambahkanAlatTulis = true;
        do {
            try {
                System.out.println("=========================== Tambahkan Daftar Barang ============================");
                if (stationary.getNamaProduk() == null) {
                    System.out.print("Nama barang            : ");
                    stationary.setNamaProduk(scanner.nextLine());
                } else {
                    System.out.printf("Nama barang            : %s\n", stationary.getNamaProduk());
                }
                if (stationary.getKapasitasPenyimpanan() == 0) {
                    System.out.print("Kapasitas penyimpanan  : ");
                    stationary.setKapasitasPenyimpanan(Integer.parseInt(scanner.nextLine()));
                } else {
                    System.out.printf("Kapasitas penyimpanan  : %d\n", stationary.getKapasitasPenyimpanan());
                }
                if (stationary.getBiayaPenyimpanan() == 0) {
                    System.out.print("Biaya penyimpanan (Rp.): ");
                    stationary.setBiayaPenyimpanan(Integer.parseInt(scanner.nextLine()));
                } else {
                    System.out.printf("Biaya penyimpanan (Rp.): %d\n", stationary.getBiayaPenyimpanan());
                }
                if (stationary.getLamaPenyimpanan() == 0) {
                    System.out.print("Lama penyimpanan (hari): ");
                    stationary.setLamaPenyimpanan(Integer.parseInt(scanner.nextLine()));
                } else {
                    System.out.printf("Lama penyimpanan (hari): %d\n", stationary.getLamaPenyimpanan());
                }
                System.out.println("Kondisi Penyimpanan    :");
                System.out.println("1. Pecah belah");
                System.out.println("2. Bukan pecah belah");
                System.out.print("Pilih: ");
                int pilih = Integer.parseInt(scanner.nextLine());
                garisTepi();
                Thread.sleep(400);
                clearScreen();
                switch (pilih) {
                    case 1:
                        stationary.setKondisiPenyimpanan("Pecah belah");
                        alertSukses();
                        diMenuTambahkanAlatTulis = false;
                        break;
                    case 2:
                        stationary.setKondisiPenyimpanan("Bukan pecah belah");
                        alertSukses();
                        diMenuTambahkanAlatTulis = false;
                        break;
                    default:
                        alertPilihanTidakTersedia();
                }
            } catch (Exception e) {
                alertInputTidakValid();
            }

        } while (diMenuTambahkanAlatTulis);
        stationarys.add(stationary);
    }

    private static void menuTambahkanDaftarPerkakas() throws InterruptedException, IOException {
        Tool tool = new Tool();
        boolean diMenuTambahkanPerkakas = true;
        do {
            try {
                System.out.println("=========================== Tambahkan Daftar Barang ============================");
                if (tool.getNamaProduk() == null) {
                    System.out.print("Nama barang            : ");
                    tool.setNamaProduk(scanner.nextLine());
                } else {
                    System.out.printf("Nama barang            : %s\n", tool.getNamaProduk());
                }
                if (tool.getKapasitasPenyimpanan() == 0) {
                    System.out.print("Kapasitas penyimpanan  : ");
                    tool.setKapasitasPenyimpanan(Integer.parseInt(scanner.nextLine()));
                } else {
                    System.out.printf("Kapasitas penyimpanan  : %d\n", tool.getKapasitasPenyimpanan());
                }
                if (tool.getBiayaPenyimpanan() == 0) {
                    System.out.print("Biaya penyimpanan (Rp.): ");
                    tool.setBiayaPenyimpanan(Integer.parseInt(scanner.nextLine()));
                } else {
                    System.out.printf("Biaya penyimpanan (Rp.): %d\n", tool.getBiayaPenyimpanan());
                }
                if (tool.getLamaPenyimpanan() == 0) {
                    System.out.print("Lama penyimpanan (hari): ");
                    tool.setLamaPenyimpanan(Integer.parseInt(scanner.nextLine()));
                } else {
                    System.out.printf("Lama penyimpanan (hari): %d\n", tool.getLamaPenyimpanan());
                }
                System.out.println("Kondisi Penyimpanan    :");
                System.out.println("1. Pecah belah");
                System.out.println("2. Bukan pecah belah");
                System.out.print("Pilih: ");
                int pilih = Integer.parseInt(scanner.nextLine());
                garisTepi();
                Thread.sleep(400);
                clearScreen();
                switch (pilih) {
                    case 1:
                        tool.setKondisiPenyimpanan("Pecah belah");
                        alertSukses();
                        diMenuTambahkanPerkakas = false;
                        break;
                    case 2:
                        tool.setKondisiPenyimpanan("Bukan pecah belah");
                        alertSukses();
                        diMenuTambahkanPerkakas = false;
                        break;
                    default:
                        alertPilihanTidakTersedia();
                }
            } catch (Exception e) {
                alertInputTidakValid();
            }

        } while (diMenuTambahkanPerkakas);
        tools.add(tool);
    }

    private static void menuMasukkanBarang() throws InterruptedException, IOException {
        boolean diMenuMasukkanBarang = true;
        do {
            System.out.println("=========================== Masukkan Jumlah Barang =============================");
            if (foods.isEmpty() && drinks.isEmpty() && stationarys.isEmpty() && tools.isEmpty()) {
                System.out.println("Tidak ada barang");
                garisPutus();
                System.out.println("0. Kembali");
                try {
                    System.out.print("Pilih: ");
                    int pilih = Integer.parseInt(scanner.nextLine());
                    garisTepi();
                    Thread.sleep(400);
                    clearScreen();
                    if (pilih == 0) {
                        diMenuMasukkanBarang = false;
                    } else {
                        alertPilihanTidakTersedia();
                    }
                } catch (Exception e) {
                    alertInputTidakValid();
                }
            } else {
                int indeksBarang = 0;
                System.out.println("Daftar nama barang:");
                for (int i = 0; i < foods.size(); i++) {
                    indeksBarang++;
                    System.out.printf("%d. %s\n", indeksBarang, foods.get(i).getNamaProduk());
                }
                for (int i = 0; i < drinks.size(); i++) {
                    indeksBarang++;
                    System.out.printf("%d. %s\n", indeksBarang, drinks.get(i).getNamaProduk());
                }
                for (int i = 0; i < stationarys.size(); i++) {
                    indeksBarang++;
                    System.out.printf("%d. %s\n", indeksBarang, stationarys.get(i).getNamaProduk());
                }
                for (int i = 0; i < tools.size(); i++) {
                    indeksBarang++;
                    System.out.printf("%d. %s\n", indeksBarang, tools.get(i).getNamaProduk());
                }
                garisPutus();
                System.out.println("0. Kembali");
                try {
                    System.out.print("Pilih: ");
                    int pilih = Integer.parseInt(scanner.nextLine());
                    garisTepi();
                    Thread.sleep(400);
                    clearScreen();
                    if (pilih == 0) {
                        diMenuMasukkanBarang = false;
                    } else if (pilih > 0 && pilih <= indeksBarang) {
                        int cekIndeksBarang = 0;
                        System.out.println("=========================== Masukkan Jumlah Barang =============================");
                        System.out.print("Jumlah barang: ");
                        int jumlah = Integer.parseInt(scanner.nextLine());
                        garisTepi();
                        Thread.sleep(400);
                        clearScreen();
                        for (int i = 0; i < foods.size(); i++) {
                            cekIndeksBarang++;
                            if (pilih == cekIndeksBarang) {
                                if (jumlah > (foods.get(i).getKapasitasPenyimpanan() - foods.get(i).getJumlahTersedia())) {
                                    alertMelebihiKapasitas();
                                } else {
                                    foods.get(i).setJumlahMasuk(jumlah);
                                    alertSukses();
                                    diMenuMasukkanBarang = false;
                                }

                            }
                        }
                        for (int i = 0; i < drinks.size(); i++) {
                            cekIndeksBarang++;
                            if (pilih == cekIndeksBarang) {
                                if (jumlah > (drinks.get(i).getKapasitasPenyimpanan() - drinks.get(i).getJumlahTersedia())) {
                                    alertMelebihiKapasitas();
                                } else {
                                    drinks.get(i).setJumlahMasuk(jumlah);
                                    alertSukses();
                                    diMenuMasukkanBarang = false;
                                }

                            }
                        }
                        for (int i = 0; i < stationarys.size(); i++) {
                            cekIndeksBarang++;
                            if (pilih == cekIndeksBarang) {
                                if (jumlah > (stationarys.get(i).getKapasitasPenyimpanan() - stationarys.get(i).getJumlahTersedia())) {
                                    alertMelebihiKapasitas();
                                } else {
                                    stationarys.get(i).setJumlahMasuk(jumlah);
                                    alertSukses();
                                    diMenuMasukkanBarang = false;
                                }

                            }
                        }
                        for (int i = 0; i < tools.size(); i++) {
                            cekIndeksBarang++;
                            if (pilih == cekIndeksBarang) {
                                if (jumlah > (tools.get(i).getKapasitasPenyimpanan() - tools.get(i).getJumlahTersedia())) {
                                    alertMelebihiKapasitas();
                                } else {
                                    tools.get(i).setJumlahMasuk(jumlah);
                                    alertSukses();
                                    diMenuMasukkanBarang = false;
                                }

                            }
                        }

                    } else {
                        alertPilihanTidakTersedia();
                    }
                } catch (Exception e) {
                    alertInputTidakValid();
                }
            }

        } while (diMenuMasukkanBarang);

    }

    private static void menuKeluarkanBarang() throws InterruptedException, IOException {
        boolean diMenuKeluarkanBarang = true;
        do {
            System.out.println("=============================== Keluarkan Barang ===============================");
            if (foods.isEmpty() && drinks.isEmpty() && stationarys.isEmpty() && tools.isEmpty()) {
                System.out.println("Tidak ada barang");
                garisPutus();
                System.out.println("0. Kembali");
                try {
                    System.out.print("Pilih: ");
                    int pilih = Integer.parseInt(scanner.nextLine());
                    garisTepi();
                    Thread.sleep(400);
                    clearScreen();
                    if (pilih == 0) {
                        diMenuKeluarkanBarang = false;
                    } else {
                        alertPilihanTidakTersedia();
                    }
                } catch (Exception e) {
                    alertInputTidakValid();
                }
            } else {
                int indeksBarang = 0;
                System.out.println("Daftar nama barang:");
                for (int i = 0; i < foods.size(); i++) {
                    indeksBarang++;
                    System.out.printf("%d. %s\n", indeksBarang, foods.get(i).getNamaProduk());
                }
                for (int i = 0; i < drinks.size(); i++) {
                    indeksBarang++;
                    System.out.printf("%d. %s\n", indeksBarang, drinks.get(i).getNamaProduk());
                }
                for (int i = 0; i < stationarys.size(); i++) {
                    indeksBarang++;
                    System.out.printf("%d. %s\n", indeksBarang, stationarys.get(i).getNamaProduk());
                }
                for (int i = 0; i < tools.size(); i++) {
                    indeksBarang++;
                    System.out.printf("%d. %s\n", indeksBarang, tools.get(i).getNamaProduk());
                }
                garisPutus();
                System.out.println("0. Kembali");
                try {
                    System.out.print("Pilih: ");
                    int pilih = Integer.parseInt(scanner.nextLine());
                    garisTepi();
                    Thread.sleep(400);
                    clearScreen();
                    if (pilih == 0) {
                        diMenuKeluarkanBarang = false;
                    } else if (pilih > 0 && pilih <= indeksBarang) {
                        int cekIndeksBarang = 0;
                        System.out.println("=============================== Keluarkan Barang ===============================");
                        System.out.print("Jumlah barang: ");
                        int jumlah = Integer.parseInt(scanner.nextLine());
                        garisTepi();
                        Thread.sleep(400);
                        clearScreen();
                        for (int i = 0; i < foods.size(); i++) {
                            cekIndeksBarang++;
                            if (pilih == cekIndeksBarang) {
                                if (jumlah > foods.get(i).getJumlahTersedia()) {
                                    alertMelebihiJumlahTersedia();
                                } else {
                                    foods.get(i).setJumlahKeluar(jumlah);
                                    alertSukses();
                                    diMenuKeluarkanBarang = false;
                                }

                            }
                        }
                        for (int i = 0; i < drinks.size(); i++) {
                            cekIndeksBarang++;
                            if (pilih == cekIndeksBarang) {
                                if (jumlah > drinks.get(i).getJumlahTersedia()) {
                                    alertMelebihiJumlahTersedia();
                                } else {
                                    drinks.get(i).setJumlahKeluar(jumlah);
                                    alertSukses();
                                    diMenuKeluarkanBarang = false;
                                }
                            }
                        }
                        for (int i = 0; i < stationarys.size(); i++) {
                            cekIndeksBarang++;
                            if (pilih == cekIndeksBarang) {
                                if (jumlah > stationarys.get(i).getJumlahTersedia()) {
                                    alertMelebihiJumlahTersedia();
                                } else {
                                    stationarys.get(i).setJumlahKeluar(jumlah);
                                    alertSukses();
                                    diMenuKeluarkanBarang = false;
                                }

                            }
                        }
                        for (int i = 0; i < tools.size(); i++) {
                            cekIndeksBarang++;
                            if (pilih == cekIndeksBarang) {
                                if (jumlah > tools.get(i).getJumlahTersedia()) {
                                    alertMelebihiJumlahTersedia();
                                } else {
                                    tools.get(i).setJumlahKeluar(jumlah);
                                    alertSukses();
                                    diMenuKeluarkanBarang = false;
                                }
                            }
                        }
                    } else {
                        alertPilihanTidakTersedia();
                    }
                } catch (Exception e) {
                    alertInputTidakValid();
                }
            }

        } while (diMenuKeluarkanBarang);

    }

    private static void menuLihatDetailDaftarBarang() throws InterruptedException, IOException {
        boolean diMenuLihatBarang = true;
        do {
            System.out.println("========================== Lihat Detail Daftar Barang ==========================");
            if (foods.isEmpty() && drinks.isEmpty() && stationarys.isEmpty() && tools.isEmpty()) {
                System.out.println("Tidak ada barang");
            } else {
                int indeksBarang = 0;
                for (int i = 0; i < foods.size(); i++) {
                    indeksBarang++;
                    System.out.printf("%d.  -Nama barang           : %s\n", indeksBarang, foods.get(i).getNamaProduk());
                    System.out.println("    -Jenis barang          : Makanan");
                    System.out.printf("    -Kondisi barang        : %s\n", foods.get(i).getKondisiPenyimpanan());
                    System.out.printf("    -Lama penyimpanan      : %d hari (terhitung dari waktu barang masuk pertama)\n", foods.get(i).getLamaPenyimpanan());
                    System.out.printf("    -Kapasitas penyimpanan : %d\n", foods.get(i).getKapasitasPenyimpanan());
                    System.out.printf("    -Jumlah barang tersedia: %d\n", foods.get(i).getJumlahTersedia());
                    System.out.println("    -Riwayat barang masuk  : (no) (Jumlah)\t(waktu)");
                    if (foods.get(i).getRiwayatJumlahMasuk().isEmpty()) {
                        System.out.println("                               - Tidak ada");
                    } else {
                        for (int j = 0; j < foods.get(i).getRiwayatJumlahMasuk().size(); j++) {
                            System.out.printf("                               %d.   %s\n", j + 1, foods.get(i).getRiwayatJumlahMasuk().get(j));
                        }
                    }
                    System.out.println("    -Riwayat barang keluar : (no) (Jumlah)\t(waktu)");
                    if (foods.get(i).getRiwayatJumlahKeluar().isEmpty()) {
                        System.out.println("                               - Tidak ada");
                    } else {
                        for (int j = 0; j < foods.get(i).getRiwayatJumlahKeluar().size(); j++) {
                            System.out.printf("                               %d.   %s\n", j + 1, foods.get(i).getRiwayatJumlahKeluar().get(j));
                        }
                    }
                    System.out.printf("    -Biaya penyimpanan     : Rp.%d\n", foods.get(i).getBiayaPenyimpanan());
                }
                for (int i = 0; i < drinks.size(); i++) {
                    indeksBarang++;
                    System.out.printf("%d.  -Nama barang           : %s\n", indeksBarang, drinks.get(i).getNamaProduk());
                    System.out.println("    -Jenis barang          : Minuman");
                    System.out.printf("    -Kondisi barang        : %s\n", drinks.get(i).getKondisiPenyimpanan());
                    System.out.printf("    -Lama penyimpanan      : %d hari (terhitung dari waktu barang masuk pertama)\n", drinks.get(i).getLamaPenyimpanan());
                    System.out.printf("    -Kapasitas penyimpanan : %d\n", drinks.get(i).getKapasitasPenyimpanan());
                    System.out.printf("    -Jumlah barang tersedia: %d\n", drinks.get(i).getJumlahTersedia());
                    System.out.println("    -Riwayat barang masuk  : (no) (Jumlah)\t(waktu)");
                    if (drinks.get(i).getRiwayatJumlahMasuk().isEmpty()) {
                        System.out.println("                               - Tidak ada");
                    } else {
                        for (int j = 0; j < drinks.get(i).getRiwayatJumlahMasuk().size(); j++) {
                            System.out.printf("                               %d.   %s\n", j + 1, drinks.get(i).getRiwayatJumlahMasuk().get(j));
                        }
                    }
                    System.out.println("    -Riwayat barang keluar : (no) (Jumlah)\t(waktu)");
                    if (drinks.get(i).getRiwayatJumlahKeluar().isEmpty()) {
                        System.out.println("                               - Tidak ada");
                    } else {
                        for (int j = 0; j < drinks.get(i).getRiwayatJumlahKeluar().size(); j++) {
                            System.out.printf("                               %d.   %s\n", j + 1, drinks.get(i).getRiwayatJumlahKeluar().get(j));
                        }
                    }
                    System.out.printf("    -Biaya penyimpanan     : Rp.%d\n", drinks.get(i).getBiayaPenyimpanan());
                }
                for (int i = 0; i < stationarys.size(); i++) {
                    indeksBarang++;
                    System.out.printf("%d.  -Nama barang           : %s\n", indeksBarang, stationarys.get(i).getNamaProduk());
                    System.out.println("    -Jenis barang          : Alat Tulis");
                    System.out.printf("    -Kondisi barang        : %s\n", stationarys.get(i).getKondisiPenyimpanan());
                    System.out.printf("    -Lama penyimpanan      : %d hari (terhitung dari waktu barang masuk pertama)\n", stationarys.get(i).getLamaPenyimpanan());
                    System.out.printf("    -Kapasitas penyimpanan : %d\n", stationarys.get(i).getKapasitasPenyimpanan());
                    System.out.printf("    -Jumlah barang tersedia: %d\n", stationarys.get(i).getJumlahTersedia());
                    System.out.println("    -Riwayat barang masuk  : (no) (Jumlah)\t(waktu)");
                    if (stationarys.get(i).getRiwayatJumlahMasuk().isEmpty()) {
                        System.out.println("                               - Tidak ada");
                    } else {
                        for (int j = 0; j < stationarys.get(i).getRiwayatJumlahMasuk().size(); j++) {
                            System.out.printf("                               %d.   %s\n", j + 1, stationarys.get(i).getRiwayatJumlahMasuk().get(j));
                        }
                    }
                    System.out.println("    -Riwayat barang keluar : (no) (Jumlah)\t(waktu)");
                    if (stationarys.get(i).getRiwayatJumlahKeluar().isEmpty()) {
                        System.out.println("                               - Tidak ada");
                    } else {
                        for (int j = 0; j < stationarys.get(i).getRiwayatJumlahKeluar().size(); j++) {
                            System.out.printf("                               %d.   %s\n", j + 1, stationarys.get(i).getRiwayatJumlahKeluar().get(j));
                        }
                    }
                    System.out.printf("    -Biaya penyimpanan     : Rp.%d\n", stationarys.get(i).getBiayaPenyimpanan());
                }
                for (int i = 0; i < tools.size(); i++) {
                    indeksBarang++;
                    System.out.printf("%d.  -Nama barang           : %s\n", indeksBarang, tools.get(i).getNamaProduk());
                    System.out.println("    -Jenis barang          : Perkakas");
                    System.out.printf("    -Kondisi barang        : %s\n", tools.get(i).getKondisiPenyimpanan());
                    System.out.printf("    -Lama penyimpanan      : %d hari (terhitung dari waktu barang masuk pertama)\n", tools.get(i).getLamaPenyimpanan());
                    System.out.printf("    -Kapasitas penyimpanan : %d\n", tools.get(i).getKapasitasPenyimpanan());
                    System.out.printf("    -Jumlah barang tersedia: %d\n", tools.get(i).getJumlahTersedia());
                    System.out.println("    -Riwayat barang masuk  : (no) (Jumlah)\t(waktu)");
                    if (tools.get(i).getRiwayatJumlahMasuk().isEmpty()) {
                        System.out.println("                               - Tidak ada");
                    } else {
                        for (int j = 0; j < tools.get(i).getRiwayatJumlahMasuk().size(); j++) {
                            System.out.printf("                               %d.   %s\n", j + 1, tools.get(i).getRiwayatJumlahMasuk().get(j));
                        }
                    }
                    System.out.println("    -Riwayat barang keluar : (no) (Jumlah)\t(waktu)");
                    if (tools.get(i).getRiwayatJumlahKeluar().isEmpty()) {
                        System.out.println("                               - Tidak ada");
                    } else {
                        for (int j = 0; j < tools.get(i).getRiwayatJumlahKeluar().size(); j++) {
                            System.out.printf("                               %d.   %s\n", j + 1, tools.get(i).getRiwayatJumlahKeluar().get(j));
                        }
                    }
                    System.out.printf("    -Biaya penyimpanan     : Rp.%d\n", tools.get(i).getBiayaPenyimpanan());
                }

            }
            garisPutus();
            System.out.println("0. Kembali");
            try {
                System.out.print("Pilih: ");
                int pilih = Integer.parseInt(scanner.nextLine());
                garisTepi();
                Thread.sleep(400);
                clearScreen();
                if (pilih == 0) {
                    diMenuLihatBarang = false;
                } else {
                    alertPilihanTidakTersedia();
                }
            } catch (Exception e) {
                alertInputTidakValid();
            }
        } while (diMenuLihatBarang);

    }

    private static void menuHapusDaftarBarang() throws InterruptedException, IOException {
        boolean diMenuHapusBarang = true;
        do {
            System.out.println("============================= Hapus Daftar Barang ==============================");
            if (foods.isEmpty() && drinks.isEmpty() && stationarys.isEmpty() && tools.isEmpty()) {
                System.out.println("Tidak ada barang");
                garisPutus();
                System.out.println("0. Kembali");
                try {
                    System.out.print("Pilih: ");
                    int pilih = Integer.parseInt(scanner.nextLine());
                    garisTepi();
                    Thread.sleep(400);
                    clearScreen();
                    if (pilih == 0) {
                        diMenuHapusBarang = false;
                    } else {
                        alertPilihanTidakTersedia();
                    }
                } catch (Exception e) {
                    alertInputTidakValid();
                }
            } else {
                int indeksBarang = 0;
                System.out.println("Daftar nama barang:");
                for (int i = 0; i < foods.size(); i++) {
                    indeksBarang++;
                    System.out.printf("%d. %s\n", indeksBarang, foods.get(i).getNamaProduk());
                }
                for (int i = 0; i < drinks.size(); i++) {
                    indeksBarang++;
                    System.out.printf("%d. %s\n", indeksBarang, drinks.get(i).getNamaProduk());
                }
                for (int i = 0; i < stationarys.size(); i++) {
                    indeksBarang++;
                    System.out.printf("%d. %s\n", indeksBarang, stationarys.get(i).getNamaProduk());
                }
                for (int i = 0; i < tools.size(); i++) {
                    indeksBarang++;
                    System.out.printf("%d. %s\n", indeksBarang, tools.get(i).getNamaProduk());
                }
                garisPutus();
                System.out.println("0. Kembali");
                try {
                    System.out.print("Pilih: ");
                    int pilih = Integer.parseInt(scanner.nextLine());
                    garisTepi();
                    Thread.sleep(400);
                    clearScreen();
                    if (pilih == 0) {
                        diMenuHapusBarang = false;
                    } else if (pilih > 0 && pilih <= indeksBarang) {
                        int cekIndeksBarang = 0;
                        for (int i = 0; i < foods.size(); i++) {
                            cekIndeksBarang++;
                            if (pilih == cekIndeksBarang) {
                                foods.remove(i);
                            }
                        }
                        for (int i = 0; i < drinks.size(); i++) {
                            cekIndeksBarang++;
                            if (pilih == cekIndeksBarang) {
                                drinks.remove(i);
                            }
                        }
                        for (int i = 0; i < stationarys.size(); i++) {
                            cekIndeksBarang++;
                            if (pilih == cekIndeksBarang) {
                                stationarys.remove(i);
                            }
                        }
                        for (int i = 0; i < tools.size(); i++) {
                            cekIndeksBarang++;
                            if (pilih == cekIndeksBarang) {
                                tools.remove(i);
                            }
                        }
                        alertSukses();
                        diMenuHapusBarang = false;
                    } else {
                        alertPilihanTidakTersedia();
                    }
                } catch (Exception e) {
                    alertInputTidakValid();
                }
            }

        } while (diMenuHapusBarang);
    }

}
