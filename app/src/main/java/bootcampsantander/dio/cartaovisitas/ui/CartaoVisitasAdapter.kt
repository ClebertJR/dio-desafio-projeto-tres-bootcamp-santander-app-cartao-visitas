package bootcampsantander.dio.cartaovisitas.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import bootcampsantander.dio.cartaovisitas.data.CartaoVisitas
import bootcampsantander.dio.cartaovisitas.databinding.ItemCartaoVisitasBinding

class CartaoVisitasAdapter :
    ListAdapter<CartaoVisitas, CartaoVisitasAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCartaoVisitasBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemCartaoVisitasBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CartaoVisitas) {
            binding.tvNome.text = item.nome
            binding.tvTelefone.text = item.telefone
            binding.tvEmail.text = item.email
            binding.tvNomeEmpresa.text = item.empresa
            binding.cdContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.cdContent.setOnClickListener {
                listenerShare(it)
            }
        }
    }

}

class DiffCallback : DiffUtil.ItemCallback<CartaoVisitas>() {
    override fun areItemsTheSame(oldItem: CartaoVisitas, newItem: CartaoVisitas) = oldItem == newItem
    override fun areContentsTheSame(oldItem: CartaoVisitas, newItem: CartaoVisitas) =
        oldItem.id == newItem.id
}