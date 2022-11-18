package com.example.mindfulmind

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SeekHelpFragment : Fragment() {
    private val base_url = "https://api.yelp.com/v3/"
    private val YELP_API_KEY = "x8pc_hyzzRcQxNP1qKaRAczx-CjqUBGMvaPj3aZgNis0aOJosehOiO8c-nxf34YZQuHXAGc__ZchkwIqP3vaAN9yZiAkfE4DH03pEKW5q2g5ovRQc1voZOxfWLp3Y3Yx"
    private lateinit var SeekHelpRecyclerView: RecyclerView
    val listOfTherapists = mutableListOf<Therapist>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val view = inflater.inflate(R.layout.fragment_seek_help, container, false)
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val YelpService :YelpAPIEndpointInterface = retrofit.create(YelpAPIEndpointInterface::class.java)
        // Lookup the recyclerview in activity layout
        val SeekHelpRecyclerView = view.findViewById<View>(R.id.help_rv) as RecyclerView
        // Initialize contacts
        val adapter = SeekHelpAdapter(listOfTherapists, this@SeekHelpFragment)
        // Attach the adapter to the recyclerview to populate items
        SeekHelpRecyclerView.adapter = adapter
        // Set layout manager to position the items
        SeekHelpRecyclerView.layoutManager =  GridLayoutManager(context,1)
        YelpService.findTherapists("Bearer $YELP_API_KEY","Therapy", "NYC").enqueue(
            object: Callback<HelpItemDataModel>{
                override fun onResponse(call: Call<HelpItemDataModel>, response: Response<HelpItemDataModel>) {
                    Log.i("therapist", "response $response")
                    val body = response.body()
                    listOfTherapists.addAll(body!!.therapists)
                    adapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<HelpItemDataModel>, t: Throwable) {
                    Log.i("therapistError", "error $t")
                }
            }
        )
        return view


    }

    companion object {
        fun newInstance(): SeekHelpFragment {
            return SeekHelpFragment()
        }
    }
}