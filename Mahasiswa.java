public class Mahasiswa{
    private String nomorInduk;
    private String nama;

    public Mahasiswa(){}
    /**
     * 
     * @param nim Nomor Induk Mahasiswa
     * @param nama Nama Mahasiswa
     */
    public Mahasiswa(String nim, String nama){
        this.nomorInduk = nim;
        this.nama = nama;
    }

    /**
     * 
     * @param nim Nomor induk Mahasiswa
     */
    public void setNim(String nim){
        this.nomorInduk = nim;
    }
    /**
     * 
     * @param name Nama Mahasiswa
     */
    public void setNama(String name){
        this.nama = name;
    }

    public String getNim(){
        return this.nomorInduk;
    }
    public String getNama(){
        return this.nama;
    }

}