/**
 * Created with IntelliJ IDEA.
 * User: Orif
 * Date: 12/17/12
 * Time: 1:21 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.Date;
import java.util.List;

public class CreditCardApp {
    public static void main(String[] args) {
        IPersistenceProvider persistenceProvider = new PersistenceProvider();
        IMessagingProvider messagingProvider = new EmailProvider();
        IRuleFactory ruleFactory = new RuleFactory();

        CreditCardProvider cardProvider = new CreditCardProvider(persistenceProvider, messagingProvider, ruleFactory);

        CompanyCustomer companyCustomer = new CompanyCustomer("MUM", cardProvider);
        companyCustomer.setAddress(new Address("1000 North 4th Street", "Fairfield", "Iowa", 52557));
        companyCustomer.setEmployeeCount(100);

        CreditCardAccount companyAccount = new CreditCardAccount(companyCustomer, CreditCardLabel.Gold);
        companyCustomer.addAccount(companyAccount);

        PersonCustomer personCustomer = new PersonCustomer("Orifjon Turabaev", cardProvider);
        personCustomer.setAddress(new Address("1000 North 4th Street", "Fairfield", "Iowa", 52557));
        personCustomer.setBirthDate(new Date());

        CreditCardAccount personAccount = new CreditCardAccount(personCustomer, CreditCardLabel.Silver);
        personCustomer.addAccount(personAccount);

        cardProvider.addCustomer(companyCustomer);
        cardProvider.addCustomer(personCustomer);

        companyAccount.addTransaction(new DepositTransaction(companyAccount, 400));
        companyAccount.addTransaction(new WithdrawalTransaction(companyAccount, 300));
        companyAccount.addTransaction(new DepositTransaction(companyAccount, 600));

        System.out.println("Current balance: " + companyAccount.getBalance());

        personAccount.addTransaction(new DepositTransaction(personAccount, 400));

        System.out.println("Transactions list for company account:");
        List<ITransaction> transactions = companyAccount.getTransactions(Specification.Any);
        for (ITransaction transaction : transactions) {
            System.out.println("Transaction: " + transaction + "\t amount: " + transaction.getAmount());
        }
    }
}
