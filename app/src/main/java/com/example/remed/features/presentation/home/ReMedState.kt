package com.example.remed.features.presentation.home

import com.example.remed.features.domain.model.ReMed

data class ReMedState(
    val remeds: List<ReMed> = emptyList(),
    var currentRemed: ReMed? = null
)