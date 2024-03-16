package viacheslav.chugunov.pagedeffect.internal

import androidx.annotation.IntRange
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember

@Composable
internal fun BasePagedEffect(
    state: ScrollableState,
    @IntRange(from = 1) totalItems: Int,
    @IntRange(from = 0) requestOffset: Int,
    requestNewItems: suspend () -> Unit
) {
    val isPagedState = remember {
        derivedStateOf {
            val lastVisibleIndex = state.lastVisibleIndex
            val totalCurrentItems = state.totalItems
            val lastIndex = totalCurrentItems - 1
            totalCurrentItems > 0 && lastVisibleIndex < lastIndex - requestOffset && totalCurrentItems < totalItems
        }
    }
    val isPaged = isPagedState.value
    LaunchedEffect(isPaged) {
        if (isPaged) {
            requestNewItems()
        }
    }
}

@Composable
internal fun BasePagedEffect(
    state: ScrollableState,
    @IntRange(from = 1) totalItems: Int,
    @IntRange(from = 1) visibleItems: Int,
    @IntRange(from = 1) step: Int,
    @IntRange(from = 0) requestOffset: Int,
    onVisibleItemsChanged: suspend (Int) -> Unit
) {
    BasePagedEffect(
        state = state,
        totalItems = totalItems,
        requestOffset = requestOffset,
        requestNewItems = {
            if (visibleItems < totalItems) {
                if (visibleItems + step <= totalItems) {
                    onVisibleItemsChanged(visibleItems + step)
                } else {
                    onVisibleItemsChanged(totalItems)
                }
            }
        }
    )
}