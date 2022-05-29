package com.hasan.foraty.calculator.domain.model

sealed class CalculatorAction {
    object Add: CalculatorAction()
    object Minus:CalculatorAction()
    object Divine:CalculatorAction()
    object Multiple:CalculatorAction()
    object Decimal:CalculatorAction()
    object Present:CalculatorAction()
    object Reverse:CalculatorAction()
    object Result:CalculatorAction()
    object Clear:CalculatorAction()
    object Remove : CalculatorAction()

    data class Number(val number:Int):CalculatorAction()
}
