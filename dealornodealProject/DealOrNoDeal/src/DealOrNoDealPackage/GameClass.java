/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DealOrNoDealPackage;

import static java.lang.Thread.sleep;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GameClass {
    HashMap<Integer, Integer> caseMap = new HashMap<Integer, Integer>();
    RandomNumberGen RandomNum = new RandomNumberGen(); 
    Scanner scan = new Scanner(System.in);
    int yourCase;
    int openedCase = 6;
    int[] casesYouWantToOpen = new int[openedCase + 1];
    int[] newlyOpenedCase = new int[openedCase + 1];
   
    
    public void timeToPlayTheGame(){
        RandomNum.settingUpCases();
        setUpBoard();
        gamePlay();
    }
    
    public void setUpBoard(){
        //Populating the hashMap.
        for (int i = 1; i < 27; i++) {
            caseMap.put(i, RandomNum.getCaseValue());
        }
        
        //Printing out the welcome menu.
        System.out.println("Welcome to DEAL OR NO DEAL!");
        pause();
        System.out.println("Are you ready to win some money?");
        pause();
        System.out.println("");
        System.out.println("Pick a case! This case will be your case.");
        
        //Printing out the board.
        printOutBoard(); 
    }
    
    public void gamePlay(){
        //Getting the case you want.
        System.out.print("And your case is -> ");
        yourCase = scan.nextInt();
        
        //Removing the case from the hashMap.
        removingYourCase();
        
        //Starting the case picking
        pause();
        System.out.println("");
        System.out.println("Lets get down to bussiness...");
        while(openedCase > 0){
            pickingCases();
        }

    }
    
    public void printOutBoard(){
        //This method prints out the hashMaps keys.
        if(openedCase == 6){
            System.out.println("This is the board that you will be choicing from");
            System.out.println(caseMap.keySet());
        }
        else{
            pause();
            System.out.println("This is left on the board");
            System.out.println(caseMap.keySet());
        }
            
    }
    
    public void removingYourCase(){
        System.out.println("");
        System.out.println("Perfect, Your case has been brought down from the board.");
        pause();
        System.out.println("");
        
        //Saving the case you picked into a temp int.
        int tempCaseHolder = yourCase;
        
        //TESTING!@#!@#!@#!
        int tempCaseValueHolder = caseMap.get(yourCase);
        

        yourCase = tempCaseValueHolder;
        
        //Removing the case you picked from the Map
        caseMap.remove(tempCaseHolder);
        
        printOutBoard();

    }
 
    public void pause(){
        try {
            sleep(2000);
        } catch (InterruptedException ex) {
        }
    }
    
    public void pickingCases(){
        System.out.println("");
        System.out.println("You can pick " + openedCase + " cases now.");
        System.out.println("What cases would you like?");
        int tempNum = 0;
        for (int i = 1; i < openedCase + 1;) {
            System.out.print("Case " + i + " -> ");
        
            casesYouWantToOpen[i] = scan.nextInt();
            newlyOpenedCase[tempNum] = casesYouWantToOpen[i];
            
            if(caseMap.get(casesYouWantToOpen[i]) != null && casesYouWantToOpen[i] <= 26 && casesYouWantToOpen[i] > 0 ){
                
                for (int j = 1; j <= tempNum; j++) {
                    
                }
                i++;
            }
            
            else {
                System.out.println("");
                System.out.println("There was an error with the number " + casesYouWantToOpen[i] + " you have entered, please a differnet number.");
                System.out.println("");
                i = i;
                newlyOpenedCase[tempNum] = 0;
            }
            
            tempNum++;
            
        }
        
        System.out.println("");
        System.out.println("Bring those cases down!");
        System.out.println("");
     
        for (int i = 1; i < openedCase + 1; i++) {
            gettingValuesFromKey(i);
            caseMap.remove(casesYouWantToOpen[i]);     
        }
 
        printOutBoard();

        if(openedCase == 2){ 
            
             openedCase = 1;

        }   
         else{
            
             openedCase--;
                     
        }
 
    }
    
    public void gettingValuesFromKey(int i){
        System.out.println("In case " + i);
        System.out.println("We have a value of: $" + caseMap.get(casesYouWantToOpen[i]));
        pause();
        System.out.println("");
    }
    
 
    }

  
