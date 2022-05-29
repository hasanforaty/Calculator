package com.hasan.foraty.calculator.domain.model

sealed class CalculatorAction {
    object Add: CalculatorAction()
    object Minus:CalculatorAction()
    object Divine:CalculatorAction()
    object Present:CalculatorAction()
    object Reverse:CalculatorAction()
    object Clear:CalculatorAction()
    data class Number(val number:String):CalculatorAction()
}
