package org.goafabric.anonymizer.processors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PersonJob {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void run() {
        log.info("anonymizing {}", this.getClass());
        read();
    }

    private void read() {
        final String sql = "select * from person";
        jdbcTemplate.query(sql, resultSet -> {
            while (resultSet.next()) {
                process(resultSet.getString("id"));
            }
        });
    }

    private void process(String id) {
        log.info("processing {}", id);
    }
}
