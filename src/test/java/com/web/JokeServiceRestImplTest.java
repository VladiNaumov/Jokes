package com.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {
        InteractiveShellApplicationRunner
        .SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner
        .SPRING_SHELL_SCRIPT_ENABLED + "=false"
}

)
class JokeServiceRestImplTest {

    @Autowired
    private JokeService jokeService;

    @Test
    void getJoke() {
        String joke = jokeService.getJoke();
        assertNotNull(joke);
        assertTrue(joke.contains("Chuck Norris"));

    }
}