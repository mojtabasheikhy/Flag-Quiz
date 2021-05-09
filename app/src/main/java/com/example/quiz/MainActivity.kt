package com.example.quiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.quiz.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var bind_start:ActivityMainBinding
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind_start= DataBindingUtil.setContentView(this,R.layout.activity_main)
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        bind_start.startBtn.setOnClickListener{
            if (bind_start.nameInputEt.text.toString().isEmpty()){
                Snackbar.make(bind_start.startBtn,"لطفا نام خود را وارد نمایید",Snackbar.LENGTH_INDEFINITE)
                    .setAction("فهمیدم"){}
                    .setActionTextColor(ContextCompat.getColor(this,R.color.white))
                    .setTextColor(ContextCompat.getColor(this,R.color.white))
                    .setBackgroundTint(ContextCompat.getColor(this,R.color.purple_700))
                    .show()
            }
            else{
                var intent=Intent(this,startquiz::class.java)
                intent.putExtra(question_obj.username,bind_start.nameInputEt.text.toString())
                    startActivity(intent)
                finish()

            }
        }

    }
}