package br.com.fiap.currencyconverter.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL = "http://economia.awesomeapi.com.br/json/daily/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCurrencyService(): ExchangeService {
        return retrofitFactory.create(ExchangeService::class.java)
    }

}