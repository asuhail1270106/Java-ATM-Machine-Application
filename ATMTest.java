/**
 * Abdullah Suhail
 * 01/26/17
 * ATMTest.java
 * Lab 01
 * This program demonstrates the ATM class.
 * A user is asked to input an Initial balance and can then deposit and withdraw from the balance.
 * Also, they can view a 12 month Interest buildup of their balance depending on a default 4% annual
 * interest rate or an otherwise manually inputted interest rate.
*/

import java.text.DecimalFormat;
import java.text.SimpleDateFormat; // To format the date displayed
import java.util.Calendar; // To get the current date
import javax.swing.JOptionPane; // For the JOptionPane class

public class ATMTest
{
    // declare variable the need to be used   
    static double inp;
    static int num, redo;
		
	
	
    public static void main(String[] args)
    {
      
      JOptionPane.showMessageDialog(null, "Welcome to IIT Bank and Trust", "IIT Bank and Trust",
				JOptionPane.INFORMATION_MESSAGE);
      // Create an ATM object.
      ATM account = new ATM(inp);
      // Create a date object to display current date
      String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
      // Create a DecimalFormat object to display numbers to two decimal places
      DecimalFormat twoPlace =  new DecimalFormat("0.00");
      // Ask user for a balance. Use try-catch block to catch negative and non-numeric numbers
      try
      {
      inp = Integer.parseInt(JOptionPane.showInputDialog(null, 
				"What is your current balance?\n", "IIT Bank and Trust", JOptionPane.QUESTION_MESSAGE));
				account.setBalance(inp);
	  if (inp < 0)
	  {
		  JOptionPane.showMessageDialog(null,  "Your entry was negative.", "IIT Bank and Trust", JOptionPane.ERROR_MESSAGE);
		  		  System.exit(0);
	  }
      }
      catch(NumberFormatException e)
      {
    	  JOptionPane.showMessageDialog(null,  "Your entry was not numeric.", "IIT Bank and Trust", JOptionPane.ERROR_MESSAGE);
    	  		  System.exit(0);
      }
      
    // Use a do-while loop to display the Bank Menu that will allow user to perform a variety of actions
	do
	{
		{
			//display the menu
			String selection = JOptionPane.showInputDialog(null, 
					"What would you like to do today?\n" + 
					"1. View Balance\n" +
					"2. Deposit\n" +
					"3. Withdraw\n" +
					"4. Change Interest\n" +
					"5. Balance Sheet (Yearly Interest Rate Values) \n" + 
					"6. Balance with Interest After 1 year\n" +
					"7. Exit this program\n",  "IIT Bank and Trust Menu", JOptionPane.QUESTION_MESSAGE);
			// Use if statements to perform actions based on user inputted menu number. Use try-catch block to catch negative and non-numeric numbers.
			try
			{
			num = Integer.parseInt(selection);
			if (num < 0)
			{
				JOptionPane.showMessageDialog(null,  "Your entry was negative.", "IIT Bank and Trust", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
			}
			}
			catch(NumberFormatException e)
		    {
				JOptionPane.showMessageDialog(null,  "Your entry was not numeric.", "IIT Bank and Trust", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
		    }
			
			// Executed when user chooses to view balance
			if (num == 1)
			{
				JOptionPane.showMessageDialog(null,  "Your balance is " + account.toString(), "IIT Bank and Trust",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
			//Executed when user chooses to make a deposit
			if (num == 2)
			{
				try
				{
				inp = Integer.parseInt(JOptionPane.showInputDialog(null,  "Enter deposit amount", "IIT Bank and Trust",
						JOptionPane.QUESTION_MESSAGE));
				if (inp < 0)
				{
					JOptionPane.showMessageDialog(null,  "Your entry was negative.", "IIT Bank and Trust", JOptionPane.ERROR_MESSAGE);
					  		  System.exit(0);
				}
				}
				catch(NumberFormatException e)
			    {
				JOptionPane.showMessageDialog(null,  "Your entry was not numeric.", "IIT Bank and Trust", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
			    }
				account.deposit(inp);
				if (account.getBalance() > 100 && account.getBalance() < 500)
				{
					account.withdraw(50);
					JOptionPane.showMessageDialog(null,  "You've been fined for low balance, balance is now: " + account.toString() + ".", "IIT Bank and Trust", 
							JOptionPane.WARNING_MESSAGE);
				}
				else if (account.getBalance() < 100)
				{
					JOptionPane.showMessageDialog(null,  "Your balance may not drop below $100.", "IIT Bank and Trust", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,  "Your balance is " + account.toString(), "IIT Bank and Trust",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
			//Executed when user chooses to make a withdrawal
			if (num == 3)
			{
				try
				{
				inp = Integer.parseInt(JOptionPane.showInputDialog(null,  "Enter withdrawal amount", "IIT Bank and Trust",
						JOptionPane.QUESTION_MESSAGE));
				if (inp < 0)
				{
					JOptionPane.showMessageDialog(null,  "Your entry was negative.", "IIT Bank and Trust", JOptionPane.ERROR_MESSAGE);
					  		  System.exit(0);
				}
				}
				catch(NumberFormatException e)
			    {
				JOptionPane.showMessageDialog(null,  "Your entry was not numeric.", "IIT Bank and Trust", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
			    }
				account.withdraw(inp);
				if (account.getBalance() > 100 && account.getBalance() < 500)
				{
					account.withdraw(50);
					JOptionPane.showMessageDialog(null,  "You've been fined for low balance, balance is now: " + account.toString() + ".", "IIT Bank and Trust", 
							JOptionPane.WARNING_MESSAGE);
				}
				else if (account.getBalance() < 100)
				{
					account.deposit(inp);
					JOptionPane.showMessageDialog(null,  "Your balance may not drop below $100.", "IIT Bank and Trust", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,  "Your balance: " + account.toString(), "IIT Bank and Trust", JOptionPane.INFORMATION_MESSAGE);
				}				
			}
			
			//Executed when a user chooses to change the default interest rate
			if (num == 4)
			{
				try
				{
				inp = Integer.parseInt(JOptionPane.showInputDialog(null,  "Enter new Interst Rate as a percent value (Ex: 4 for 4%)", "IIT Bank and Trust",
						JOptionPane.QUESTION_MESSAGE));
				if (inp < 0)
				{
					JOptionPane.showMessageDialog(null,  "Your entry was negative.", "IIT Bank and Trust", JOptionPane.ERROR_MESSAGE);
					  		  System.exit(0);
				}
				}
				catch(NumberFormatException e)
			    {
				JOptionPane.showMessageDialog(null,  "Your entry was not numeric.", "IIT Bank and Trust", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
			    }
				
				account.modifyMonthlyInterest(inp/100);
				JOptionPane.showMessageDialog(null,  "Your New Interest Rate is: " + twoPlace.format(inp) + "%", "IIT Bank and Trust", 
						JOptionPane.INFORMATION_MESSAGE);
			}
			
			//Executed when a user chooses to view a 12 month balance updated with annual interest
			if (num == 5)
			{
				StringBuilder report = new StringBuilder();
				report.append("Month #           \t" + "Balance\n");
				for (int month = 1; month < 13; month++)
				{
					account.monthlyInterest();
					
					report.append("Month " + (month) + ":          \t" + account.toString() + "\n");
				}
				
				JOptionPane.showMessageDialog(null,  report+ "\n", "IIT Bank and Trust", JOptionPane.INFORMATION_MESSAGE);				
			}
			
			//Executed when a user chooses to view balance after a rate change
			if (num == 6)
			{
				account.monthlyInterest();
				JOptionPane.showMessageDialog(null,  "Your balance after updated interest rate: " + account.toString(), "IIT Bank and Trust", 
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (num == 7)
			{
				System.exit(0);
			}
		}
		// Executed when user chooses to perform other actions on the menu
		redo = JOptionPane.showConfirmDialog(null, "Go back to the Bank Menu?", "IIT Bank and Trust", JOptionPane.YES_NO_OPTION);
	}
	//Do while condition that will repeat this loop as long as the int value for redo remains 0
	while (redo==0);
	//Displays the date and name of programmer as program exits
	JOptionPane.showMessageDialog(null, "Current Date: " + timeStamp + ".\n" + 
			"Programmed by Abdullah Suhail.");
    }
}
