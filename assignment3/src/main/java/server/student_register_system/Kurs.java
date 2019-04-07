package main.java.server.student_register_system;

public class Kurs {
    private String kode;
    private String navn;
    private String skoleNavn;

    public Kurs(String kode, String navn, String skoleNavn) {
        this.setKode(kode);
        this.setNavn(navn);
        this.setSkoleNavn(skoleNavn);
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

    public String getSkoleNavn() { return skoleNavn; }

    public void setSkoleNavn(String skole){ this.skoleNavn = skole;}
}
