package com.arsal.drool.rule.engine.config

import org.kie.api.KieServices
import org.kie.api.builder.KieFileSystem
import org.kie.api.runtime.KieContainer
import org.kie.api.runtime.KieSession
import org.kie.internal.io.ResourceFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import java.io.IOException

@Configuration
class DroolRuleEngineConfigs {

    private val kieServices = KieServices.Factory.get()

    @Throws(IOException::class)
    private fun getKieFileSystem(): KieFileSystem? {
        val kieFileSystem = kieServices.newKieFileSystem()
        kieFileSystem.write(ResourceFactory.newClassPathResource("rules.drl"))

        return kieFileSystem
    }

    @Throws(IOException::class)
    fun getKieContainer(): KieContainer? {
        getKieRepository()
        val kb = kieServices.newKieBuilder(getKieFileSystem())
        kb.buildAll()
        val kieModule = kb.kieModule
        return kieServices.newKieContainer(kieModule.releaseId)
    }

    private fun getKieRepository() {
        val kieRepository = kieServices.repository
        kieRepository.addKieModule { kieRepository.defaultReleaseId }
    }

    @Throws(IOException::class)
    @Bean
    fun kieSession(): KieSession? {
        getKieRepository()
        val kContainer = getKieContainer()
        return kContainer?.newKieSession()
    }
}