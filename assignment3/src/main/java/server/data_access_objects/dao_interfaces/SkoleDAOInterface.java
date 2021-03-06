package main.java.server.data_access_objects.dao_interfaces;

import main.java.server.student_register_system.Skole;

import java.util.List;

public interface SkoleDAOInterface {
    /**
     * Finds an entry in the database table and returns it as an object.
     * @param name The ID for that particular kurs in the database.
     * @return Skole An object representation of the particular database entry.
     */
    public Skole findSkole(String name);

    /**
     * Finds all entries in the database table and returns them as a list of object.
     * @return List<Skole> A list of object representations from the database table.
     */
    public List<Skole> findAllSkole();

    /**
     *  Updates an entry in the database table.
     * @param skole the entry that needs updating.
     * @param navn the new value for the year entry
     *
     */
    public void updateSkole (Skole skole, String navn);

    /**
     * Adds a new entry to the database.
     * @param skole The item to be stored in the database.
     *
     */
    public void storeSkole (Skole skole);

    /**
     * Adds a list of entries to the database.
     * @param skoleList the list to add to the database.
     *
     */
    public void storeAllSkole (List<Skole> skoleList);

    /**
     * Removes an entry from the database.
     * @param skole The entry to be removed from the database.
     *
     */
    public void deleteSkole (Skole skole);

    /**
     * Closes the connection to the database.
     */
    void closeConnection();
}
