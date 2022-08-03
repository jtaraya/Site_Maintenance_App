package models;

import java.time.LocalDateTime;

public class Engineer {
    private int id;
    private int emp_no;
    private String name;
    private String siteAllocation;
    private LocalDateTime hireDate;
    private String engineerDetails;
    private ArrayList<Site> sites;
    private int mobileNo;
}

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
