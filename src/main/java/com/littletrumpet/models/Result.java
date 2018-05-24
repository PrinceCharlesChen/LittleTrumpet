package com.littletrumpet.models;

import java.util.List;

/**
 * Created by C.D on 2017/6/4.
 */
public class Result {
    private int total;
    private List<DownloadKey> rows;


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DownloadKey> getRows() {
        return rows;
    }

    public void setRows(List<DownloadKey> rows) {
        this.rows = rows;
    }
}
