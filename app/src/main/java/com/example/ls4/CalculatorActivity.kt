package com.example.ls4

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class CalculatorActivity : AppCompatActivity() {
    private lateinit var edtNumOne: TextInputLayout
    private lateinit var edtNumTwo: TextInputLayout
    private lateinit var edtResult: TextInputLayout
    private lateinit var btnAdd: Button
    private lateinit var btnSub: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button
    private var numOne: Int = 0
    private var numTwo: Int = 0
    private var resultNum: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)
        mapView()
        setEvent()
    }

    private fun mapView() {
        edtNumOne = findViewById(R.id.edt_num_one)
        edtNumTwo = findViewById(R.id.edt_num_two)
        edtResult = findViewById(R.id.edt_result)
        btnAdd = findViewById(R.id.btn_add)
        btnSub = findViewById(R.id.btn_sub)
        btnMultiply = findViewById(R.id.btn_multiply)
        btnDivide = findViewById(R.id.btn_divide)
    }

    private fun setEvent() {
        btnAdd.setOnClickListener { cal('+') }
        btnSub.setOnClickListener { cal('-') }
        btnMultiply.setOnClickListener { cal('*') }
        btnDivide.setOnClickListener { cal('/') }
    }

    private fun mapValue() {
        numOne = edtNumOne.editText?.text.toString().trim().toInt()
        numTwo = edtNumTwo.editText?.text.toString().trim().toInt()
    }

    private fun cal(operation: Char) {
        mapValue()
        resultNum = when (operation) {
            '+' -> numOne + numTwo
            '-' -> numOne - numTwo
            '*' -> numOne * numTwo
            '/' -> numOne / numTwo
            else -> 0
        }
        edtResult.editText?.setText(resultNum.toString())
    }
}