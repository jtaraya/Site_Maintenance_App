package dao;

public class SiteDao {

    // LIST
    List<Site> getAll();

    // CREATE
    void add(Site site);

    // READ
    Site findById(int id);

    // UPDATE
    void update(int id, String siteName, int siteId, String engineerName, int engineerId);

    // DELETE
    void deleteById(int id);

    void clearAllSites();
}
