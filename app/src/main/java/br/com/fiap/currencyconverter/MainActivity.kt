package br.com.fiap.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.currencyconverter.screens.SelectionScreenViewModel
import br.com.fiap.currencyconverter.screens.ShowResultScreen
import br.com.fiap.currencyconverter.screens.ShowSelectionScreen
import br.com.fiap.currencyconverter.ui.theme.CurrencyConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "selection",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.End,
                                tween(200)
                            ) + fadeOut(animationSpec = tween(200))
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.End,
                                tween(200)
                            )
                        }
                    ) {
                        composable(route = "selection") {
                            ShowSelectionScreen(SelectionScreenViewModel(), navController)
                        }
                        composable(
                            route = "result/{currencyFrom}/{currencyTo}",
                            arguments = listOf(
                                navArgument(name = "currencyFrom") { type = NavType.StringType },
                                navArgument(name = "currencyTo") { type = NavType.StringType },
                            )
                        ) {
                            val currencyFrom = it.arguments?.getString("currencyFrom")
                            val currencyTo = it.arguments?.getString("currencyTo")
                            ShowResultScreen(navController, currencyFrom!!, currencyTo!!)
                        }
                    }
                }
            }
        }
    }
}
