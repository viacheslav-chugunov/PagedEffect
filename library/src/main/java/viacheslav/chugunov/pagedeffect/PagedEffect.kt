package viacheslav.chugunov.pagedeffect

import androidx.annotation.IntRange
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState
import androidx.compose.runtime.Composable
import viacheslav.chugunov.pagedeffect.internal.BasePagedEffect

/**
 * An effect that implements pagination for LazyList.
 * @param state state of LazyList.
 * @param totalItems maximum number of elements in LazyList. The value must be 1 or greater.
 * @param requestOffset offset of elements from the end after which the pagination request begins.
 * The value must be 0 or greater.
 * @param requestNewItems A function called when the list has been scrolled to the end and new list
 * elements need to be requested in order to display them.
 * */
@Composable
fun PagedEffect(
    state: LazyListState,
    @IntRange(from = 1) totalItems: Int,
    @IntRange(from = 0) requestOffset: Int = 0,
    requestNewItems: suspend () -> Unit
) = BasePagedEffect(state, totalItems, requestOffset, requestNewItems)

/**
 * An effect that implements pagination for LazyGrid.
 * @param state state of LazyGrid.
 * @param totalItems maximum number of elements in LazyGrid. The value must be 1 or greater.
 * @param requestOffset offset of elements from the end after which the pagination request begins.
 * The value must be 0 or greater.
 * @param requestNewItems A function called when the list has been scrolled to the end and new list
 * elements need to be requested in order to display them.
 * */
@Composable
fun PagedEffect(
    state: LazyGridState,
    @IntRange(from = 1) totalItems: Int,
    @IntRange(from = 0) requestOffset: Int = 0,
    requestNewItems: suspend () -> Unit
) = BasePagedEffect(state, totalItems, requestOffset, requestNewItems)

/**
 * An effect that implements pagination for LazyStaggeredGrid.
 * @param state state of LazyStaggeredGrid.
 * @param totalItems maximum number of elements in LazyStaggeredGrid. The value must be 1 or greater.
 * @param requestOffset offset of elements from the end after which the pagination request begins.
 * @param requestNewItems A function called when the list has been scrolled to the end and new list
 * elements need to be requested in order to display them.
 * */
@Composable
fun PagedEffect(
    state: LazyStaggeredGridState,
    @IntRange(from = 1) totalItems: Int,
    @IntRange(from = 0) requestOffset: Int = 0,
    requestNewItems: suspend () -> Unit
) = BasePagedEffect(state, totalItems, requestOffset, requestNewItems)

/**
 * An effect that implements pagination for LazyList.
 * @param state state of LazyList.
 * @param totalItems maximum number of elements in LazyList. The value must be 1 or greater.
 * @param visibleItems number of items already displayed in LazyList. The value must be 1 or greater.
 * @param step number of items to request after pagination.
 * @param requestOffset offset of elements from the end after which the pagination request begins.
 * The value must be 0 or greater.
 * @param onVisibleItemsChanged function called when the number of visible elements in the list
 * needs to be updated
 * */
@Composable
fun PagedEffect(
    state: LazyListState,
    @IntRange(from = 1) totalItems: Int,
    @IntRange(from = 1) visibleItems: Int,
    @IntRange(from = 1) step: Int,
    @IntRange(from = 0) requestOffset: Int = 0,
    onVisibleItemsChanged: suspend (Int) -> Unit
) = BasePagedEffect(state, totalItems, visibleItems, step, requestOffset, onVisibleItemsChanged)

/**
 * An effect that implements pagination for LazyGrid.
 * @param state state of LazyGrid.
 * @param totalItems maximum number of elements in LazyGrid. The value must be 1 or greater.
 * @param visibleItems number of items already displayed in LazyList. The value must be 1 or greater.
 * @param step number of items to request after pagination.
 * @param requestOffset offset of elements from the end after which the pagination request begins.
 * The value must be 0 or greater.
 * @param onVisibleItemsChanged function called when the number of visible elements in the list
 * needs to be updated
 * */
@Composable
fun PagedEffect(
    state: LazyGridState,
    @IntRange(from = 1) totalItems: Int,
    @IntRange(from = 1) visibleItems: Int,
    @IntRange(from = 1) step: Int,
    @IntRange(from = 0) requestOffset: Int = 0,
    onVisibleItemsChanged: suspend (Int) -> Unit
) = BasePagedEffect(state, totalItems, visibleItems, step, requestOffset, onVisibleItemsChanged)

/**
 * An effect that implements pagination for LazyStaggeredGrid.
 * @param state state of LazyStaggeredGrid.
 * @param totalItems maximum number of elements in LazyStaggeredGrid. The value must be 1 or greater.
 * @param visibleItems number of items already displayed in LazyList. The value must be 1 or greater.
 * @param step number of items to request after pagination.
 * @param requestOffset offset of elements from the end after which the pagination request begins.
 * The value must be 0 or greater.
 * @param onVisibleItemsChanged function called when the number of visible elements in the list
 * needs to be updated
 * */
@Composable
fun PagedEffect(
    state: LazyStaggeredGridState,
    @IntRange(from = 1) totalItems: Int,
    @IntRange(from = 1) visibleItems: Int,
    @IntRange(from = 1) step: Int,
    @IntRange(from = 0) requestOffset: Int = 0,
    onVisibleItemsChanged: suspend (Int) -> Unit
) = BasePagedEffect(state, totalItems, visibleItems, step, requestOffset, onVisibleItemsChanged)