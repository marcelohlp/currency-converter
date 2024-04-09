package br.com.fiap.currencyconverter.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.currencyconverter.R
import br.com.fiap.currencyconverter.components.ButtonBasic
import br.com.fiap.currencyconverter.components.CardSelectionDropdownMenu
import br.com.fiap.currencyconverter.components.TextTitle
import br.com.fiap.currencyconverter.model.businessrules.buttonIsEnabled

@Composable
fun ShowSelectionScreen(
    selectionScreenViewModel: SelectionScreenViewModel,
    navController: NavController
) {

    val context = LocalContext.current

    val currenciesFrom = selectionScreenViewModel.getAvailableCurrenciesFrom()
    val currenciesTo = selectionScreenViewModel.getAvailableCurrenciesTo()
    val selectedCurrencyFrom by selectionScreenViewModel.selectionCurrencyFrom.observeAsState(
        currenciesFrom[0]
    )
    val selectedCurrencyTo by selectionScreenViewModel.selectedCurrencyTo.observeAsState(
        currenciesTo[0]
    )

    val enabled = buttonIsEnabled(selectedCurrencyFrom, selectedCurrencyTo)

    Column(modifier = Modifier.background(color = colorResource(id = R.color.background))) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {

            TextTitle(text = stringResource(id = R.string.selection_screen_title))

            CardSelectionDropdownMenu(
                context = context,
                selectionScreenViewModel = selectionScreenViewModel,
                availableCurrenciesOptionsFrom = currenciesFrom,
                availableCurrenciesOptionsTo = currenciesTo,
                selectedCurrencyFrom = selectedCurrencyFrom,
                selectedCurrencyTo = selectedCurrencyTo
            )

            ButtonBasic(
                navController = navController,
                navigateString = "result/$selectedCurrencyFrom/$selectedCurrencyTo",
                enabled = enabled,
                text = stringResource(id = R.string.selection_screen_button)
            )

        }
    }

}