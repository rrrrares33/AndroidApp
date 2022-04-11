package com.example.myapplication.navigation

import com.example.myapplication.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("Home", R.drawable.ic_home, "Home")
    object List : NavigationItem("CarsList", R.drawable.ic_list, "Cars")
    object Video : NavigationItem("Video", R.drawable.ic_video, "Video")
    object Favorite : NavigationItem("Favorite", R.drawable.ic_favorite, "Favorite")
    object Animation : NavigationItem("Animation", R.drawable.ic_animation_icon, "Anim.")
}
