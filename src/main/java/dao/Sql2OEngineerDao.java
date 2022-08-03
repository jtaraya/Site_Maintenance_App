package dao;

import models.Engineer;
import models.Site;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2OEngineerDao implements EngineerDao {

    private final Sql2o sql2o;

    public Sql2OEngineerDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Engineer engineer) {
        String sql = "INSERT INTO engineers (name, emp_no)" + "VALUES (:name, :emp_no);";

        try (Connection con = DB.sql2o.open()) {
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
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM engineers")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Engineer.class);
        }
    }

    @Override
    public Engineer findById(int id) {
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM engineers WHERE id = :id")
                    .throwOnMappingFailure(false)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Engineer.class);
        }
    }

    @Override
    public void update(int id, String newName, String newEmpNo, String siteAllocation) {
        String sql = "UPDATE engineers SET (engineer_name, emp_no) = (:name, :emp_no) WHERE id=:id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", newName)
                    .addParameter("id", id)
//                    .addParameter("emp_no", newEmpNo)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from engineers WHERE id=:id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println();
        }
    }

    @Override
    public void clearAllEngineers() {
        String sql = "DELETE from engineers";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println();
        }
    }

    @Override
    public List<Site> getAllSitesByEngineer(int engineerId) {
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM sites WHERE engineerid = :engineerid")
                    .addParameter("engineerid", engineerId)
                    .executeAndFetch(Site.class);
        }
    }
}
