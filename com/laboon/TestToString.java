package com.laboon;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TestToString {

	
	@Test
	public void TestZeroCase() {
		World testworld = new World(0,20,30);
		String result = testworld.toString();
		assertEquals(result,"  \n");
	}
	
	@Test
	public void TestSmallSize(){
		World testworld = new World(1,20,30);
		Cell cell = mock(Cell.class);
		when(cell.getStateRep()).thenReturn('X'); 
		String result = testworld.toString();
		verify(cell,times(1)).getStateRep();
		assertEquals(result,"  0\n X\n");
	}
	
	@Test
	public void TestBaseCase1(){
		World testworld = new World(40,20,30);
		Cell cell = mock(Cell.class);
		when(cell.getStateRep()).thenReturn('X'); 
		String r = testworld.toString();
		verify(cell,times(1)).getStateRep();
		String[] result=r.split("\n");
		assertEquals(result,"  0123456789012345678901234567890123456789");
		
	}
	
	@Test
	public void TestBaseCase2(){
		World testworld = new World(1000,20,30);
		Cell cell = mock(Cell.class);
		when(cell.getStateRep()).thenReturn('X'); 
		String r = testworld.toString();
		verify(cell,times(1)).getStateRep();
		String[] result=r.split("\n",42);
		assertEquals(result,"  0123456789012345678901234567890123456789");
		
	}
}
