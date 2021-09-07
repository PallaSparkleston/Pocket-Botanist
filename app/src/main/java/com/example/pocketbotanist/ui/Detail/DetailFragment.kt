package com.example.pocketbotanist.ui.Detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pocketbotanist.R
import com.example.pocketbotanist.data.Plant
import java.util.*

class DetailFragment : Fragment() {
    private val ARG_PLANT_ID = "plant_id"
    private val logTag = "PB.DetailFragment"

    private lateinit var plant : Plant
    private lateinit var titleField : EditText
    private lateinit var ownedCheckBox : CheckBox

    private val pickPlantIntent = Intent(Intent.ACTION_PICK)

    private lateinit var plantDetailViewModel : PlantDetailViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(logTag, "onAttach() called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(logTag, "onCreate() called")
        plant = Plant()

        val factory =
            PlantDetailViewModelFactory(
                requireContext()
            )
        plantDetailViewModel = ViewModelProvider(this, factory)
            .get(PlantDetailViewModel::class.java)
        val plantId : UUID = arguments?.getSerializable(ARG_PLANT_ID) as UUID
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.d(logTag, "onCreateView() called")
        val view = inflater.inflate(R.layout.owned_layout, container, false)
        ownedCheckBox = view.findViewById(R.id.checkbox) as CheckBox

        var intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        startActivity(intent)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(logTag, "onViewCreated() called")

        plantDetailViewModel.plantLiveData.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer { plant ->
                plant?.let {
                    this.plant = plant
                    updateUI()
                }
            }
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(logTag, "onActivityCreated() called")

    }

    private fun updateUI() {

    }
}
