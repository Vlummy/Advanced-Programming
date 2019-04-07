package main.java.server.student_register_system;

public class Karakter {
    private String verdi;
    private Integer studentID;
    private String courseID;
    private Integer ar;

    public Karakter(String verdi, Integer studentID, String courseID, Integer ar) {
        this.setVerdi(verdi);
        this.setStudentID(studentID);
        this.setCourseID(courseID);
        this.setAr(ar);
    }

    public String getVerdi() {
        return verdi;
    }

    public void setVerdi(String verdi) {
        this.verdi = verdi;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public Integer getAr() {
        return ar;
    }

    public void setAr(Integer ar) {
        this.ar = ar;
    }
}
