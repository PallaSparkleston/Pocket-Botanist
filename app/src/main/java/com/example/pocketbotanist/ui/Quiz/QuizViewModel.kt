package com.example.pocketbotanist.ui.Quiz

import com.example.pocketbotanist.R

const val NUM_QUESTIONS = 1

class QuizViewModel {

    private val LOG_TAG = "448.QuizViewModel"

    // new question
    private val questionBank: MutableList<Question> = mutableListOf()

    // question index to keep track of what question number we are on
    public var currentQuestionIndex = 0


    // add all the questions to the bank
    init {
        questionBank.add( Question(R.string.quiz_question_1) )
        //questionBank.add( Question(R.string.quiz_question_2) )
    }

    // current question
    val currentQuestion: Question
        get() = questionBank[currentQuestionIndex]

    // which question is it
    val currentQuestionTextId: Int
        get()= currentQuestion.textResId

    // Player's anwer
    val currentQuestionAnswer: String?
        get()= currentQuestion.answer


    // move to next
    fun moveToNextQuestion(){
        if (currentQuestionIndex < NUM_QUESTIONS)
            currentQuestionIndex++
        else
            currentQuestionIndex = 0
    }

    // move to previous
    fun moveToPreviousQuestion(){
        if (currentQuestionIndex > 0)
            currentQuestionIndex--
        else
            currentQuestionIndex = NUM_QUESTIONS
    }
}