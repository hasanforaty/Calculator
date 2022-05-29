package com.hasan.foraty.calculator.ui.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hasan.foraty.calculator.domain.model.CalculatorB

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