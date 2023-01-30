import java.util.Scanner;

public class Atm{
    String name;
    String userName;
    String password;
    String accountNo;
    double balance = 1000000;
    int transactions = 0;
    String transactionHistory = "";

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        this.name = sc.nextLine();
        System.out.println("\nEnter Username: ");
        this.userName = sc.nextLine();
        System.out.println("\nEnter the Password: ");
        this.password = sc.nextLine();
        System.out.println("\nEnter your Account Number: ");
        this.accountNo = sc.nextLine();
        System.out.println("\nRegistration completed successfully! Kindly login to your account.");
    }
 
         // User Login
        public boolean login() {
            boolean isLogin = false;
            Scanner sc = new Scanner(System.in);
            while (!isLogin) {
                System.out.print("\nEnter Username: ");
                String username = sc.nextLine();
                if (username.equals(userName)) {
                    while (!isLogin) {
                        System.out.print("\nEnter Your Password: ");
                        String Password = sc.nextLine();
                        if (Password.equals(password)) {
                            System.out.println("\nLogin successful!");
                            isLogin = true;
                        } else
                            System.out.println("\nIncorrect Password");
                    }
                }
                    else
                    System.out.println("\nUsername not found");
                }
                return true;
            }
                     // withdraw money
            public void withdraw () {
                System.out.println("\nEnter the amount to be withdrawn : ");
                Scanner sc = new Scanner(System.in);
                double amount = sc.nextDouble();
                try {
                    if (balance > amount) {
                  balance -= amount;
                        System.out.println("\nWithdrawal successful");
                        String str = "Rs " + amount + " withdrawn\n";
                        transactionHistory = transactionHistory.concat(str);
                    } else
                        System.out.println("\nInsufficient Balance.");
                } catch (Exception ignored) {
                }
            }
                      // Deposit
            public void deposit () {
                System.out.println("\nEnter amount to deposit : ");
                Scanner sc = new Scanner(System.in);
                double amount = sc.nextDouble();
                try {
                    if (amount <= 100000.00) {
                        transactions++;
                        balance += amount;
                        System.out.println("\nDeposit successful!");
                        String str = "Rs " + amount + " deposited\n";
                        transactionHistory = transactionHistory.concat(str);
                    } else
                        System.out.println("\nLimit Exceeded!");
                } catch (Exception ignored) {
                }
            }
                //Transfer
                public void transfer() {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("\nEnter recipient name: ");
                    String recipient = sc.nextLine();
                    System.out.println("\nEnter recipient's account number: ");
                    String accountNo = sc.nextLine();
                    System.out.println("\nEnter amount to be transferred :");
                    double amount = sc.nextDouble();
                    try {
                        if (balance >= amount) {
                            if (amount <= 50000.00) {
                                transactions++;
                                balance -= amount;
                                System.out.println("\nSuccessfully transferred to " + recipient);
                                String str = "Rs" + amount + " transferred to account number: " + accountNo + "\n";
                                transactionHistory = transactionHistory.concat(str);
                            } else
                                System.out.println("\nsorry! Limit is is 50000.00");
                        } else
                            System.out.println("\nInsufficient Balance.");
                    } catch (Exception ignored) {
                    }
                }
                public void checkBalance () {
                    System.out.println("\nRs" + balance);
                }
                        // transaction history
                public void transHistory () {
                    if (transactions == 0)
                        System.out.println("\nEmpty!");
                    else
                        System.out.println("\n" + transactionHistory);
                }
            }
                             //Interface of ATM
            class Atm_Transaction{
                    public static int takeInput(int lmt) {
                int input = 0;
                boolean flag = false;
                        while(!flag){
                    try{
                            Scanner sc = new Scanner(System.in);
                            input=sc.nextInt() ;
                    flag = true;
                    if (input > lmt || input < 1 ){
                        System.out.println("Select the number between 1 to " + lmt);
                    flag = false;
                    }
                }
                        catch(Exception e){
                            System.out.println("Enter integer value only ");
                            flag = false;
                        }
                }return input;
            }

                                  // main method
             public static void main(String[] args)
            {

                System.out.println("\n WELCOME TO ATM \n");

                System.out.println("1. Register \n2.Exit");

                System.out.print("Enter your choice: ");

                int choice = takeInput(2);

                if (choice == 1) {

                    Atm b = new Atm();
                    b.register();
                    while (true) {

                        System.out.println("\n1.Login\n2.Exit");

                        System.out.print("Enter your choice: ");
                        int ch = takeInput(2);

                        if (ch == 1) {
                            if (b.login()) {

                                System.out.println("\n\nWELCOME BACK! " + b.name + "\n\n");

                                boolean isFinished = false;
                                while (!isFinished) {

                                    System.out.println("\n1.Deposit\n2.withdraw\n3.Transfer\n4.Transaction History\n5.Check Balance");
                                    System.out.print("Enter your choice: ");

                                    int c = takeInput(6);
                                    switch (c) {
                                        case 1: 
                                        { b.deposit();}
                                        case 2: 
                                        { b.withdraw();}
                                        case 3: 
                                        { b.transfer();}
                                        case 4: 
                                        { b.transHistory();}
                                        case 5: 
                                        { b.checkBalance();}
                                        case 6: 
                                        { isFinished = true;}
                                        default: 
                                        { System.out.println("\nwrong choice!");}
                                    }
                                }
                            }
                    } else

                        System.exit(0);
             }
        }
    }    
            
}  
