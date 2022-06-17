package org.goafabric.anonymizer.processors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
@Transactional
public class PersonJob {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    final String tableName = "public.person";

    public void run() {
        log.info("anonymizing {}", tableName);
        read();
    }

    private void read() {
        jdbcTemplate.query(String.format("select * from %s",tableName), resultSet -> {
            while (resultSet.next()) { write(resultSet.getString("id")); }
        });
    }

    private void write(String id) {
        log.info("processing {}", id);

        final String fields = "first_name = ?, last_name = ?";
        jdbcTemplate.update(String.format("UPDATE %s SET %s WHERE id = ?", tableName, fields),
                "han", "solo", id);
    }
}
