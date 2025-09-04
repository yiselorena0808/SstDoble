package com.example.sstdoble.api;

import com.example.sstdoble.controller.CrearActividades;
import com.example.sstdoble.controller.CrearListaChequeo;
import com.example.sstdoble.controller.CrearReportes;
import com.example.sstdoble.controller.CrearGestion;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("crearListaChequeo")
    Call<ApiResponse<CrearListaChequeo>> crearListaChequeo(@Body CrearListaChequeo lista);

    @GET("listarListasChequeo")
    Call<List<CrearListaChequeo>> getListasChequeo();

    @POST("crearReporte ")
    Call<ApiResponse<CrearReportes>> crearReporte(@Body CrearReportes reporte);

    @GET("listarReportes")
    Call<List<CrearReportes>> getReportes();
    @POST("login")
    Call<LoginResponse> login(@Body LoginRequest request);

    @POST("crearGestion")
    Call<ApiResponse<CrearGestion>> crearGestion(@Body CrearGestion gestion);

    // 🔹 Listar todas las gestiones
    @GET("listarGestiones")
    Call<List<CrearGestion>> getGestiones();

    @POST ("crearActividadLudica")
    Call<ApiResponse<CrearActividades>> crearActividad(@Body CrearActividades actividad);

    @GET("listarActividadesLudicas")
    Call<List<CrearActividades>> getActividad ();
}
