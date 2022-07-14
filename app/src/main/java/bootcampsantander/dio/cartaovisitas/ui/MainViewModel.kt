package bootcampsantander.dio.cartaovisitas.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import bootcampsantander.dio.cartaovisitas.data.CartaoVisitas
import bootcampsantander.dio.cartaovisitas.data.CartaoVisitasRepository


class MainViewModel(private val cartaoVisitasRepository: CartaoVisitasRepository): ViewModel() {

    fun insert(cartaoVisitas: CartaoVisitas) {
        cartaoVisitasRepository.insert(cartaoVisitas)
    }

    fun getAll(): LiveData<List<CartaoVisitas>> {
        return cartaoVisitasRepository.getAll()
    }

}

class MainViewModelFactory(private val repository: CartaoVisitasRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}