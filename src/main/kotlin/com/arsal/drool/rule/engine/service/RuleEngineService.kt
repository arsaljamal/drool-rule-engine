package com.arsal.drool.rule.engine.service

import org.kie.api.runtime.KieSession
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RuleEngineService {

    @Autowired
    lateinit var kieSession: KieSession

    fun executeRules(data: Any) {
        kieSession.insert(data)
        kieSession.fireAllRules()
    }

    companion object {
        @JvmStatic
        fun printResult(data: Any) {
            println("Patient Diagnosis: $data")
        }
    }
}