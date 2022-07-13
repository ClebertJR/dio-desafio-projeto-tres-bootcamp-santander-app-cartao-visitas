package bootcampsantander.dio.cartaovisitas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import bootcampsantander.dio.cartaovisitas.databinding.ActivityAddCartaoVisitasBinding
import bootcampsantander.dio.cartaovisitas.databinding.ActivityMainBinding

class AddCartaoVisitasActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddCartaoVisitasBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {

        binding.btnClose.setOnClickListener {
            finish()
        }
        binding.btnConfirm.setOnClickListener {
            //TODO
        }

    }
}