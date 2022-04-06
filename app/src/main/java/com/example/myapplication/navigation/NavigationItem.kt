package com.example.myapplication.navigation

import com.example.myapplication.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object List : NavigationItem("carsList", R.drawable.ic_list, "Cars")
    object Favorite : NavigationItem("favorite", R.drawable.ic_favorite, "Favorite")
}
