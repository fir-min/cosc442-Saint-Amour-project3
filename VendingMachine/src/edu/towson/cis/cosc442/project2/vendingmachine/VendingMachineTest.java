/**
 * 
 */
package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author FIRMS
 *
 */
public class VendingMachineTest {

	/**
	 * @throws java.lang.Exception
	 */
	public VendingMachineItem a, b, c, d;
	
	public VendingMachine v;
	@Before
	public void setUp() throws Exception {
		a = new VendingMachineItem("cookie", 1.25);
		b = new VendingMachineItem("ice cream", 2.00);
		c = new VendingMachineItem("apple", .50);
		d = new VendingMachineItem("banana", .25);
		
		v = new VendingMachine();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem, java.lang.String)}.
	 */
	@Test
	public void testAddItem1() {
		try {
			v.addItem(a, "A");
			v.addItem(b, "B");
			v.addItem(c, "C");
			v.addItem(d, "D");
		}catch(VendingMachineException e) {
			fail();
		}
	}
	
	@Test
	public void testAddItem2() {
		try {
			v.addItem(a, "A");
			v.addItem(b, "B");
			v.addItem(c, "C");
			v.addItem(d, "D");
			v.addItem(d, "D");
			fail();
		}catch(VendingMachineException e) {
			assertTrue(e.getMessage().contains("already occupied"));
		}
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#getItem(java.lang.String)}.
	 */
	@Test
	public void testGetItem1() {
		v.addItem(a, "A");
		v.addItem(b, "B");
		v.addItem(c, "C");
		v.addItem(d, "D");
		
		assertEquals(a, v.getItem("A"));
		assertEquals(b, v.getItem("B"));
		assertEquals(c, v.getItem("C"));
		assertEquals(d, v.getItem("D"));
	}
	
	@Test
	public void testGetItem2() {
		v.addItem(a, "A");
		v.addItem(b, "B");
		v.addItem(c, "C");
		v.addItem(d, "D");
		try {
			v.getItem("A");
			v.getItem("F");
			fail();
		}catch(VendingMachineException e) {
			assertTrue(e.getMessage().contains("Invalid code for vending machine item"));
		}
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 */
	@Test
	public void testRemoveItem1() {
		v.addItem(a, "A");
		v.addItem(b, "B");
		v.addItem(c, "C");
		v.addItem(d, "D");
		
		assertEquals(a, v.removeItem("A"));
		assertEquals(b, v.removeItem("B"));
		assertEquals(c, v.removeItem("C"));
		assertEquals(d, v.removeItem("D"));
	}
	
	@Test
	public void testRemoveItem2() {
		v.addItem(a, "A");
		v.addItem(b, "B");
		v.addItem(c, "C");
		
		try{
			v.removeItem("A");
			v.removeItem("D");
			fail();
		}catch(VendingMachineException e) {
			assertTrue(e.getMessage().contains("is empty -- cannot remove item"));
		}
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#insertMoney(double)}.
	 */
	@Test
	public void testInsertMoney1() {
		try {
			v.insertMoney(1.25);
			v.insertMoney(2.25);
		}catch(VendingMachineException e) {
			fail();
		}
	}
	
	@Test
	public void testInsertMoney2() {
		try{
			v.insertMoney(0);
			fail();
		}catch(VendingMachineException e) {
			assertTrue(e.getMessage().contains("Invalid amount.  Amount must be >= 0"));
		}
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#getBalance()}.
	 */
	@Test
	public void testGetBalance() {
		v.insertMoney(5.0);
		assertTrue(5.0 == v.getBalance());
		
		v.insertMoney(6.00);
		assertTrue(11.0 == v.getBalance());
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 */
	@Test
	public void testMakePurchase1() {
		v.addItem(a, "A");
		v.addItem(b, "B");
		v.addItem(c, "C");
		
		v.insertMoney(5.00);
		
		assertTrue(v.makePurchase("C"));
	}
	
	@Test
	public void testMakePurchase2() {
		v.addItem(a, "A");
		v.addItem(b, "B");
		v.addItem(c, "C");
		
		assertFalse(v.makePurchase("B"));
		
	}
	
	@Test
	public void testMakePurchase3() {
		v.addItem(a, "A");
		v.addItem(b, "B");
		v.addItem(c, "C");
		
		v.insertMoney(5.00);
		
		assertFalse(v.makePurchase("D"));
		
		
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#returnChange()}.
	 */
	@Test
	public void testReturnChange() {
		v.addItem(a, "A");
		v.addItem(b, "B");
		v.addItem(c, "C");
		
		v.insertMoney(5.00);
		
		v.makePurchase("B");
		
		assertTrue(3.0 == v.returnChange());
	}

}
