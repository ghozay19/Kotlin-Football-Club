package com.example.ghozy.footbalappsbasic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private var club_Name: String = ""
    private var club_Logo = 0
    private var club_Desc = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        loadData()

    }

    private fun loadData() {


        val intent = intent
        club_Name = intent.getStringExtra("clubName")
        club_Logo = intent.getIntExtra("logoClub",0)
        club_Desc = intent.getStringExtra("clubDesc")

        name_detail.text = club_Name
        desc_detail.text = club_Desc



        Glide.with(this)
                .load(club_Logo)
                .into(logo_detail)
    }
}
