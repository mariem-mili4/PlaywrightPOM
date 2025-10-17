package com.qa.opencart.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Page;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;

    public Page initBrowser(Properties prop) {

        String browserName = prop.getProperty("browser");
        System.out.println(" Browser name is : " + browserName);

        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                System.out.println("Browser name is not valid");
                break;
        }
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(prop.getProperty("url"));
        return page;

    }
    public Properties initProp() throws IOException {
        FileInputStream ip = new FileInputStream("src/main/resources/config/config.properties");
        prop = new Properties();
        prop.load(ip);
        return prop;
    }


}
