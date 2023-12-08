package org.jhotdraw.draw.figure;

import org.jhotdraw.draw.QuadTreeDrawing;
import org.junit.Before;
import org.junit.Test;

public class ArrangeTest {
    private QuadTreeDrawing drawing;

    private Figure figure1;
    private Figure figure2;
    @Before
    public void init(){
        figure1 = new TextFigure("hello");
        figure2 = new TextFigure("akjshdjkasd");
        drawing = new QuadTreeDrawing();
        drawing.add(figure1);
        drawing.add(figure2);

    }

    @Test
    public void bringToFront(){
        drawing.bringToFront(figure1);
        assert(figure1.equals(drawing.getChild(1)));
    }

    @Test
    public void sendToBack(){
        drawing.sendToBack(figure2);
        assert(figure2.equals(drawing.getChild(0)));
    }


}
