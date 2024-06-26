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

class SignUpActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var idEditText: EditText
    private lateinit var pwdEditText: EditText

    private lateinit var signUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nameEditText = findViewById(R.id.name_edit_text)
        idEditText = findViewById(R.id.id_edit_text)
        pwdEditText = findViewById(R.id.pwd_edit_text)
        signUpButton = findViewById(R.id.signup_button)

        signUpButton.setOnClickListener {
            if(idEditText.text.toString().isEmpty() ||
                pwdEditText.text.toString().isEmpty() ||
                nameEditText.text.toString().isEmpty()
                ) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SignInActivity::class.java).apply {
                    putExtra("user_data", UserData(
                        name = nameEditText.text.toString(),
                        id = idEditText.text.toString(),
                        pwd = pwdEditText.text.toString()
                    ))
                }
                setResult(RESULT_OK,intent)
                finish()
            }
        }
    }
}