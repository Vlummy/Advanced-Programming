package main.java.server.data_access_objects.dao_interfaces;
import main.java.server.student_register_system.Kull;
import java.util.List;

public interface KullDAOInterface {
    /**
     * Finds an entry in the database table and returns it as an object.
     * @param id The ID for that particular kull in the database.
     * @return Kull An object representation of the particular database entry.
     */
    public Kull findKull(Long id);

    /**
     * Finds all entries in the database table and returns them as a list of object.
     * @return List<Kull> A list of object representations from the database table.
     */
    public List<Kull> findAllKull();

    /**
     *  Updates an entry in the database table.
     * @param id the ID of the entry that needs updating.
     * @param kode the new value for the entry.
     *
     */
    public void updateKull (Long id, String kode);

    /**
     * Adds a new entry to the database.
     * @param id The ID of the item to be stored in the database.
     *
     */
    public void storeKull (Long id);

    /**
     * Adds a list of entries to the database.
     * @param id the id of the list to add to the database.
     *
     */
    public void storeAllKull (Long id);

    /**
     * Removes an entry from the database.
     * @param id The ID of the entry to be removed from the database.
     *
     */
    public void deleteKull (Long id);

    /**
     * Closes the connection to the database.
     */
    void closeConnection();
}
