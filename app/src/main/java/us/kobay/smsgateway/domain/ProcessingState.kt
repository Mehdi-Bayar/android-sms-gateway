package us.kobay.smsgateway.domain

enum class ProcessingState {
    Pending,
    Processed,
    Sent,
    Delivered,
    Failed
}