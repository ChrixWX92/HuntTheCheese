package org.example.service;

import org.example.service.model.Cat;
import org.example.service.model.Cheese;
import org.example.service.model.Mouse;
import org.example.service.model.ParticipantType;

import static org.example.service.CheesyScenario.Outcome.*;

public class CheesyScenario {

    private final String scenarioString;

    private Cat cat;
    private Mouse mouse;
    private Cheese cheese;

    public CheesyScenario(String scenario, int catSpeed, int mouseSpeed) {

        this.scenarioString = scenario;
        createParticipants(catSpeed, mouseSpeed);

    }

    public String huntTheCheese() {

        int catInitialPosition = cat.position;
        int mouseInitialPosition = mouse.position;

        Outcome outcome = null;

        while (outcome == null) {
            moveMovers();
            outcome = determineOutcome(catInitialPosition, mouseInitialPosition);
        }

        return outcome.message;

    }

    private void moveMovers() {
        cat.move();
        mouse.move();
    }

    private Outcome determineOutcome(int catInitialPosition, int mouseInitialPosition) {

        //FIXME: Cat's success is currently based on whether mouse' FINAL position falls with its travelled range.
        // This doesn't account for overlaps between the two. Logic needs rewriting to determine whether both objects'
        // ranges overlap.

        boolean catSucceeded = cat.hasMetGoal(catInitialPosition, mouse.position);
        boolean mouseSucceeded = mouse.hasMetGoal(mouseInitialPosition, cheese.position);

        if (catSucceeded && mouseSucceeded) { return BOTH_WIN; }
        if (catSucceeded) { return CAT_WINS; }
        if (mouseSucceeded) { return MOUSE_WINS; }
        if (limitsHit()) { return UNRESOLVABLE; }

        return null;

    }

    private boolean limitsHit() {
        return ((cat.position <= 0 || cat.position >= scenarioString.length() - 1)
            && (mouse.position <= 0 || mouse.position >= scenarioString.length() - 1));
    }

    private void createParticipants(int catSpeed, int mouseSpeed) {

        for (int position = 0; position < scenarioString.length(); position++) {
            ParticipantType participantType = ParticipantType.getBySymbol(scenarioString.charAt(position));
            switch (participantType) {
                case CAT -> this.cat = new Cat(position, catSpeed);
                case MOUSE -> this.mouse = new Mouse(position, mouseSpeed);
                case CHEESE -> this.cheese = new Cheese(position);
                case null -> {}
            }
        }

    }

    public enum Outcome {

        MOUSE_WINS("Cheese"),
        BOTH_WIN("Cheese party!"),
        UNRESOLVABLE("Unresolved"),
        CAT_WINS("No cheese");

        public final String message;

        Outcome(String message) {
            this.message = message;
        }

    }

}
