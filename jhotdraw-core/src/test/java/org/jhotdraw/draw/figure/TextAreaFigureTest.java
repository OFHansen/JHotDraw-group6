package org.jhotdraw.draw.figure;

import org.jhotdraw.draw.tool.TextAreaEditingTool;
import org.jhotdraw.draw.tool.Tool;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.testng.Assert.*;

public class TextAreaFigureTest {


    private TextAreaFigure textAreaFigure;

    @Before
    public void setUp() {
        textAreaFigure = new TextAreaFigure("Initial Text");
    }

    @Test
    public void testSetText() {
        // Verify that the initial text is set correctly
        assertEquals("Initial Text", textAreaFigure.getText());

        // Modify the text and verify the change
        textAreaFigure.setText("New Text");
        assertEquals("New Text", textAreaFigure.getText());
    }

    @Test
    public void testEditing() {
        // Verify that the figure is initially editable
        assertTrue(textAreaFigure.isEditable());

        // Disable editing and verify
        textAreaFigure.setEditable(false);
        assertFalse(textAreaFigure.isEditable());

        // Enable editing again and verify
        textAreaFigure.setEditable(true);
        assertTrue(textAreaFigure.isEditable());
    }

    @Test
    public void testSetTextAndGetText() {
        // Create a TextAreaFigure instance
        TextAreaFigure textAreaFigure = new TextAreaFigure();

        // Set the text to be displayed
        String inputText = "Hello, JUnit!";
        textAreaFigure.setText(inputText);

        // Get the displayed text
        String displayedText = textAreaFigure.getText();

        // Assert that the inputted text is the same as the displayed text
        assertEquals(inputText, displayedText);
    }

}