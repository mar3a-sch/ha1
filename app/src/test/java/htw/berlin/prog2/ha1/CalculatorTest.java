package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen

    @Test
    @DisplayName("Testet Funktionalität der Vorzeichenumkehr")
    void NegativesZeichen() {
    Calculator c = new Calculator();
        c.pressDigitKey(3);
        c.pressDigitKey(7);   // Bildschirm zeigt "37"
        c.pressNegativeKey(); // Es sollte "-37" ergeben

        String erwartet= "-37";  //Zahl, die Erwartet wird
        String Zahl = c.readScreen();

        //Vergleich von Erwartungswert mit ergebenden Zahl
        /**
         * if (erwartet.equals(Zahl)) {
         *             System.out.println("DivisionMitNull : Ergebnis = " + Zahl);
         *         } else {
         *             System.out.println("DivisionMitNull : Erwartet = " + erwartet + ", aber war = " + Zahl);
         *         }
         */

        assertEquals(erwartet, Zahl);
    }

   /* @Test
    @DisplayName("Testet die unäre Operation \"1/x\" mit 0")
    void DivisionMitNull(){
        Calculator c = new Calculator();

        c.pressDigitKey(0);
        c.pressUnaryOperationKey("1/x");

        String erwartet= "Error";  //String, das Erwartet wird
        String Zahl = c.readScreen();

        assertEquals(erwartet, Zahl);

    }

    @Test
    @DisplayName("Erwartet, dass die letzte Operation korrekt wiederholt wird.")
    void DoppelteRechnung() {

        Calculator c = new Calculator();

        c.pressDigitKey(8);
        c.pressBinaryOperationKey("-");
        c.pressDigitKey(2);
        c.pressEqualsKey();
        c.pressEqualsKey();

        String erwartet = "4";
        String Zahl = c.readScreen();

        assertEquals(erwartet, Zahl);
    }

    */
}

