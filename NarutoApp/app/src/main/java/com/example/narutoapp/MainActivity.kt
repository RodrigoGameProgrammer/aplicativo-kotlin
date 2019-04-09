package com.example.narutoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val a = 5
    private val b = 10
    private var lv: ListView? = null
    private var customeAdapter: CustomAdapter? = null
    private var imageModelArrayList: ArrayList<ImageModel>? = null
    private val myImageList = intArrayOf(R.mipmap.pain2, R.mipmap.neji, R.mipmap.gaara, R.mipmap.sasori, R.mipmap.tsu, R.mipmap.sakura, R.mipmap.itachi, R.mipmap.sixpain,R.mipmap.konan, R.mipmap.kakashi, R.mipmap.shisui, R.mipmap.shino)
    private val myImageNameList = arrayOf("Pain", "Neji", "Gaara", "Sasori", "Tsunade", "Sakura", "Itachi", "6 Caminhos de Pain", "Konan", "Kakashi", "Shisui", "Shino")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lv = findViewById(R.id.listView) as ListView

        imageModelArrayList = populateList()
        Log.d("hjhjh", imageModelArrayList!!.size.toString() + "")
        customeAdapter = CustomAdapter(this, imageModelArrayList!!)
        lv!!.adapter = customeAdapter



    }

    private fun populateList(): ArrayList<ImageModel> {

        val list = ArrayList<ImageModel>()

        for (i in 0..7) {
            val imageModel = ImageModel()
            imageModel.setNames(myImageNameList[i])
            imageModel.setImage_drawables(myImageList[i])
            list.add(imageModel)
        }

        return list
    }


    public override fun onResume() {
        super.onResume()

    }

    class CustomAdapter(private val context: Context, private val imageModelArrayList: ArrayList<ImageModel>) : BaseAdapter() {

        override fun getViewTypeCount(): Int {
            return count
        }

        override fun getItemViewType(position: Int): Int {

            return position
        }

        override fun getCount(): Int {
            return imageModelArrayList.size
        }

        override fun getItem(position: Int): Any {
            return imageModelArrayList[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var convertView = convertView
            val holder: ViewHolder

            if (convertView == null) {
                holder = ViewHolder()
                val inflater = context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                convertView = inflater.inflate(R.layout.item_list, null, true)

                holder.tvname = convertView!!.findViewById(R.id.name) as TextView
                holder.iv = convertView.findViewById(R.id.imgView) as ImageView

                convertView.tag = holder
            } else {
                // the getTag returns the viewHolder object set as a tag to the view
                holder = convertView.tag as ViewHolder
            }

            holder.tvname!!.setText(imageModelArrayList[position].getNames())
            holder.iv!!.setImageResource(imageModelArrayList[position].getImage_drawables())

            return convertView
        }

        private inner class ViewHolder {

            var tvname: TextView? = null
            internal var iv: ImageView? = null

        }

    }

    class ImageModel {

        var name: String? = null
        var image_drawable: Int = 0

        fun getNames(): String {
            return name.toString()
        }

        fun setNames(name: String) {
            this.name = name
        }

        fun getImage_drawables(): Int {
            return image_drawable
        }

        fun setImage_drawables(image_drawable: Int) {
            this.image_drawable = image_drawable
        }

    }
}
