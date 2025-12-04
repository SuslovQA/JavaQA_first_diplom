package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameStoreTest {
    GameStore store = new GameStore();


    @BeforeEach
    public void setup() {
        store.addPlayTime("Nick", 5);
        store.addPlayTime("Don", 6);
    }


    @Test
    public void shouldContainsGame() {
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("1 Баттл Онлайн", "Шутер");
        Game game3 = store.publishGame("2 Баттл Онлайн", "Стратегии");

        assertTrue(store.containsGame(game3));
    }

    @Test
    public void shouldAddGame() {
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldNotAddGame() {
        Game game = null;

        assertFalse(store.containsGame(game));
    }


    @Test
    public void shouldAddPlayTime() {
        store.addPlayTime("Nick", 1);

        int expected = 6;
        int actual = store.playedTime.get("Nick");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayer() {
        String expected = "Don";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSumPlayedTime() {
        int expected = 11;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);
    }
}
