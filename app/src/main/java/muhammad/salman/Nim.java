package muhammad.salman;

/**
 * Created by Qoharu on 3/7/17.
 */

public class Nim {
    int id;
    int nim;
    String nama;

    public Nim(){

    }

    public Nim(int nim, String nama){
        this.nama = nama;
        this.nim = nim;
    }
    public Nim(int id, int nim, String nama){
        this.id = id;
        this.nama = nama;
        this.nim = nim;
    }

    public int getId() {
        return id;
    }

    public int getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }
}
