package org.example.service.model;

public abstract class Mover extends Participant {

    public int speed;

    public Mover(int position, int speed) {
        super(position);
        this.speed = speed;
    }

    public void move() {
        this.position += this.speed;
    }

    public boolean hasMetGoal(int initialPosition, int goalPosition) {
        return (goalPosition <= this.position && goalPosition > initialPosition
            || goalPosition >= this.position && goalPosition < initialPosition);

    }
}
