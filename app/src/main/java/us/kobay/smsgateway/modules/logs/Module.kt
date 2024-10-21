package us.kobay.smsgateway.modules.logs

import us.kobay.smsgateway.modules.logs.repositories.LogsRepository
import us.kobay.smsgateway.modules.logs.vm.LogsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val logsModule = module {
    singleOf(::LogsRepository)
    singleOf(::LogsService)
    viewModelOf(::LogsViewModel)
}

val NAME = "logs"