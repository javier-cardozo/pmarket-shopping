package uy.org.pmarket.shopping.integration.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType;

@Configuration
public class ResilienceConfig {

    @Value("${circuit.breaker.sliding.window.size:10}")
    private Integer slidingWindowSize;
    @Value("${circuit.breaker.failure.rate.threshold:20}")
    private Integer failureRateThreshold;
    @Value("${circuit.breaker.slow.call.rate.threshold:20}")
    private Integer slowCallRateThreshold;
    @Value("${circuit.breaker.number.call.half.open.state:1}")
    private Integer permittedNumberOfCallsInHalfOpenState;
    @Value("${circuit.breaker.number.call:5}")
    private Integer minimumNumberOfCalls;
    @Value("${circuit.breaker.call.duration.threshold:60}")
    private Integer slowCallDurationThreshold;
    @Value("${circuit.breaker.wait.duration.open.state:300}")
    private Integer waitDurationInOpenState;

    public static final String NAME = "SAURON_RESILIENCE";

    /*
     * https://resilience4j.readme.io/docs/circuitbreaker
     */
    @Bean(name = "circuitBreaker")
    CircuitBreaker configCircuitBreaker() {
        //@formatter:off
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                        .slidingWindowType(SlidingWindowType.COUNT_BASED)
                        .slidingWindowSize(this.slidingWindowSize)
                        .failureRateThreshold(this.failureRateThreshold)
                        .slowCallRateThreshold(this.slowCallRateThreshold)
                        .permittedNumberOfCallsInHalfOpenState(this.permittedNumberOfCallsInHalfOpenState)
                        .minimumNumberOfCalls(this.minimumNumberOfCalls)
                        .slowCallDurationThreshold(Duration.ofSeconds(this.slowCallDurationThreshold))
                        .waitDurationInOpenState(Duration.ofSeconds(this.waitDurationInOpenState))
                        .build();
        //@formatter:on
        return CircuitBreaker.of(NAME, circuitBreakerConfig);
    }

}
