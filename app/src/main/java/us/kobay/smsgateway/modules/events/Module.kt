package us.kobay.smsgateway.modules.events

import org.koin.dsl.module

val eventBusModule = module {
    single { EventBus() }
}