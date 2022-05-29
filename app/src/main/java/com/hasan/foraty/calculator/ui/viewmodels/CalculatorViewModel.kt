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


    fun doActionCalculator(action:CalculatorB){
        when(action.action){
            CalculatorAction.Add,CalculatorAction.Divine,CalculatorAction.Minus,CalculatorAction.Multiple,CalculatorAction.Present -> {
                if (_operation.value.isEmpty()){
                    _operation.value = action.symbol
                }else{
                    calculate()
                    _operation.value = action.symbol
                }
            }
            CalculatorAction.Clear -> {
                emptyState()
            }
            CalculatorAction.Declaim -> {
                if (_operation.value.isEmpty()){
                    if (_firstState.value.contains(".")) return
                    if (_firstState.value.isEmpty()) _firstState.value = "0"
                    _firstState.value = firstState.value.plus(".")
                }else {
                    if (_secondState.value.contains("."))return
                    if (_secondState.value.isEmpty())_secondState.value = "0"
                    _secondState.value = _secondState.value.plus(".")
                }
            }
            is CalculatorAction.Number -> {
                if (_operation.value.isEmpty()){
                    if (_firstState.value=="0") _firstState.value = ""
                    _firstState.value = _firstState.value.plus(action.action.number)
                }else{
                    if (_secondState.value=="0") _secondState.value = ""
                    _secondState.value = _secondState.value.plus(action.action.number)
                }
            }
            CalculatorAction.Result -> {
                calculate()
            }
            CalculatorAction.Reverse -> {
                if (_operation.value.isEmpty()){
                    if (_firstState.value=="0"||_firstState.value.isEmpty()) return
                    _firstState.value = "-"+_firstState.value
                }else{
                    if (_secondState.value=="0"||_secondState.value.isEmpty()) return
                    _secondState.value = "-"+_secondState.value
                }
            }
        }
    }
    private fun calculate(){
        if (_firstState.value.isNotEmpty()){
            if (_secondState.value.isEmpty()) {
                _operation.value = ""
                return
            }
            val result:Double = when(_operation.value){
                "+"->{
                    firstState.value.toDouble().plus(secondState.value.toDouble())
                }
                "/"->{
                    firstState.value.toDouble().div(secondState.value.toDouble())
                }
                "-"->{
                    firstState.value.toDouble().minus(secondState.value.toDouble())
                }
                "*"->{
                    firstState.value.toDouble() * secondState.value.toDouble()
                }
                "%"->{
                    firstState.value.toDouble().rem(secondState.value.toDouble())
                }
                else ->{
                    _firstState.value.toDouble()
                }
            }
            emptyState()
            _firstState.value = result.toString()
        }


    }

    private fun emptyState(){
        _firstState.value = ""
        _secondState.value = ""
        _operation.value = ""
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
                CalculatorB("0",CalculatorAction.Number(0)),CalculatorB(".",CalculatorAction.Declaim),CalculatorB("=",CalculatorAction.Result),
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