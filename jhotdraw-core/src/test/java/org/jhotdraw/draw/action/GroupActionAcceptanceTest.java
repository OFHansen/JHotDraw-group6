package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.awt.event.ActionEvent;

import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertTrue;

public class GroupActionAcceptanceTest extends ScenarioTest<GroupActionGiven, GroupActionWhen, GroupActionThen> {

    private GroupAction groupAction;
    private DrawingView drawingView;
    private DrawingEditor drawingEditor;

    @Before
    public void init() {
        //Setting up Mocks
        drawingView = mock(DrawingView.class);
        drawingEditor = mock(DrawingEditor.class);
        groupAction = spy(new GroupAction(drawingEditor));

        //Forcing correct return values
        Mockito.when(groupAction.getEditor()).thenReturn(drawingEditor);
        Mockito.when(groupAction.getView()).thenReturn(drawingView);
    }

    @Test
    public void acceptanceTest() {
        given().aDrawingViewWithMultipleFigures(drawingView);

        when().theGroupActionIsUsed(groupAction);

        then().groupingShouldBeAllowed(groupAction);
    }

}

class GroupActionGiven extends Stage<GroupActionGiven> {
    public GroupActionGiven aDrawingViewWithMultipleFigures(DrawingView drawingView) {
        Mockito.when(drawingView.getSelectionCount()).thenReturn(2);
        return self();
    }
}

class GroupActionWhen extends Stage<GroupActionWhen> {
    public GroupActionWhen theGroupActionIsUsed(GroupAction groupAction) {
        groupAction.canGroup();
        return self();
    }
}

class GroupActionThen extends Stage<GroupActionThen> {
    public GroupActionThen groupingShouldBeAllowed(GroupAction groupAction) {
        assertTrue(groupAction.canGroup());
        return self();
    }
}