package br.com.fiap.currencyconverter.screens


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.currencyconverter.R
import br.com.fiap.currencyconverter.components.ButtonBasic
import br.com.fiap.currencyconverter.components.CardResult
import br.com.fiap.currencyconverter.components.CardResultSuccess
import br.com.fiap.currencyconverter.components.TextTitle
import br.com.fiap.currencyconverter.model.ExchangeInfo
import br.com.fiap.currencyconverter.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun ShowResultScreen(
    navController: NavController,
    currencyFrom: String,
    currencyTo: String
) {

    var listOfExchangeInfo by remember {
        mutableStateOf(listOf<ExchangeInfo>(ExchangeInfo()))
    }

    var isAPIError by remember {
        mutableStateOf(false)
    }

    val call = RetrofitFactory().getCurrencyService().getExchangeInfo(currencyFrom, currencyTo)

    call.enqueue(object : Callback<List<ExchangeInfo>> {
        override fun onResponse(
            call: Call<List<ExchangeInfo>>,
            response: Response<List<ExchangeInfo>>
        ) {
            if (response.isSuccessful) {
                listOfExchangeInfo = response.body()!!
            } else {
                Log.e("Response Error", "${response.errorBody()}")
                isAPIError = true
            }
        }

        override fun onFailure(call: Call<List<ExchangeInfo>>, t: Throwable) {
            Log.e("Response Error", "${t.message}")
            isAPIError = true
        }

    })

    val exchangeInfo: ExchangeInfo? = listOfExchangeInfo.firstOrNull()

    Column(modifier = Modifier.background(color = colorResource(id = R.color.background))) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {

            TextTitle(text = stringResource(id = R.string.result_screen_title))

            CardResult(exchangeInfo = exchangeInfo!!, isAPIError = isAPIError)

            ButtonBasic(
                navController = navController,
                navigateString = "selection",
                enabled = true,
                text = stringResource(id = R.string.result_screen_button)
            )

        }
    }


}