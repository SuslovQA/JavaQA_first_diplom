package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    GameStore store = new GameStore();
    Player player = new Player("Nash");
    Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    Game game1 = store.publishGame("Баттл Онлайн", "Аркады");

    @BeforeEach
    public void setup() {

    }

    @Test
    public void shouldGetName() {
        String expected = "Nash";
        String actual = player.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldInstallGame() {
        player.installGame(game1);
    }

//    @Test
//    public void shouldSumGenreIfOneGame() {
//        GameStore store = new GameStore();
//        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
//
//        Player player = new Player("Petya");
//        player.installGame(game);
//        player.play(game, 3);
//
//        int expected = 3;
//        int actual = player.sumGenre(game.getGenre());
//        assertEquals(expected, actual);
//    }

}
