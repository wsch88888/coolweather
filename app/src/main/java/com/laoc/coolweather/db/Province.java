package com.laoc.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by chenhao7 on 2018/4/3.
 */

public class Province extends DataSupport{

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private int id;
    private String name;
}
