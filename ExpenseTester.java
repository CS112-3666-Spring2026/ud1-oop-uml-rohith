/**
 * Expense Tester class that tests all required methods for the Expense Class.
 *
 * @author Rohith Mekala
 * @version 1.0
 */
public class ExpenseTester {
    public static void main(String[] args) {
        // Test 1: Default Constructor and Getters
        Expense defaultExpense = new Expense();
        System.out.println("Test 1 (Defaults): " + (defaultExpense.getAmount() == Expense.DEFAULT_AMOUNT
                && defaultExpense.getIsTaxDeductible() == Expense.DEFAULT_IS_TAX_DEDUCTIBLE ? "Pass" : "Fail"));

        // Test 2: Full Constructor and Setter Validation
        Expense customExpense = new Expense("Textbook", 120.50, "Education", true);
        System.out
                .println("Test 2 (Full Constructor Value): " + (customExpense.getAmount() == 120.50 ? "Pass" : "Fail"));
        System.out.println("Test 2 (Full Constructor String): "
                + (customExpense.getDescription().equals("Textbook") ? "Pass" : "Fail"));

        // Test 3: Setters and Invalid Data Check
        boolean invalidAmtResult = customExpense.setAmount(-50.0); // Should fail validation because amount is negative
        System.out.println("Test 3 (Validation Rejection): " +
                (!invalidAmtResult ? "Pass" : "Fail"));
        System.out.println("Test 3 (Retains Original Value after Invalid Value Fails): " +
                (customExpense.getAmount() == 120.50 ? "Pass" : "Fail"));

        // Test 4: Copy Constructor / Deep Copy Check
        Expense copiedEx = new Expense(customExpense);
        System.out.println("Test 4 (Copy Match): " +
                (copiedEx.equals(customExpense) ? "Pass" : "Fail"));

        copiedEx.setIsTaxDeductible(false); // Change copy instance
        System.out.println("Test 4 (Deep Copy Isolation): " +
                (customExpense.getIsTaxDeductible() != copiedEx.getIsTaxDeductible() ? "Pass" : "Fail"));

        // Test 5: Equals Method Comparison
        Expense identicalEx = new Expense("Textbook", 120.50, "Education", true);
        System.out.println("Test 5 (Structural Equality): " +
                (customExpense.equals(identicalEx) ? "Pass" : "Fail"));
    }
}
