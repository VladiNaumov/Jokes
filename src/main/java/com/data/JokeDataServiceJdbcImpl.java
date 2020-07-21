package com.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JokeDataServiceJdbcImpl implements JokeDataService {

    //шаблонный класс JdbcTemplate, который упрощает работу с SQL и JDBC реляционных СУБД.
    // Большая часть JDBC кода состоит из получения ресурсов, управления соединением,
    // обработки исключений и вообще проверки ошибок, ни как не связанных с тем, для чего предназначен код.
    // JdbcTemplate берет на себя все это за вас.
    private final JdbcTemplate jdbcTemplate;

    public JokeDataServiceJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void save(String joke) {
    //Запрос в БД для сохранения
        jdbcTemplate.update("INSERT INTO jokes (joke) VALUES (?)", joke);
    }

    @Override
    public List<String> findAll() {
        //Запрос в БД (получени)
        return jdbcTemplate.query("SELECT * FROM jokes",
                (rs, rowNum) -> rs.getString("joke"));
    }
}
