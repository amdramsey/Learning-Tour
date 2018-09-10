package com.aramzy.listviewlearning.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.aramzy.listviewlearning.R
import com.aramzy.listviewlearning.model.Community

class communityListAdapter: BaseAdapter {

    var dataList: ArrayList<Community>;
    var context: Context

    constructor(dataList: ArrayList<Community>, context: Context) {

        this.dataList = dataList
        this.context = context

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater;
        val rowView: View = inflater.inflate(R.layout.community_list_item, parent, false)
        val img: ImageView = rowView.findViewById(R.id.img)
        val title: TextView = rowView.findViewById(R.id.title)
        img.setImageResource(dataList[position].getImg())
        title.setText(dataList[position].getTitle())
        return rowView

    }

    override fun getItem(position: Int): Any {

        return dataList.get(position)

    }

    override fun getItemId(position: Int): Long {

        return 0;

    }

    override fun getCount(): Int {

        return dataList.size

    }

}