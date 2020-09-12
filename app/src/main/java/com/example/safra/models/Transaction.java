package com.example.safra.models;

public class Transaction {
    private int destinationAccount;
    private int destinationAmount;
    private int destinationBank;
    private int idOrigin;
    private String destinationDescription;
    private User user;

    public Transaction(int destinationAccount, int destinationAmount, int destinationBank, int idOrigin, String destinationDescription, User user) {
        this.destinationAccount = destinationAccount;
        this.destinationAmount = destinationAmount;
        this.destinationBank = destinationBank;
        this.idOrigin = idOrigin;
        this.destinationDescription = destinationDescription;
        this.user = user;
    }

    private void checkTransaction(){

    }

    private boolean destinyExists(){
        //Check if the destination account really exists
        return true;
    }

    private boolean hasBalance(){
        //Check if the user can make this transaction withe the balance/limit available
        return user.getAccount().getBalance() - destinationAmount <= user.getAccount().getBalance() + user.getAccount().getLimit();
    }

    public void makeTransaction() throws Exception{
        if (destinyExists()){
            if (hasBalance()){
                user.getAccount().setBalance(user.getAccount().getBalance() - destinationAmount);
            }
            else{
                throw new Exception("There's not enough money and limit on the account");
            }
        }
        else{
            throw new Exception("The destiny account doesn't exists");
        }
    }
}
