package com.example.faustocheca.recadosf.getservice;

import com.example.faustocheca.recadosf.Recado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by faustocheca on 12/9/16.
 */
public interface MyRetrofitInterface {

    @GET ("ObtenerListaRecados")
    Call<String>traerRecados();

}


/*

http://elrecadero-ebtm.rhcloud.com/ObtenerListaRecados




 */