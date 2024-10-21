package us.kobay.smsgateway.modules.logs.repositories

import androidx.lifecycle.distinctUntilChanged
import us.kobay.smsgateway.modules.logs.db.LogEntriesDao

class LogsRepository(
    private val dao: LogEntriesDao
) {
    val lastEntries = dao.selectLast().distinctUntilChanged()
}