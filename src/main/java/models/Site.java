package models;

import java.time.LocalDateTime;

public class Site {

    private int id;
    private int siteId;
    private String siteName;
    private int engineerId;
    private String engineerName;
    private LocalDateTime createdAt;
    private boolean decommissioned;
}
