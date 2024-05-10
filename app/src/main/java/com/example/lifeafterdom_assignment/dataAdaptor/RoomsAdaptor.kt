package com.example.lifeafterdom_assignment.dataAdaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lifeafterdom_assignment.R
import com.example.lifeafterdom_assignment.data.Rooms

class RoomsAdaptor(private var roomsList: ArrayList<Rooms>, private val listener: onItemClickListener): RecyclerView.Adapter <RoomsAdaptor.RoomsDisplayHolder>() {

    inner class RoomsDisplayHolder (itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val imgRDHRoomImg : ImageView = itemView.findViewById(R.id.imgRDHRoomImg)
        val tvRDHRoomName : TextView = itemView.findViewById(R.id.tvRDHRoomName)
        val tvRDHPrice : TextView = itemView.findViewById(R.id.tvRDHPrice)
        val tvRDHAddress : TextView = itemView.findViewById(R.id.tvRDHAddress)

        // OnClickItem Function
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position : Int = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                listener.itemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomsDisplayHolder {
        val itemView = LayoutInflater.from(parent.context).inflate( R.layout.rooms_display_holder, parent, false )
        return RoomsDisplayHolder(itemView)
    }

    override fun getItemCount(): Int {
        return roomsList.size
    }

    override fun onBindViewHolder(holder: RoomsDisplayHolder, position: Int) {
        val currentItem = roomsList[position]
//        holder.imgRDHRoomImg.setImageResource(currentItem.image)
        holder.tvRDHRoomName.text = currentItem.name
        holder.tvRDHPrice.text = "RM " + currentItem.price.toString()
        holder.tvRDHAddress.text = currentItem.address
    }

    fun setFilteredList(roomsList: ArrayList<Rooms>){
        this.roomsList = roomsList
        notifyDataSetChanged()
    }

    interface onItemClickListener{
        fun itemClick(position: Int)
    }
}