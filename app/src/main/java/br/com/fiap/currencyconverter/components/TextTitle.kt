package br.com.fiap.currencyconverter.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.currencyconverter.R
import br.com.fiap.currencyconverter.ui.theme.Roboto

@Composable
fun TextTitle(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp,
        color = colorResource(id = R.color.text_color),
        textAlign = TextAlign.Center,
        fontFamily = Roboto,
        lineHeight = 50.sp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    )
}