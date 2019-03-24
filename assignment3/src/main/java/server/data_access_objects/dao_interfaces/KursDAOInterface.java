package main.java.server.data_access_objects.dao_interfaces;

import main.java.server.student_register_system.Kurs;

import java.util.List;

public interface KursDAOInterface {
    /**
     * Finds an entry in the database table and returns it as an object.
     * @param id The ID for that particular kurs in the database.
     * @return Kurs An object representation of the particular database entry.
     */
    public Kurs findKurs(Long id);

    /**
     * Finds all entries in the database table and returns them as a list of object.
     * @return List<Kurs> A list of object representations from the database table.
     */
    public List<Kurs> findAllKurs();

    /**
     *  Updates an entry in the database table.
     * @param id the ID of the entry that needs updating.
     * @param kode the new value for the grade entry.
     * @param navn the new value for the year entry
     *
     */
    public void updateKurs (Long id, String kode, String navn);

    /**
     * Adds a new entry to the database.
     * @param id The ID of the item to be stored in the database.
     *
     */
    public void storeKurs (Long id);

    /**
     * Adds a list of entries to the database.
     * @param id the id of the list to add to the database.
     *
     */
    public void storeAllKurs (Long id);

    /**
     * Removes an entry from the database.
     * @param id The ID of the entry to be removed from the database.
     *
     */
    public void deleteKurs (Long id);

    /**
     * Closes the connection to the database.
     */
    void closeConnection();
}
