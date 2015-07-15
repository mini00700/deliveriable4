package com.laboon;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TestToString {

	//This one can test the edge case that size is zero.
	@Test
	public void TestZeroCase() {
		World testworld = new World(0,20,30);
		String result = testworld.toString();
		//I expect that it will return "  \n"
		assertEquals(result,"  \n");
	}
	
	//This one can test the base case which is a small size.
	@Test
	public void TestSmallSize(){
		World testworld = new World(1,20,30);
		
		//I just want to test size. So I need to remove the effect of other method first.
		//I mock the cell. Let it return 'X' in each time.
		Cell cell = mock(Cell.class);
		when(cell.getStateRep()).thenReturn('X'); 
		testworld._world[0][0]=cell;
		String result = testworld.toString();
		verify(cell,times(1)).getStateRep();
		assertEquals(result,"  0\n0 X\n");
	}
	
	
	//This one can 
	@Test
	public void TestBaseCase1(){
		World testworld = new World(40,20,30);
		
		for(int i=0;i<40;i++){
			for(int j=0;j<40;j++){
				Cell cell = mock(Cell.class);
				when(cell.getStateRep()).thenReturn('X');
				testworld._world[i][j]=cell;
			}
		}
		
		String r = testworld.toString();
		String[] result=r.split("\n");
		assertEquals(result[0],"  0123456789012345678901234567890123456789");
		
	}
	
	@Test
	public void TestBaseCase2(){
		World testworld = new World(1000,20,30);
		for(int i=0;i<40;i++){
			for(int j=0;j<40;j++){
				Cell cell = mock(Cell.class);
				when(cell.getStateRep()).thenReturn('X');
				testworld._world[i][j]=cell;
			}
		} 
		String r = testworld.toString();
		String[] result=r.split("9");
		assertEquals(result[0],"  012345678");
		
	}
}
