package com.laoc.coolweather.gson;

/**
 * Created by chenhao7 on 2018/4/4.
 */

public class AQI {
    public AQICity city;
    public class AQICity {
        public String aqi;
        public String pm25;
    }
}
