package ru.neosvet.lesson1;

public class Track implements Exercise {
    private int distance;

    public Track(int distance) {
        this.distance = distance;
    }

    @Override
    public void train(Entity entity) {
        if(entity.canRun(distance)) {
            entity.run();
        } else {
            System.out.println(entity.getType() + " не справился.");
        }
    }

    @Override
    public String toString() {
        return "Дорожка длиной " + distance;
    }
}
