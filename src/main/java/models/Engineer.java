package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Engineer {
    private int id;
    private int emp_no;
    private String name;
    private String siteAllocation;
    private LocalDateTime hireDate;
    private String engineerDetails;
    private ArrayList<Site> sites;
    private int mobileNo;


    public int getId() {
        return id;
    }


    public int getEmp_no() {
        return emp_no;
    }

    public String getName() {
        return name;
    }

    public String getSiteAllocation() {
        return siteAllocation;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public String getEngineerDetails() {
        return engineerDetails;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    //    public static List<Engineer> all() {
//        String sql = "SELECT id, name FROM engineers";
//        try(Connection con = DB.sql2o.open()){
//            return con.createQuery(sql).executeAndFetch(Engineer.class);
//        }
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engineer engineer = (Engineer) o;
        return getId() == engineer.getId() &&
                Objects.equals(getName(), engineer.getName()) &&
                Objects.equals(getEmp_no(), engineer.getEmp_no()) &&
                Objects.equals(getMobileNo(), engineer.getMobileNo()) &&
                Objects.equals(sites, engineer.sites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getEmp_no(), getMobileNo(), sites);
    }

}



//
//
