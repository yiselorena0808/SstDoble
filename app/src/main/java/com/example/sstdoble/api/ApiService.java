package com.example.sstdoble.api;

import com.example.sstdoble.controller.CrearListaChequeo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("crearListaChequeo")
    Call<ApiResponse> crearListaChequeo(@Body CrearListaChequeo lista);
    @GET("listarListasChequeo")
    Call<List<CrearListaChequeo>> getListasChequeo();

}
