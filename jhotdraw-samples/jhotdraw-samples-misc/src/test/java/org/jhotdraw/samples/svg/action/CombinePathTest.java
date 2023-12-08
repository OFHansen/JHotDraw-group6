package org.jhotdraw.samples.svg.action;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.samples.svg.figures.SVGPathFigure;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class CombinePathTest {
    private CombineAction combineAction;
    private DrawingEditor mockEditor;
    private SVGPathFigure mockPrototype;
    private DrawingView mockView;
    private Drawing mockDrawing;

    @Before
    public void setUp() {
        // Mock the DrawingEditor
        mockEditor = mock(DrawingEditor.class);

        //Mock the DrawingView
        mockView = mock(DrawingView.class);
        when(mockEditor.getActiveView()).thenReturn(mockView);

        // Mock the Drawing
        mockDrawing = mock(Drawing.class);
        when(mockView.getDrawing()).thenReturn(mockDrawing);

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

    @Test
    public void testUpdateEnabledState() {
        // Case: can group
        when(mockView.getSelectionCount()).thenReturn(2);
        Set<Figure> selectedFigures = new HashSet<>();
        selectedFigures.add(mock(SVGPathFigure.class));
        when(mockView.getSelectedFigures()).thenReturn(selectedFigures);

        combineAction.updateEnabledState();

        assertTrue(combineAction.isEnabled());
    }

    @Test
    public void testCanGroup() {
        // Case: can group
        when(mockView.getSelectionCount()).thenReturn(2);
        Set<Figure> selectedFigures = new HashSet<>();
        selectedFigures.add(mock(SVGPathFigure.class));
        when(mockView.getSelectedFigures()).thenReturn(selectedFigures);
        assertTrue(combineAction.canGroup());

        // Case: cannot group
        when(mockView.getSelectionCount()).thenReturn(1);
        selectedFigures.clear();
        selectedFigures.add(mock(Figure.class));
        when(mockView.getSelectedFigures()).thenReturn(selectedFigures);
        assertFalse(combineAction.canGroup());
    }
}
