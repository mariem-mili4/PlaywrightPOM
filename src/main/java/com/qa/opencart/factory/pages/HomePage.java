package com.qa.opencart.factory.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    Page page;
    //1. String Locators
    private String search ="input[name='search']";
    private String searchIcon ="div#search button";
    private String searchPageHeader = "div#content h1";

    //2. Page constructor
    public HomePage(Page page) {
        this.page = page;
    }
    //3. page actions/methods
    public String getHomePageTitle(){
        String title = page.title();
        System.out.println("Page title is : " + title);
        return title;
    }
    public String getHomePageURL (){
        String url = page.url();
        System.out.println("Page URL is : " + url);
        return page.url();
    }
    public String searchProduct(String productName){
        page.fill(search, productName);
        page.click(searchIcon);
        String header = page.textContent(searchPageHeader);
        System.out.println("Product header is : " + header);
        return header;

    }



}
