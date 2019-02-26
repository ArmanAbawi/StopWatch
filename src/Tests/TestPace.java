package Tests;

import Exceptions.TheException;
import model.Pace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPace {

    private Pace y;
    private Pace h;



@BeforeEach

public void runbefore() throws TheException {
     y = new Pace(10, 40, 0.4);
}



@Test

public void TestgetPace() {

    assertEquals(1.6, y.getPace());
}

@Test

public void TestchangePace() throws TheException {
    y.setPace (50, 10, 0.4);
    assertEquals (2, y.getPace());

}

@Test

public void TestexceptionPace() {

    boolean thrown = false;

    try {
    h = new Pace(-10, 90, 0.4);
    } catch (TheException e) {
        thrown = true;
    }

    assertTrue(thrown);

}
}











