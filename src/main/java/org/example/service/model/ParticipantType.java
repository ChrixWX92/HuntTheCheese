package org.example.service.model;

public enum ParticipantType {

    CAT('K', Cat.class),
    MOUSE('M', Mouse.class),
    CHEESE('C', Cheese.class);

    public final char symbol;
    public final Class<? extends Participant> clazz;

    // clazz is unused, but is intended for setting CheesyScenario's fields via reflection
    ParticipantType(char symbol, Class<? extends Participant> clazz) {
        this.symbol = symbol;
        this.clazz = clazz;
    }

    public static ParticipantType getBySymbol(char symbol) {
        for (ParticipantType participantType : values()) {
            if (participantType.symbol == symbol){
                return participantType;
            }
        }
        return null;
    }

}
