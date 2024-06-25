package navigations

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class navigation {
	public static void openBrowser() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
	}
	public static void navigateToNeededPage(String URL) {
		WebUI.navigateToUrl(URL)
	}
	public static void closeBrowser() {
		WebUI.closeBrowser()
	}
}
