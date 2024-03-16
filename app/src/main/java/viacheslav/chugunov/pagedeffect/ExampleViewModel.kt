package viacheslav.chugunov.pagedeffect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ExampleViewModel : ViewModel() {
    val allItems: List<Int> = List(105) { it + 1 }
    val pagingStep: Int = 30
    val isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val visibleItems: MutableStateFlow<List<Int>> = MutableStateFlow(allItems.subList(0, pagingStep))

    fun requestPaging(newVisibleItemsCount: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            if (isLoading.value) return@launch
            isLoading.value = true
            delay(1500)
            visibleItems.value = allItems.subList(0, newVisibleItemsCount)
            isLoading.value = false
        }
    }
}