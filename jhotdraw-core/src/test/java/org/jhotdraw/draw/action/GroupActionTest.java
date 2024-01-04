package org.jhotdraw.draw.action;

import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;


public class GroupActionTest {

    private GroupAction groupAction;
    private DrawingView drawingView;
    private DrawingEditor drawingEditor;

    @Before
    public void init(){
        //Setting up Mocks
        drawingView = mock(DrawingView.class);
        drawingEditor = mock(DrawingEditor.class);
        groupAction = spy(new GroupAction(drawingEditor));

        //Forcing correct return values
        when(groupAction.getEditor()).thenReturn(drawingEditor);
        when(groupAction.getView()).thenReturn(drawingView);
    }

    @Test
    public void cannotGroupWithSingleFigure(){
        //Setting up Mocks
        when(drawingView.getSelectionCount()).thenReturn(1);

        //Assert
        assertFalse(groupAction.canGroup());
    }

    @Test
    public void  canGroupWithMultipleFigures(){
        //Setting up Mocks
        when(drawingView.getSelectionCount()).thenReturn(3);

        //Assert
        assertTrue(groupAction.canGroup());
    }

    @Test
    public void canGroupWithManyFigures(){
        //Setting up Mocks
        when(drawingView.getSelectionCount()).thenReturn(50);

        //Assert
        assertTrue(groupAction.canGroup());
    }

    @Test
    public void cannotUngroupWithTwoFigures(){
        //Setting up Mocks
        when(drawingView.getSelectionCount()).thenReturn(2);
        when(drawingView.getSelectedFigures()).thenReturn(null);

        //Assert
        assertFalse(groupAction.canUngroup());
    }

    @Test
    public void canUngroupWithSingleFigure(){
        //Setting up Mocks
        CompositeFigure figure1 = mock(CompositeFigure.class);
        CompositeFigure figure2 = mock(CompositeFigure.class);
        CompositeFigure figure3 = mock(CompositeFigure.class);
        CompositeFigure figure4 = mock(CompositeFigure.class);
        CompositeFigure figure5 = mock(CompositeFigure.class);

        when(drawingView.getSelectionCount()).thenReturn(1);
        when(drawingView.getSelectedFigures())
                .thenReturn(new HashSet<>(Arrays.asList(figure1, figure2, figure3, figure4, figure5)));
        groupAction.setPrototype(figure1);

        //Assert
        assertTrue(groupAction.canUngroup());
    }

}