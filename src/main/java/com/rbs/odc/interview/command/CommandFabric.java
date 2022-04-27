package com.rbs.odc.interview.command;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommandFabric {

    private static final String COMMANDS_PACKES_TO_SCAN = "com.rbs.odc.interview.command";

    private Map<String, Command> mapOfCommands;

    public static CommandFabric getInstance() {
        CommandFabric singleton = CommandFabricHolder.INSTANCE;
        singleton.initializeCommands();
        return singleton;
    }

    private void initializeCommands() {
        mapOfCommands = new HashMap<>();
        List<Class<?>> classes = getAllClassesFrom(COMMANDS_PACKES_TO_SCAN);
        classes.stream()
                .filter(clazz -> Arrays.asList(clazz.getInterfaces()).contains(Command.class))
                .forEach(clazz -> {
                    try {
                        Command newInstance = (Command) clazz.newInstance();
                        mapOfCommands.put(newInstance.getName(), newInstance);
                    } catch (InstantiationException | IllegalAccessException ignored) {
                        //nothing here
                    }
                });

    }

    public Optional<Command> getCommand(String command) {
        return Optional.ofNullable(mapOfCommands.get(command));
    }

    private static class CommandFabricHolder {

        private static final CommandFabric INSTANCE = new CommandFabric();

    }

    private static List<Class<?>> getAllClassesFrom(String packageName) {
        return new Reflections(packageName, new SubTypesScanner(false))
                .getAllTypes()
                .stream()
                .map(name -> {
                    try {
                        return Class.forName(name);
                    } catch (ClassNotFoundException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }


}
