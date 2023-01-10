package com.arsal.drool.rule.engine.dto

data class Diagnosis(
        val name: String,
        val probability: Double,
        val temperature: Temperature
)
