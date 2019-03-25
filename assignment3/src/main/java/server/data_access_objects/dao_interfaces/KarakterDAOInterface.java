package main.java.server.data_access_objects.dao_interfaces;

import main.java.server.student_register_system.Karakter;
import java.util.List;

public interface KarakterDAOInterface {
    /**
     * Finds an entry in the database table and returns it as an object.
     * @param id The ID for that particular karakter in the database.
     * @return Karakter An object representation of the particular database entry.
     */
    public Karakter findKarakter(Long id);

    /**
     * Finds all entries in the database table and returns them as a list of object.
     * @return List<Karakter> A list of object representations from the database table.
     */
    public List<Karakter> findAllKarakter();

    /**
     *  Updates an entry in the database table.
     * @param id the ID of the entry that needs updating.
     * @param karakter the new value for the grade entry.
     * @param ar the new value for the year entry
     *
     */
    public void updateKarakter (Long id, String karakter, Integer ar);

    /**
     * Adds a new entry to the database.
     * @param id The ID of the item to be stored in the database.
     *
     */
    public void storeKarakter (Long id);

    /**
     * Adds a list of entries to the database.
     * @param id the id of the list to add to the database.
     *
     */
    public void storeAllKarakter (Long id);

    /**
     * Removes an entry from the database.
     * @param id The ID of the entry to be removed from the database.
     *
     */
    public void deleteKarakter (Long id);

    /**
     * Closes the connection to the database.
     */
    void closeConnection();
}
