import models.Polynomial;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitTesting {
    @Test
    public void additionTest() {

        String test1,test2,rezString;
        test1 = "4x^5+2x^3+6x^2+x^1";
        test2 = "2x^4+3x^3+2x^2+3x^1";

        Polynomial poly1 = new Polynomial();
        poly1 = poly1.StringToPolynomial(test1);
        System.out.println("Primul polinom :");
        poly1.printPolynomial();

        Polynomial poly2 = new Polynomial();
        poly2 = poly2.StringToPolynomial(test2);
        System.out.println("Al doilea polinom :");
        poly2.printPolynomial();

        Polynomial rez;
        rez = poly1.addPolynomial(poly2);
        rezString = rez.polinomToString();
        System.out.println("Rezultat : ");
        System.out.println(rezString);

        assertEquals(rezString,"4.0X^5+2.0X^4+5.0X^3+8.0X^2+4.0X^1");


    }

    @Test
    public void substractTest() {

        String test1,test2,rezString;
        test1 = "4x^5+2x^3+6x^2+x^1";
        test2 = "2x^4+3x^3+2x^2+3x^1";

        Polynomial poly1 = new Polynomial();
        poly1 = poly1.StringToPolynomial(test1);
        System.out.println("Primul polinom :");
        poly1.printPolynomial();

        Polynomial poly2 = new Polynomial();
        poly2 = poly2.StringToPolynomial(test2);
        System.out.println("Al doilea polinom :");
        poly2.printPolynomial();

        Polynomial rez;
        rez = poly1.substractPolynomial(poly2);
        rezString = rez.polinomToString();
        System.out.println("Rezultat : ");
        System.out.println(rezString);

        assertEquals(rezString,"4.0X^5-2.0X^4-1.0X^3+4.0X^2-2.0X^1");


    }

    @Test
    public void multiplicationTest() {
        String test1,test2,rezString;
        test1 = "4x^5+2x^3+6x^2+x^1";
        test2 = "2x^4+3x^3+2x^2+3x^1";

        Polynomial poly1 = new Polynomial();
        poly1 = poly1.StringToPolynomial(test1);
        System.out.println("Primul polinom :");
        poly1.printPolynomial();

        Polynomial poly2 = new Polynomial();
        poly2 = poly2.StringToPolynomial(test2);
        System.out.println("Al doilea polinom :");
        poly2.printPolynomial();

        Polynomial rez;
        rez = poly1.multiplicatePolynomial(poly2);
        rezString = rez.polinomToString();
        System.out.println("Rezultat : ");
        System.out.println(rezString);

        assertEquals(rezString,"8.0X^9+12.0X^8+12.0X^7+30.0X^6+24.0X^5+21.0X^4+20.0X^3+3.0X^2");

    }

    @Test
    public void derivationTest() {
        String test1,rezString;
        test1 = "4x^5+2x^3+6x^2+x^1";

        Polynomial poly1 = new Polynomial();
        poly1 = poly1.StringToPolynomial(test1);
        System.out.println("Primul polinom :");
        poly1.printPolynomial();


        Polynomial rez;
        rez = poly1.derivatePolynomial(poly1);
        rezString = rez.polinomToString();
        System.out.println("Rezultat : ");
        System.out.println(rezString);

        assertEquals(rezString,"20.0X^4+6.0X^2+12.0X^1+1.0X^0");
    }

    @Test
    public void integrationTest() {
        String test1,rezString;
        test1 = "4x^5+2x^3+6x^2+x^1";

        Polynomial poly1 = new Polynomial();
        poly1 = poly1.StringToPolynomial(test1);
        System.out.println("Primul polinom :");
        poly1.printPolynomial();


        Polynomial rez;
        rez = poly1.integratePolynomial(poly1);
        rezString = rez.polinomToString();
        System.out.println("Rezultat : ");
        System.out.println(rezString);

        assertEquals(rezString,"0.6666666666666666X^6+0.5X^4+2.0X^3+0.5X^2");

    }



}
