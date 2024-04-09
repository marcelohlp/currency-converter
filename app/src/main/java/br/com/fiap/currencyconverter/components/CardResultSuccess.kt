package br.com.fiap.currencyconverter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.com.fiap.currencyconverter.R
import br.com.fiap.currencyconverter.model.businessrules.toDouble

@Composable
fun CardResultSuccess(
    exchangeName: String,
    currencyCodeFrom: String,
    value: String,
    currencyCodeTo: String,
    currencyToUnitValue: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = CardDefaults.elevatedShape,
        colors = CardDefaults.cardColors(colorResource(id = R.color.background_card))
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(color = colorResource(id = R.color.background_card))
        ) {

            TextBasic(text = exchangeName)

            Spacer(modifier = Modifier.height(16.dp))

            RowCardResult(
                systemText = stringResource(id = R.string.result_screen_currency_from_code),
                textAnswer = currencyCodeFrom
            )

            Spacer(modifier = Modifier.height(16.dp))

            RowCardResult(
                systemText = stringResource(id = R.string.result_screen_input_value),
                textAnswer = value
            )

            Spacer(modifier = Modifier.height(16.dp))

            RowCardResult(
                systemText = stringResource(id = R.string.result_screen_currency_to_code),
                textAnswer = currencyCodeTo
            )

            Spacer(modifier = Modifier.height(16.dp))

            RowCardResult(
                systemText = stringResource(id = R.string.result_screen_currency_to_unit_value),
                textAnswer = currencyToUnitValue
            )

        }

    }

}