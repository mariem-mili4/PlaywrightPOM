package com.qa.opencart.tests;

import com.microsoft.playwright.Page;
import com.qa.opencart.base.TestBase;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {



    @Test
    public void homePageTitleTest(){
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppConstants.Login_PAGE_TITLE);
    }
    @Test
    public void homePageURLTest(){
        String actualURL = homePage.getHomePageURL();
        Assert.assertEquals(actualURL,"https://naveenautomationlabs.com/opencart/");
    }

    @DataProvider
    public Object[][] getProductData(){
        return new Object[][]{
                {"Macbook"},
                {"iMac"},
                {"Samsung"}
        };
    }
    @Test(dataProvider = "getProductData")
    public void searchProductTest(String productName){
        String actualTitle = homePage.searchProduct(productName);
        Assert.assertEquals(actualTitle,"Search - "+ productName);
    }



}
