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

    final String tableName = "public.person";

    public void run() {
        log.info("anonymizing {}", tableName);
        read();
    }

    private void read() {
        jdbcTemplate.query("select * from " + tableName, resultSet -> {
            while (resultSet.next()) { process(resultSet.getString("id")); }
        });
    }

    private void process(String id) {
        //final String sql = "UPDATE " + tableName + ""
        log.info("processing {}", id);
        jdbcTemplate.update("UPDATE public.person SET first_name = ?, last_name = ? WHERE id = ?"
                , "han", "solo", id);
    }
}
