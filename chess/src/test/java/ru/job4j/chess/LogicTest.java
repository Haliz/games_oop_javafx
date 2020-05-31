package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.RookWhite;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void move() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(rsl, is(true));
    }

    @Test
    public void moveFigureOnWay() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.H2));
        logic.add(new RookWhite(Cell.F4));
        boolean rsl = logic.move(Cell.H2, Cell.B8);
        assertThat(rsl, is(false));
    }
}