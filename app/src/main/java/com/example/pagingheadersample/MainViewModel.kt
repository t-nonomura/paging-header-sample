package com.example.pagingheadersample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class MainViewModel(repository: Repository) : ViewModel() {

    class Factory(private val repository: Repository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }
    }

    val pagedList = LivePagedListBuilder(
        MainModelDataSource.Factory(repository),
        PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(10)
            .build()
    ).build()
}