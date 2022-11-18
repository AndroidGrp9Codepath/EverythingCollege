package com.example.mindfulmind

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SeekHelpFragment : Fragment() {
    private val base_url = "https://api.yelp.com/v3/"
    private val YELP_API_KEY = "x8pc_hyzzRcQxNP1qKaRAczx-CjqUBGMvaPj3aZgNis0aOJosehOiO8c-nxf34YZQuHXAGc__ZchkwIqP3vaAN9yZiAkfE4DH03pEKW5q2g5ovRQc1voZOxfWLp3Y3Yx"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val YelpService :YelpAPIEndpointInterface = retrofit.create(YelpAPIEndpointInterface::class.java)
        YelpService.findTherapists("Bearer $YELP_API_KEY","Therapy", "NYC").enqueue(
            object: Callback<Any>{
                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    Log.i("therapist", "response $response")
                }

                override fun onFailure(call: Call<Any>, t: Throwable) {
                    Log.i("therapistError", "error $t")
                }
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seek_help, container, false)
    }

    companion object {
        fun newInstance(): SeekHelpFragment {
            return SeekHelpFragment()
        }
    }
}