package com.example.quizapp

object Constants {

    var user_name : String = "user_name"
    var correctAns : String = "correctAns"
    var totalQuestion : String = "total_Question"

    fun getQuestions(): ArrayList<Questoin> {
        val questionList = ArrayList<Questoin>()

        val ques1 = Questoin(
            1,
            "which country this flag belongs to",
            R.drawable.usa,
            "USA","chna","India","Russia",
            1
        )
        questionList.add(ques1)
        val ques2 = Questoin(
            2,
            "which country this flag belongs to",
            R.drawable.uae,
            "UAE","chna","India","Russia",
            1
        )
        questionList.add(ques2)
        val ques3 = Questoin(
            3,
            "which country this flag belongs to",
            R.drawable.russia,
            "USA","chna","India","Russia",
            4
        )
        questionList.add(ques3)
        val ques4 = Questoin(
            4,
            "which country this flag belongs to",
            R.drawable.italy,
            "Italy","chna","India","Russia",
            1
        )
        questionList.add(ques4)
        val ques5 = Questoin(
            5,
            "which country this flag belongs to",
            R.drawable.indonesia,
            "Indonesia","chna","India","Russia",
            1
        )
        questionList.add(ques5)
        val ques6 = Questoin(
            6,
            "which country this flag belongs to",
            R.drawable.britain,
            "Britain","chna","India","Russia",
            1
        )
        questionList.add(ques6)
        val ques7 = Questoin(
            7,
            "which country this flag belongs to",
            R.drawable.india,
            "USA","chna","India","Russia",
            3
        )
        questionList.add(ques7)
        val ques8 = Questoin(
            8,
            "which country this flag belongs to",
            R.drawable.france,
            "France","chna","India","Russia",
            1
        )
        questionList.add(ques8)
        val ques9 = Questoin(
            9,
            "which country this flag belongs to",
            R.drawable.china,
            "USA","china","India","Russia",
            2
        )
        questionList.add(ques9)
        return questionList
    }
}