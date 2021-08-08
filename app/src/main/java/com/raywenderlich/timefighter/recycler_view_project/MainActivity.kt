package com.raywenderlich.timefighter.recycler_view_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    /**
     * Create an instance of the recycler view, List, Image view, text view
     */
    private lateinit var instanceRecyclerView: RecyclerView
    private lateinit var personsName: ArrayList<Persons>
    lateinit var imageView: Array<Int>
    lateinit var textView: Array<String>
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






        textView= arrayOf(
            "Seun",
            "Ayo",
            "Tayo",
            "Timi",
            "tolu",
            "sswde",
            "njfnfj",
            "kdnjv",
            "jcnkc",
            "jncnie"
        )
        imageView = arrayOf(
            R.drawable.julian_wan_wnolnjo7ts8_unsplash,
            R.drawable.luis_villasmil_6qf1uljgpu4_unsplash,
            R.drawable.nicolas_horn_mtztgvdshfy_unsplash,
            R.drawable.sarah_brown_ttdc88_6a_i_unsplash,
            R.drawable.tomoko_uji_mupcsmpgh6k_unsplash,
            R.drawable.tomoko_uji_mupcsmpgh6k_unsplash,
            R.drawable.tomoko_uji_mupcsmpgh6k_unsplash,
            R.drawable.pexels_irina_iriser_1590549,
            R.drawable.sergey_zolkin__uey8ati6d0_unsplash,
            R.drawable.sigmund_jzz_3jwmzha_unsplash,

        )

        instanceRecyclerView = findViewById(R.id.recyclerViewId)
        instanceRecyclerView.layoutManager = LinearLayoutManager(this)
        instanceRecyclerView.setHasFixedSize(true)
        personsName = arrayListOf<Persons>()
        getPersonsData()

    }



    private fun getPersonsData() {
        for (i in imageView.indices){
            val name = Persons(textView[i],imageView[i])
            personsName.add(name)
        }
        instanceRecyclerView.adapter = ProjectAdapter(personsName)
    }
}