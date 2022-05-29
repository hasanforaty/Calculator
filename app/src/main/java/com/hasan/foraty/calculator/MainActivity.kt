package com.hasan.foraty.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import com.hasan.foraty.calculator.ui.screens.CalculatorMainScreen
import com.hasan.foraty.calculator.ui.theme.CalculatorTheme
import com.hasan.foraty.calculator.ui.viewmodels.CalculatorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    val viewMode by viewModels<CalculatorViewModel>()
                    CalculatorMainScreen(viewModel = viewMode)
                }
            }
        }
    }
}
