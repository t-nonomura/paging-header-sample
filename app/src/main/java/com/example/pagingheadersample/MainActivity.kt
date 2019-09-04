package com.example.pagingheadersample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodmap.library.kmrecyclerviewstickyheader.KmHeaderItemDecoration
import com.kodmap.library.kmrecyclerviewstickyheader.KmStickyListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAdapter()
        initViewModel()
    }

    private fun initAdapter() {
        adapter = MainAdapter()
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
        recycler_view.addItemDecoration(object : KmHeaderItemDecoration(object : KmStickyListener {
            override fun isHeader(itemPosition: Int?): Boolean {
                return adapter.getItemViewType(itemPosition ?: -1) == 1
            }

            override fun getHeaderLayout(headerPosition: Int?): Int {
                return R.layout.list_item_header
            }

            override fun getHeaderPositionForItem(itemPosition: Int?): Int {
                var counter = itemPosition ?: return -1
                while (!isHeader(counter)) {
                    counter--
                }
                return counter
            }

            override fun bindHeaderData(header: View?, headerPosition: Int?) {
                header ?: return
                headerPosition ?: return

                (header as HeaderLayout).setContent(adapter.getHeaderItem(headerPosition))
            }
        }) {})
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            MainViewModel.Factory(RepositoryImpl())
        ).get(MainViewModel::class.java)

        viewModel.pagedList.observe(this, Observer {
            adapter.submitList(it)
        })
    }
}
