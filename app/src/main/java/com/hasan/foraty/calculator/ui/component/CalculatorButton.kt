package com.hasan.foraty.calculator.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hasan.foraty.calculator.domain.model.CalculatorAction
import com.hasan.foraty.calculator.domain.model.CalculatorB
import com.hasan.foraty.calculator.ui.theme.CalculatorTheme


@Composable
fun CalculatorButton(
    button:CalculatorB,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 12.sp,
    onClickListener:(CalculatorB)->Unit = {},
){
    Box(modifier = Modifier
        .clip(Shapes.Full)
        .clickable {
            onClickListener(button)
        }
        .then(modifier),
        contentAlignment = Alignment.Center
    ){

        Text(
            text = button.symbol,
            fontSize = fontSize,
            textAlign = TextAlign.Center,
            color = LocalContentColor.current
        )
    }
}






@Preview(showBackground = true)
@Composable
private fun Preview_CalculatorButton(){
    CalculatorTheme {
        Surface {
            CalculatorButton(
                button = CalculatorB(symbol = "+",action = CalculatorAction.Add),
                modifier = Modifier
                    .size(16.dp)
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                fontSize = 12.sp
            )
        }
    }
}