package br.com.fiap.currencyconverter.model.businessrules

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import br.com.fiap.currencyconverter.R
import br.com.fiap.currencyconverter.components.TextAlert

private fun checkEqualsInputs(inputFrom: String, inputTo: String): Boolean {
    return inputFrom.equals(inputTo)
}

fun buttonIsEnabled(inputFrom: String, inputTo: String): Boolean {
    return !(checkEqualsInputs(inputFrom, inputTo))
}

@Composable
fun ShowTextAlertCurrencyType(inputFrom: String, inputTo: String) {
    if (checkEqualsInputs(inputFrom, inputTo)) {
        TextAlert(text = stringResource(id = R.string.selection_screen_alert_text))
    }
}
