package com.va181.bigbro.services;

import com.va181.bigbro.model.ResponseData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiBarang {
    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponseData> addData(
            @Field("namaBarang") String namaBarang,
            @Field("jumlah") String jumlah,
            @Field("gambar") String gambar,
            @Field("jenis") String jenis
    );

    @FormUrlEncoded
    @POST("update.php")
    Call<ResponseData> editData(
            @Field("id") String id,
            @Field("namaBarang") String namaBarang,
            @Field("jumlah") String jumlah,
            @Field("gambar") String gambar,
            @Field("jenis") String jenis
    );

    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseData> deleteData(
            @Field("id") String id
    );

    @FormUrlEncoded
    @POST("search.php")
    Call<ResponseData> searchData(
            @Field("search") String keyword
    );

    @GET("getdata.php")
    Call<ResponseData> getData();
}
