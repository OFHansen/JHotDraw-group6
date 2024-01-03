package org.jhotdraw.action.edit.BDD;
import org.jhotdraw.action.edit.DeleteAction;
import org.jhotdraw.draw.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class WhenDeleteActionIsPerformed {
    private final DrawingView view;
    private final DeleteAction deleteAction;

    public WhenDeleteActionIsPerformed(DrawingView view) {
        this.view = view;
        this.deleteAction = new DeleteAction((JComponent) view);
    }

    public void perform() {
        deleteAction.actionPerformed(new ActionEvent(view, ActionEvent.ACTION_PERFORMED, null));
        System.out.println("actionPerformed success");
    }
}
