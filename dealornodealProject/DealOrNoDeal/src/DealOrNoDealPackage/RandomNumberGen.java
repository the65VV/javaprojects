/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DealOrNoDealPackage;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 *
 */

public class RandomNumberGen {
    int[] caseValueArray = new int[]{1, 5, 10, 15, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000, 75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000};
    ArrayList<Integer> newCaseValueArray = new ArrayList<Integer>();
    int randomNumber = 0;
    int realCaseValue;

    public void settingUpCases(){
        for (int i = 0; i < caseValueArray.length; i++) {
            newCaseValueArray.add(caseValueArray[i]);
        }
    }
    
    public int getCaseValue() {
        getRandomValue();

        return realCaseValue;
    }
    public void getRandomValue() {
        Random rng = new Random();
        randomNumber = rng.nextInt(newCaseValueArray.size()); //gets 0 to size - 1
        realCaseValue = newCaseValueArray.get(randomNumber);
        newCaseValueArray.remove(randomNumber);
    }
    
}
