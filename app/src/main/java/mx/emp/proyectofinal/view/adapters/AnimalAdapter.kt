package mx.emp.proyectofinal.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import mx.emp.proyectofinal.R
import mx.emp.proyectofinal.databinding.AnimalItemBinding
import mx.emp.proyectofinal.model.entities.Animal
import kotlin.random.Random

class AnimalAdapter(private val items: ArrayList<Animal>):RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    var onItemClick:((Animal)->Unit)?=null

    class AnimalViewHolder(private val viewBinding: AnimalItemBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(animal:Animal,onItemClick:((Animal)->Unit)?){
            val androidColors = viewBinding.root.resources.getIntArray(R.array.androidcolors)
            viewBinding.animalCard.setCardBackgroundColor(androidColors[Random.nextInt(androidColors.size)])
            viewBinding.tvAnimalName.text = animal.name
            Glide.with(itemView)
                .load(animal.uriImage)
                .placeholder(R.drawable.ic_img_placeholder)
                .into(viewBinding.imgAnimal)
            viewBinding.tvAnimalDescription.text = animal.description

            viewBinding.animalCard.setOnClickListener {
                onItemClick?.invoke(animal)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val binding = AnimalItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(items[position],onItemClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(newitems: ArrayList<Animal>){
        items.clear()
        items.addAll(newitems)
        notifyDataSetChanged()
    }

}