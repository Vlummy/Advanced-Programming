package main.java.server.student_register_system;

public class Karakter {
    private Integer id;
    private String karakter;
    private Integer ar;

    public Karakter(Integer id, String karakter, Integer ar) {
        this.setId(id);
        this.setKarakter(karakter);
        this.setAr(ar);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKarakter() {
        return karakter;
    }

    public void setKarakter(String karakter) {
        this.karakter = karakter;
    }

    public Integer getAr() {
        return ar;
    }

    public void setAr(Integer ar) {
        this.ar = ar;
    }
}
