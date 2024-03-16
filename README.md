# PagedEffect

## Description

An android library that helps implement pagination in Compose for LazyList, LazyGrid and LazyStaggeredGrid.

<p align="center">
  <img src="https://github.com/viacheslav-chugunov/PagedEffect/blob/main/assets/paging_example.gif" height=500 />
</p>

## Setup

Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency:

```gradle
dependencies {
    implementation("com.github.viacheslav-chugunov:PagedEffect:1.0")
}
```

## Usage

|Argument|Description|
| --- | --- |
|`state`|State of LazyList, LazyGrid or LazyStaggeredGrid.|
|`totalItems`|Maximum number of elements in LazyList, LazyGrid or LazyStaggeredGrid. The value must be 1 or greater.|
|`requestOffset`|Offset of elements from the end after which the pagination request begins. The value must be 0 or greater|
|`requestNewItems`|A function called when the list has been scrolled to the end and new list elements need to be requested in order to display them.|

```kotlin
@Composable
fun PagedEffect(
    state: LazyListState,
    totalItems: Int,
    requestOffset: Int,
    requestNewItems: suspend () -> Unit
)

@Composable
fun PagedEffect(
    state: LazyGridState,
    totalItems: Int,
    requestOffset: Int,
    requestNewItems: suspend () -> Unit
)

@Composable
fun PagedEffect(
    state: LazyStaggeredGridState,
    totalItems: Int,
    requestOffset: Int,
    requestNewItems: suspend () -> Unit
)
```

|Argument|Description|
| --- | --- |
|`state`|State of LazyList, LazyGrid or LazyStaggeredGrid.|
|`totalItems`|Maximum number of elements in LazyList, LazyGrid or LazyStaggeredGrid. The value must be 1 or greater.|
|`visibleItems`|Number of items already displayed in LazyList. The value must be 1 or greater.|
|`step`|Number of items to request after pagination.|
|`requestOffset`|Offset of elements from the end after which the pagination request begins. The value must be 0 or greater.|
|`onVisibleItemsChanged`|A function called when the number of visible elements in the list needs to be updated.|


```kotlin
@Composable
fun PagedEffect(
    state: LazyListState,
    totalItems: Int,
    visibleItems: Int,
    step: Int,
    requestOffset: Int,
    onVisibleItemsChanged: suspend (Int) -> Unit
)

@Composable
fun PagedEffect(
    state: LazyGridState,
    totalItems: Int,
    visibleItems: Int,
    step: Int,
    requestOffset: Int,
    onVisibleItemsChanged: suspend (Int) -> Unit
)

@Composable
fun PagedEffect(
    state: LazyStaggeredGridState,
    totalItems: Int,
    visibleItems: Int,
    step: Int,
    requestOffset: Int,
    onVisibleItemsChanged: suspend (Int) -> Unit
)
```
