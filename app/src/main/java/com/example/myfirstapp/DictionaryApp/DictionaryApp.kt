package com.example.myfirstapp.DictionaryApp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.R

class DictionaryApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dictionary_app)

        val recyclerView = findViewById<RecyclerView>(R.id.recycleViewMain)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Example data
        val itemList = listOf(
            ItemModel("Instagram", "Social", "4.4★"),
            ItemModel("Facebook", "Social", "4.2★"),
            ItemModel("Twitter", "Social", "4.0★"),
            ItemModel("WhatsApp", "Messaging", "4.3★"),
            ItemModel("Snapchat", "Social", "4.2★"),
            ItemModel("TikTok", "Entertainment", "4.5★"),
            ItemModel("YouTube", "Video", "4.7★"),
            ItemModel("Spotify", "Music", "4.6★"),
            ItemModel("Netflix", "Entertainment", "4.4★"),
            ItemModel("Zoom", "Communication", "4.3★"),
            ItemModel("Gmail", "Email", "4.5★"),
            ItemModel("Google Maps", "Navigation", "4.6★"),
            ItemModel("Uber", "Travel", "4.2★"),
            ItemModel("Airbnb", "Travel", "4.5★"),
            ItemModel("Reddit", "Social", "4.3★"),
            ItemModel("Pinterest", "Lifestyle", "4.4★"),
            ItemModel("LinkedIn", "Professional", "4.3★"),
            ItemModel("Amazon", "Shopping", "4.6★"),
            ItemModel("eBay", "Shopping", "4.2★"),
            ItemModel("Flipboard", "News", "4.3★"),
            ItemModel("Medium", "Reading", "4.5★"),
            ItemModel("Discord", "Communication", "4.4★"),
            ItemModel("Slack", "Work", "4.3★"),
            ItemModel("Trello", "Productivity", "4.5★"),
            ItemModel("Canva", "Design", "4.8★"),
            ItemModel("Duolingo", "Education", "4.7★"),
            ItemModel("Coursera", "Education", "4.6★"),
            ItemModel("Khan Academy", "Education", "4.6★"),
            ItemModel("Fitbit", "Health", "4.2★"),
            ItemModel("Headspace", "Health", "4.5★"),
            ItemModel("Adobe Lightroom", "Photography", "4.3★"),
            ItemModel("Snapseed", "Photography", "4.4★"),
            ItemModel("Shazam", "Music", "4.6★"),
            ItemModel("SoundCloud", "Music", "4.5★"),
            ItemModel("Waze", "Navigation", "4.6★"),
            ItemModel("Grammarly", "Writing", "4.7★"),
            ItemModel("PayPal", "Finance", "4.4★"),
            ItemModel("Venmo", "Finance", "4.3★"),
            ItemModel("Robinhood", "Finance", "4.2★"),
            ItemModel("Dropbox", "Storage", "4.4★"),
            ItemModel("Google Drive", "Storage", "4.6★"),
            ItemModel("Microsoft Teams", "Work", "4.3★"),
            ItemModel("Google Meet", "Communication", "4.4★"),
            ItemModel("Clubhouse", "Social", "4.2★"),
            ItemModel("Telegram", "Messaging", "4.5★"),
            ItemModel("Signal", "Messaging", "4.4★"),
            ItemModel("Flipkart", "Shopping", "4.3★"),
            ItemModel("Zomato", "Food", "4.4★"),
            ItemModel("Swiggy", "Food", "4.3★")
        )


        val adapter = MainAdapter(itemList)
        recyclerView.adapter = adapter
    }
}

class MainAdapter(private val itemList: List<ItemModel>) :
    RecyclerView.Adapter<MainAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val details: TextView = itemView.findViewById(R.id.tvDetails)
        val ratings: TextView = itemView.findViewById(R.id.tvRatings)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.appgist, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.title.text = currentItem.title
        holder.details.text = currentItem.details
        holder.ratings.text = currentItem.ratings
    }

    override fun getItemCount(): Int = itemList.size
}

data class ItemModel(
    val title: String,
    val details: String,
    val ratings: String
)

