package bootcampsantander.dio.cartaovisitas.ui

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import bootcampsantander.dio.cartaovisitas.App
import bootcampsantander.dio.cartaovisitas.databinding.ActivityMainBinding
import bootcampsantander.dio.cartaovisitas.ui.CartaoVisitasAdapter
import bootcampsantander.dio.cartaovisitas.ui.MainViewModel
import bootcampsantander.dio.cartaovisitas.ui.MainViewModelFactory
import bootcampsantander.dio.cartaovisitas.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { CartaoVisitasAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpPermissions()
        binding.rvCards.adapter = adapter
        getAllCartaoVisitas()
        insertListeners()
    }

    private fun setUpPermissions() {
        // write permission to access the storage
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            1
        )
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            1
        )
    }

    private fun insertListeners() {
        binding.fab.setOnClickListener {
            val intent = Intent(this, AddCartaoVisitasActivity::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = { card ->
            Image.share(this@MainActivity, card)
        }
    }

    private fun getAllCartaoVisitas() {
        mainViewModel.getAll().observe(this) { cartaoVisitas ->
            adapter.submitList(cartaoVisitas)
        }
    }


}