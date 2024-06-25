package org.example.service.model;

public abstract class Participant {

    public ParticipantType type;
    public int position;

    public Participant(int position) {
        this.position = position;
    }

}
