package com.akhutornoy.bootstrap.presentation.ui.main.petlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akhutornoy.bootstrap.R
import com.akhutornoy.bootstrap.presentation.ui.extension.autoNotify
import com.akhutornoy.bootstrap.presentation.ui.main.model.PetModel
import kotlinx.android.synthetic.main.item_pet.view.*
import kotlin.properties.Delegates

class PetListAdapter(
    private val callback: OnPetClickListener
) : RecyclerView.Adapter<PetListAdapter.PetViewHolder>() {

    var items: List<PetModel> by Delegates.observable(emptyList()) { prop, oldList, newList ->
        autoNotify(oldList, newList) { o, n -> o.name == n.name }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pet, parent, false)
        return PetViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        holder.setData(items[position])
    }

    inner class PetViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun setData(pet: PetModel) {
            itemView.setOnClickListener { callback.onPetClicked(pet) }
            itemView.tv_name.text = pet.name
            itemView.tv_breed.text = pet.breed
        }

    }

    interface OnPetClickListener {
        fun onPetClicked(pet: PetModel)
    }

}