package com.example.mindfulmind

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import kotlinx.coroutines.launch
import okhttp3.Headers
import org.json.JSONObject

private const val API_KEY = BuildConfig.API_KEY
private const val ARTICLE_SEARCH_URL =
    "https://type.fit/api/quotes"
private const val TAG = "QuotesListFragment"
class QuoteListFragment : Fragment() {

    // Add these properties
    private val quotes = mutableListOf<DisplayJournals>()
    private lateinit var quotesRecyclerView: RecyclerView
    private lateinit var quoteAdapter: JournalAdapter

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
        quotesRecyclerView.layoutManager = GridLayoutManager(context,2)

//        quotesRecyclerView.layoutManager = layoutManager
//        quotesRecyclerView.setHasFixedSize(true)
//        quoteAdapter = JournalAdapter(view.context, quotes)
//        quotesRecyclerView.adapter = quoteAdapter

        // Update the return statement to return the inflated view from above
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        fetchJournals()
    }
    private fun fetchJournals() {
//        val client =AsyncHttpClient()
//        client.get(ARTICLE_SEARCH_URL, object : JsonHttpResponseHandler(){
//            override fun onSucess(
//                statusCode: Int,
//                headers: Headers?,
//                json: JsonHttpResponseHandler.JSON
//            ) {
//                val resultJson: JSONObject = json.jsonObject.get()
//            }
//        })
//        lifecycleScope.launch {
//
//
//            (activity?.application as JournalApplication).db.journalDao().getAll().collect{ databaseList ->
//                databaseList.map {entity ->
//                    DisplayJournals(
//
//                        entity.journalEntry,
//                    )
//                }.also { mappedList ->
////                    foods.clear()
//                    quotes.addAll(mappedList)
//                    quoteAdapter.notifyDataSetChanged()
//                }
//            }
//
//        }
    }

    companion object {
        fun newInstance(): QuoteListFragment {
            return QuoteListFragment()
        }
    }
}