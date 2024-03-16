package viacheslav.chugunov.pagedeffect

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory

@Composable
fun ExampleComposable() {
    val state = rememberLazyListState()
    val viewModel = viewModel(ExampleViewModel::class.java)
    val allItems = viewModel.allItems
    val step = viewModel.pagingStep
    val isLoading = viewModel.isLoading.collectAsState().value
    val visibleItems = viewModel.visibleItems.collectAsState().value

    PagedEffect(
        state = state,
        totalItems = allItems.size,
        visibleItems = visibleItems.size,
        step = step,
        requestOffset = 1,
        onVisibleItemsChanged = viewModel::requestPaging
    )

    LazyColumn(
        state = state
    ) {
        items(
            items = visibleItems,
            key = { it }
        ) { item ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Title $item",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W500
                    )
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Subtitle $item",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400
                    )
                )
            }
        }
        if (isLoading) {
            item {
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}