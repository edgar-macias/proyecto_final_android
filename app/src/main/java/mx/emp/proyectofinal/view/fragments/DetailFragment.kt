package mx.emp.proyectofinal.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import mx.emp.proyectofinal.R
import mx.emp.proyectofinal.databinding.FragmentDetailBinding
import mx.emp.proyectofinal.model.entities.Animal
import kotlin.random.Random

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding
    private var animal:Animal? = null
    private val args:DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val androidColors = resources.getIntArray(R.array.androidcolors)
        view.setBackgroundColor(androidColors[Random.nextInt(androidColors.size)])
        binding = FragmentDetailBinding.bind(view)
        animal = args.animal

        binding.tvAnimalName.text = animal?.name
        Glide.with(view)
            .load(animal?.uriImage)
            .placeholder(R.drawable.ic_img_placeholder)
            .apply(RequestOptions().override(600,600))
            .into(binding.imgAnimal)
        binding.tvAnimalDescription.text = animal?.description
        binding.tvAnimalWeight.text = binding.root.resources.getString(R.string.peso,animal?.peso.toString())
        val id = when(animal?.gender){
            'M'->R.id.rbM
            'F'->R.id.rbF
            else->R.id.rbS
        }
        binding.rgAnimalGender.check(id)
        binding.rbF.isEnabled=false
        binding.rbM.isEnabled=false
        binding.rbS.isEnabled=false

    }
}