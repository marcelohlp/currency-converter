package br.com.fiap.currencyconverter.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import br.com.fiap.currencyconverter.R
import br.com.fiap.currencyconverter.ui.theme.Roboto

@Composable
fun TextAlert(text: String) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight.Light,
        color = colorResource(id = R.color.alert_text_color),
        textAlign = TextAlign.End,
        fontFamily = Roboto,
        modifier = Modifier.fillMaxWidth()
    )
}