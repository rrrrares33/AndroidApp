package com.example.myapplication.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.car.model.Car
import com.example.myapplication.car.model.CarData
import com.example.myapplication.car.model.CarRowItem

fun filterCarsBySearch(carList: List<Car>, searchText: String): MutableList<Car> {
    val returnList: MutableList<Car> = mutableListOf()
    for (car in carList){
        val textToSearch = car.manufacture + ' ' + car.model
        if (textToSearch.contains(searchText, ignoreCase = true)) {
            returnList.add(car)
        }
    }
    return returnList
}

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun CarsList() {
    val selectedCarIndex = 0;
    val cars = remember {
        CarData.carList
    }
    var text by remember {
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .padding(bottom = 50.dp)
    ) {
        OutlinedTextField(
            value = text,
            label = { Text(text = "Search") },
            onValueChange = {
                text = it
            }
        )

        LazyColumn(
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 10.dp,
                bottom = 50.dp
            )
        ) {
            items(filterCarsBySearch(cars, text)) { item ->
                CarRowItem(item)
            }
        }
    }
}
