package com.hasan.foraty.calculator.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hasan.foraty.calculator.domain.model.CalculatorAction
import com.hasan.foraty.calculator.ui.component.CalculatorButton
import com.hasan.foraty.calculator.ui.theme.CalculatorTheme
import com.hasan.foraty.calculator.ui.viewmodels.CalculatorViewModel

@Composable
fun CalculatorMainScreen(
    viewModel: CalculatorViewModel
) {
    val spacedBy = 8.dp
    //TODO check to See , if we are in LandScape or not
    val isLandScape = remember {
        mutableStateOf(false)
    }
    isLandScape.value = LocalConfiguration.current.orientation== Configuration.ORIENTATION_LANDSCAPE
    Box(
        modifier = Modifier,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(spacedBy),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = spacedBy, end = spacedBy)
                .align(if (isLandScape.value) Alignment.TopCenter else Alignment.BottomCenter)
                .verticalScroll(rememberScrollState())
        ) {


            BasicTextField(
                value = viewModel.resultState.value,
                onValueChange = {},
                readOnly = true,
                maxLines = 2,
                textStyle =
                TextStyle.Default.copy(
                    fontSize = 60.sp,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.End,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
            )
            CalculatorButtons(
                landScape = isLandScape.value,
                buttonSpace = spacedBy,
                viewModel = viewModel
            )
        }
    }
}

@Composable
fun CalculatorButtons(
    landScape: Boolean = false,
    buttonSpace: Dp,
    viewModel: CalculatorViewModel
) {
    if (landScape) {
        //TODO add view for LandScape View
    } else {
        for (row in viewModel.portrayRows){
            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {
                for (button in row.list){
                    CalculatorButton(
                        button = button,
                        modifier = actionToModifier(action = button.action),
                        onClickListener = viewModel::doActionCalculator,
                        fontSize = 30.sp
                    )
                }
            }
        }

    }
}

@Composable
fun RowScope.actionToModifier(action:CalculatorAction): Modifier {
    return when(action){
        CalculatorAction.Add,CalculatorAction.Minus,CalculatorAction.Divine,CalculatorAction.Multiple,CalculatorAction.Remove, ->{
            LocalContentColor.provides(MaterialTheme.colorScheme.onPrimaryContainer)
            Modifier
                .aspectRatio(1f)
                .weight(1f)
                .background(MaterialTheme.colorScheme.primaryContainer)
        }

        CalculatorAction.Clear,CalculatorAction.Present,CalculatorAction.Reverse-> {
            LocalContentColor.provides(MaterialTheme.colorScheme.onTertiaryContainer)
            Modifier
                .aspectRatio(1f)
                .weight(1f)
                .background(MaterialTheme.colorScheme.tertiaryContainer)
        }
        is CalculatorAction.Number,CalculatorAction.Decimal,CalculatorAction.Result -> {
            LocalContentColor.provides(MaterialTheme.colorScheme.onSecondaryContainer)
            Modifier
                .aspectRatio(1f)
                .weight(1f)
                .background(MaterialTheme.colorScheme.secondaryContainer)
        }
    }
}





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCalculatorMainScreen() {
    val mockViewModel = CalculatorViewModel.makeMockObject()
    CalculatorTheme {
        Surface {
            CalculatorMainScreen(viewModel = mockViewModel)
        }
    }
}



