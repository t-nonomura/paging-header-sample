package com.example.pagingheadersample

import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource


class MainModelDataSource(private val repository: Repository) : PageKeyedDataSource<Int, Item>() {

    private lateinit var layout: List<Item>
    private var totalPage = 0
    private var totalItemCount = 0

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Item>
    ) {
        layout = repository.getMain()
        totalPage = layout.size
        load(page = 0, loadInitialCallback = callback)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        load(page = params.key, loadCallback = callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun load(
        page: Int,
        loadInitialCallback: LoadInitialCallback<Int, Item>? = null,
        loadCallback: LoadCallback<Int, Item>? = null
    ) {
        val nextPage = page + 1
        if (page > totalPage - 1) {
            loadCallback?.onResult(emptyList(), null)
            loadInitialCallback?.onResult(emptyList(), 0, 0, null, null)
        } else {
            val data = when (val item = layout[page]) {
                is Header -> loadHeader(item.id, item.shopName)
                is Body -> loadBody(item.id, item.makerName, item.commodityName)
                else -> listOf(Body(0, "", ""))
            }

            totalItemCount += 1
            loadInitialCallback?.onResult(data, 0, totalItemCount, null, nextPage)
            loadCallback?.onResult(data, nextPage)
        }
    }

    private fun loadHeader(id: Int, shop: String): List<Item> {
        return repository.getHeader(id, shop).let {
            listOf(
                Header(it.id, it.shopName)
            )
        }
    }

    private fun loadBody(id: Int, maker: String, commodity: String): List<Item> {
        return repository.getBody(id, maker, commodity).let {
            listOf(
                Body(it.id, it.makerName, it.commodityName)
            )
        }
    }

    class Factory(private val repository: Repository) : DataSource.Factory<Int, Item>() {
        override fun create(): DataSource<Int, Item> {
            return MainModelDataSource(repository)
        }
    }
}