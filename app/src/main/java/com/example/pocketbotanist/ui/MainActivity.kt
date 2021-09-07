package com.example.pocketbotanist.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.pocketbotanist.ui.Menu.MenuFragment
import com.example.pocketbotanist.R
import com.example.pocketbotanist.ui.Quiz.QuizFragment
import com.example.pocketbotanist.ui.Owned.OwnedFragment
import com.example.pocketbotanist.ui.Catalog.CatalogFragment
import com.example.pocketbotanist.ui.Catalog.CatalogViewModel
import com.example.pocketbotanist.ui.Result.ResultFragment
import kotlinx.android.synthetic.main.menu_fragment.*
import kotlinx.android.synthetic.main.quiz_fragment.*
import java.util.*

class MainActivity : AppCompatActivity(), CatalogFragment.Callbacks {

    private val logTag = "448.MainActivity"
    private var detailContainer: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(logTag, "onCreate() called")
        setContentView(R.layout.activity_main)

        // TODO 2 create fragment transaction
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(currentFragment == null ) {
            val fragment = MenuFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(logTag, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(logTag, "onResume() called")
    }

    override fun onPause() {
        Log.d(logTag, "onPause() called")
        super.onPause()
    }

    override fun onStop() {
        Log.d(logTag, "onStop() called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(logTag, "onDestroy() called")
        super.onDestroy()
    }

    // TODO: make this work lol

    fun launchQuiz() {
        Log.d(logTag, "launchQuiz called")
        if (detailContainer == null) {
            val fragment = QuizFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                .addToBackStack(null).commit()
        }
    }

    fun launchCatalog() {
        Log.d(logTag, "launchCatalog called")
        if (detailContainer == null) {
            val fragment = CatalogFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                .addToBackStack(null).commit()
        }
    }

    fun launchOwnedPlants() {
        Log.d(logTag, "launchOwnedPlants called")
        if (detailContainer == null) {
            val fragment = OwnedFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                .addToBackStack(null).commit()
        }
    }

    fun launchResult() {
        Log.d(logTag, "launchResult called")
        onBackPressed()
        if (detailContainer == null) {
            val fragment = ResultFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                .addToBackStack(null).commit()
        }
    }

    override fun onPlantSelected(plantId: UUID) {
        Log.d(logTag, "MainActivity.onPlantSelected: $plantId")
        val fragment = CatalogFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}