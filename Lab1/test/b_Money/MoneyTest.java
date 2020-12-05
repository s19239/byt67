package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	/*
	 * Testing method getAmount() which returns amount of money
	 */
	@Test
	public void testGetAmount() {
		assertEquals(1000, EUR10.getAmount(), 0);
	}
	/*
	 * Testing method getCurrency() which returns currency 
	 */
	@Test
	public void testGetCurrency() {
		assertEquals(SEK, SEK0.getCurrency());
		}

	/*
	 * Testing method toString
	 */
	@Test
	public void testToString() {
		System.out.println(EUR20);
	}

	
	@Test
	public void testGlobalValue() {
		assertEquals((int)(10000 * 0.15), SEK100.universalValue(), 0);
	}

	
	@Test
	public void testEqualsMoney() {
		Money Eu2 = new Money(2000, EUR);
		assertTrue(Eu2.equals(EUR20));
	}

	/*
	 * Testing method add()
	 */
	@Test
	public void testAdd() {
		Money added = EUR20.add(SEK100);
		int sum = (int)((2000) + (10000 * 0.15 / 1.5));
		assertEquals(sum, added.getAmount(), 0);
	}

	/*
	 * Testing method sub() SEK200-Sek100
	 */
	@Test
	public void testSub() {
		Money subbed = SEK200.sub(SEK100);
		int res = 20000 - 10000 ;
		assertEquals(res, subbed.getAmount(), 0);
	}

	@Test
	public void testIsZero() {
		assertTrue(SEK0.isZero());
	}

	@Test
	public void testNegate() {
		assertEquals(-2000, EUR20.negate().getAmount(), 0);
		}

	@Test
	public void testCompareTo() {
		assertEquals(-1, SEK100.compareTo(SEK200));

	}
}
