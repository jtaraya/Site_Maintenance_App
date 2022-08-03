package dao;

import models.Site;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2OSiteDao implements SiteDao {

    private final Sql2o sql2o;
    public Sql2OSiteDao(Sql2o sql2o){
        this.sql2o = sql2o;

        //making the sql2o object available everywhere so we can call methods in it
    }

    @Override
    public void add(Site site) {
        String sql = "INSERT INTO sites (siteName, siteId, engineerName)" + "VALUES (:siteName, :siteId, :engineerName);";
        try(Connection con = DB.sql2o.open()){ //try to open a connection
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .bind(site)
                    .executeUpdate()
                    .getKey();
            site.setId(id); //update object to set id now from database
            System.out.println(sql);
        } catch (Sql2oException ex) {
            System.out.println();
        }
    }

    @Override
    public Site findById(int id) {
        return null;
    }

    @Override
    public void update(int id, String siteName, int siteId, String engineerName, int engineerId) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAllSites() {

    }

    @Override
    public List<Site> getAll() {
        try(Connection con =DB.sql2o.open()){
            return con.createQuery("SELECT * FROM sites")
                    .executeAndFetch(Site.class);
        }
    }

    @Override
    public void add(Site site) {

    }
}
