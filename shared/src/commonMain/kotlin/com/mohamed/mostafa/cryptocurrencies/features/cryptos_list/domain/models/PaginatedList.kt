package com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.models

import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.ApiService.Constants.PAGINATION_PER_PAGE_COUNT


//This is not working yet
data class PaginatedList<T>(
    val currentList: ArrayList<T> = arrayListOf(),
    var page: Int = 1,
    val perPage: Int = PAGINATION_PER_PAGE_COUNT,
    val getNextPage: (() -> Unit)? = null,
    var scrollPosition: Int = 0,
    var hasReachedMax: Boolean = false,
    var isLoadingMore: Boolean = false,
    val isEmpty: Boolean = false,
) {

    fun appendList(newList: List<T>): PaginatedList<T> {
        currentList.addAll(newList)
        if (newList.size < perPage) {
            hasReachedMax = true
        }
        return copy(currentList = currentList)
    }

    //Note:if page is starting from 0 then we should increase 1, if not then it's just page
    fun onScrollPositionChanged(position: Int) {
        scrollPosition = position
        if (!hasReachedMax) {
            if (scrollPosition + 1 >= (perPage * page)) {
                goToNextPage()
            }
        }
    }

    fun setIsLoadingMore(loading: Boolean) = copy(isLoadingMore = loading)


    fun updatePage() = copy(page = page.plus(1))

    private fun goToNextPage() {
        if (!isLoadingMore) {
            page = page.plus(1)
            getNextPage?.invoke()
        }
    }

    fun shouldLoadMore(index: Int): Boolean {
        return ((index + 1) >= (page * PAGINATION_PER_PAGE_COUNT) && !isLoadingMore)
    }

}
