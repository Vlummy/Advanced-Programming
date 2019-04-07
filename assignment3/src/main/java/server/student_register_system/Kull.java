package main.java.server.student_register_system;

public class Kull {
    private String kode;
    private String skoleNavn;

    public Kull(String kode, String skoleNavn) {
        this.setKode(kode);
        this.setSkoleNavn(skoleNavn);
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getSkoleNavn() { return skoleNavn; }

    public void setSkoleNavn(String skoleNavn){ this.skoleNavn = skoleNavn;}
}
