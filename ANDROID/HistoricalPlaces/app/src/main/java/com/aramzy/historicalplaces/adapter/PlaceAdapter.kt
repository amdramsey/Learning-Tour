package com.aramzy.historicalplaces.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.aramzy.historicalplaces.R
import com.aramzy.historicalplaces.model.Place

class PlaceAdapter(private var places: ArrayList<Place>, private var context: Context) : BaseAdapter() {

    @SuppressLint("SetTextI18n", "ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val v: View = LayoutInflater.from(context).inflate(R.layout.list_item_place, parent, false)

        (v.findViewById<ImageView>(R.id.img)).setImageResource(this.places.get(position).getImg())
        v.findViewById<TextView>(R.id.lblTitle).text = this.places.get(position).getName()
        v.findViewById<TextView>(R.id.lblRating).text = "${v.resources.getString(R.string.evaluation)}: ${this.places.get(position).getRate()}"
        val selectedPlace: Place = places.get(position)
        val lblRate: TextView = v.findViewById(R.id.lblRating)
        v.findViewById<Button>(R.id.btnRate).setOnClickListener(View.OnClickListener {

            selectedPlace.setRate(selectedPlace.getRate() + 1)
            lblRate.text = "${v.resources.getString(R.string.evaluation)}: ${selectedPlace.getRate()}"

            val preffile: String = "com.aramzy.historicalplaces.adapter.preferences"
            var sharedPreferences: SharedPreferences = context.getSharedPreferences(preffile, Context.MODE_PRIVATE)
            sharedPreferences.edit().putInt(selectedPlace.getName(), selectedPlace.getRate()).apply()

        })

        return v

    }

    override fun getItem(position: Int): Any {

        return places.get(position)

    }

    override fun getItemId(position: Int): Long {

        return 0

    }

    override fun getCount(): Int {

        return places.size

    }

}