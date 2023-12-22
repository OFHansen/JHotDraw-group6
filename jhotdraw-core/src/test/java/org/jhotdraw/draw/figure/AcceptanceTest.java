package org.jhotdraw.draw.figure;


import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Before;
import org.junit.Test;

public class AcceptanceTest extends ScenarioTest<GivenEdit, WhenNewText, ThenSetNewText> {

    private TextAreaFigure textAreaFigure;

    @Before
    public void init() {
        textAreaFigure = new TextAreaFigure("Dummy Text");
    }

    @Test
    public void acceptanceTest() {
        given().editText();
        when().addNewText(textAreaFigure);
        then().assertNewText(textAreaFigure);
    }
}



class GivenEdit extends Stage<GivenEdit> {
    public GivenEdit editText() {
        return self();
    }
}

class WhenNewText extends Stage<WhenNewText> {
    public WhenNewText addNewText(TextAreaFigure textAreaFigure) {
        textAreaFigure.setText("New Text");
        return self();
    }
}

class ThenSetNewText extends Stage<ThenSetNewText> {
    public ThenSetNewText assertNewText(TextAreaFigure textAreaFigure) {
        assert(textAreaFigure.getText().equals("New Text"));
        return self();
    }
}