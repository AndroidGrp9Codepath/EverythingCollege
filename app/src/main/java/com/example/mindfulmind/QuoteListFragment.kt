package com.example.mindfulmind

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

private const val API_KEY = BuildConfig.API_KEY
private const val ARTICLE_SEARCH_URL =
    "https://healthruwords.p.rapidapi.com/v1/quotes/?t=Wisdom&maxR=1&size=medium&id=731"
private const val TAG = "QuotesListFragment"
class QuoteListFragment : Fragment() {

    // Add these properties
    private val quotes = mutableListOf<DisplayJournals>()
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
        val layoutManager = LinearLayoutManager(context)
        quotesRecyclerView = view.findViewById(R.id.quotes_recycler_view)
        quotesRecyclerView.layoutManager = layoutManager
        quotesRecyclerView.setHasFixedSize(true)
        quoteAdapter = QuoteAdapter(view.context, quotes)
        quotesRecyclerView.adapter = quoteAdapter

        // Update the return statement to return the inflated view from above
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchFoods()
    }
    private fun fetchFoods() {
        lifecycleScope.launch {


            (activity?.application as JournalApplication).db.journalDao().getAll().collect{ databaseList ->
                databaseList.map {entity ->
                    DisplayJournals(

                        entity.journalEntry,
                    )
                }.also { mappedList ->
//                    foods.clear()
                    quotes.addAll(mappedList)
                    quoteAdapter.notifyDataSetChanged()
                }
            }

        }
    }

    companion object {
        fun newInstance(): QuoteListFragment {
            return QuoteListFragment()
        }
    }
}