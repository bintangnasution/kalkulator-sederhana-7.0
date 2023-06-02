package com.bintangnasution.myfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var currentNumber: String = ""
    private var operand: Double = 0.0
    private var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

        val button0: Button = findViewById(R.id.button0)
        button0.setOnClickListener { appendNumber("0") }

        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener { appendNumber("1") }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener { appendNumber("2") }

        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener { appendNumber("3") }

        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener { appendNumber("4") }

        val button5: Button = findViewById(R.id.button5)
        button5.setOnClickListener { appendNumber("5") }

        val button6: Button = findViewById(R.id.button6)
        button6.setOnClickListener { appendNumber("6") }

        val button7: Button = findViewById(R.id.button7)
        button7.setOnClickListener { appendNumber("7") }

        val button8: Button = findViewById(R.id.button8)
        button8.setOnClickListener { appendNumber("8") }

        val button9: Button = findViewById(R.id.button9)
        button9.setOnClickListener { appendNumber("9") }

        val buttonPlus: Button = findViewById(R.id.buttonPlus)
        buttonPlus.setOnClickListener { setOperator("+") }

        val buttonMinus: Button = findViewById(R.id.buttonMinus)
        buttonMinus.setOnClickListener { setOperator("-") }

        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        buttonMultiply.setOnClickListener { setOperator("*") }

        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        buttonDivide.setOnClickListener { setOperator("/") }

        val buttonEquals: Button = findViewById(R.id.buttonEquals)
        buttonEquals.setOnClickListener { calculateResult() }

        val buttonClear: Button = findViewById(R.id.buttonClear)
        buttonClear.setOnClickListener { clear() }
    }

    private fun setOperator(op: String) {
        operator = op
        operand = currentNumber.toDouble()
        currentNumber = ""
    }

    private fun appendNumber(number: String) {
        currentNumber += number
        resultTextView.text = currentNumber
    }

    private fun calculateResult() {
        val secondOperand = currentNumber.toDouble()
        var result: Double? = null
        when (operator) {
            "+" -> result = operand + secondOperand
            "-" -> result = operand - secondOperand
            "*" -> result = operand * secondOperand
            "/" -> {
                if (secondOperand != 0.0) {
                    result = operand / secondOperand
                } else {
                    resultTextView.text = "Error: Cannot divide by zero"
                }
            }
        }
        if (result != null) {
            resultTextView.text = result.toString()
        }
        currentNumber = ""
        operator = ""
        operand = 0.0
    }

    private fun clear() {
        currentNumber = "null"
        operator = ""
        operand = 0.0
        resultTextView.text = ""
    }
}
