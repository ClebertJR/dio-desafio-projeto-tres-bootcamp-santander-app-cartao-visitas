package bootcampsantander.dio.cartaovisitas.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CartaoVisitasRepository(private val dao: CartaoVisitasDao) {

    fun insert(cartaoVisitas: CartaoVisitas) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(cartaoVisitas)
        }
    }

    fun getAll() = dao.getAll()

}