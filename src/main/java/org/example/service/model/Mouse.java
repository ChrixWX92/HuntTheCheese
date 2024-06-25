package org.example.service.model;

import static org.example.service.model.ParticipantType.MOUSE;

public class Mouse extends Mover {

    public Mouse(int position, int speed) {
        super(position, speed);
        this.type = MOUSE;
    }

}
