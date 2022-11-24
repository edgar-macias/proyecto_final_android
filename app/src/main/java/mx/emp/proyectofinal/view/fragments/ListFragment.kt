package mx.emp.proyectofinal.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.emp.proyectofinal.R
import mx.emp.proyectofinal.databinding.FragmentListBinding
import mx.emp.proyectofinal.view.adapters.AnimalAdapter
import mx.emp.proyectofinal.viewmodels.AnimalListViewModel

class ListFragment : Fragment(R.layout.fragment_list) {

    private val animalViewModel : AnimalListViewModel by viewModels()

    private lateinit var binding : FragmentListBinding
    private lateinit var adapter: AnimalAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentListBinding.bind(view)
        binding.refresh.setOnRefreshListener {
            animalViewModel.getAnimalList()
            binding.refresh.isRefreshing = false
        }

        adapter = AnimalAdapter(arrayListOf())
        adapter.onItemClick = {
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(it)
            findNavController().navigate(action)
        }

        binding.animalList.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
        binding.animalList.adapter = adapter

        animalViewModel.list.observe(viewLifecycleOwner) {
            adapter.updateItems(it)
        }

        animalViewModel.loader.observe(viewLifecycleOwner) {
            binding.loader.visibility = if (it) View.VISIBLE else View.GONE
        }
    }
}