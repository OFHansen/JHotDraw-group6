package org.jhotdraw.action.edit.BDD;

import org.jhotdraw.draw.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThenFiguresAreDeleted {
    private final Drawing drawing;

    public ThenFiguresAreDeleted(Drawing drawing) {
        this.drawing = drawing;
    }

    public void figuresShouldBeDeleted() {
        assertTrue(drawing.getChildren().isEmpty(), "Drawing should be empty after deletion");
        System.out.println("Figure is deleted");
    }
}
