package org.goafabric.anonymizer.processors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PersonProcessor {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void run() {
        log.info("anonymizing {}", this.getClass());
    }
}
