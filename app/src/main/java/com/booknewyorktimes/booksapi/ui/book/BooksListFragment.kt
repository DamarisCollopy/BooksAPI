package com.booknewyorktimes.booksapi.ui.book

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booknewyorktimes.booksapi.R
import com.booknewyorktimes.booksapi.ui.details.DetailsBooksActivity
import kotlinx.android.synthetic.main.fragment_books_list.*


class BooksListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_books_list, container, false)

        // viewModel escutando por um livedata
        listennerLiveData(view)

        return view
    }

    private fun listennerLiveData(view: View) {
        // Criacao do viewModel
        val viewModel : BooksViewModel = ViewModelProviders.of(this).get(BooksViewModel ::class.java)
        viewModel.booksLiveData.observe(viewLifecycleOwner, Observer {
            //let substitui a chamada do if(...== null), ele ja faz a checagem
            it?.let { books ->
                with(recycler_main) {
                    layoutManager =
                        LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = BooksAdapter(books){book ->
                            val intent = DetailsBooksActivity.getStartIntent(view.getContext(), book.title, book.description)
                            view.getContext().startActivity(intent)
                    }
                }
            }
        })
        // Chamo o viewModel
        viewModel.getBookLiveData()
    }
}