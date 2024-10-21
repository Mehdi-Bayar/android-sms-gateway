package us.kobay.smsgateway.providers

interface IPProvider {
    suspend fun getIP(): String?
}