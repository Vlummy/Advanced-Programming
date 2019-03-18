package main.java.server.student_register_system;

public class Student {
    private String nr;
    private String navn;

    public Student(String nr, String navn) {
        this.setNr(nr);
        this.setNavn(navn);
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
