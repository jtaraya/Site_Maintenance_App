package dao;

import models.Engineer;
import models.Site;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2OEngineerDao implements EngineerDao {

    private final Sql2o sql2o;

    public Sql2OEngineerDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Engineer engineer) {
        String sql = "INSERT INTO engineers (name, emp_no)" + "VALUES (:name, :emp_no);";

        try(Connection con = DB.sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(engineer)
                    .executeUpdate()
                    .getKey();
            engineer.setId(id);
            System.out.println(sql);
        } catch (Sql2oException ex) {
            System.out.println();
        }
    }

    @Override
    public List<Engineer> getAll() {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM engineers")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Engineer.class);

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
