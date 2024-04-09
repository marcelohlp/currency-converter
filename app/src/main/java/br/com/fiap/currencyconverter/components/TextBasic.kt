package br.com.fiap.currencyconverter.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.currencyconverter.R
import br.com.fiap.currencyconverter.ui.theme.Roboto

@Composable
fun TextBasic(text: String) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = colorResource(id = R.color.text_color),
        textAlign = TextAlign.Start,
        fontFamily = Roboto,
        modifier = Modifier.padding(vertical = 2.dp)
    )
}