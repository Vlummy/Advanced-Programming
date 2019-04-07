package main.java.server.data_access_objects.dao_interfaces;
import main.java.server.student_register_system.Kull;
import java.util.List;

public interface KullDAOInterface {
    /**
     * Finds an entry in the database table and returns it as an object.
     * @param kode The ID for that particular kull in the database.
     * @return Kull An object representation of the particular database entry.
     */
    public Kull findKull(String kode);

    /**
     * Finds all entries in the database table and returns them as a list of object.
     * @return List<Kull> A list of object representations from the database table.
     */
    public List<Kull> findAllKull();

    /**
     *  Updates an entry in the database table.
     * @param kull the entry that needs updating.
     * @param kode the new value for the entry.
     *
     */
    public void updateKull (Kull kull, String kode, String skole);

    /**
     * Adds a new entry to the database.
     * @param kull The item to be stored in the database.
     *
     */
    public void storeKull (Kull kull);

    /**
     * Adds a list of entries to the database.
     * @param kullList the list to add to the database.
     *
     */
    public void storeAllKull (List<Kull> kullList);

    /**
     * Removes an entry from the database.
     * @param kull The entry to be removed from the database.
     *
     */
    public void deleteKull (Kull kull);

    /**
     * Closes the connection to the database.
     */
    void closeConnection();
}
