package us.kobay.smsgateway.ui.styles

import android.graphics.Color

val us.kobay.smsgateway.domain.ProcessingState.color: Int
    get() = when (this) {
        us.kobay.smsgateway.domain.ProcessingState.Pending -> Color.parseColor("#FFBB86FC")
        us.kobay.smsgateway.domain.ProcessingState.Processed -> Color.parseColor("#FF6200EE")
        us.kobay.smsgateway.domain.ProcessingState.Sent -> Color.parseColor("#FF3700B3")
        us.kobay.smsgateway.domain.ProcessingState.Delivered -> Color.parseColor("#FF03DAC5")
        us.kobay.smsgateway.domain.ProcessingState.Failed -> Color.parseColor("#FF018786")
    }