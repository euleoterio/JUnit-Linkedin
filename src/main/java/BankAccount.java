public class BankAccount {

    public double balance;
    public double minimumBalance;
    public boolean isActive = true;
    public String holderName;

    public BankAccount() {
    }

    public BankAccount(double balance, double minimumBalance) {
        this.balance = balance;
        this.minimumBalance = minimumBalance;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double withdraw(double amount) {
        if(balance - amount > minimumBalance) {
            balance -= amount;
            return amount;
        } else {
            throw  new RuntimeException();
        }
    }

    public double deposit(double amount) {
        return balance += amount;
    }


}
