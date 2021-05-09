package com.example.quiz

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.quiz.databinding.ActivityStartquizBinding
import java.lang.annotation.ElementType

class startquiz : AppCompatActivity(), View.OnClickListener {
    lateinit var bind: ActivityStartquizBinding

    //makane soal dar araye baraye avalin bar
    var current_possition: Int = 1
    //نام کاربر
     var user_name:String? = null
    //متغیر نگهداری تعداد جواب های درست
    var correct_answer_counter: Int = 0

    var questions_obj = ArrayList<questions>()

    //javabe entekhab shode az samte karbar
    var selected_opt: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_startquiz)

        //گرفتن نام کاربر از اکتیویتی قبل
         user_name=intent.getStringExtra(question_obj.username)



        question_setup()

        bind.answer2.setOnClickListener(this)
        bind.answer1.setOnClickListener(this)
        bind.answer3.setOnClickListener(this)
        bind.answer4.setOnClickListener(this)
        bind.submitAnswer.setOnClickListener(this)


    }

    @SuppressLint("SetTextI18n")
    private fun question_setup() {
        //ست کردن بک گراند در حالت انتخاب نشده
        set_default_background_opt()


        if (selected_opt == 0) {
            bind.submitAnswer.text = "ارسال"
        } else if (selected_opt != 0 && questions_obj.size < current_possition) {
            bind.submitAnswer.text = "سوال بعد"
        }


        //نمونه سازی از ابجکت
        questions_obj = question_obj.list_question()

        //گرفتن اولین نمونه از آبجکتی که ساختیم برای ست کردن بروی تسکت ویو ها ایمیج ویوها
        var questions_first_index = questions_obj.get(current_possition - 1)

        //ست کردن نوار پیشرفت در تعداد سوالات
        bind.questionProgress.progress = current_possition
        bind.progressCounter.text = current_possition.toString() + " / " + bind.questionProgress.max

        //ست کردن سوال گزینه ها و عکس کشور
        bind.qeustion.text = questions_first_index.question
        bind.imageFlag.setImageResource(questions_first_index.image_flag)
        bind.answer1.text = questions_first_index.op1
        bind.answer2.text = questions_first_index.op2
        bind.answer3.text = questions_first_index.op3
        bind.answer4.text = questions_first_index.op4
    }

    fun set_default_background_opt() {
        val arraylist_btn = ArrayList<Button>()
        arraylist_btn.add(bind.answer1)
        arraylist_btn.add(bind.answer2)
        arraylist_btn.add(bind.answer3)
        arraylist_btn.add(bind.answer4)
        for (btn in arraylist_btn) {
            btn.background = ContextCompat.getDrawable(this, R.drawable.background_notcheck_answer)
            btn.setTextColor(ContextCompat.getColor(this, R.color.gray))
        }
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.answer1 -> {
                setbackground_option_clicked(bind.answer1, 1)
            }
            R.id.answer2 -> {
                setbackground_option_clicked(bind.answer2, 2)
            }
            R.id.answer3 -> {
                setbackground_option_clicked(bind.answer3, 3)
            }
            R.id.answer4 -> {
                setbackground_option_clicked(bind.answer4, 4)
            }

            R.id.submit_answer -> {
                if (selected_opt == 0) {
                    current_possition++
                    when {
                        current_possition <= questions_obj.size -> {
                            question_setup()
                        }
                        else -> {
                            //سوالات به اخر رسیدو ایندکس روی 11 ثبت شده
                            Toast.makeText(this, "تمام شد", Toast.LENGTH_SHORT).show()
                            var intent=Intent(this,resualt::class.java)
                            intent.putExtra(question_obj.username,user_name)
                            intent.putExtra(question_obj.correct_answer,correct_answer_counter)
                            startActivity(intent)
                            finish()
                        }
                    }

                } else {

                    if (questions_obj.get(current_possition - 1).correct_answer != selected_opt) {
                        change_background_opt_when_answer_correct_or_wrong(selected_opt, R.drawable.wrong_answer_background,R.color.black)
                    }
                    else {
                        correct_answer_counter++
                    }
                    change_background_opt_when_answer_correct_or_wrong(questions_obj.get(current_possition - 1).correct_answer, R.drawable.correct_answer_background,R.color.white)
                    selected_opt = 0

                    if (current_possition == questions_obj.size) {
                        bind.submitAnswer.text = "تمام"
                    } else bind.submitAnswer.text = "سوال بعد"


                }
            }
        }
    }

    //تابع تغییر شکل گزینه ها در هنگانم انتخاب شدن
    fun setbackground_option_clicked(btn: Button, selecteditem: Int) {
        set_default_background_opt()
        //تغییر مقدار از صفر به صورت دیفالت به یکی از چهار حالت

        selected_opt = selecteditem
        //تغییر شکل گزینه انتخاب شده
        btn.background = ContextCompat.getDrawable(this, R.drawable.background_checked)
        btn.setTextColor(ContextCompat.getColor(this, R.color.black))
        btn.setTypeface(btn.typeface, Typeface.BOLD)
        btn.textSize = 18f

    }

    //تغییر شکل بک گراند گزینه ها وقتی جواب غلط است یا درست
    private fun change_background_opt_when_answer_correct_or_wrong(answer: Int, background: Int,textcolor:Int) {
        when (answer) {
            1 -> {
                bind.answer1.background = ContextCompat.getDrawable(this, background)
                bind.answer1.setTextColor(ContextCompat.getColor(this,textcolor))
            }
            2 -> {
                bind.answer2.background = ContextCompat.getDrawable(this, background)
                bind.answer2.setTextColor(ContextCompat.getColor(this,textcolor))
            }
            3 -> {
                bind.answer3.background = ContextCompat.getDrawable(this, background)
                bind.answer3.setTextColor(ContextCompat.getColor(this,textcolor))
            }
            4 -> {
                bind.answer4.background = ContextCompat.getDrawable(this, background)
                bind.answer4.setTextColor(ContextCompat.getColor(this,textcolor))
            }

        }


    }
}