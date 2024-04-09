package br.com.fiap.currencyconverter.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SelectionScreenViewModel : ViewModel() {

    private val _value = MutableLiveData<String>()
    val value: LiveData<String> = _value

    fun onValueChanged(newValue: String) {
        _value.value = newValue
    }

    private val _selectedCurrencyFrom = MutableLiveData<String>()
    val selectionCurrencyFrom: LiveData<String> = _selectedCurrencyFrom

    fun onSelectedCurrencyFromChanged(newSelectedCurrency: String) {
        _selectedCurrencyFrom.value = newSelectedCurrency
    }

    private val _selectedCurrencyTo = MutableLiveData<String>()
    val selectedCurrencyTo: LiveData<String> = _selectedCurrencyTo

    fun onSelectedCurrencyToChanged(newSelectedCurrency: String) {
        _selectedCurrencyTo.value = newSelectedCurrency
    }

    private val currenciesFrom = listOf("BRL", "EUR", "USD")

    fun getAvailableCurrenciesFrom(): List<String> {
        return currenciesFrom
    }

    private val currenciesTo = listOf(
        "ARS",
        "AUD",
        "BRL",
        "CLP",
        "EUR",
        "HKD",
        "INR",
        "JPY",
        "MXN",
        "PYG",
        "RUB",
        "USD",
        "UYU",
        "KRW"
    )

    fun getAvailableCurrenciesTo(): List<String> {
        return currenciesTo
    }


}