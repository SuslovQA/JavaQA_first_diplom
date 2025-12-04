package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PlayerTest {
    GameStore store = new GameStore();
    Player player = new Player("Nash");
    Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    Game game1 = store.publishGame("Баттл Онлайн", "Аркады");
    Game game2 = store.publishGame("Онлайн", "РПГ");


    @Test
    public void shouldGetName() {
        String expected = "Nash";
        String actual = player.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldInstallGame() {
        player.installGame(game1);

        Assertions.assertTrue(player.playedTime.containsKey(game1));
    }

    @Test
    public void shouldInstallGame1() {
        player.installGame(game2);
        player.installGame(game2);

        Assertions.assertTrue(player.playedTime.containsKey(game2));
    }

    @Test
    public void shouldPlay() {
        player.play(game, 7);

        int expected = 7;
        int actual = player.playedTime.get(game);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);
        player.play(game1, 3);
        player.play(game1, 3);
        player.play(game2, 1);


        int expected = 9;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerByGenre() {
        player.play(game, 5);
        player.play(game1, 6);
        player.play(game1, 6);

        Game expected = game1;
        Game actual = player.mostPlayerByGenre("Аркады");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerByGenre2() {
        player.play(game, 5);
        player.play(game1, 5);

        Game expected = null;
        Game actual = player.mostPlayerByGenre("ффф");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotGetMostPlayerByGenre() {
        Game expected = null;
        Game actual = player.mostPlayerByGenre("Аркады");

        Assertions.assertEquals(expected, actual);
    }
}
