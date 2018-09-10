package adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.ImageView
import com.aramzy.suqaljumea.R
import dataClasses.Advertising

class AdvertisingAdapter(private val context: Context, private var dataList: ArrayList<Advertising>): BaseAdapter() {

    private lateinit var title: EditText
    private lateinit var price: EditText
    private lateinit var date : EditText
    private lateinit var city : EditText

    private lateinit var img  : ImageView

    @SuppressLint("ViewHolder", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.advertising_adapter, parent, false)

        title = view.findViewById(R.id.title)
        price = view.findViewById(R.id.price)
        date  = view.findViewById(R.id.date )
        city  = view.findViewById(R.id.city )

        img   = view.findViewById(R.id.img)

        title.setText(dataList[position].advertisingName)
        price.setText(dataList[position].advertisingPrice)
        date.setText(dataList[position].date)
        city.setText(dataList[position].advertiserCity)

        img.setImageResource(dataList[position].advertisingPicture.toInt())

        return view
    }

    override fun getItem(position: Int): Any {

        return dataList[position]

    }

    override fun getItemId(position: Int): Long {

        return 0

    }

    override fun getCount(): Int {

        return dataList.size

    }

}