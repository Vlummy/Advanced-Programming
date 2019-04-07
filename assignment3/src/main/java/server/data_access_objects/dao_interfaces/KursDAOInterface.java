package main.java.server.data_access_objects.dao_interfaces;

import main.java.server.student_register_system.Kurs;

import java.util.List;

public interface KursDAOInterface {
    /**
     * Finds an entry in the database table and returns it as an object.
     * @param kode The ID for that particular kurs in the database.
     * @return Kurs An object representation of the particular database entry.
     */
    public Kurs findKurs(String kode);

    /**
     * Finds all entries in the database table and returns them as a list of object.
     * @return List<Kurs> A list of object representations from the database table.
     */
    public List<Kurs> findAllKurs();

    /**
     *  Updates an entry in the database table.
     * @param kurs the entry that needs updating.
     * @param kode the new value for the code entry.
     * @param navn the new value for the name entry
     *
     */
    public void updateKurs (Kurs kurs, String kode, String navn, String skole);

    /**
     * Adds a new entry to the database.
     * @param kurs The item to be stored in the database.
     *
     */
    public void storeKurs (Kurs kurs);

    /**
     * Adds a list of entries to the database.
     * @param kursList the list to add to the database.
     *
     */
    public void storeAllKurs (List<Kurs> kursList);

    /**
     * Removes an entry from the database.
     * @param kurs The entry to be removed from the database.
     *
     */
    public void deleteKurs (Kurs kurs);

    /**
     * Closes the connection to the database.
     */
    void closeConnection();
}
