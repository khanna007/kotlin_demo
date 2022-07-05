package com.example.kotlin_demo.presentation.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_demo.R
import com.example.kotlin_demo.data.CountryModel
import kotlinx.android.synthetic.main.card_view.view.*


class UserViewAdapter(private val country: ArrayList<CountryModel>,
                      private val itemClick : (countryModel : CountryModel)->Unit) :
    RecyclerView.Adapter<UserViewAdapter.UserViewHolder>() {

    fun updateUserList(newUser:List<CountryModel>){
        country.clear()
        country.addAll(newUser)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)
        return  UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.countryName.text = (country[position].countryName)
        holder.countryCapital.text = (country[position].capital)
    }

    override fun getItemCount(): Int {
        return country.size
    }

   inner class UserViewHolder( itemView : View) : RecyclerView.ViewHolder(itemView){
        private val imageView = itemView.imageView
         val countryName: TextView = itemView.findViewById(R.id.name)
         val countryCapital: TextView = itemView.findViewById(R.id.capital)
        init {
            itemView.setOnClickListener {
                itemClick(country[adapterPosition])
            }
        }
    }
}