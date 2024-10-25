package rous.space.rs.spaceshipms.application.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SpaceshipLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(SpaceshipLoggingAspect.class);

    @Before("execution(* rous.space.rs.spaceshipms.SpaceshipService.getSpaceshipById(..))")
    public void logNegativeId(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof Long spaceshipId) {
            if (spaceshipId < 0) {
                logger.warn("Attempt to retrieve spaceship with negative ID: {}", spaceshipId);
            }
        }
    }
}
