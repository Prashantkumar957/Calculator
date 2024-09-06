package com.prashantkumar957.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvDisplay: TextView
    private var currentDisplay = ""
    private var operator = ""
    private var operand1 = ""
    private var operand2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDisplay = findViewById(R.id.tvDisplay)

        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btn4: Button = findViewById(R.id.btn4)
        val btn5: Button = findViewById(R.id.btn5)
        val btn6: Button = findViewById(R.id.btn6)
        val btn7: Button = findViewById(R.id.btn7)
        val btn8: Button = findViewById(R.id.btn8)
        val btn9: Button = findViewById(R.id.btn9)

        val btnPlus: Button = findViewById(R.id.btnPlus)
        val btnMinus: Button = findViewById(R.id.btnMinus)
        val btnMultiply: Button = findViewById(R.id.btnMultiply)
        val btnDivide: Button = findViewById(R.id.btnDivide)
        val btnEqual: Button = findViewById(R.id.btnEqual)
        val btnClear: Button = findViewById(R.id.btnClear)
        val btnBackspace: Button = findViewById(R.id.btnBackspace)

        btn1.setOnClickListener { appendNumber("1") }
        btn2.setOnClickListener { appendNumber("2") }
        btn3.setOnClickListener { appendNumber("3") }
        btn4.setOnClickListener { appendNumber("4") }
        btn5.setOnClickListener { appendNumber("5") }
        btn6.setOnClickListener { appendNumber("6") }
        btn7.setOnClickListener { appendNumber("7") }
        btn8.setOnClickListener { appendNumber("8") }
        btn9.setOnClickListener { appendNumber("9") }

        btnPlus.setOnClickListener { setOperator("+") }
        btnMinus.setOnClickListener { setOperator("-") }
        btnMultiply.setOnClickListener { setOperator("*") }
        btnDivide.setOnClickListener { setOperator("/") }

        btnEqual.setOnClickListener { calculateResult() }

        btnClear.setOnClickListener { clearDisplay() }

        btnBackspace.setOnClickListener { backspace() }
    }


    private fun appendNumber(number: String) {
        currentDisplay += number
        tvDisplay.text = currentDisplay
    }

    private fun setOperator(op: String) {
        if (currentDisplay.isNotEmpty()) {
            operand1 = currentDisplay
            operator = op
            currentDisplay = ""
        }
    }

    private fun calculateResult() {
        if (currentDisplay.isNotEmpty() && operand1.isNotEmpty()) {
            operand2 = currentDisplay
            val result = when (operator) {
                "+" -> operand1.toDouble() + operand2.toDouble()
                "-" -> operand1.toDouble() - operand2.toDouble()
                "*" -> operand1.toDouble() * operand2.toDouble()
                "/" -> operand1.toDouble() / operand2.toDouble()
                else -> 0.0
            }
            currentDisplay = result.toString()
            tvDisplay.text = currentDisplay
            operand1 = ""
            operand2 = ""
            operator = ""
        }
    }

    private fun clearDisplay() {
        currentDisplay = ""
        operand1 = ""
        operand2 = ""
        operator = ""
        tvDisplay.text = "0"
    }

    private fun backspace() {
        if (currentDisplay.isNotEmpty()) {
            currentDisplay = currentDisplay.dropLast(1)
            tvDisplay.text = if (currentDisplay.isEmpty()) "0" else currentDisplay
        }
    }
}
