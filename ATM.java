/**
 * Abdullah Suhail
 * 01/26/17
 * ATM.java
 * Lab 01
 * The ATM class simulates am ATM machine.
*/

public class ATM
{
   private double balance;      // Account balance
   
   private static double annualInterestRate = .04; // Account Interest Rate

   /**
      This constructor sets the starting balance
      at 0.0.
   */

   public ATM()
   {
      balance = 0.0;
   }
   
   /**
      This constructor sets the starting balance
      to the value passed as an argument.
      @param startBalance The starting balance.
   */

   public ATM(double startBalance)
   {
      balance = startBalance;
   }

   /**
      This constructor sets the starting balance
      to the value in the String argument.
      @param str The starting balance, as a String.
   */

   public ATM(String str)
   {
      balance = Double.parseDouble(str);
   }

   /**
      The deposit method makes a deposit into
      the account.
      @param amount The amount to add to the
                    balance field.
   */

   public void deposit(double amount)
   {
      balance += amount;
   }

   /**
      The deposit method makes a deposit into
      the account.
      @param str The amount to add to the
                 balance field, as a String.
   */

   public void deposit(String str)
   {
      balance += Double.parseDouble(str);
   }

   /**
      The withdraw method withdraws an amount
      from the account.
      @param amount The amount to subtract from
                    the balance field.
   */

   public void withdraw(double amount)
   {
      balance -= amount;
   }

   /**
      The withdraw method withdraws an amount
      from the account.
      @param str The amount to subtract from
                 the balance field, as a String.
   */

   public void withdraw(String str)
   {
      balance -= Double.parseDouble(str);
   }
   
   /**
    * The monthlyInterest method adds a small amount to the balance
    * which is the balance itself multiplied by the monthly interest rate
    */
   
   public void monthlyInterest()
   {
	   balance += balance * (annualInterestRate / 12.0);
   }
   
   /**
    * This modify method alters the Interest Rate with a user inputted value
    * @param rateUpdate The amount that updates the Interest Rate variable
    */
   
   public static void modifyMonthlyInterest(double rateUpdate)
   {
	   annualInterestRate = rateUpdate;
   }
   
   /**
    * This modify method alters the Interest Rate with a user inputted value
    * @param strRateUpdate The amount that updates the Interest Rate variable,
    * 					   as a string
    */
   
   public static void modifyMonthlyInterest(String strRateUpdate)
   {
	   annualInterestRate = Double.parseDouble(strRateUpdate);
   }
   
   
   /**
    * This method returns the balance as a string with two decimal places
    */
   
   public String toString()
   {
	   return String.format("$%.2f", balance);
   }
   
 
   /**
      The setBalance method sets the account balance.
      @param b The value to store in the balance field.
   */

   public void setBalance(double b)
   {
      balance = b;
   }

   /**
      The setBalance method sets the account balance.
      @param str The value, as a String, to store in
                 the balance field.
   */

   public void setBalance(String str)
   {
      balance = Double.parseDouble(str);
   }
   
   /**
      The getBalance method returns the
      account balance.
      @return The value in the balance field.
   */

   public double getBalance()
   {
      return balance;
   }
}