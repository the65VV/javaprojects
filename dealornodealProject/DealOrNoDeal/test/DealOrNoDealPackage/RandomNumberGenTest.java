/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DealOrNoDealPackage;

import java.util.ArrayList;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RandomNumberGenTest {
   
    
    
    public RandomNumberGenTest() {
            
       
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of settingUpCases method, of class RandomNumberGen.
     */
    @Test
    public void testSettingUpCases() {
        System.out.println("settingUpCases");

        Random rng = new Random(42);

        try {
            int[] testcaseValueArray = new int[rng.nextInt(26)];
            ArrayList<Integer> array = new ArrayList<Integer>();
            RandomNumberGen setCase = new RandomNumberGen();
            setCase.settingUpCases();
            
            for (int i = 0; i < testcaseValueArray.length; i++) {
                
               assertEquals(array.add(i),setCase.newCaseValueArray); 
            }
            

        } catch (IllegalArgumentException e) {
        }

    }

    /**
     * Test of getCaseValue method, of class RandomNumberGen.
     */
    @Test
    public void testGetCaseValue() {
        System.out.println("getCaseValue");
         Random rng = new Random();
        
         try {
           
            int testcaseValueArray = rng.nextInt();
             
            RandomNumberGen gValue = new RandomNumberGen();
            gValue.getRandomValue();
            assertEquals(testcaseValueArray, gValue.realCaseValue);
        } catch (IllegalArgumentException e) {
        }
      
    }
    

    /**
     * Test of getRandomValue method, of class RandomNumberGen.
     */
    @Test
    public void testGetRandomValue() {
       
        System.out.println("getRandomValue");
        
         Random rng = new Random();
       
        try {
            ArrayList<Integer> array = new ArrayList<Integer>();
            int tempRandom = rng.nextInt(array.size());
            int testcaseValueArray = array.get(tempRandom);
            array.remove(tempRandom);
            
            RandomNumberGen instance = new RandomNumberGen();
            instance.getRandomValue();
            assertEquals(testcaseValueArray,instance.newCaseValueArray);
        } catch (IllegalArgumentException e) {
        }

    }
    
}
