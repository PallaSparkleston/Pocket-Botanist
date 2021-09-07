package com.example.pocketbotanist.ui.Result

import com.example.pocketbotanist.data.Plant

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketbotanist.data.PlantRepository
import com.example.pocketbotanist.data.database.PlantDao
import kotlinx.android.synthetic.main.menu_fragment.*


private const val ARG_CRIME_ID = "crime_id"

class ResultFragment : Fragment() {
    private lateinit var plantRepository : PlantRepository

    companion object {
        private const val PREFS_PLANT = "plant"
    }

    private val logTag = "448.resultFrag"



    private var adapter: PlantAdapter? = null
    private lateinit var resultRecyclerView: RecyclerView
    lateinit var resultViewModel: ResultViewModel

//    private val catalogViewModel: CatalogViewModel by
//    lazy {
//        ViewModelProviders.of(this).get
//        (CatalogViewModel::class.java)
//    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(logTag, "onAttach() called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(logTag, "onCreate() called")

        val factory = ResultViewModelFactory(requireContext())
        resultViewModel = ViewModelProvider(this, factory)
            .get(ResultViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(logTag, "onCreateView() called")
        val view = inflater.inflate(R.layout.catalog_fragment, container, false)
        activity?.setTitle("Owned Plants")

        resultRecyclerView =
            view.findViewById(R.id.catalog_recycler_view) as RecyclerView

        resultRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI(emptyList())

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(logTag, "onViewCreated() called")
        resultViewModel.plantListLiveData.observe(
            viewLifecycleOwner,
            Observer { plants ->
                plants?.let {
                    Log.i(logTag, "Got plants ${plants.size}")
                    updateUI(plants)
                }
            }
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(logTag, "onActivityCreated() called")
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

    private inner class PlantHolder(view: View)
        : RecyclerView.ViewHolder(view) {
        private lateinit var plant: Plant

        internal val titleTextView: TextView = itemView.findViewById(R.id.plant_title)
        internal val plantOwnedImage: ImageView = itemView.findViewById(R.id.plant_owned_image)

        fun bind(plant: Plant, clickListener: (Plant) -> Unit) {
            Log.d(logTag, "bind(plant, clickListener) called")
            this.plant = plant

            titleTextView.text = this.plant.title
            plantOwnedImage.visibility = if(this.plant.isOwned) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

    private inner class PlantAdapter(private val plants: List<Plant>,
                                     private val clickListener: (Plant) -> Unit)
        : RecyclerView.Adapter<PlantHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType:Int)
                : PlantHolder {
            val view = layoutInflater.inflate(R.layout.list_item_plant, parent, false)
            return PlantHolder(view)
        }

        override fun getItemCount(): Int = plants.size

        override fun onBindViewHolder(holder: PlantHolder, position: Int) {
            val plant = plants[position]
            holder.bind(plant, clickListener)
        }
    }

    private fun updateUI(plants: List<Plant>) {
        adapter = PlantAdapter(plants) { plant: Plant -> Unit
        }
        resultRecyclerView.adapter = adapter
    }

}
