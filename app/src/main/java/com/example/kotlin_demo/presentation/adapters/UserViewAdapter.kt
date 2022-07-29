package com.example.kotlin_demo.presentation.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
 import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_demo.R
import com.example.kotlin_demo.domain.model.Country
import kotlinx.android.synthetic.main.card_view.view.*


class UserViewAdapter(private val country: ArrayList<Country>,
                      private val itemClick : (Country : Country)->Unit) :
    RecyclerView.Adapter<UserViewAdapter.UserViewHolder>() {

    fun updateUserList(newUser:List<Country>){
        country.clear()
        country.addAll(newUser)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.card_view,
            parent,
            false)
        return  UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) = holder.bind(country[position])

    override fun getItemCount(): Int {
        return country.size
    }

   inner class UserViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind (item:Country){
            with(itemView){
                name.text=item.countryName
                capital.text=item.countryCapital

            }
        }
        init {
            itemView.setOnClickListener {
                itemClick(country[adapterPosition])
            }
        }
    }
}