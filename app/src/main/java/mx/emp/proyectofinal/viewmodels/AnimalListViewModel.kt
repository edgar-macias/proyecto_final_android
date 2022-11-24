package mx.emp.proyectofinal.viewmodels

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.emp.proyectofinal.model.entities.Animal
import mx.emp.proyectofinal.model.repository.AnimalRepository

class AnimalListViewModel:ViewModel() {

    val list = MutableLiveData<ArrayList<Animal>>()
    val loader = MutableLiveData<Boolean>()

    init {
        getAnimalList()
    }

    fun getAnimalList(){
        Handler(Looper.getMainLooper()).postDelayed({
            val animals = AnimalRepository.getTestAnimals()
            list.postValue(animals)
            loader.postValue(false)
        },4000)
    }
}