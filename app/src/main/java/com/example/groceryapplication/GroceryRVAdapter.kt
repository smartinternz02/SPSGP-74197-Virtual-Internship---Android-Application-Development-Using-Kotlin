package com.example.groceryapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroceryRVAdapter (
    var list: List<GroceryItems>,
    val groceryItemClickInterface: GroceryItemClickInterface
    ): RecyclerView.Adapter<GroceryRVAdapter.GroceryViewHolder>() {


    inner class GroceryViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        val nameTV=itemview.findViewById<TextView>(R.id.idTVItemName)
        val quantityTV=itemview.findViewById<TextView>(R.id.idTVQuantity)
        val rateTV=itemview.findViewById<TextView>(R.id.idTVRate)
        val amountTV=itemview.findViewById<TextView>(R.id.idTVTotalAmt)
        val deleteTV=itemview.findViewById<ImageView>(R.id.idTVDelete)
    }

    interface GroceryItemClickInterface{
        fun onItemClick(groceryItems: GroceryItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.grocery_rv_item,parent,false)
        return GroceryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        holder.nameTV.text=list.get(position).itemName
        holder.quantityTV.text=list.get(position).itemQuantity.toString()
        holder.rateTV.text="RS."+list.get(position).itemPrice.toString()
        val itemTotal:Int=list.get(position).itemPrice*list.get(position).itemQuantity
        holder.amountTV.text="RS."+itemTotal.toString()
        holder.deleteTV.setOnClickListener {
            groceryItemClickInterface.onItemClick(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}

//fun ImageView.setOnClickListener(onItemClick: Unit) {

//}
