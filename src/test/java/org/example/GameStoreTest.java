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
    public void shouldAddGame() {
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddPlayTime() {
        int expected = 5;
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
