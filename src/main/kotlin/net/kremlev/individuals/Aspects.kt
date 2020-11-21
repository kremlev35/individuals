package net.kremlev.individuals

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Aspect
@Component
class Aspects {

    private val LOGGER = LoggerFactory.getLogger(javaClass)

    @Around("@annotation(net.kremlev.individuals.annotations.LoggedRest)")
    fun logRestController(joinPoint: ProceedingJoinPoint): Any? {
        val start = LocalDateTime.now();
        var output: Any? = null
        var toThrowable: Throwable? = null

        try {
            output = joinPoint.proceed()
        } catch (e: Throwable) {
            toThrowable = e
        }

        val stop = LocalDateTime.now()
        val clazz = joinPoint.signature.declaringType.simpleName
        val method = joinPoint.signature.name

        LOGGER.info("starting @ '$clazz.$method' @ {}", start)
        LOGGER.info("finishing @ '$clazz.$method' @ {} with duration {}", stop, stop.minusNanos(start.nano.toLong()).nano)

        if (toThrowable != null)
            throw toThrowable

        return output
    }
}