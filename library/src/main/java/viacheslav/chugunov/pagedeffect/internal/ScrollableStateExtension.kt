package viacheslav.chugunov.pagedeffect.internal

import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState

internal val ScrollableState.lastVisibleIndex: Int
    get() = when (this) {
        is LazyListState -> layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: -1
        is LazyGridState -> layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: -1
        is LazyStaggeredGridState -> layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: -1
        else -> throw IllegalStateException("unexpected scrollable state")
    }

internal val ScrollableState.totalItems: Int
    get() = when (this) {
        is LazyListState -> layoutInfo.totalItemsCount
        is LazyGridState -> layoutInfo.totalItemsCount
        is LazyStaggeredGridState -> layoutInfo.totalItemsCount
        else -> throw IllegalStateException("unexpected scrollable state")
    }
