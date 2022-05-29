package com.hasan.foraty.calculator.ui.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hasan.foraty.calculator.domain.model.CalculatorAction
import com.hasan.foraty.calculator.domain.model.CalculatorB
import com.hasan.foraty.calculator.domain.model.CalculatorBRow

class CalculatorViewModel:ViewModel() {

    val resultState:State<String>
    get() {
        return mutableStateOf("${_firstState.value} ${_operation.value} ${_secondState.value}")
    }


    private val _firstState = mutableStateOf("")
    val firstState:State<String> = _firstState

    private val _secondState = mutableStateOf("")
    val secondState:State<String> = _secondState

    private val _operation = mutableStateOf("")
    val operationState:State<String> = _operation


    fun doActionCalculator(action:CalculatorB){
        TODO()
    }




    val portrayRows = listOf(
        CalculatorBRow(
            listOf(
                CalculatorB("AC",CalculatorAction.Clear),CalculatorB("+/-",CalculatorAction.Reverse),CalculatorB("%",CalculatorAction.Present),CalculatorB("/",CalculatorAction.Divine)
            )
        ),
        CalculatorBRow(
            listOf(
                CalculatorB("7",CalculatorAction.Number(7)),CalculatorB("8",CalculatorAction.Number(8)),CalculatorB("9",CalculatorAction.Number(9)),CalculatorB("*",CalculatorAction.Multiple),
            )
        ),
        CalculatorBRow(
            listOf(
                CalculatorB("4",CalculatorAction.Number(4)),CalculatorB("5",CalculatorAction.Number(5)),CalculatorB("6",CalculatorAction.Number(6)),CalculatorB("-",CalculatorAction.Minus),
            )
        ),
        CalculatorBRow(
            listOf(
                CalculatorB("1",CalculatorAction.Number(1)),CalculatorB("2",CalculatorAction.Number(2)),CalculatorB("3",CalculatorAction.Number(3)),CalculatorB("+",CalculatorAction.Add),
            )
        ),
        CalculatorBRow(
            listOf(
                CalculatorB("0",CalculatorAction.Number(0)),CalculatorB(".",CalculatorAction.Declaim),CalculatorB("9",CalculatorAction.Result),
            )
        )
    )





    companion object{
        fun makeMockObject():CalculatorViewModel{
            return CalculatorViewModel().apply {
                _firstState.value = "12.0"
                _secondState.value = "14.0"
                _operation.value = "*"
            }
        }
    }

}