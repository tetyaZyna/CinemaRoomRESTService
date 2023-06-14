package cinema.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Slf4j
@ConfigurationProperties(prefix = "cinema")
public record CinemaProps (
        String password,
        int totalRows,
        int totalColumns,
        int firstRows,
        Price price
){
    public record Price(int low, int high) {}
    @PostConstruct
    void logLoaded() {
        log.info("props = {}", this);
    }
}
