package net.unethicalite.backend.scheduler

import net.unethicalite.backend.repository.SessionRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class SessionScheduler(
    private val sessionRepository: SessionRepository
) {
    @Scheduled(cron = "0 0 * * * *")
    private fun checkAndClear() {
        sessionRepository.removeExpired()
    }
}