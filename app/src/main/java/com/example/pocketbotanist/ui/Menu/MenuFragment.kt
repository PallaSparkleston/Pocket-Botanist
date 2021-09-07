package com.example.pocketbotanist.ui.Menu

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.pocketbotanist.R
import androidx.lifecycle.ViewModelProvider
import java.util.*
import androidx.lifecycle.Observer
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pocketbotanist.ui.MainActivity
import com.example.pocketbotanist.ui.Quiz.QuizFragment
import kotlinx.android.synthetic.main.menu_fragment.*


private const val ARG_POCKET_ID = "pocket_id"
//private var callbacks: MenuFragment.Callbacks? = null

class MenuFragment : Fragment() {

    private lateinit var main: MainActivity

//    interface Callbacks {
//        fun MainActivity.launchQuiz()
//        fun MainActivity.launchCatalog()
//        fun MainActivity.launchOwnedPlants()
//    }

    private var detailContainer: FrameLayout? = null

    private lateinit var quizButton: Button
    private lateinit var catalogButton: Button
    private lateinit var ownedPlants: Button

    private val logTag = "448.MenuFrag"

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        callbacks = context as Callbacks?
        Log.d(logTag, "onAttach() called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.setTitle("Pocket Botanist")
        Log.d(logTag, "onCreate() called")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(logTag, "onCreateView() called")
        val view = inflater.inflate(R.layout.menu_fragment, container, false)
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

    override fun onStart() {
        super.onStart()
        Log.d(logTag, "onStart() called")
        main = activity as MainActivity

        take_quiz.setOnClickListener { main.launchQuiz() }
        plant_catalog.setOnClickListener { main.launchCatalog() }
        owned_plants.setOnClickListener { main.launchOwnedPlants() }
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
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(logTag, "onDestroy() called")
    }

    override fun onDetach() {
        super.onDetach()
//        callbacks = null
        Log.d(logTag, "onDetach() called")
    }

}