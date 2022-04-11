package locators;

public class Admin_Endpoint_SettingLocators {

    public final static String enableCheckbox = "//label[text()='Enabled']/../input";
    public static final String fileAudit = "//span[text()='File Audit']";
    public static final String fileExtension = "//span[text()='File Extensions']";
    public static final String addNewExtensionBtn = "//*[@title='Add New Extension']";
    public static final String enterExtension = "//*[@title='Add New Extension']/../../input";
    public static final String deleteExtension = "//div[text()='@override']/following-sibling::button/i[@title='Delete']";
    public static final String tabsName = "//li[contains(@class, 'tabstrip')]/span[text()='@override']";
    public static final String saveBtn = "//button[text()='Save']";
    public static final String savedConfirmation = "//div[@class='alert alert-success' and text()='Saved']";
    public static final String softwareInventory ="//span[text()='Software Inventory']";
    public static final String CollectNewUpArrow="//span[@class='k-icon k-i-arrow-n']";
    public static final String CollectNewDownArrow="//span[@class='k-link k-link-decrease']";
    public static final String CollectNewEventsValue="//input[@class='k-input k-formatted-value']";
    
}
