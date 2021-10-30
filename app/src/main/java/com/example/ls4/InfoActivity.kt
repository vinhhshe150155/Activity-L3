package com.example.ls4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class InfoActivity : AppCompatActivity() {
    private lateinit var edtPhone: TextInputLayout
    private lateinit var edtEmail: TextInputLayout
    private lateinit var edtName: TextInputLayout
    private lateinit var edtCompany: TextInputLayout
    private lateinit var edtPwd: TextInputLayout
    private lateinit var btnContinue: Button
    private lateinit var tvErrorPhone: TextView
    private lateinit var tvErrorEmail: TextView
    private lateinit var tvErrorName: TextView
    private lateinit var tvErrorCompany: TextView
    private lateinit var tvErrorPwd: TextView
    private lateinit var phone: String
    private lateinit var email: String
    private lateinit var name: String
    private lateinit var company: String
    private lateinit var pwd: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info)
        mapView()
        btnContinue.setOnClickListener {
            checkValid()
        }
    }

    private fun mapView() {
        edtPhone = findViewById(R.id.edt_phone)
        edtEmail = findViewById(R.id.edt_email)
        edtName = findViewById(R.id.edt_name)
        edtCompany = findViewById(R.id.edt_company)
        edtPwd = findViewById(R.id.edt_pwd)
        btnContinue = findViewById(R.id.btn_continue)
        tvErrorPhone = findViewById(R.id.tv_phone_error)
        tvErrorEmail = findViewById(R.id.tv_email_error)
        tvErrorName = findViewById(R.id.tv_name_error)
        tvErrorCompany = findViewById(R.id.tv_company_error)
        tvErrorPwd = findViewById(R.id.tv_pwd_error)
    }

    private fun mapValue() {
        phone = edtPhone.editText?.text.toString().trim()
        email = edtEmail.editText?.text.toString().trim()
        name = edtName.editText?.text.toString().trim()
        company = edtCompany.editText?.text.toString().trim()
        pwd = edtPwd.editText?.text.toString().trim()
    }

    private fun checkValid() {
        mapValue()
        var check = true
        val regexPhone = "(84|0[3|5|7|8|9])+([0-9]{8})\\b".toRegex()
        val regexEmail = "^\\S+@\\S+\$".toRegex()
        val regexName = "^[a-zA-Z ]{1,10}\$".toRegex()
        if (!regexPhone.containsMatchIn(phone)) {
            tvErrorPhone.visibility = View.VISIBLE
            edtPhone.setBackgroundColor(0xFF00FF0)
            check = false
        } else {
            tvErrorPhone.visibility = View.GONE
        }
        if (!regexEmail.containsMatchIn(email)) {
            tvErrorEmail.visibility = View.VISIBLE
            edtEmail.setBackgroundColor(0xFF00FF0)
            check = false
        } else {
            tvErrorEmail.visibility = View.GONE
        }
        if (!regexName.containsMatchIn(name)) {
            tvErrorName.visibility = View.VISIBLE
            edtName.setBackgroundColor(0xFF00FF0)
            check = false
        } else {
            tvErrorName.visibility = View.GONE
        }
        if (!regexName.containsMatchIn(company)) {
            tvErrorCompany.visibility = View.VISIBLE
            edtCompany.setBackgroundColor(0xFF00FF0)
            check = false
        } else {
            tvErrorCompany.visibility = View.GONE
        }
        if (pwd.length < 8) {
            tvErrorPwd.visibility = View.VISIBLE
            edtPwd.setBackgroundColor(0xFF00FF0)
            check = false
        } else {
            tvErrorPwd.visibility = View.GONE
        }
        if(check){
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }
    }
}