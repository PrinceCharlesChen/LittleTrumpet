package com.littletrumpet.models;


import java.util.Date;

public class DownloadKey {

    public int id;
    public String key;
    public int status;
    public int issell;
    public String url;
    public String systime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSystime() {
        return systime;
    }

    public void setSystime(String systime) {
        this.systime = systime;
    }

    public int getIssell() {
        return issell;
    }

    public void setIssell(int issell) {
        this.issell = issell;
    }
}



