package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTests {
    Todos todos = new Todos();

    @Test
    void getAllTasks() {
        String result = "Бег Еда Сон";
        todos.addTask("Сон");
        todos.addTask("Бег");
        todos.addTask("Еда");
        Assertions.assertEquals(result, todos.getAllTasks());

    }

    @Test
    void addTask() {
        String result = "Бег Еда Сон";
        todos.addTask("Сон");
        todos.addTask("Еда");
        todos.addTask("Еда");
        todos.addTask("Бег");
        todos.addTask("Бег");
        Assertions.assertEquals(result, todos.getAllTasks());
    }

    @Test
    void remoteTask() {
        String result = "Бег";
        todos.addTask("Сон");
        todos.addTask("Бег");
        todos.addTask("Еда");
        todos.removeTask("Сон");
        todos.removeTask("Еда");
        Assertions.assertEquals(result, todos.getAllTasks());
    }

    @Test
    void noAddMore7Task() {
        todos.addTask("Сон");
        todos.addTask("Бег");
        todos.addTask("Еда");
        todos.addTask("Гейм");
        todos.addTask("Сын");
        todos.addTask("Дочь");
        todos.addTask("Пиво");
        todos.addTask("Жена");
        Assertions.assertEquals(7, todos.getTasks().size());
    }
}