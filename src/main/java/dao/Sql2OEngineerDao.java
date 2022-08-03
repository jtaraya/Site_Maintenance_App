package dao;

import models.Engineer;
import models.Site;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2OEngineerDao implements EngineerDao {

    private final Sql2o sql2o;

    public Sql2OEngineerDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public List<Engineer> getAll() {
        return null;
    }

    @Override
    public void add(Engineer engineer) {

    }

    @Override
    public Engineer findById(int id) {
        return null;
    }

    @Override
    public List<Site> getAllSitesByEngineer(int engineerId) {
        return null;
    }

    @Override
    public void update(int id, String name, String emp_no, String siteAllocation) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAllEngineers() {

    }
}
