package org.example.service.model;

import static org.example.service.model.ParticipantType.CHEESE;

public class Cheese extends Participant {

    public Cheese(int position) {
        super(position);
        this.type = CHEESE;
    }

}
