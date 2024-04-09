package br.com.fiap.currencyconverter.model

import com.google.gson.annotations.SerializedName


data class ExchangeInfo(
    @SerializedName("code") var currencyCodyFrom: String = "",
    @SerializedName("codein") var currencyCodyTo: String = "",
    @SerializedName("name") var name: String = "",
    @SerializedName("bid")var bid: String = "",
)


