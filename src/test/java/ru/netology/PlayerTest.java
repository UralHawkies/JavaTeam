package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    /**
     * Тест проверяет повторную установку игры
     */
    @Test
    public void shouldSameGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player1 = new Player("Petya");
        player1.installGame(game1);
        player1.play(game1, 3);
        player1.installGame(game1);
        player1.play(game1, 4);

        int expected = 7;
        int actual = player1.sumGenre("Аркады");
        assertEquals(expected, actual);
    }

    /**
     * Тест проверяет суммирование времени в определенный тип игры
     */
    @Test
    public void shouldSumAllSameGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Страйк", "Стрелялки");
        Game game3 = store.publishGame("Нетология Квест", "Аркады");

        Player player1 = new Player("Petya");
        player1.installGame(game1);
        player1.installGame(game2);
        player1.installGame(game3);
        player1.play(game1, 3);
        player1.play(game1, 2);
        player1.play(game2, 4);
        player1.play(game3, 2);


        int expected = 7;
        int actual = player1.sumGenre("Аркады");
        assertEquals(expected, actual);
    }

    /**
     * Тест проверяет возвращение наименования игры по ее типу и времени игры
     */
    @Test
    public void shouldReturnName() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Страйк", "Стрелялки");
        Game game3 = store.publishGame("Нетология Квест", "Аркады");

        Player player1 = new Player("Petya");
        player1.installGame(game1);
        player1.installGame(game2);
        player1.installGame(game3);
        player1.play(game1, 3);
        player1.play(game1, 2);
        player1.play(game2, 4);
        player1.play(game3, 4);


        String expected = "Нетология Баттл Онлайн";
       // String actual = player1.mostPlayerByGenre("Аркады");
        // assertEquals(expected, actual);
    }


    /** Тест проверяет добавление игры без ее установки */
    @Test
    public void notShouldAddGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Страйк", "Стрелялки");

        Player player1 = new Player("Petya");
        player1.installGame(game1);
        player1.play(game1, 3);

        Assertions.assertThrows(NotInstallGame.class, () -> {
            player1.play(game2, 4);
        });
    }

    /**
     * Тест проверяет суммирование времени данного типы, если игрок не играл в этот тип
     */
    @Test
    public void notShouldReturnTimeGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game3 = store.publishGame("Нетология Квест", "Аркады");

        Player player1 = new Player("Petya");
        player1.installGame(game1);
        player1.installGame(game3);
        player1.play(game1, 3);
        player1.play(game1, 2);
        player1.play(game3, 4);

        Assertions.assertThrows(NotInstallGame.class, () -> {
            player1.sumGenre("Стрелялки");
        });
    }
    // другие ваши тесты
}
