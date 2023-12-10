package org.jhotdraw.draw.figure;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.junit.Before;
import org.junit.Test;

public class AcceptanceTest extends ScenarioTest<GivenFigure,WhenArrange,ThenLayerChange> {
    private Figure[] figures;
    private Figure figure1;
    private Figure figure2;

    @Before
    public void init(){
        figure1 = new TextFigure("a");
        figure2 = new TextFigure("b");
        figures = new Figure[2];

        figures[0] = figure1;
        figures[1] = figure2;
    }

    @Test
    public  void acceptanceTest(){
        given().addFigures(figures);

        when().bringToFront(figure1);

        then().assertNewLayer(1,figure1);
    }


}

class GivenFigure extends Stage<GivenFigure> {
    @ProvidedScenarioState
    QuadTreeDrawing drawing;

    @BeforeStage
    private void init(){
        drawing = new QuadTreeDrawing();
    }

    public GivenFigure addFigures(Figure[] figure){
        for (Figure fig : figure){
            drawing.add(fig);
        }
        return self();
    }
}

class WhenArrange extends Stage<WhenArrange> {
    @ExpectedScenarioState
    protected QuadTreeDrawing drawing;

    public WhenArrange bringToFront(Figure figure){
        drawing.bringToFront(figure);
        return self();
    }

}

class ThenLayerChange extends Stage<ThenLayerChange>{

    @ExpectedScenarioState
    protected QuadTreeDrawing drawing;

    public ThenLayerChange assertNewLayer(int numb, Figure fig){
        assert(fig.equals(drawing.getChild(numb)));
        return self();
    }

}