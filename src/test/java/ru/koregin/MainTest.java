package ru.koregin;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void whenPlusThenRightResult() throws Exception {
        String input = "1 + 1";
        assertEquals("2", Main.calc(input));
    }

    @Test
    public void whenMinusThenRightResult() throws Exception {
        String input = "1 - 1";
        assertEquals("0", Main.calc(input));
    }

    @Test
    public void whenMinusThenRightMinusResult() throws Exception {
        String input = "1 - 2";
        assertEquals("-1", Main.calc(input));
    }

    @Test
    public void whenMultipleThenRightResult() throws Exception {
        String input = "2 * 2";
        assertEquals("4", Main.calc(input));
    }

    @Test
    public void whenDivideThenRightResult() throws Exception {
        String input = "10 / 2";
        assertEquals("5", Main.calc(input));
    }

    @Test
    public void whenDivideThenRightIntegerResult() throws Exception {
        String input = "9 / 2";
        assertEquals("4", Main.calc(input));
    }

    @Test(expected = Exception.class)
    public void whenOperandNotInteger() throws Exception {
        String input = "10 * 2.5";
        Main.calc(input);
    }

    @Test
    public void whenRomeNumbersDivide() throws Exception {
        String input = "VI / III";
        assertEquals("II", Main.calc(input));
    }

    @Test
    public void whenRomeNumbersDivideWithIntegerResult() throws Exception {
        String input = "IX / II";
        assertEquals("IV", Main.calc(input));
    }

    @Test
    public void whenRomeNumbersMultiple() throws Exception {
        String input = "X * X";
        assertEquals("C", Main.calc(input));
    }

    @Test(expected = Exception.class)
    public void whenRomeNumbersWithMinusResult() throws Exception {
        String input = "I - II";
        Main.calc(input);
    }

    @Test(expected = Exception.class)
    public void whenNumbersWithDifferentTypes() throws Exception {
        String input = "I + 1";
        Main.calc(input);
    }

    @Test(expected = Exception.class)
    public void whenOnlyOneOperand() throws Exception {
        String input = "1";
        Main.calc(input);
    }

    @Test(expected = Exception.class)
    public void whenThreeOperandInsteadTwo() throws Exception {
        String input = "1 + 2 + 3";
        Main.calc(input);
    }

    @Test(expected = Exception.class)
    public void whenNumberMoreThenTen() throws Exception {
        String input = "10 + 1111";
        Main.calc(input);
    }

    @Test(expected = Exception.class)
    public void whenRomanNumberResultZero() throws Exception {
        String input = "I - I";
        Main.calc(input);
    }
}