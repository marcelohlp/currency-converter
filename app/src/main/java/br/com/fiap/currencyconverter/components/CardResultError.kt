package br.com.fiap.currencyconverter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import br.com.fiap.currencyconverter.R

@Composable
fun CardResultError(text: String) {
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
            TextAlertBig(text = text)
        }

    }
}