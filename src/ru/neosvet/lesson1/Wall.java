package ru.neosvet.lesson1;

public class Wall implements Exercise {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void train(Entity entity) {
        if(entity.canJump(height)) {
            entity.jump();
        } else {
            System.out.println(entity.getType() + " не справился.");
        }
    }

    @Override
    public String toString() {
        return "Стена высотой " + height;
    }
}
