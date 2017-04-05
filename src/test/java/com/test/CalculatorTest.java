package com.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by raul on 3/30/17.
 */
public class CalculatorTest {
    @Mock
    Calculator calculator;
    @Mock
    Calculator calculator2;

    @Before
    public void setUp(){
        //MockitoAnnotations.initMocks(this);
        calculator = Mockito.mock(Calculator.class);
        calculator2 = Mockito.mock(Calculator.class);
    }
    @Test
    public void addNums() throws Exception {
        //assertEquals(3, calculator.add();
        verify(calculator, times(1)).addNums(1,2);
    }

    @Test
    public void subtract() throws Exception {
        verify(calculator2, times(1)).subtractNums(1,2);
    }

}