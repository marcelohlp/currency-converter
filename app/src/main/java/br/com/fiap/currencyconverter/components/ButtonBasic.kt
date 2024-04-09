package br.com.fiap.currencyconverter.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import br.com.fiap.currencyconverter.R

@Composable
fun ButtonBasic(navController: NavController, navigateString: String, enabled: Boolean, text: String) {
    Button(
        onClick = {
            navController.navigate(navigateString)
                  },
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.button_color)),
        enabled = enabled
    ) {
        TextButton(text = text)
    }
}
