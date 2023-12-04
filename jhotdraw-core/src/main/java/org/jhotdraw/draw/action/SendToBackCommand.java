package org.jhotdraw.draw.action;

import org.jhotdraw.draw.Command;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.Figure;

import java.util.Collection;

public class SendToBackCommand implements Command {
    private DrawingView view;
    private Collection<Figure> figures;

    public SendToBackCommand(DrawingView view, Collection<Figure> figures) {
        this.view = view;
        this.figures = figures;
    }

    @Override
    public void execute() {
        Drawing drawing = view.getDrawing();
        for (Figure figure : figures) {
            drawing.sendToBack(figure);
        }
    }
}