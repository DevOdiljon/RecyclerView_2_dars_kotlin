package com.example.a2_recyclerviewcustommultitypeadapterkotlin.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a2_recyclerviewcustommultitypeadapterkotlin.R
import com.example.a2_recyclerviewcustommultitypeadapterkotlin.model.Member

class CustomAdapter(val members: List<Member>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_AVAILABLE_YES = 0;
    private val TYPE_AVAILABLE_NO = 1;

    override fun getItemViewType(position: Int): Int {
        return if (members[position].availabe){
            TYPE_AVAILABLE_YES
        }else{
            TYPE_AVAILABLE_NO
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_AVAILABLE_YES){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_laypout_yes, parent, false)
            return CustomViewHolderYes(view)
        }
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_no, parent, false)
            return CustomViewHolderNo(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members.get(position)

        if (holder is CustomViewHolderYes){
            holder.tv_name_yes.setText(member.tv_name)
            holder.tv_tel_number_yes.setText(member.tv_tel_number)
        }

        if (holder is CustomViewHolderNo){
            holder.tv_name_no.setText(member.tv_name)
            holder.tv_tel_number_no.setText(member.tv_tel_number)
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    class CustomViewHolderYes(view: View) : RecyclerView.ViewHolder(view) {
        val tv_name_yes = view.findViewById<TextView>(R.id.tv_name_yes)
        val tv_tel_number_yes = view.findViewById<TextView>(R.id.tv_tel_number_yes)
    }

    class CustomViewHolderNo(view: View) : RecyclerView.ViewHolder(view) {
        val tv_name_no = view.findViewById<TextView>(R.id.tv_name_no)
        val tv_tel_number_no = view.findViewById<TextView>(R.id.tv_tel_number_no)
    }


}

