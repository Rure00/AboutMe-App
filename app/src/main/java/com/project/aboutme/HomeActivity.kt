package com.project.aboutme

import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class HomeActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var idText: TextView
    private lateinit var finishButton: View

    private val images = mutableListOf<Drawable>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageView = findViewById(R.id.image)
        idText = findViewById(R.id.user_id)
        finishButton = findViewById(R.id.finish_button)

        val id = intent.getStringExtra("id") ?: throw Exception("Id is Not Found...")
        idText.text = id

        with(images) {
            add(ContextCompat.getDrawable(this@HomeActivity, R.drawable.a)!!)
            add(ContextCompat.getDrawable(this@HomeActivity, R.drawable.b)!!)
            add(ContextCompat.getDrawable(this@HomeActivity, R.drawable.c)!!)
            add(ContextCompat.getDrawable(this@HomeActivity, R.drawable.d)!!)
            add(ContextCompat.getDrawable(this@HomeActivity, R.drawable.e)!!)
        }
        imageView.setImageDrawable(images[Random().nextInt(5)])
        finishButton.setOnClickListener { finish() }
    }
}