package com.web;

import com.dto.JokerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeServiceRestImpl implements JokeService {

    private static Logger logger = LoggerFactory.getLogger(JokeServiceRestImpl.class);

    // Класс RestTemplate является центральным классом в Spring Framework
    // для синхронических вызовов (synchronous calls) сделанных с помощью Client для доступа к RESTful Web Service.
    // Данный класс предоставляет функции для легкого потребления REST Services.
    // При использовании вышеупомянутого класса, пользователь должен предоставить URL,
    // параметры (если есть) и извлечь полученные результаты.

    private final RestTemplate restTemplate;

    private String URL = "http://api.icndb.com/jokes/random";


    public JokeServiceRestImpl(RestTemplate restImplate) {
        this.restTemplate = restImplate;
    }


    @Override
    public String getJoke() {

        logger.debug("getJoke - started");

        // ResponseEntity — специальный класс для возврата ответов.
        // С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код.
        ResponseEntity<JokerDTO> responseEntity=
                restTemplate.getForEntity(URL, JokerDTO.class);

        logger.info(responseEntity.getBody().getValue().getJoke());

        logger.debug("getJoke - stoped");

        return responseEntity.getBody().getValue().getJoke();

        /*
         ResponseEntity<String> responseEntity=
                restTemplate.getForEntity(URL, String.class);

        return responseEntity.getBody();
         */

    }
}
