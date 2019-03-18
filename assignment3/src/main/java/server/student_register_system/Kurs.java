package main.java.server.student_register_system;

public class Kurs {
    private String kode;
    private String navn;

    public Kurs(String kode, String navn) {
        this.setKode(kode);
        this.setNavn(navn);
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
