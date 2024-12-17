import java.util.Scanner;
class BankDetails{
    private String bankName;
    private String accountNumber;
    private String accountType;
    private long accountBalance;

    Scanner sc = new Scanner(System.in);

    //method to open new account
    public void openAcc(){
        System.out.println("Enter Bank Name: ");
        bankName = sc.next();
        System.out.println("Enter Account Number: ");
        accountNumber = sc.next();
        System.out.println("Enter Account Type: ");
        accountType = sc.next();
        System.out.println("Enter Account Balance: ");
        accountBalance = sc.nextLong();
    }
    //method to display account details
    public void showAcc(){
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Balance: " + accountBalance);
        System.out.print("\n");

    }

    //method to deposit money
    public void accDeposit(){
        System.out.println("Enter Deposit Amount: ");
        long depositAmount = sc.nextLong();
        accountBalance += depositAmount;
    }

    //method to withdraw money
    public void accWithdrawal(){
        System.out.println("Enter Withdrawal Amount: ");
        long withdrawalAmount = sc.nextLong();
        if(withdrawalAmount > accountBalance){
            accountBalance -= withdrawalAmount;
        } else {
            System.out.println("Your account balance has insufficient funds");
        }
    }

    //method to search an account number
    public boolean search(String accN){
        if(accountNumber.equals(accN)){
            showAcc();
            return true;
        } else {
            return false;
        }
    }
}

public class BankingApp {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        //create initial accounts
        System.out.print("How many customers do you want to input? ");
        int n = sc.nextInt();
        BankDetails C[] = new BankDetails[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new BankDetails();
            C[i].openAcc();
        }
        // loop runs until number 5 is not pressed to exit
        int ch;
        do {
            System.out.println("\n ***Banking System Application***");
            System.out.println("1. Display all account details \n 2. Search by Account number\n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Exit ");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    for (int i = 0; i < C.length; i++) {
                        C[i].showAcc();
                    }
                    break;
                case 2:
                    System.out.print("Enter account no. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].accDeposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account No : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].accWithdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 5:
                    System.out.println("See you soon...");
                    break;
            }
        }
        while (ch != 5);
    }
}
