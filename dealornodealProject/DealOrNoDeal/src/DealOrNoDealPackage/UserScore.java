/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DealOrNoDealPackage;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class UserScore {
   // int caseAmount = 0;
    String gameUserName;
    public void writingToFile(int CaseAmount) throws IOException{
        Scanner scan = new Scanner(System.in);
        
        //for file
 //       DealOrNoDealTest fileTest = new DealOrNoDealTest();
        
        //user enter their name
        System.out.println("");
        System.out.print("Enter Your name: ");
        gameUserName = scan.nextLine();
        
        //prints 
        System.out.println("Congrats " + gameUserName + " you have won $" + CaseAmount);
        userScore(gameUserName, CaseAmount); 
    }
    
     public void userScore(String tempName, int amountYouhaveWon) throws FileNotFoundException, IOException{
        //write to file
        try {
            try (FileWriter fileS = new FileWriter("UserScore.txt", true)) {
                System.out.println("-------------------------------");
                fileS.write("\r\nName: " + tempName + ", And the amount they won $" + amountYouhaveWon + ".");
                fileS.close();   
            }
        }
        
        catch(IOException o){
           System.out.println("File not found" + o);
        }  
    }
}
