package com.arsal.drool.rule.engine.dto

data class Patient(
        val id: String,
        val name: String,
        val age: Int,
        val gender: String,
        val symptoms: List<String>,
        val diagnoses: List<Diagnosis>
)
