package com.shell;

import com.data.JokeDataService;
import com.web.JokeService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
public class ShellCommands {

    private final JokeService jokeService;
    private final JokeDataService jokeDataService;

    public ShellCommands(JokeService jokeService, JokeDataService jokeDataService) {
        this.jokeService = jokeService;
        this.jokeDataService = jokeDataService;
    }
    //сюда сохраняем шутку (строку) каторая приходит по запросу
    private String lastJoke;

    @ShellMethod("Get joke")
    public String joke(){
        lastJoke = jokeService.getJoke();
        return lastJoke;
    }



    @ShellMethod("Save")
    public String save() {
        if (lastJoke == null) {
            return "Сначало загрузите шутку";
        } else {
            jokeDataService.save(lastJoke);
            return "Шутка сохранена";
        }
    }

    @ShellMethod ("Show")
    public String show(){
        return jokeDataService.findAll().stream()
          //System.lineSeparator() делает разрыв строки
        .collect(Collectors.joining(System.lineSeparator()));
    }

}
