package main.java.server.student_register_system;

public class Student {
    private Integer studentNo;
    private String navn;
    private String kullKode;

    public Student(Integer studentNo, String navn, String kullKode) {
        this.setStudentNo(studentNo);
        this.setNavn(navn);
        this.setKullKode(kullKode);
    }

    public Integer getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getKullKode() {
        return kullKode;
    }

    public void setKullKode(String kullKode) {
        this.kullKode = kullKode;
    }
}
