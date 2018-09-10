package com.aramzy.historicalplaces

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ListView
import com.aramzy.historicalplaces.adapter.PlaceAdapter
import com.aramzy.historicalplaces.model.Place

class MainActivity : AppCompatActivity() {

    private var places = arrayListOf<Place>()
    private var names: Array<String> = arrayOf()
    private var countries: Array<String> = arrayOf()
    private var images: Array<Int> = arrayOf()
    private var listView: ListView? = null
    private var adapter: PlaceAdapter? = null
    private var sharedPreferences: SharedPreferences? = null
    private val preffile: String = "com.aramzy.historicalplaces.adapter.preferences"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        names = resources.getStringArray(R.array.names)
        countries = resources.getStringArray(R.array.countries)
        images = arrayOf(R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5, R.drawable.img_6, R.drawable.img_7, R.drawable.img_8, R.drawable.img_9, R.drawable.img_10, R.drawable.img_11, R.drawable.img_12, R.drawable.img_13, R.drawable.img_14, R.drawable.img_15, R.drawable.img_16)
        listView = findViewById(R.id.lv)
        adapter = PlaceAdapter(places, this)

        sharedPreferences = getSharedPreferences(preffile, Context.MODE_PRIVATE)

        var i: Int = 0

        while(i < names.size) {

            val place: Place = Place(name = names[i], country = countries[i], img = images[i], description = "Hello")
            place.setRate(sharedPreferences!!.getInt(place.getName(), 0))
            places.add(place)
            i += 1

        }

        listView!!.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val menuInflater: MenuInflater = menuInflater
        menuInflater.inflate(R.menu.main_menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item!!.itemId == R.id.clear_menu_item) {

            sharedPreferences!!.edit().clear().apply()
            places.clear()

            var i: Int = 0

            while(i < names.size) {

                val place: Place = Place(name = names[i], country = countries[i], img = images[i], description = "Hello")
                place.setRate(sharedPreferences!!.getInt(place.getName(), 0))
                place.setRate(sharedPreferences!!.getInt(place.getName(), 0))
                places.add(place)
                i += 1

            }

            var placeAdapter: PlaceAdapter = PlaceAdapter(places, this)

            listView!!.adapter = placeAdapter

        }

        return super.onOptionsItemSelected(item)

    }

}