package edu.depaul.se433.skeleton;
import static edu.depaul.se433.Orders.ShippingMethod.*;
import static edu.depaul.se433.Orders.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.depaul.se433.Orders;


public class OrdersTest {
	@Test
	@DisplayName("Standard, >50, tax")
	void taxStanOver()
	{
		double y= Orders.calculateTotal(60, Orders.ShippingMethod.Standard, "IL");
		assertEquals(63.60,y);
	}
	@Test
	@DisplayName("NextDay, >50, tax")
	void taxNextOver()
	{
		double y= Orders.calculateTotal(60, Orders.ShippingMethod.NextDay, "NY");
		assertEquals(88.60,y);
	}
	
	@Test
	@DisplayName("Standard, <50, tax")
	void taxStanUnder()
	{
		double y= Orders.calculateTotal(40, Orders.ShippingMethod.Standard, "CA");
		assertEquals(51.60,y);
	}
	
	@Test
	@DisplayName("NextDay, <50, tax")
	void taxNextUnder()
	{
		double y= Orders.calculateTotal(40, Orders.ShippingMethod.NextDay, "IL");
		assertEquals(66.60,y);
	}
	@Test
	@DisplayName("Standard, >50, no tax")
	void noTaxStanOver()
	{
		double y= Orders.calculateTotal(60, Orders.ShippingMethod.Standard, "RI");
		assertEquals(60.00,y);
	}
	@Test
	@DisplayName("NextDay, >50, no tax")
	void noTaxNextOver()
	{
		double y= Orders.calculateTotal(60, Orders.ShippingMethod.NextDay, "ID");
		assertEquals(85,y);
	}
	@Test
	@DisplayName("NextDay, <50, no tax")
	void noTaxNextUnder()
	{
		double y= Orders.calculateTotal(60, Orders.ShippingMethod.NextDay, "NC");
		assertEquals(65,y);
	}
	@Test
	@DisplayName("Standard, <50, no tax")
	void noTaxStanUnder()
	{
		double y= Orders.calculateTotal(40, Orders.ShippingMethod.NextDay, "ID");
		assertEquals(50,y);
	}
	//Boundary Value Analysis
	@Test
	@DisplayName("Standard, price=50, tax")
	void taxLowerBound()
	{
		double y= Orders.calculateTotal(50, Orders.ShippingMethod.Standard, "NY");
		assertEquals(63,y);
	}
	@Test
	@DisplayName("Standard, price=50.01, tax")
	void taxUpperBound()
	{
		double y= Orders.calculateTotal(50.01, Orders.ShippingMethod.Standard, "CA");
		assertEquals(53.01,y);
	}
	@Test
	@DisplayName("Standard, price=0.10, tax")
	void noTaxUpperBound()
	{
		double y= Orders.calculateTotal(0.10, Orders.ShippingMethod.Standard, "ID");
		assertEquals(11.10,y);
	}
	@Test
	@DisplayName("Standard, >50, tax")
	void noTaxLowerBound()
	{
		double y= Orders.calculateTotal(0, Orders.ShippingMethod.Standard, "ID");
		assertEquals(0,y);
	}

	@Test
	@DisplayName("Error invalid state input")
	void invalidState()
	{
		
		boolean thrown = false;
		try {
			double y= Orders.calculateTotal(12, Orders.ShippingMethod.Standard, "12");
		}
		catch(IllegalArgumentException e) {
			thrown=true;
		}
		assertTrue(thrown);
		
	}
	@Test
	@DisplayName("Error invalid state input")
	void invalidNotUS()
	{
		
		boolean thrown = false;
		try {
			double y= Orders.calculateTotal(12, Orders.ShippingMethod.Standard, "XI");
		}
		catch(IllegalArgumentException e) {
			thrown=true;
		}
		assertTrue(thrown);
		
	}
	@Test
	@DisplayName("Error invalid price input")
	void invalidPrice()
	{
		
		boolean thrown = false;
		try {
			double y= Orders.calculateTotal(-1, Orders.ShippingMethod.Standard, "IL");
		}
		catch(IllegalArgumentException e) {
			thrown=true;
		}
		assertTrue(thrown);
		
	}

}
