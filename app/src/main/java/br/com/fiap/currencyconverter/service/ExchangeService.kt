package br.com.fiap.currencyconverter.service


import br.com.fiap.currencyconverter.model.ExchangeInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ExchangeService {

    @GET("{currencyFrom}-{currencyTo}/1")
    fun getExchangeInfo(
        @Path("currencyFrom") currencyFrom: String,
        @Path("currencyTo") currencyTo: String
    ): Call<List<ExchangeInfo>>

}