package main.java.server.data_access_objects.dao_interfaces;

import main.java.server.student_register_system.Student;

import java.util.List;

public interface StudentDAOInterface {
    /**
     * Finds an entry in the database table and returns it as an object.
     * @param studentNo The ID for that particular student in the database.
     * @return Student An object representation of the particular database entry.
     */
    public Student findStudent(Integer studentNo);

    /**
     * Finds all entries in the database table and returns them as a list of object.
     * @return List<Student> A list of object representations from the database table.
     */
    public List<Student> findAllStudent();

    /**
     *  Updates an entry in the database table.
     * @param student the entry that needs updating.
     * @param navn the new value for the name entry
     * @param kull the new value for the kull entry
     *
     */
    public void updateStudent (Student student, Integer studentNo, String navn, String kull);

    /**
     * Adds a new entry to the database.
     * @param student The item to be stored in the database.
     *
     */
    public void storeStudent (Student student);

    /**
     * Adds a list of entries to the database.
     * @param studentList the list to add to the database.
     *
     */
    public void storeAllStudent (List<Student> studentList);

    /**
     * Removes an entry from the database.
     * @param student The entry to be removed from the database.
     *
     */
    public void deleteStudent (Student student);

    /**
     * Closes the connection to the database.
     */
    void closeConnection();
}
