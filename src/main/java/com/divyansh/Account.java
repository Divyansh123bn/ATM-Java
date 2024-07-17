package com.divyansh;
import java.text.DecimalFormat;
import java.util.*;

public class Account {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    Scanner scan=new Scanner(System.in);
    DecimalFormat moneyFormat =new DecimalFormat("'Rs.'##,##0.00");

    public Account(){
    }

    public Account(int customerNumber,int pinNumber){
        this.customerNumber=customerNumber;
        this.pinNumber=pinNumber;
    }

    public Account(int customerNumber,int pinNumber,double checkingBalance,double savingBalance){
        this.customerNumber=customerNumber;
        this.pinNumber=pinNumber;
        this.checkingBalance=checkingBalance;
        this.savingBalance=savingBalance;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public double calcCheckingWithdraw(double amount){
        checkingBalance=(checkingBalance-amount);
        return checkingBalance;
    }

    public double calcSavingWithdraw(double amount){
        savingBalance=(savingBalance-amount);
        return savingBalance;
    }

    public double calcCheckingDeposit(double amount){
        checkingBalance=(checkingBalance+amount);
        return checkingBalance;
    }

    public double calcSavingDeposit(double amount){
        savingBalance=(savingBalance+amount);
        return savingBalance;
    }

    public void calcCheckTransfer(double amount){
        checkingBalance = checkingBalance - amount;
        savingBalance = savingBalance + amount;
    }

    public void calcSavingTransfer(double amount){
        savingBalance=savingBalance-amount;
        checkingBalance=checkingBalance+amount;
    }

    public void getCheckingWithdrawInput(){
        boolean end=false;
        while(!end){
            try{
                System.out.println("Current Checking Amount Balance:" + moneyFormat.format(checkingBalance));
                System.out.println("Enter Amount you want to withdraw:");
                double amount=scan.nextDouble();
                if((checkingBalance - amount)>=0 && amount>=0){
                    calcCheckingWithdraw(amount);
                    System.out.println(" Your Current Checking Amount Balance:"+moneyFormat.format(checkingBalance));
                    end=true;
                }
                else{
                    System.out.println("Balance cannot be negative.");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid choice.");
                scan.next();
            }
        }
    }

    public void getSavingWithdrawInput(){
        boolean end=false;
        while(!end){
            try {
                System.out.println("Current Saving Account Balance:"+moneyFormat.format(savingBalance));
                System.out.println("Enter Amount to withdraw:");
                double amount=scan.nextDouble();
                if ((savingBalance - amount) >= 0 && amount >= 0) {
                    calcSavingWithdraw(amount);
                    System.out.println("Your Current Saving Account Balance:" + moneyFormat.format(savingBalance));
                } else {
                    System.out.println("Balance cannot be negative.");
                    end = true;
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid Input.");
                scan.next();
            }
        }
    }

    public void getCheckingDepositInput() {
        boolean end = false;
        while (!end){
            try {
                System.out.println("Current Checking Account Balance:" + moneyFormat.format(checkingBalance));
                System.out.println("Enter Amount to Deposit:");
                double amount = scan.nextDouble();
                if((checkingBalance+amount)>=0 && amount>=0){
                    calcCheckingDeposit(amount);
                    System.out.println("Current Checking Account Balance:"+moneyFormat.format(checkingBalance));
                    end=true;
                }
                else{
                    System.out.println("Balance cannot be Negative.");
                }
                }catch(InputMismatchException e){
                System.out.println("Invalid Input.");
                scan.next();
            }
        }
    }

    public void getSavingDepositInput(){
        boolean end=false;
        while(!end){
            try {
                System.out.println("Current Saving Account Balance:"+moneyFormat.format(savingBalance));
                System.out.println("Enter Amount to be Deposited:");
                double amount =scan.nextDouble();
                if((savingBalance+amount)>=0 && amount>=0){
                    calcSavingDeposit(amount);
                    System.out.println("Current Amount Balance:"+moneyFormat.format(savingBalance));
                    end=true;
                }
                else{
                    System.out.println("Balance cannot be Negative.");
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid Input.");
                scan.next();
            }
        }
    }

    public void getTransferInput(String accType){
        boolean end=false;
        while(!end){
            try {
                if (accType.equals("Checkings")) {
                    System.out.println("Select an Account you want to Transfer funds to:");
                    System.out.println("1.Savings.");
                    System.out.println("2.Exit.");
                    System.out.println("Enter Choice:");
                    int choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            try {
                                System.out.println("Current Checking Account Balance:" + moneyFormat.format(checkingBalance));
                                System.out.println("Enter Amount to Transfer from Saving to Checking:");
                                double amount = scan.nextDouble();
                                if ((checkingBalance + amount) >= 0 && (savingBalance - amount) >= 0 && amount >= 0) {
                                    calcCheckTransfer(amount);
                                    System.out.println("Current Checking Account Balance:" + moneyFormat.format(checkingBalance));
                                    System.out.println("Current Saving Account Balance:" + moneyFormat.format(savingBalance));
                                    end = true;
                                } else {
                                    System.out.println("Balance cannot be Negative.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Input.");
                                scan.next();
                            }
                        case 2:
                            return;

                        default:
                            System.out.println("Invalid Input.");
                            scan.next();
                    }
                } else if (accType.equals("Savings")) {
                    System.out.println("Select an Account you want to Transfer funds to:");
                    System.out.println("1.Checkings.");
                    System.out.println("2.Exit.");
                    System.out.println("Enter Choice:");
                    int choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            try {
                                System.out.println("Current Saving Account Balance:" + moneyFormat.format(savingBalance));
                                System.out.println("Enter Amount to Transfer from Checking to Saving:");
                                double amount = scan.nextDouble();
                                if ((checkingBalance + amount) >= 0 && (savingBalance - amount) >= 0 && amount >= 0) {
                                    calcSavingTransfer(amount);
                                    System.out.println("Current Checking Account Balance:" + moneyFormat.format(checkingBalance));
                                    System.out.println("Current Saving Account Balance:" + moneyFormat.format(savingBalance));
                                    end = true;
                                } else {
                                    System.out.println("Balance cannot be Negative.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Input.");
                                scan.next();
                            }
                        case 2:
                            return;

                        default:
                            System.out.println("Invalid Input.");
                            scan.next();
                    }
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid Input.");
                scan.next();
            }
        }
    }

}
