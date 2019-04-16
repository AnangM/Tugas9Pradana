import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int index = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Mahasiswa[] mahasiswa = new Mahasiswa[20];

    public static void main(String[] args) {
        int menu = 0;
        do {
            try {
                cetakMenu();
                System.out.print("PILIHAN ANDA --> ");
                menu = Integer.parseInt(br.readLine());
                switch (menu) {
                case 1:
                    String ulang = "y";
                    while (ulang.equals("y") || ulang.equals("Y")) {
                        mahasiswa[index] = createMahasiswa();
                        index++;
                        System.out.print("Masukkan data lagi? (y/n) ");
                        ulang = br.readLine();
                    }
                    break;
                case 2:
                    lihatData();
                    break;
                case 3:
                    System.out.print("Masukkan NIM : ");
                    String nim = br.readLine();
                    Mahasiswa mhs = mahasiswa[cariMahasiswa(nim)];
                    System.out.println("Nama --> " + mhs.getNim());
                    System.out.println("Nama --> " + mhs.getNama());
                    break;
                case 4:
                    System.out.println();
                    System.out.print("Masukkan NIM untuk diubah -->");
                    String nimUbah = br.readLine();
                    Integer mhsUbah = cariMahasiswa(nimUbah);
                    ubahData(mhsUbah);
                    break;
                case 5:
                    System.out.println();
                    System.out.print("Masukkan NIM untuk dihapus -->  ");
                    String nimHapus = br.readLine();
                    int indexHapus = cariMahasiswa(nimHapus);
                    System.out.print("Apakah anda yakin?(y/n) ");
                    if (br.readLine().equals("y")) {
                        hapusData(indexHapus);
                    }
                    break;
                case 6:
                    System.out.println();
                    System.out.println("Pilih 1 untuk menggunakan metode selection sort");
                    System.out.println("      2 untuk menggunakan metode exchange sort");
                    System.out.println("      3 untuk menggunakan metode buble sort");
                    System.out.println("      4 untuk menggunakan metode insertion sort");
                    System.out.println("      5 untuk menggunakan metode shell sort");
                    System.out.print("Pilihan anda --> ");
                    String pilihSort = br.readLine();
                    if (pilihSort.equals("1")) {
                        selectionSort();
                    } else if (pilihSort.equals("2")) {
                        exchangeSort();
                    } else if (pilihSort.equals("3")) {
                        bubleSort();
                    } else if (pilihSort.equals("4")) {
                        insertionSort();
                    }else if(pilihSort.equals("5")){
                        shellSort();
                    }
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (menu != 7);
    }

    /**
     * 
     * @param mhs The array containing data to be shown
     */
    static void lihatData() {
        System.out.println();
        System.out.println("++--++---------------++---------------++");
        System.out.println("||No||      Nim      ||      Nama     ||");
        System.out.println("++--++---------------++---------------++");
        for (int i = 0; i < index; i++) {
            if (mahasiswa[i] != null) {
                if (i < 10) {
                    System.out.print("||" + (i + 1) + " ||");
                } else {
                    System.out.print("||" + (i + 1) + "||");

                }
                System.out.printf("%-15s||", mahasiswa[i].getNim());
                System.out.printf("%-15s||%n", mahasiswa[i].getNama());
            }
        }
        System.out.println("++--++---------------++---------------++");
    }

    static void ubahData(Integer i) {
        try {
            if (i != null) {
                System.out.println();
                System.out.println("Nama --> " + mahasiswa[i].getNama());
                System.out.println("Nim --> " + mahasiswa[i].getNim());
                System.out.println("Pilih: 1 Untuk Mengubah Nim");
                System.out.println("       2 Untuk Mengubah Nama");
                System.out.println("       0 Kembali ke menu utama");
                System.out.print("Pilihan anda --> ");
                String pilihan = br.readLine();
                if (pilihan.equals("1")) {
                    System.out.print("Nim" + mahasiswa[i].getNim() + " diubah menjadi --> ");
                    String nimBaru = br.readLine();
                    System.out.print("Apakah anda yakin akan mengubah?(y/n) ");
                    if (br.readLine().equals("y")) {
                        mahasiswa[i].setNim(nimBaru);
                    }
                    ubahData(i);
                    System.out.println("Data Berhasil Diubah!");
                } else if (pilihan.equals("2")) {
                    System.out.print("Nama" + mahasiswa[i].getNama() + " diubah menjadi --> ");
                    String namaBaru = br.readLine();
                    System.out.print("Apakah anda yakin akan mengubah?(y/n) ");
                    if (br.readLine().equals("y")) {
                        mahasiswa[i].setNama(namaBaru);
                    }
                    ubahData(i);
                    System.out.println("Data Berhasil Diubah!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param mahasiswa The array containing data to be searched
     * @param nim       The Keyword by NIM
     * @return if found return the array index of the data if not found return null
     */
    static Integer cariMahasiswa(String nim) {
        int indexFound = 0;
        boolean found = false;
        for (int i = 0; i < mahasiswa.length; i++) {
            if (mahasiswa[i] != null) {
                if (mahasiswa[i].getNim().equals(nim)) {
                    indexFound = i;
                    found = true;
                }
            }
        }

        if (found) {
            return indexFound;
        } else {
            return null;
        }
    }

    /**
     * 
     * @return return the object created and ready to input to array
     */
    static Mahasiswa createMahasiswa() {
        String nama, nim;
        Mahasiswa mhs = new Mahasiswa();
        try {
            System.out.print("Masukkan NIM -> ");
            nim = br.readLine();
            System.out.print("Masukkan Nama ->");
            nama = br.readLine();
            mhs.setNama(nama);
            mhs.setNim(nim);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mhs;
    }

    static void hapusData(int i) {
        if (i < index) {
            mahasiswa[i] = mahasiswa[i + 1];
            hapusData(i + 1);
        } else {
            mahasiswa[index] = null;
            index--;
        }
    }

    // SORTING
    // WORKING DO NOT TOUCH!
    static void selectionSort() {
        for (int i = 0; i < index - 1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < index; j++) {
                if (Long.parseLong(mahasiswa[indexMin].getNim())>Long.parseLong(mahasiswa[j].getNim())) {
                    indexMin = j;

                }
            }
            if (indexMin != i) {
                Mahasiswa temp = mahasiswa[indexMin];
                mahasiswa[indexMin] = mahasiswa[i];
                mahasiswa[i] = temp;
            }
        }
    }

    // WORKING DO NOT TOUCH!
    static void exchangeSort() {
        for (int i = 0; i < index - 1; i++) {
            for (int j = i + 1; j < index; j++) {
                if ((Long.parseLong(mahasiswa[i].getNim())>Long.parseLong(mahasiswa[j].getNim()))) {
                    Mahasiswa temp = mahasiswa[i];
                    mahasiswa[i] = mahasiswa[j];
                    mahasiswa[j] = temp;
                }
            }
        }
    }

    // WORKING DO NOT TOUCH!
    static void bubleSort() {
        for (int i = 0; i < index - 1; i++) {
            for (int j = 0; j < index - i - 1; j++) {
                if (Long.parseLong(mahasiswa[j].getNim())>Long.parseLong(mahasiswa[j + 1].getNim())) {
                    Mahasiswa temp = mahasiswa[j];
                    mahasiswa[j] = mahasiswa[j + 1];
                    mahasiswa[j + 1] = temp;
                }
            }
        }
    }
    //WORKING DO NOT TOUCH
    static void insertionSort() {
        for (int i = 1; i < index; i++) {
            Mahasiswa key = mahasiswa[i];
            int j = i -1;
            
            while(j>=0&&(Long.parseLong(mahasiswa[j].getNim())>Long.parseLong(key.getNim()))){
                mahasiswa[j+1] = mahasiswa[j];
                j = j - 1;
            }
            mahasiswa[j+1] = key;

        }
    }
    //WORKING DO NOT TOUCH
    static void shellSort() {
        for (int lompat = index/2; lompat > 0;lompat /= 2) {
            for(int i = lompat; i<index; i++){
                Mahasiswa temp = mahasiswa[i];
                int j;
                for(j = i;j >= lompat && 
                    (Long.parseLong(mahasiswa[j-lompat].getNim())>Long.parseLong(temp.getNim()))
                ; j -= lompat){
                    mahasiswa[j] = mahasiswa[j-lompat];
                }
                mahasiswa[j]=temp;
            }
        }
    }

    // CETAK MENU
    static void cetakMenu() {
        System.out.println(".:Menu:.");
        System.out.println("1. Tambahkan Data");
        System.out.println("2. Lihat Data");
        System.out.println("3. Cari Data");
        System.out.println("4. Ubah Data");
        System.out.println("5. Hapus Data");
        System.out.println("6. Urutkan Data");
        System.out.println("7. Keluar");
        System.out.println();
    }
}