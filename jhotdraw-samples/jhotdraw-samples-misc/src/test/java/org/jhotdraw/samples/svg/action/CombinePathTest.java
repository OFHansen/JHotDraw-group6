package org.jhotdraw.samples.svg.action;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.samples.svg.figures.SVGPathFigure;
import org.junit.Before;
import org.junit.Test;

public class CombinePathTest {
    private CombineAction combineAction;
    private DrawingEditor mockEditor;
    private SVGPathFigure mockPrototype;

    @Before
    public void setUp() {
        // Mock the DrawingEditor
        mockEditor = mock(DrawingEditor.class);

        // Create the CombineAction instance with a mock SVGPathFigure
        mockPrototype = mock(SVGPathFigure.class);
        combineAction = new CombineAction(mockEditor, mockPrototype, true);
    }

    @Test
    public void testConstructorInitialization() {
        // Verify that the DrawingEditor is set correctly
        assertEquals(mockEditor, combineAction.getEditor());

        // Verify that the prototype SVGPathFigure is set correctly
        assertEquals(mockPrototype, combineAction.getPrototype());

        // Verify that isCombineAction is set to true
        assertTrue(combineAction.getIsCombineAction());
    }
}
