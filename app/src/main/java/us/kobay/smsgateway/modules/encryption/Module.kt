package us.kobay.smsgateway.modules.encryption

import org.koin.dsl.module

val encryptionModule = module {
    single {
        EncryptionService(get())
    }
}