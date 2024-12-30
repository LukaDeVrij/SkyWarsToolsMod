package org.polyfrost.example.client;

import org.polyfrost.oneconfig.api.commands.v1.CommandManager;

public class ExampleClient {

    public static final ExampleClient INSTANCE = new ExampleClient();

    private ExampleConfig config;

    public void initialize() {
        System.out.println("Initializing Example Client");

        config = new ExampleConfig();
        CommandManager.registerCommand(new ExampleCommand());
    }

    public ExampleConfig getConfig() {
        return config;
    }

}
