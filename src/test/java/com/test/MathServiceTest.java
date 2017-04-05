package com.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by raul on 4/2/17.
 */
public class MathServiceTest {
    MathService mathServ;
    @Mock
    Calculator calculator;
    @Before
    public void setUp() throws Exception {
        calculator = Mockito.mock(Calculator.class);
        mathServ = new MathService(calculator);

    }
    @Test
    public void verifyAddNums() throws Exception {
        //assertEquals(3, calculator.add();
        mathServ.calculator.addNums(1,2);
        verify(mathServ.calculator, times(1)).addNums(1,2);
    }
    @Test
    public void testAddNums() throws Exception {
        //assertEquals(3, calculator.add();
        when(mathServ.calculator.addNums(1,2)).thenReturn(3);
        assertEquals(3, mathServ.calculator.addNums(1,2));
        //verify(mathServ.calculator, times(1)).addNums(1,2);
    }

    @Test
    public void verifySubtractNums() throws Exception {
        mathServ.calculator.subtractNums(1,2);
        verify(calculator, times(1)).subtractNums(1,2);
    }
    @Test
    public void testSubtractNums() throws Exception {
        //assertEquals(3, calculator.add();
        when(mathServ.calculator.subtractNums(1,2)).thenReturn(-1);
        assertEquals(-1, mathServ.calculator.subtractNums(1,2));
        //verify(mathServ.calculator, times(1)).addNums(1,2);
    }

    //Spies use the instance and modify it
    @Test
    public void spyArray() throws Exception{
        ArrayList list = spy(new ArrayList());
        list.add(1);
        verify(list, times(1)).add(1);
        assertEquals(1, list.get(0));
    }
    //mocks call the methods but dont do anything unless specified by when()->thenReturn()
    @Test
    public void mockArray() throws Exception{
        ArrayList list = mock(ArrayList.class);
        list.add(1);
        verify(list, times(1)).add(1);
        assertEquals(null, list.get(0));
    }
}