package com.project.aboutme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignInActivity : AppCompatActivity() {

    private lateinit var idEditText: EditText
    private lateinit var pwdEditText: EditText

    private lateinit var loginButton: Button
    private lateinit var signUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        idEditText = findViewById(R.id.id_edit_text)
        pwdEditText = findViewById(R.id.pwd_edit_text)
        loginButton = findViewById(R.id.login_button)
        signUpButton = findViewById(R.id.signup_button)

        loginButton.setOnClickListener {
            if(idEditText.text.toString().isEmpty() || pwdEditText.text.toString().isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            }
        }
        signUpButton.setOnClickListener {
            val toSignUp = Intent(this, SignUpActivity::class.java)
            startActivity(toSignUp)
        }
    }
}