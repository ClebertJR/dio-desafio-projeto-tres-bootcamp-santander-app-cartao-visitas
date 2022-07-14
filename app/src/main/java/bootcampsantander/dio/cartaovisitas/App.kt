package bootcampsantander.dio.cartaovisitas

import android.app.Application
import bootcampsantander.dio.cartaovisitas.data.AppDatabase
import bootcampsantander.dio.cartaovisitas.data.CartaoVisitasRepository

class App: Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { CartaoVisitasRepository(database.visitasDao()) }
}