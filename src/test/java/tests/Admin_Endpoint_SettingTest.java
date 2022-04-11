package tests;

import java.io.IOException;
import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Admin_AlertsPage;
import pages.Admin_ApplicationLogPage;
import pages.Admin_Endpoint_SettingPage;
import pages.Admin_UsersPage;
import pages.LoginPage;
import utility.DriverTestCase;
import utility.ExecutionLog;
import utility.PropertyReader;
import utility.QAAnnotations.TestCaseInfo;

public class Admin_Endpoint_SettingTest extends DriverTestCase {
	private static LoginPage loginPage;
	private static Admin_Endpoint_SettingPage admin_Endpoint_SettingPage;

	PropertyReader propertyReader = new PropertyReader();
	String userName = propertyReader.readProperty("username");
	String password = propertyReader.readProperty("password");

	Random random = new Random();
	int randNo = random.nextInt(100000);

	@BeforeTest
	public void initForAppLog() throws Exception {
		setup();
		loginPage = new LoginPage(getWebDriver());
		new Admin_ApplicationLogPage(getWebDriver());
		new Admin_AlertsPage(getWebDriver());
		new Admin_UsersPage(getWebDriver());
		admin_Endpoint_SettingPage = new Admin_Endpoint_SettingPage(getWebDriver());

		loginPage.loginIntoApplication(userName, password);

	}

	@Test(enabled=true,description = "C189", groups = "Functional Testing", testName = "Verify application allows to disable the File Audit ")
	public void testUserClickOnEnableButtonToDisableFileAuditOptionAndExtensions() throws Exception {

		try {
			Boolean status = true;

			admin_Endpoint_SettingPage.selectAdminEndpointsSettingMenu();
			admin_Endpoint_SettingPage.checkUncheckEnabledCheckBox(status);
			admin_Endpoint_SettingPage.clickOnSaveButton();

		} catch (Error e) {
			getScreenshot("testUserClickOnEnableButtonToDisableFileAuditOptionAndExtensions");
			ExecutionLog.logErrorMessage(e);
			throw e;
		} catch (Exception e) {
			getScreenshot("testUserClickOnEnableButtonToDisableFileAuditOptionAndExtensions");
			ExecutionLog.logExceptionMessage(e);
			throw e;
		} finally {
			try {
				ExecutionLog.log("File Audit has been enabled to disable");
			} catch (Error e) {
				ExecutionLog.logErrorMessage(e);
				throw e;
			} catch (Exception e) {
				ExecutionLog.logExceptionMessage(e);
				throw e;
			}
		}
	}
	@TestCaseInfo(testCaseID = "C4852", title = "Verify application allows to enable the 'Software Inventory' present under Administration -> Endpoints -> Settings -> Software Inventory")
    @Test(enabled=true,description="C4852",groups= {"SomkeTest"},testName="Verify application allows to enable the 'Software Inventory' present under Administration -> Endpoints -> Settings -> Software Inventory")
    public void testUserAbleToClickOnSofwareInventoryAndAbleToClickSave() throws Exception {
		try {
		admin_Endpoint_SettingPage.selectAdminEndpointsSettingMenu();
		admin_Endpoint_SettingPage.clickOnSoftwareInventory();
		admin_Endpoint_SettingPage.clickOnSaveButton();
		admin_Endpoint_SettingPage.assertChangesAreSaved();
    }catch (Error e) {
		getScreenshot("testUserNotUnabletoClickSoftwareInventory");
		ExecutionLog.logErrorMessage(e);
		throw e;
	} catch (Exception e) {
		getScreenshot("testUserUnableToClickOnSoftwareInventory");
		ExecutionLog.logExceptionMessage(e);
		throw e;
	} finally {
		try {
			ExecutionLog.log("User Unable To click On Software Inventory");
		} catch (Error e) {
			ExecutionLog.logErrorMessage(e);
			throw e;
		} catch (Exception e) {
			ExecutionLog.logExceptionMessage(e);
			throw e;
		}
	}
	}
	@TestCaseInfo(testCaseID = "4853", title = "Verify hours in 'Collect new events every (Hour)' is getting increased when click on upper arrow button if 'Software Inventory' is enabled")
    @Test(priority='0',description="C4853",groups= {"SmokeTest"},testName="")
    public void testUserAbletoIncreaseTwoHoursOfCollectNewEventsInSoftwareInventory() throws Exception {
		try {
		admin_Endpoint_SettingPage.selectAdminEndpointsSettingMenu();
		admin_Endpoint_SettingPage.clickOnSoftwareInventory();
		admin_Endpoint_SettingPage.clickOnSaveButton();
		admin_Endpoint_SettingPage.assertChangesAreSaved();
    }catch (Error e) {
		getScreenshot("testUserNotUnabletoClic");
		ExecutionLog.logErrorMessage(e);
		throw e;
	} catch (Exception e) {
		getScreenshot("testUserUnableToIncreaseTimetoTwoHours");
		ExecutionLog.logExceptionMessage(e);
		throw e;
	} finally {
		try {
			ExecutionLog.log("User Unable  to Increase Collection Events Time");
		} catch (Error e) {
			ExecutionLog.logErrorMessage(e);
			throw e;
		} catch (Exception e) {
			ExecutionLog.logExceptionMessage(e);
			throw e;
		}
	}
    }
	@AfterTest(alwaysRun = true)
	public void closeBrowser() throws Exception {
		destroyBrowser();
	}

}
