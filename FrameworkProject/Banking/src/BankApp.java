/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/16/12
 * Time: 7:00 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.Date;
import java.util.List;
import java.util.Vector;

public class BankApp {
    public static void main(String[] args) {
        IPersistenceProvider persistenceProvider = new PersistenceProvider();
        IMessagingProvider messagingProvider = new EmailProvider();
        IRuleFactory ruleFactory = new RuleFactory();

        // NOTE: rules
        List<IRule> rules = new Vector<IRule>();
        rules.add(
                new EmailRule(
                        RuleOrder.Before,
                        new Specification<DepositTransaction>() {
                            @Override
                            public boolean isSatisfiedBy(DepositTransaction transaction) {
                                return (transaction.getCustomer() instanceof PersonCustomer
                                        && transaction.getAmount() > 500);                            }
                        },
                        "Deposit amount is more than 500",
                        messagingProvider));
        rules.add(
                new EmailRule(
                        RuleOrder.After,
                        new Specification<DepositTransaction>() {
                            @Override
                            public boolean isSatisfiedBy(DepositTransaction transaction) {
                                if (transaction.getCustomer() instanceof PersonCustomer) {
                                    List<ITransaction> transactions = new Vector<ITransaction>(transaction.getAccount().getTransactions(Specification.Any));
                                    transactions.add(transaction);
                                    if (FinancialAccount.tryGetBalance(transactions) < 0)
                                        return true;
                                }

                                return false;
                            }
                        },
                        "Account balance is still negative. Please fill it as soon as possible.",
                        messagingProvider));
        rules.add(
                new EmailRule(
                        RuleOrder.After,
                        new Specification<DepositTransaction>() {
                            @Override
                            public boolean isSatisfiedBy(DepositTransaction transaction) {
                                return (transaction.getCustomer() instanceof CompanyCustomer);
                            }
                        },
                        "Deposit successfully performed.",
                        messagingProvider));

        ruleFactory.add(DepositTransaction.class, rules);

        rules = new Vector<IRule>();
        rules.add(
                new EmailRule(
                        RuleOrder.Before,
                        new Specification<WithdrawalTransaction>() {
                            @Override
                            public boolean isSatisfiedBy(WithdrawalTransaction transaction) {
                                return (transaction.getCustomer() instanceof PersonCustomer
                                        && transaction.getAmount() > 500);
                            }
                        },
                        "Withdrawal amount is more than 500",
                        messagingProvider));
        rules.add(
                new EmailRule(
                        RuleOrder.After,
                        new Specification<WithdrawalTransaction>() {
                            @Override
                            public boolean isSatisfiedBy(WithdrawalTransaction transaction) {
                                if (transaction.getCustomer() instanceof PersonCustomer) {
                                    List<ITransaction> transactions = new Vector<ITransaction>(transaction.getAccount().getTransactions(Specification.Any));
                                    transactions.add(transaction);
                                    if (FinancialAccount.tryGetBalance(transactions) < 0)
                                        return true;
                                }

                                return false;
                            }
                        },
                        "Account balance has became negative. Please fill it as soon as possible.",
                        messagingProvider));
        rules.add(
                new EmailRule(
                        RuleOrder.After,
                        new Specification<WithdrawalTransaction>() {
                            @Override
                            public boolean isSatisfiedBy(WithdrawalTransaction transaction) {
                                return (transaction.getCustomer() instanceof CompanyCustomer);
                            }
                        },
                        "Withdrawal successfully performed.",
                        messagingProvider));

        ruleFactory.add(WithdrawalTransaction.class, rules);
        Bank bank = new Bank(persistenceProvider, messagingProvider, ruleFactory);

        /////////////////////////////////////////////////////////////////////////////

        CompanyCustomer companyCustomer = new CompanyCustomer("MUM", bank);
        companyCustomer.setAddress(new Address("1000 North 4th Street", "Fairfield", "Iowa", 52557));
        companyCustomer.setEmployeeCount(100);

        SavingAccount companyAccount = new SavingAccount(companyCustomer);
        companyCustomer.addAccount(companyAccount);

        PersonCustomer personCustomer = new PersonCustomer("Orifjon Turabaev", bank);
        personCustomer.setAddress(new Address("1000 North 4th Street", "Fairfield", "Iowa", 52557));
        personCustomer.setBirthDate(new Date());

        CheckingAccount personAccount = new CheckingAccount(personCustomer);
        personCustomer.addAccount(personAccount);

        bank.addCustomer(companyCustomer);
        bank.addCustomer(personCustomer);

        companyAccount.addTransaction(new DepositTransaction(companyAccount, 400));
        companyAccount.addTransaction(new WithdrawalTransaction(companyAccount, 300));
        companyAccount.addTransaction(new DepositTransaction(companyAccount, 600));

        System.out.println("Current balance: " + companyAccount.getBalance());

        personAccount.addTransaction(new DepositTransaction(personAccount, 400));
        personAccount.addTransaction(new WithdrawalTransaction(personAccount, 600));
        System.out.println("Current balance of Orif: " + personAccount.getBalance());

        bank.setCommonInterest(0.1);
        System.out.println("Current balance of MUM with interest: " + companyAccount.getBalance());

        System.out.println("Transactions list for company account:");
        List<ITransaction> transactions = companyAccount.getTransactions(Specification.Any);
        for (ITransaction transaction : transactions) {
            System.out.println("Transaction: " + transaction + "\t amount: " + transaction.getAmount());
        }
    }
}
