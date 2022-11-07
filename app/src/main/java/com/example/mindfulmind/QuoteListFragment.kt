package com.example.mindfulmind

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import okhttp3.Headers
import org.json.JSONException
import org.json.JSONObject

//private const val API_KEY = BuildConfig.API_KEY
private const val ARTICLE_SEARCH_URL =
    "https://type.fit/api/quotes"
private const val TAG = "QuotesListFragment"
class QuoteListFragment : Fragment() {

    // Add these properties
    private val quotes = mutableListOf<Quotes>()
    private lateinit var quotesRecyclerView: RecyclerView
    private lateinit var quoteAdapter: QuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Change this statement to store the view in a variable instead of a return statement
        val view = inflater.inflate(R.layout.fragment_quote_list, container, false)

        // Add these configurations for the recyclerView and to configure the adapter
//        val layoutManager = LinearLayoutManager(context)
        quotesRecyclerView = view.findViewById(R.id.quotes_recycler_view)
        val context = view.context
        quotesRecyclerView.layoutManager = GridLayoutManager(context,1)

//        quotesRecyclerView.layoutManager = layoutManager
//        quotesRecyclerView.setHasFixedSize(true)
//        quoteAdapter = JournalAdapter(view.context, quotes)
//        quotesRecyclerView.adapter = quoteAdapter
        updateAdapter(quotesRecyclerView)
        return view
    }
    private fun updateAdapter(recyclerView: RecyclerView) {
        val client = AsyncHttpClient()
        val params = RequestParams()
        client[
                "https://api.quotable.io/quotes", params, object :
                    JsonHttpResponseHandler(){
                    override fun onSuccess(
                        statusCode: Int,
                        headers: Headers,
                        json: JsonHttpResponseHandler.JSON
                    ){

                        val resultsJSON = json.jsonObject.get("results").toString()
                        val gson = Gson()
                        val arrayMovieType = object : TypeToken<List<Quotes>>() {}.type
                        val models : List<Quotes> = gson.fromJson(resultsJSON,arrayMovieType)
                        recyclerView.adapter = QuoteAdapter(models)
                        Log.d("MovieFragment", "response successful")
                        //print(models)
                    }
                    override fun onFailure(
                        statusCode: Int,
                        headers: Headers?,
                        errorResponse: String,
                        t: Throwable?
                    ) {
                        // The wait for a response is over
                        // If the error is not null, log it!
                        t?.message?.let {
                            Log.e("Failure", errorResponse)
                        }
                    }
                }]
    }

    companion object {
        fun newInstance(): QuoteListFragment {
            return QuoteListFragment()
        }
    }
}