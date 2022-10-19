package ru.vsu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegralTest {

    final double epsilent = 0.0001;
    final double scale = Math.pow(10, 4);

    @Test
    public void integralRectangleTest1() {
        assertEquals(Integral.integralRectangle(-3, 7, x -> Math.pow(x, 3)), "580");
    }

    @Test
    public void integralRectangleTest2() {
        assertEquals(Integral.integralRectangle(-3, 7, x -> Math.pow(x, 7)), "719780");
    }

    @Test
    public void integralRectangleTest3() {
        assertEquals(Integral.integralRectangle(0, 30, Math::sin), "0.8457485501124159");
    }

    @Test
    public void integralRectangleTest4() {
        assertEquals(Integral.integralRectangle(-3, 7, Math::cos), "-0.9880316240928618");
    }

    @Test
    public void integralTrapezoidTest1() {
        assertEquals(Integral.integralTrapezoid(-3, 7, x -> Math.pow(x, 3)), "580");
    }


    @Test
    public void integralTrapezoidTest2() {
        assertEquals(Integral.integralTrapezoid(-3, 7, x -> Math.pow(x, 7)), "719780");
    }

    @Test
    public void integralTrapezoidTest3() {
        assertEquals(Integral.integralTrapezoid(0, 30, Math::sin), "0.8457485501124159");
    }

    @Test
    public void integralTrapezoidTest4() {
        assertEquals(Integral.integralTrapezoid(-3, 7, Math::cos), "0.7981066067786563");
    }

}