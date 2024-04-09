package br.com.fiap.currencyconverter.components

import android.content.Context
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
import br.com.fiap.currencyconverter.model.businessrules.ShowTextAlertCurrencyType
import br.com.fiap.currencyconverter.screens.SelectionScreenViewModel

@Composable
fun CardSelectionDropdownMenu(
    context: Context,
    selectionScreenViewModel: SelectionScreenViewModel,
    availableCurrenciesOptionsFrom: List<String>,
    availableCurrenciesOptionsTo: List<String>,
    selectedCurrencyFrom: String,
    selectedCurrencyTo: String
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

            TextTitleCard(text = stringResource(id = R.string.selection_screen_subtitle))

            Spacer(modifier = Modifier.height(16.dp))

            Spacer(modifier = Modifier.height(16.dp))

            TextBasic(text = stringResource(id = R.string.selection_screen_from))

            DropdownMenuSelection(
                context = context,
                availableCurrencyOptions = availableCurrenciesOptionsFrom,
                selectedCurrency = selectedCurrencyFrom,
                selectionScreenViewModel = selectionScreenViewModel,
                from = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextBasic(text = stringResource(id = R.string.selection_screen_to))

            DropdownMenuSelection(
                context = context,
                availableCurrencyOptions = availableCurrenciesOptionsTo,
                selectedCurrency = selectedCurrencyTo,
                selectionScreenViewModel = selectionScreenViewModel,
                from = false
            )

            ShowTextAlertCurrencyType(inputFrom = selectedCurrencyFrom, inputTo = selectedCurrencyTo)

        }

    }
    
}