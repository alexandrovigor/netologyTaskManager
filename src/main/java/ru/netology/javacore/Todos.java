package ru.netology.javacore;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Todos {
    protected final static int SIZE = 7;
    protected Set<String> tasks = new TreeSet<>();

    public Todos() {
    }

    public void addTask(String task) {
        if (tasks.size() < SIZE) {
            this.tasks.add(task);
        }
    }

    public void removeTask(String task) {
        if (!tasks.isEmpty()) {
            for (String s : tasks) {
                if (s.equals(task)) {
                    this.tasks.remove(s);
                    break;
                }
            }
        }
    }

    public String getAllTasks() {
        return tasks
                .stream()
                .sorted()
                .collect(Collectors.joining(" "));
    }

    public Set<String> getTasks() {
        return tasks;
    }
}
