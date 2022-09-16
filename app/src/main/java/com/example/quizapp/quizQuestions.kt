package com.example.quizapp

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class quizQuestions : AppCompatActivity() , View.OnClickListener {
    var submitBtn: Button? = null
    var imageView: ImageView? = null
    var tvQuestion : TextView? = null
    var progress : TextView? = null
    var progressBar : ProgressBar? = null
    var optionOne : TextView? = null
    var optionTwo : TextView? = null
    var optionThree : TextView? = null
    var optionFour : TextView? = null
    private var questions : ArrayList<Questoin>? = null
    private var questionNum:Int = 1
    var selectedOptionNum : Int = 0
    var mCorrectAns : Int = 0
    var userName : String? = null
    var maxQuestoin : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        submitBtn= findViewById(R.id.SubmitBTN)
        imageView= findViewById(R.id.imageView)
        tvQuestion= findViewById(R.id.question)
        progress= findViewById(R.id.tvProgress)
        progressBar= findViewById(R.id.progressBar)
        optionOne= findViewById(R.id.optionOne)
        optionTwo= findViewById(R.id.optionTwo)
        optionThree= findViewById(R.id.optionThree)
        optionFour= findViewById(R.id.optionFour)
        optionOne!!.setOnClickListener(this)
        optionTwo!!.setOnClickListener(this)
        optionThree!!.setOnClickListener(this)
        optionFour!!.setOnClickListener(this)
        submitBtn!!.setOnClickListener(this)
        userName = intent.getStringExtra(Constants.user_name)
        maxQuestoin = questions?.size

        questions= Constants.getQuestions()
        setQuestions()

    }

    private fun setQuestions() {

        defaultView()

        var question = questions?.get(questionNum-1)
        question?.image?.let { imageView?.setImageResource(it) }
        progress?.text = "${questionNum}/${progressBar?.max}"
        progressBar?.progress = questionNum
        tvQuestion?.text = question?.question
        optionOne?.text = question?.optionOne
        optionFour?.text = question?.optionFour
        optionThree?.text = question?.optionThree
        optionTwo?.text = question?.optionTwo
    }

    private fun defaultView(){
        var optionList = ArrayList<TextView>()
        optionOne?.let { optionList.add(0,it) }
        optionTwo?.let { optionList.add(1,it) }
        optionThree?.let { optionList.add(2,it) }
        optionFour?.let { optionList.add(3,it) }


        for(option in optionList){
                option.setTypeface(option.typeface,Typeface.NORMAL)
                option.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.default_option_view_bg
                )
            }
    }

    private fun selectedOptionView(optionNum:Int,option:TextView){

        defaultView()

        selectedOptionNum = optionNum
        option.setTypeface(option.typeface,Typeface.BOLD)
        option.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_view_bg
        )
    }

    fun ansView(answer:Int , answerView: Int){
        when(answer){
            1 -> {
                optionOne?.background = ContextCompat.getDrawable(
                    this,
                    answerView
                )
            }
            2 -> {
                optionTwo?.background = ContextCompat.getDrawable(
                    this,
                    answerView
                )
            }
            3 -> {
                optionThree?.background = ContextCompat.getDrawable(
                    this,
                    answerView
                )
            }
            4 -> {
                optionFour?.background = ContextCompat.getDrawable(
                    this,
                    answerView
                )
            }
        }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.optionOne -> {
                optionOne?.let { selectedOptionView(1,it)}
            }
            R.id.optionTwo -> {
                optionTwo?.let { selectedOptionView(2,it)}
            }
            R.id.optionThree -> {
                optionThree?.let { selectedOptionView(3,it)}
            }
            R.id.optionFour -> {
                optionFour?.let { selectedOptionView(4,it)}
            }
            R.id.SubmitBTN -> {
                if (selectedOptionNum==0){
                    questionNum++
                    when{
                        questionNum<=questions!!.size -> {
                            setQuestions()
                        }
                        else->{
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.user_name,userName)
                            intent.putExtra(Constants.correctAns,mCorrectAns)
                            intent.putExtra(Constants.totalQuestion,maxQuestoin)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    if (selectedOptionNum != questions?.get(questionNum-1)?.correctAnswer){
                        ansView(selectedOptionNum,R.drawable.wrong_option_bg)
                    }else{
                        mCorrectAns++
                    }
                    questions?.get(questionNum-1)?.let { ansView(it.correctAnswer,R.drawable.correct_option_bg) }
                    if (questionNum==questions?.size){
                        submitBtn?.text = "FINISH"
                    }
                    else{
                        submitBtn?.text = "NEXT"
                    }
                    selectedOptionNum=0
                }
            }
        }
    }
}