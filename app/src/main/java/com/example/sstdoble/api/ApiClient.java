package com.example.sstdoble.api;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ApiClient {

    private static final String BASE_URL = "https://backsst.onrender.com/";

    private static Retrofit retrofitPublic = null;   // ✅ Para login/registro
    private static Retrofit retrofitProtected = null; // ✅ Para endpoints con token
    private static String lastToken = "";

    // 🔹 Cliente sin token (ej: login)
    public static Retrofit getClient() {
        if (retrofitPublic == null) {
            retrofitPublic = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitPublic;
    }

    // 🔹 Cliente con token (endpoints protegidos)
    public static Retrofit getClient(String token) {
        if (retrofitProtected == null || !lastToken.equals(token)) {
            lastToken = token;

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request().newBuilder()
                                    .addHeader("Authorization", "Bearer " + token)
                                    .build();
                            return chain.proceed(request);
                        }
                    })
                    .build();

            retrofitProtected = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofitProtected;
    }
}
