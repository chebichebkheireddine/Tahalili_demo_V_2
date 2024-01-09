import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.example.tahalili_demo_v_2.DataItem


import com.example.tahalili_demo_v_2.R

class ItemAdapter(private val itemList: List<DataItem>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]

        holder.lastName.text = item.name_lab
        holder.phone.text = item.tlp_lab
        holder.emaile.text = item.email_lab

    }
    override fun getItemCount(): Int {
        return itemList.size
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lastName: TextView
        val phone: TextView
        val emaile: TextView
        init {
            lastName = itemView.findViewById(R.id.labNameTextView)
            phone= itemView.findViewById(R.id.phoneTextView)
            emaile= itemView.findViewById(R.id.availabilityTextView)

        }
    }
}
