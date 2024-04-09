package br.com.fiap.currencyconverter.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import br.com.fiap.currencyconverter.R
import br.com.fiap.currencyconverter.model.ExchangeInfo

@Composable
fun CardResult(exchangeInfo: ExchangeInfo, isAPIError: Boolean) {
    if (exchangeInfo != null && isAPIError == false) {
        CardResultSuccess(
            exchangeName = exchangeInfo.name.replace("/", " / "),
            currencyCodeFrom = exchangeInfo.currencyCodyFrom,
            value = "1",
            currencyCodeTo = exchangeInfo.currencyCodyTo,
            currencyToUnitValue = exchangeInfo.bid.replace(".", ","),
        )
        Log.i("BID", exchangeInfo.bid)
    } else {
        CardResultError(text = stringResource(id = R.string.result_screen_erro_message))
    }
}