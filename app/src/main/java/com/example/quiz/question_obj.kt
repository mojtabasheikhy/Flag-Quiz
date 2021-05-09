package com.example.quiz

object question_obj {

    const val username="user_name"
    const val total_question="total_question"
    const val correct_answer= "correct_answer"
    fun list_question():ArrayList<questions>{
        val que = ArrayList<questions>()
        val que1_data = questions(1,R.drawable.ic_flag_of_argentina,"پرچم زیر برای کدام کشور است ؟","آلمان","استرلیا" ,"آرژانتین","آمریکا",3)
        val que2_data = questions(2,R.drawable.ic_flag_of_denmark,"پرچم زیر برای کدام کشور است ؟","سریلانکا","ازبکستان" ,"روسیه","دانمارک",4)
        val que3_data = questions(3,R.drawable.ic_flag_of_brazil,"پرچم زیر برای کدام کشور است ؟","برزیل","عراق" ,"ترکیه","آفریقای جنوبی",1)
        val que4_data = questions(4,R.drawable.ic_flag_of_belgium,"پرچم زیر برای کدام کشور است ؟","فرانسه","بلژیک" ,"آرژانتین","مالزی",2)
        val que5_data = questions(5,R.drawable.ic_flag_of_india,"پرچم زیر برای کدام کشور است ؟","افغانستان","پاکستان" ,"ترکمنستان","هند",4)
        val que6_data = questions(6,R.drawable.ic_flag_of_fiji,"پرچم زیر برای کدام کشور است ؟","آلبانی","چین" ,"فیجی","اندونزی",3)
        val que7_data = questions(7,R.drawable.ic_flag_of_germany,"پرچم زیر برای کدام کشور است ؟","انگلستان","آلمان" ,"ایتالیا","نپال",2)
        val que8_data = questions(8,R.drawable.ic_flag_of_kuwait,"پرچم زیر برای کدام کشور است ؟","بحرین","چین" ,"کویت","قطر",3)
        val que9_data = questions(9,R.drawable.ic_flag_of_new_zealand,"پرچم زیر برای کدام کشور است ؟","نیوزیلند","استرلیا" ,"سوریه","ژاپن",1)
        val que10_data = questions(10,R.drawable.ic_flag_of_australia,"پرچم زیر برای کدام کشور است ؟","استرلیا","نیوزیلند" ,"کره جنوبی","قطر",1)

        que.add(que1_data)
        que.add(que2_data)
        que.add(que3_data)
        que.add(que4_data)
        que.add(que5_data)
        que.add(que6_data)
        que.add(que7_data)
        que.add(que8_data)
        que.add(que9_data)
        que.add(que10_data)
        return que
    }
}