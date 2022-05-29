package com.hasan.foraty.calculator.domain.model

sealed class CalculatorAction {
    object Add: CalculatorAction()
    object Minus:CalculatorAction()
    object Divine:CalculatorAction()
    object Present:CalculatorAction()
    data class Number(val number:String):CalculatorAction()
}
