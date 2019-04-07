package main.java.server.data_access_objects.dao_interfaces;

import main.java.server.student_register_system.Karakter;
import main.java.server.student_register_system.Kurs;
import main.java.server.student_register_system.Student;

import java.util.List;

public interface KarakterDAOInterface {
    /**
     * Finds an entry in the database table and returns it as an object.
     * @param student The student connected to a karakter in the database.
     * @param course The course connected to a karakter in the database.
     * @param ar The year value for a karakter in the database.
     * @return Karakter An object representation of the particular database entry.
     */
    public Karakter findKarakter(Student student, Kurs course, Integer ar);

    /**
     * Finds all entries in the database table and returns them as a list of object.
     * @return List<Karakter> A list of object representations from the database table.
     */
    public List<Karakter> findAllKarakter();

    /**
     *  Updates an entry in the database table.
     * @param karakter the entry that needs updating.
     * @param verdi the new value for the grade entry.
     * @param student the new value for the grade entry.
     * @param course the new value for the grade entry.
     * @param ar the new value for the year entry
     *
     */
    public void updateKarakter (Karakter karakter, String verdi, Student student, Kurs course, Integer ar);

    /**
     * Adds a new entry to the database.
     * @param karakter The item to be stored in the database.
     *
     */
    public void storeKarakter (Karakter karakter);

    /**
     * Adds a list of entries to the database.
     * @param karakterList the list to add to the database.
     *
     */
    public void storeAllKarakter (List<Karakter> karakterList);

    /**
     * Removes an entry from the database.
     * @param karakter The entry to be removed from the database.
     *
     */
    public void deleteKarakter (Karakter karakter);

    /**
     * Closes the connection to the database.
     */
    void closeConnection();
}
