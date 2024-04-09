package br.com.fiap.currencyconverter.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ColumnCardResult(systemText: String, textAnswer: String) {
    Column (
        modifier = Modifier.fillMaxWidth()
    ){
        TextBasic(text = systemText)
        TextAnswer(text = textAnswer)
    }
}