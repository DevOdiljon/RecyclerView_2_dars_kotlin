package com.example.a2_recyclerviewcustommultitypeadapterkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a2_recyclerviewcustommultitypeadapterkotlin.R
import com.example.a2_recyclerviewcustommultitypeadapterkotlin.model.Member
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        val members = prepareMemberList()
        refreshAdapter(members)
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(members)
        recyclerView.adapter = adapter
    }

    private fun initViews() {
        recyclerView.layoutManager = GridLayoutManager(this, 1)

    }

    private fun prepareMemberList(): List<Member> {

        val members = ArrayList<Member>()

        for (i in 0..30 step 1) {
            if (i % 3 == 0) {
                members.add(Member("Odilbek " + i, "+998-97-775-17-79", false))
            }else {
                members.add(Member("Odilbek " + i, "+998-97-775-17-79", true))
            }
        }

        return members
    }
}