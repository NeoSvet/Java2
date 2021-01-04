package ru.neosvet.lesson1;

import ru.neosvet.lesson1.entities.*;
import ru.neosvet.lesson1.exercises.*;
import ru.neosvet.lesson1.interfaces.*;

import java.util.Random;

public class Main {
    private static final int MIN_DISTANCE = 10;
    private static final int MIN_HEIGHT = 1;

    public static void main(String[] args) {
        Entity[] entities = new Entity[]{
                new Human(), new Cat(), new Robot()
        };
        Random random = new Random();
        Exercise[] exercises = new Exercise[]{
                new Wall(random.nextInt(4) + MIN_HEIGHT),
                new Track(random.nextInt(3000) + MIN_DISTANCE),
                new Wall(random.nextInt(2) + MIN_HEIGHT),
                new Track(random.nextInt(2100) + MIN_DISTANCE)
        };

        for (Exercise exercise : exercises) {
            System.out.println(exercise.toString());
            for (int i = 0; i < entities.length; i++) {
                if (!entities[i].isLose())
                    exercise.train(entities[i]);
            }
        }
    }
}
