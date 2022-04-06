package com.example.myapplication.car.model

data class Car (
    val id: Int,
    val manufacture: String,
    val model: String,
    val km: Int,
    val manufactureYear: Int,
    val numberOfOwner: Int,
    val price: Double = 0.0
)