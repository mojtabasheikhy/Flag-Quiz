package com.example.quiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.quiz.databinding.ActivityResualtBinding

class resualt : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("SetTextI18n")
    lateinit var bind_resualt: ActivityResualtBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind_resualt = DataBindingUtil.setContentView(this, R.layout.activity_resualt)
        var username = intent.getStringExtra(question_obj.username)
        var correct_answer = intent.getIntExtra(question_obj.correct_answer, 0)
        bind_resualt.resualtResualtTv.text = "امتیاز شما از 10 برابر است با  ${correct_answer}"
        bind_resualt.resualtUsername.text = username.toString()
        bind_resualt.button.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button -> {
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }
        }
    }
}