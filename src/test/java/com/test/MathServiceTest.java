package com.test;

import mockit.*;
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
    //mockito you can inject mock into mathserv in the setup
    @Mock
    private Calculator calculator;

    private MathService mathServ;

    //jmockit, injectable dependecy is injected into tested by itself
    //
    @Injectable
    private Calculator calculators;
    @Tested
    private MathService maths;

    @Before
    public void setUp() throws Exception {
        //dependency injection mockito & instantiate mock with Mockito.mock
        calculator = Mockito.mock(Calculator.class);
        mathServ = new MathService(calculator);

    }
    @Test
    public void verifyAddNums() throws Exception {
        //testing the mockito mock with verify..
        when(calculator.addNums(1,2)).thenReturn(3);
        //we got to invoke it else verify will fail because line above does not call just sets up mock
        mathServ.add(1,2);
        verify(calculator, times(1)).addNums(1,2);
    }

    @Test
    public void verifyAddNums2() throws Exception{
        //Same test using jmockit
        //instantiate the mock/injetable, the dependency will be injected into the tested.
        //Block below will set expectations => results etc. for jmock mock
        //calculators is our jmock mock, when that function is called with any ints inside the result will be 3
        new StrictExpectations(Calculator.class){{
            //jmock allows flexibility with the params: anyInt anyChar anyString anyByte etc...
            calculators.addNums(anyInt, anyInt);
            result = 3;
        }};

        //tested class maths can just call its class's calculator and its replaced by the intantiated expecataions above
        //maths was the @tested it has calculators injected into it and its called with math.add
        //anyInt allows us to place any int and the result will be the same!!
        assertEquals(3, maths.add(2,2));

        //never actually called so times should be 0
        new Verifications(){{maths.add(1,2); times = 0;}};
    }

    @Test
    public void testAddNums() throws Exception {
        when(calculator.addNums(1,2)).thenReturn(3);
        assertEquals(3, mathServ.add(1,2));
    }

    @Test
    public void testAddNums2() throws Exception {
        new StrictExpectations(Calculator.class){{
            calculators.addNums(anyInt, anyInt);
            result = 3;
        }};
        assertEquals(3, maths.add(1,2));
    }

    @Test
    public void verifySubtractNums() throws Exception {
        mathServ.calculator.subtractNums(1,2);
        verify(calculator, times(1)).subtractNums(1,2);
    }
    @Test
    public void testSubtractNums() throws Exception {
        when(mathServ.calculator.subtractNums(1,2)).thenReturn(-1);
        assertEquals(-1, mathServ.calculator.subtractNums(1,2));
    }

    //Spies use the instance and modify it
    //Spies in mockito
    //the spy object was actually modified, it had an item added into it
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
        //verify will pass because it was called once
        verify(list, times(1)).add(1);
        //assert will pass because in the instance noting was actually added the list is still empty
        assertEquals(null, list.get(0));
    }
}