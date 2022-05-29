package com.hasan.foraty.calculator.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hasan.foraty.calculator.domain.model.CalculatorAction
import com.hasan.foraty.calculator.domain.model.CalculatorB
import com.hasan.foraty.calculator.ui.component.CalculatorButton
import com.hasan.foraty.calculator.ui.theme.CalculatorTheme
import com.hasan.foraty.calculator.ui.viewmodels.CalculatorViewModel

@Composable
fun CalculatorMainScreen(
    viewModel: CalculatorViewModel
) {
    val spacedBy = 8.dp
    Box(
        modifier = Modifier,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(spacedBy),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = spacedBy,end = spacedBy)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = viewModel.resultState.value,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 60.sp,
                maxLines = 2,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                letterSpacing = 2.sp,
                overflow = TextOverflow.Ellipsis

            )
            CalculatorButtons(viewModel = viewModel, buttonSpace = spacedBy)
        }
    }
}

@Composable
fun ColumnScope.CalculatorButtons(
    landScape: Boolean = false,
    buttonSpace: Dp,
    viewModel: CalculatorViewModel
) {
    if (landScape) {

    } else {
        for (row in viewModel.portrayRows){
            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {
                for (button in row.list){
                    CalculatorButton(
                        button = button,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                            .background(MaterialTheme.colorScheme.secondaryContainer),
                        onClickListener = viewModel::doActionCalculator,
                        fontSize = 20.sp
                    )
                }
            }
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



