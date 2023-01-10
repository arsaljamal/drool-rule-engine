package com.arsal.drool.rule.engine

import com.arsal.drool.rule.engine.dto.Patient
import com.arsal.drool.rule.engine.service.RuleEngineService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EngineApplication : ApplicationRunner {

	@Autowired
	lateinit var myService: RuleEngineService

	override fun run(args: ApplicationArguments?) {
		val patient = Patient(
				id = "12345",
				name = "John Doe",
				age = 35,
				gender = "Male",
				symptoms = listOf("cough", "fever", "shortness of breath"),
				diagnoses = emptyList()
				)

		myService.executeRules(patient)
	}
}

fun main(args: Array<String>) {
	runApplication<EngineApplication>(*args)
}