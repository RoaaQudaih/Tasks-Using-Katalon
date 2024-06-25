package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object URL
     
    /**
     * <p></p>
     */
    public static Object QTY
     
    /**
     * <p></p>
     */
    public static Object productName
     
    /**
     * <p></p>
     */
    public static Object cartURL
     
    /**
     * <p></p>
     */
    public static Object itemNumber
     
    /**
     * <p></p>
     */
    public static Object secondProductName
     
    /**
     * <p></p>
     */
    public static Object min
     
    /**
     * <p></p>
     */
    public static Object max
     
    /**
     * <p></p>
     */
    public static Object timeOut
     
    /**
     * <p></p>
     */
    public static Object productIndex
     
    /**
     * <p></p>
     */
    public static Object numberOfProductInPage
     
    /**
     * <p></p>
     */
    public static Object quickOrderURL
     
    /**
     * <p></p>
     */
    public static Object searchTerm
     
    /**
     * <p></p>
     */
    public static Object otherSearchTerm
     
    /**
     * <p></p>
     */
    public static Object numberOfAddedProducts
     
    /**
     * <p></p>
     */
    public static Object lastProductAddedIndex
     
    /**
     * <p></p>
     */
    public static Object orderSummaryInCart
     
    /**
     * <p></p>
     */
    public static Object orderSummaryInQuickOrderPage
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters(), selectedVariables)
    
            URL = selectedVariables['URL']
            QTY = selectedVariables['QTY']
            productName = selectedVariables['productName']
            cartURL = selectedVariables['cartURL']
            itemNumber = selectedVariables['itemNumber']
            secondProductName = selectedVariables['secondProductName']
            min = selectedVariables['min']
            max = selectedVariables['max']
            timeOut = selectedVariables['timeOut']
            productIndex = selectedVariables['productIndex']
            numberOfProductInPage = selectedVariables['numberOfProductInPage']
            quickOrderURL = selectedVariables['quickOrderURL']
            searchTerm = selectedVariables['searchTerm']
            otherSearchTerm = selectedVariables['otherSearchTerm']
            numberOfAddedProducts = selectedVariables['numberOfAddedProducts']
            lastProductAddedIndex = selectedVariables['lastProductAddedIndex']
            orderSummaryInCart = selectedVariables['orderSummaryInCart']
            orderSummaryInQuickOrderPage = selectedVariables['orderSummaryInQuickOrderPage']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
