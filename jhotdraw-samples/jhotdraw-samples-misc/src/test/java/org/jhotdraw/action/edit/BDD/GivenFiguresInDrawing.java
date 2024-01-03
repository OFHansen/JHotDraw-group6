package org.jhotdraw.action.edit.BDD;

import org.jhotdraw.draw.*;
import org.jhotdraw.draw.figure.RectangleFigure;

import java.awt.geom.Rectangle2D;

public class GivenFiguresInDrawing {
    private Drawing drawing;
    private DrawingView view;

    public GivenFiguresInDrawing withASelectedFigure() {
        drawing = new DefaultDrawing();
        view = new DefaultDrawingView();
        view.setDrawing(drawing);

        RectangleFigure rect = new RectangleFigure();
        rect.setBounds(new Rectangle2D.Double(10, 10, 100, 100));
        drawing.add(rect);
        System.out.println("Create figure and add to drawing");
        view.addToSelection(rect);
        System.out.println("Return selected figure");
        return this;
    }

    public DrawingView getView() {
        return view;
    }
}
