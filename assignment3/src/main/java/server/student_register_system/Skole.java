package main.java.server.student_register_system;

/**
 * Class for representing school objects
 * Author: Øyvind Johannessen, Roy H. Jensen
 * Version 1.0
 */
public class Skole {
    private String name;

    public Skole(String name){
        this.name = name;
    }

    /**
     * Get school name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set school name
     * @param navn
     */
    public void setName(String navn) {
        this.name = name;
    }
}
