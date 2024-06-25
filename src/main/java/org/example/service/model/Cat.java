package org.example.service.model;

import static org.example.service.model.ParticipantType.CAT;

public class Cat extends Mover {

    public Cat(int position, int speed) {
        super(position, speed);
        this.type = CAT;
    }

}
