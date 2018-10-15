package com.laoc.coolweather.util;

import com.google.gson.Gson;
import com.laoc.coolweather.db.City;
import com.laoc.coolweather.db.County;
import com.laoc.coolweather.db.Province;
import com.laoc.coolweather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by chenhao7 on 2018/4/3.
 */

public class Utility {

    public static boolean handleProvinceResponse(List<Province> provinceList){
        if (provinceList.size() > 0){
                for (int i = 0;i < provinceList.size();i++){
                    Province provinceObject = provinceList.get(i);
                    Province province = new Province();
                    province.setName(provinceObject.getName());
                    province.setId(provinceObject.getId());
                    province.save();
                }
                return true;
        }
//        if (!TextUtils.isEmpty(response)){
//            try{
//                JSONArray allProvinces = new JSONArray(response);
//                for (int i = 0;i < allProvinces.length();i++){
//                    JSONObject provinceObject = allProvinces.getJSONObject(i);
//                    Province province = new Province();
//                    province.setName(provinceObject.getString("name"));
//                    province.setProvinceCode(provinceObject.getInt("id"));
//                    province.save();
//                }
//                return true;
//            }catch (JSONException e){
//                e.printStackTrace();
//            }
//        }
        return false;
    }

    public static boolean handleCityResponse(List<City> cityList,int provinceId){
        if (cityList.size() > 0){
            for (int i = 0;i < cityList.size();i++){
                City cityObject = cityList.get(i);
                City city = new City();
                city.setName(cityObject.getName());
                city.setId(cityObject.getId());
                city.setProvinceId(provinceId);
                city.save();
            }
            return true;
        }
        return false;
    }

    public static boolean handleCountyResponse(List<County> countyList,int cityId){
        if (countyList.size() > 0){
            for (int i = 0;i < countyList.size();i++){
                County countyObject = countyList.get(i);
                County county = new County();
                county.setName(countyObject.getName());
                county.setWeather_id(countyObject.getWeather_id());
                county.setId(countyObject.getId());
                county.setCityId(cityId);
                county.save();
            }
            return true;
        }
        return false;
    }

    public static Weather handleWeatherResponse(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
