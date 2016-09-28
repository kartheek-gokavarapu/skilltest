package com.tek.interview.question;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

public class FooTest {
	
   //Testcase to test the element hierarchy!
	@Test
	public final void TestElementsHierarchyWithinOrder() throws Exception
	{
		
		Item i = Mockito.mock(Item.class);
		OrderLine ol = Mockito.mock(OrderLine.class);
		Order o = Mockito.mock(Order.class);
		
		Mockito.when(i.getDescription()).thenReturn("Pen");
		Mockito.when(i.getPrice()).thenReturn(10f);
		Mockito.when(ol.getItem()).thenReturn(i);
		Mockito.when(ol.getQuantity()).thenReturn(10);
	    Mockito.when(o.get(0)).thenReturn(ol);
		Assert.assertEquals("Pen",o.get(0).getItem().getDescription());
	}
	
	//Testcase to test the calculate function!!
	@Test
	public final void TestCalculateFunction(){
		
		Item i = Mockito.mock(Item.class);
		OrderLine ol = Mockito.mock(OrderLine.class);
		Order o = Mockito.mock(Order.class);
		
		Mockito.when(i.getDescription()).thenReturn("Pen");
		Mockito.when(i.getPrice()).thenReturn(10f);
		Mockito.when(ol.getItem()).thenReturn(i);
		Mockito.when(ol.getQuantity()).thenReturn(10);
		Mockito.when(o.get(Matchers.anyInt())).thenReturn(ol);
		Mockito.when(o.size()).thenReturn(1);
	
		Map<String, Order> map = new HashMap<String, Order>();
		map.put("Or", o);
		Assert.assertEquals(110f,calculator.calculate(map),1);
		
		
	}

	
	//Test case to test the Rounding function
	@Test
	public final void TestRoundingFunction(){
	Assert.assertEquals(0.75,calculator.rounding(0.754),1);
	Assert.assertEquals(0.76,calculator.rounding(0.757),1);
	}
	
}
