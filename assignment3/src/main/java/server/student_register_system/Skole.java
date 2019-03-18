package main.java.server.student_register_system;

/**
 * Class for representing school objects
 * Author: Øyvind Johannessen, Roy H. Jensen
 * Version 1.0
 */
public class Skole {
    private String navn;

    /**
     * Get school name
     * @return
     */
    public String getName() {
        return navn;
    }

    /**
     * Set school name
     * @param navn
     */
    public void setName(String navn) {
        this.navn = navn;
    }
}
