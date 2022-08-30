package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldSumPlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Petya", 10);
        store.addPlayTime("Oleg", 20);

        int actual = store.getSumPlayedTime();
        int expected = 30;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldRegisterAndAddTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Petya", 0);
        store.addPlayTime("Petya", 10);

        String actual = store.getMostPlayer();
        String expected = "Petya";

        assertEquals(expected,actual);
    }

    @Test
    public void shouldAcceptMostTimeWhenOne() {

        GameStore store = new GameStore();

        store.addPlayTime("Petya", 1);

        String actual = store.getMostPlayer();
        String expected = "Petya";

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMostTimePlayer() {

        GameStore store = new GameStore();

        store.addPlayTime("Petya", 30);
        store.addPlayTime("Oleg", 20);
        store.addPlayTime("Ivan", 50);

        String actual = store.getMostPlayer();
        String expected = "Ivan";

        assertEquals(expected, actual);
    }
}
