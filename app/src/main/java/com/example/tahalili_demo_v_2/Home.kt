import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tahalili_demo_v_2.ApiService
import com.example.tahalili_demo_v_2.Data
import com.example.tahalili_demo_v_2.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home(private val apiService: ApiService) : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val itemList: MutableList<String> = mutableListOf()
    private lateinit var itemAdapter: ItemAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemAdapter = ItemAdapter(itemList)
        binding.recyclId.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        // Make API call and update the RecyclerView
        apiService.getData().enqueue(object : Callback<List<Data>> {
            override fun onResponse(
                call: Call<List<Data>>,
                response: Response<List<Data>>
            ) {
                if (response.isSuccessful) {
                    itemList.clear()
                    response.body()?.let { items ->
                        itemList.addAll(items.map { it.toString() }) // Map the whole object to string
                        itemAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
