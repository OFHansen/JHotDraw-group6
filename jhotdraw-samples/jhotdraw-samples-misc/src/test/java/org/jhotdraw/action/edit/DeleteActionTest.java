package org.jhotdraw.action.edit;

import org.jhotdraw.action.edit.BDD.GivenFiguresInDrawing;
import org.jhotdraw.action.edit.BDD.ThenFiguresAreDeleted;
import org.jhotdraw.action.edit.BDD.WhenDeleteActionIsPerformed;
import org.junit.jupiter.api.Test;

public class DeleteActionTest {

    @Test
    public void testDeleteAction() {
        GivenFiguresInDrawing given = new GivenFiguresInDrawing().withASelectedFigure();
        WhenDeleteActionIsPerformed when = new WhenDeleteActionIsPerformed(given.getView());
        ThenFiguresAreDeleted then = new ThenFiguresAreDeleted(given.getView().getDrawing());

        when.perform();
        then.figuresShouldBeDeleted();
    }
}
