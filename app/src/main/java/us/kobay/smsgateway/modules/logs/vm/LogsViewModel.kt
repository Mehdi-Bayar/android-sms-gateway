package us.kobay.smsgateway.modules.logs.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import us.kobay.smsgateway.modules.logs.db.LogEntry
import us.kobay.smsgateway.modules.logs.repositories.LogsRepository

class LogsViewModel(
    logs: LogsRepository
) : ViewModel() {
    val lastEntries: LiveData<List<LogEntry>> = logs.lastEntries
}