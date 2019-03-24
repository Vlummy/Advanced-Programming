package main.java.server.data_access_objects.dao_interfaces;

import main.java.server.student_register_system.Student;

import java.util.List;

public interface StudentDAOInterface {
    /**
     * Finds an entry in the database table and returns it as an object.
     * @param id The ID for that particular student in the database.
     * @return Student An object representation of the particular database entry.
     */
    public Student findStudent(Long id);

    /**
     * Finds all entries in the database table and returns them as a list of object.
     * @return List<Student> A list of object representations from the database table.
     */
    public List<Student> findAllStudent();

    /**
     *  Updates an entry in the database table.
     * @param id the ID of the entry that needs updating.
     * @param number the new value for the number entry
     * @param navn the new value for the name entry
     *
     */
    public void updateStudent (Long id, Integer number, String navn);

    /**
     * Adds a new entry to the database.
     * @param id The ID of the item to be stored in the database.
     *
     */
    public void storeStudent (Long id);

    /**
     * Adds a list of entries to the database.
     * @param id the id of the list to add to the database.
     *
     */
    public void storeAllStudent (Long id);

    /**
     * Removes an entry from the database.
     * @param id The ID of the entry to be removed from the database.
     *
     */
    public void deleteStudent (Long id);

    /**
     * Closes the connection to the database.
     */
    void closeConnection();
}
