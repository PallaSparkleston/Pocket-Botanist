package com.example.pocketbotanist.ui.Quiz

import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.pocketbotanist.R
import androidx.lifecycle.ViewModelProvider
import java.util.*
import androidx.lifecycle.Observer
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.quiz_fragment.*
import android.widget.RadioGroup
import androidx.fragment.app.FragmentManager
import com.example.pocketbotanist.ui.MainActivity


private const val ARG_POCKET_ID = "pocket_id"

class QuizFragment : Fragment() {
    private lateinit var quizViewModel: QuizViewModel

    private val logTag = "448.QuizFrag"

    private lateinit var main: MainActivity

    // the question text view for questions
    lateinit var questionTextView: TextView


    // keeps track of the answers that the user gives
    private var question1Ans:String? = null
    private var question2Ans:String? = null
    private var question3Ans:String? = null

    private var questionNum = 0

    private var question0 = "Do you want an outdoor plant or an indoor plant?"
    private var question1 = "What is the level of natural light you can expect?"
    private var question3 = "How often are you willing to water your plant?"

    private var questArray = arrayOf(question0, question1, question3)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(logTag, "onAttach() called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //setContentView(R.layout.quiz_fragment)



        Log.d(logTag, "onCreate() called")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(logTag, "onCreateView() called")
        val view = inflater.inflate(com.example.pocketbotanist.R.layout.quiz_fragment, container, false)

        activity?.setTitle("Plant Quiz")

//        val factory = QuizViewModelFactory()
//
//        quizViewModel = ViewModelProvider(this@QuizFragment, factory).get(QuizViewModel::class.java)
//
//        updateQuestion(resources.getString(quizViewModel.currentQuestionTextId))
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(logTag, "onViewCreated() called")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(logTag, "onActivityCreated() called")
    }

    private fun updateQuestion(currentQuestion: String) {
        setCurrentScoreText()
        question_text_view.text = currentQuestion
    }

    private fun setCurrentScoreText() {

//      when (quizViewModel.currentQuestionAnswer) {
//            "True","False" -> {
//                true_false_layout.visibility = View.VISIBLE
//                multiple_choice_layout.visibility = View.INVISIBLE
//                fill_in_the_blank_layout.visibility = View.INVISIBLE
//            }
//            "NY","CA","TX","AZ" -> {
//                true_false_layout.visibility = View.INVISIBLE
//                multiple_choice_layout.visibility = View.VISIBLE
//                fill_in_the_blank_layout.visibility = View.INVISIBLE
//            }
//            "STEM" -> {
//                true_false_layout.visibility = View.INVISIBLE
//                multiple_choice_layout.visibility = View.INVISIBLE
//                fill_in_the_blank_layout.visibility = View.VISIBLE
//            }
//
//        }
    }

    fun nextQuestion(){
        questionNum += 1
        if (questionNum >= questArray.size-1){
            next_button.visibility = View.GONE
        }
        updateQuestion(questArray[questionNum])
        var but_id: Int = multRadioGroup.checkedRadioButtonId
        if(questionNum > 0){
            radio_option_1.text = "Low"
            radio_option_2.text = "Medium"
            radio_option_3.text = "High"
            radio_option_3.visibility = View.VISIBLE
            radio_option_4.text = "#"
        }
//        if(questionNum == 0){
//            radio_option_1.text = "Yes"
//            radio_option_2.text = "No"
//            radio_option_3.visibility = View.GONE
//            radio_option_3.text = "#"
//            radio_option_4.text = "#"
//        }
        if(questionNum == 0){
            radio_option_1.text = "Outdoor"
            radio_option_2.text = "Indoor"
            radio_option_3.visibility = View.GONE
            radio_option_3.text = "#"
            radio_option_4.text = "#"
        }
        if (id!=-1){
            Log.d(logTag, but_id.toString())
            val rad:RadioButton? = view?.findViewById(id)
            val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
            with (sharedPref.edit()){
                putString(questionNum.toString(), rad?.text.toString())
                commit()
            }
            multRadioGroup.clearCheck()
//            radio_option_1.setChecked(false)
//            radio_option_2.setChecked(false)
//            radio_option_3.setChecked(false)
//            radio_option_4.setChecked(false)
        }
    }

    fun submitAnswers() {
        main = activity as MainActivity
        main.launchResult()
    }


    override fun onStart() {
        super.onStart()
        Log.d(logTag, "onStart() called")

        next_button.setOnClickListener{nextQuestion()}
        submit_button.setOnClickListener{submitAnswers()}
    }

    override fun onResume() {
        super.onResume()
        Log.d(logTag, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(logTag, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(logTag, "onStop() called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(logTag, "onDestroyView() called")

        activity?.setTitle("Pocket Botanist")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(logTag, "onDestroy() called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(logTag, "onDetach() called")
    }



}