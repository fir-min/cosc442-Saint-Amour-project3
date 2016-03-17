package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class VendingMachineItemTest {
	
	public VendingMachineItem a, b, c, d, e, f;
	@Before
	public void setUp() throws Exception {
		a = new VendingMachineItem("cookie", 1.25);
		b = new VendingMachineItem("ice cream", 2.25);
		d = new VendingMachineItem("non-gummy bears", 4.25);
		e = new VendingMachineItem("gummy bears", 3.25);
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testVendingMachineException1() {
		try {
	        c = new VendingMachineItem("candy", 0.0);
	        fail();
	    } catch (VendingMachineException e) {
	        assertEquals(e.getMessage(), "Price cannot be less than zero");
	    }
	}
	
	@Test
	public void testGetName() {
		assertEquals("cookie", a.getName());
		assertEquals("ice cream", b.getName());
		assertEquals("non-gummy bears", d.getName());
		assertEquals("gummy bears", e.getName());
	}

	@Test
	public void testGetPrice1() {
		//
		double z = a.getPrice();
		//boolean r = ;
		
		assertEquals((z == 1.25), true);
		
		
	}
	
	
	

}
