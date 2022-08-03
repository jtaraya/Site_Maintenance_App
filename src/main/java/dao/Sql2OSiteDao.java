package dao;

import models.Site;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2OSiteDao implements SiteDao {

    private final Sql2o sql2o;
    public Sql2OSiteDao(Sql2o sql2o){
        this.sql2o = sql2o; //making the sql2o object available everywhere so we can call methods in it
    }

    @Override
    public List<Site> getAll() {
        return null;
    }

    @Override
    public void add(Site site) {

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
}
