package com.adaptable.riskmanagement;

import java.util.Date;
import java.util.UUID;

public class RiskReport {
    private String name = "Adaptable Risk report";
    private String status = "ok";
    private Date datetime = new Date();
    private String id = UUID.randomUUID().toString();

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Date getDatetime() {
        return datetime;
    }

    public String getId() {
        return id;
    }
}
