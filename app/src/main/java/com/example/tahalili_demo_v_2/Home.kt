import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tahalili_demo_v_2.ApiService
import com.example.tahalili_demo_v_2.DataItem
import com.example.tahalili_demo_v_2.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Home : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val itemList: MutableList<DataItem> = mutableListOf()
    private lateinit var itemAdapter: ItemAdapter

    private lateinit var context: FragmentActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        context = requireActivity()
        init()
        return binding.root
    }

    private fun init() {
        val apiService = initializeRetrofit()
        itemAdapter = ItemAdapter(itemList)
        binding.recyclId.adapter = itemAdapter
        binding.recyclId.layoutManager = LinearLayoutManager(context)

        apiService.getData().enqueue(object : Callback<List<DataItem>> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<List<DataItem>>, response: Response<List<DataItem>>) {
                if(response.isSuccessful){
                    for (data in response.body()!!){
                        itemList.add(data)
                    }

                    binding.recyclId.adapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<DataItem>>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun initializeRetrofit(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.209.58:8000/api/V1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }

}
