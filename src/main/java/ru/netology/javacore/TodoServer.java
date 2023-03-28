package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    protected Todos todos;
    protected final int port;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(8989);) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    String jsonText = in.readLine();
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    Request request = gson.fromJson(jsonText, Request.class);

                    switch (request.type) {
                        case "ADD":
                            todos.addTask(request.task);
                            break;
                        case "REMOVE":
                            todos.removeTask(request.task);
                            break;

                    }
                    String result = todos.getAllTasks();
                    out.println(result);
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }

    static class Request {
        String type;
        String task;
    }

}