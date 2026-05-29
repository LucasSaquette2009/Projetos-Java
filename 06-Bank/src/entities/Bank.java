package entities;

import entitiesEnums.BankStatus;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private BankStatus status;
    private final List<Account> accountList = new ArrayList<>();

    //Constructors
    public Bank() {
    }

    //Getters and Setters
    public List<Account> getAccountList() {
        return accountList;
    }

    public BankStatus getStatus() {
        return status;
    }

    public void setStatus(BankStatus status) {
        this.status = status;
    }

    //Methods
    public void addAccount(Account account) {
        accountList.add(account);
    }

    public boolean removeAccount(int id) {
        for (Account c : accountList) {
            if (id == c.getId()) {
                accountList.remove(c);
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        if (accountList.isEmpty()) {
            return true;
        }
        return false;
    }

    public void renameAccount(int id, String newName) {
        for (Account c : accountList) {
            if (id == c.getId()) {
                c.setName(newName);
                return;
            }
        }
    }

    public void addBalance(int id, double balance) {
        for (Account c : accountList) {
            if (id == c.getId()) {
                Double newBalance = c.getBalance() + balance;
                c.setBalance(newBalance);
                return;
            }
        }
    }

    public boolean removeBalance(int id, double balance) {
        for (Account c : accountList) {
            if (id == c.getId()) {
                if (balance <= c.getBalance()) {
                    Double newBalance = c.getBalance() - balance;
                    c.setBalance(newBalance);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean transferBalance(int idTransfer, int idReceive, double balance) {
        if (removeBalance(idTransfer, balance)) {
            addBalance(idReceive, balance);
            return true;
        }
        return false;
    }

    public boolean idExist(int id) {
        for (Account c : accountList) {
            if (id == c.getId()) {
                return true;
            }
        }
        return false;
    }

    public Integer positionId(int id) {
        for (int i = 0; i < accountList.size(); i++) {
            if (id == accountList.get(i).getId()) {
                return i;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("ACCOUNTS:\n");
        for (Account c : accountList) {
            sb.append(c);
        }

        return sb.toString();
    }

}
