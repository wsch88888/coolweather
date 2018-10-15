package com.laoc.coolweather.util;

import com.laoc.coolweather.db.City;
import com.laoc.coolweather.db.County;
import com.laoc.coolweather.db.Province;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by chenhao7 on 2018/4/13.
 */

public interface HttpAPIS {

    String HOST = "http://guolin.tech/api/";

    @GET("china")
    Call<List<Province>> getProvince();

    @GET("china/{provinceId}")
    Call<List<City>> getCity(@Path("provinceId") int provinceCode);

    @GET("china/{provinceId}/{cityId}")
    Call<List<County>> getCounty(@Path("provinceId") int provinceCode, @Path("cityId") int cityCode);
}
