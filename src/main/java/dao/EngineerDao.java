package dao;

import models.Engineer;

import java.util.List;

public class EngineerDao {

    //LIST
    List<Engineer> getAll();

    //CREATE
    void add (Engineer engineer);

    //READ
    Engineer findById(int id);

    List<Site> getAllSitesByEngineer(int engineerId) {
        return null;
    }

    //UPDATE
    void update(int id, String name, String emp_no, String siteAllocation);

    //DELETE
    void deleteById(int id);

    void clearAllEngineers();
}
