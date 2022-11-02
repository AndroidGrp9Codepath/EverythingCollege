package com.example.mindfulmind


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch



class JournalFragment : Fragment() {

    private val journals = mutableListOf<DisplayJournals>()
    private lateinit var journalRecyclerView: RecyclerView
    private lateinit var journalAdapter: JournalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_journal, container, false)

        val layoutManager = GridLayoutManager(context,2)
        journalRecyclerView = view.findViewById(R.id.journal_recycler_view)
        journalRecyclerView.layoutManager = layoutManager
        journalRecyclerView.setHasFixedSize(true)
        journalAdapter = JournalAdapter(view.context,journals)
        journalRecyclerView.adapter = journalAdapter
//        val context = view.context
//        journalRecyclerView.layoutManager = GridLayoutManager(context, 2)


        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Call the new method within onViewCreated
        fetchJournals()

    }

    private fun fetchJournals() {
        lifecycleScope.launch {


            (activity?.application as JournalApplication).db.journalDao().getAll().collect{ databaseList ->
                databaseList.map {entity ->
                    DisplayJournals(

                        entity.journalEntry,
                    )
                }.also { mappedList ->

                    journals.addAll(mappedList)
                    journalAdapter.notifyDataSetChanged()
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