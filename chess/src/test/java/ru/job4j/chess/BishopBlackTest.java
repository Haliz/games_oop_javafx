package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void BishopPositionF8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        assertThat(bishopBlack.position(), is(Cell.F8));
        }

    @Test
    public void BishopCopyC8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Figure bishopBlackDest = bishopBlack.copy(Cell.A6);
        assertThat(bishopBlackDest.position(), is(Cell.A6));
    }
    @Test
    public void BishopWayFromC1ToG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] rls = bishopBlack.way(Cell.C1,Cell.G5);
        assertThat(rls, is(expected));
    }

    @Test
    public void BishopWayFromH1ToA8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H1);
        Cell[] expected = new Cell[] {Cell.G2, Cell.F3, Cell.E4, Cell.D5,
        Cell.C6, Cell.B7, Cell.A8};
        Cell[] rls = bishopBlack.way(Cell.H1,Cell.A8);
        assertThat(rls, is(expected));
    }

    @Test
    public void noDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H1);
        String rsl = null;
        String expect = "Could not way by diagonal from H1 to A7";
        try {
            Cell[] cells = bishopBlack.way(Cell.H1, Cell.A7);
        } catch (IllegalStateException e) {
            rsl = e.getMessage();
        }
        assertThat(rsl, is(expect));
    }
}
