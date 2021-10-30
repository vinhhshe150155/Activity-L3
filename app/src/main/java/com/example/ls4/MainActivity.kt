package com.example.ls4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var edtUsername: TextInputLayout
    private lateinit var edtPwdOne: TextInputLayout
    private lateinit var edtPwdTwo: TextInputLayout
    private lateinit var tvError: TextView
    private lateinit var btnSignUpContinue: Button
    private lateinit var username: String;
    private lateinit var pwdOne: String;
    private lateinit var pwdTwo: String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)
        mapView()
        btnSignUpContinue.setOnClickListener { checkValid() }
    }

    private fun mapView() {
        edtUsername = findViewById(R.id.edt_username)
        edtPwdOne = findViewById(R.id.edt_pwd_one)
        edtPwdTwo = findViewById(R.id.edt_pwd_two)
        btnSignUpContinue = findViewById(R.id.btn_signup_continue)
        tvError = findViewById(R.id.tv_signup_error)
    }

    private fun mapValue() {
        username = edtUsername.editText?.text.toString().trim()
        pwdOne = edtPwdOne.editText?.text.toString().trim()
        pwdTwo = edtPwdTwo.editText?.text.toString().trim()
    }

    private fun checkValid() {
        var isValid = true;
        mapValue()
        if (username.length < 6 || username.contains(' ')) {
            edtUsername.setBackgroundColor(0xFF00FF0)
            isValid = false
        }
        if (pwdOne.length < 8 || pwdOne != pwdTwo) {
            edtPwdOne.setBackgroundColor(0xFF00FF0)
            edtPwdTwo.setBackgroundColor(0xFF00FF0)
            isValid = false
        }
        if (!isValid) {
            tvError.visibility = View.VISIBLE
        } else {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }
    }
}

