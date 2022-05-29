package com.hasan.foraty.calculator.domain.model

sealed class CalculatorAction {
    object Add: CalculatorAction()
    object Minus:CalculatorAction()
    object Divine:CalculatorAction()
    object Multiple:CalculatorAction()
    object Declaim:CalculatorAction()
    object Present:CalculatorAction()
    object Reverse:CalculatorAction()
    object Result:CalculatorAction()
    object Clear:CalculatorAction()
    data class Number(val number:Int):CalculatorAction()
}
