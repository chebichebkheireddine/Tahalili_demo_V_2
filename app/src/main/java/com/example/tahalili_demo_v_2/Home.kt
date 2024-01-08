import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.tahalili_demo_v_2.R


class Home : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recycl_id)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Replace `itemList` with your actual data source
        val itemList = listOf("Item 1", "Item 2", "Item 3") // Example list of items

        val adapter = ItemAdapter(itemList)
        recyclerView.adapter = adapter

        return view
    }
}
