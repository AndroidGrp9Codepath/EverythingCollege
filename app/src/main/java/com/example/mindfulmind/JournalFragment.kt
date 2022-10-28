package com.example.mindfulmind

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.RoundingMode


class JournalFragment : Fragment() {

    private val quotes = mutableListOf<DisplayJournals>()
    private lateinit var journalRecyclerView: RecyclerView
    private lateinit var quoteAdapter: QuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.journal_item, container, false)
        val journalRecyclerView = view.findViewById<View>(R.id.journal_recycler_view) as RecyclerView
        val context = view.context
        journalRecyclerView.layoutManager = GridLayoutManager(context, 2)


        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Call the new method within onViewCreated
        fetchJournals(view)

    }

    private fun fetchJournals(view: View) {
        lifecycleScope.launch {


            (activity?.application as JournalApplication).db.journalDao().getAll().collect{ databaseList ->
                databaseList.map {entity ->
                    DisplayJournals(

                        entity.journalEntry,
                    )
                }.also { mappedList ->

                    quotes.addAll(mappedList)
                    quoteAdapter.notifyDataSetChanged()
                }
            }

        }
    }


    companion object {
        fun newInstance(): JournalFragment {
            return JournalFragment()
        }
    }
}