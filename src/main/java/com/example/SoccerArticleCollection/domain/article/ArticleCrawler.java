package com.example.SoccerArticleCollection.domain.article;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class ArticleCrawler {
    private WebDriver driver;

    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "/Users/imjongho/Downloads/chromedriver";

    //크롤링 할 URL
    private String base_url;

    public ArticleCrawler() {
        super();

        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        //Driver SetUp
        driver = new ChromeDriver();

    }

    public List<Article> crawlBBCArticleByMatch() {
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            base_url = "https://www.bbc.com/sport/football/premier-league";
            driver.get(base_url);
            System.out.println(driver.getPageSource());
            WebElement elements = driver.findElement(By.cssSelector("div.sp-c-cluster"));

            List<WebElement> div = elements.findElements(By.cssSelector("div.gel-layout__item"));
            List<Article> articles = new ArrayList<>();
            for (WebElement webElement : div) {
                String attribute = webElement.findElement(By.tagName("a")).getAttribute("href");
                String a = webElement.findElement(By.tagName("a")).getText();
                articles.add(new Article(a,attribute, ArticleType.BBC));

            }

            driver.close();

            return articles;
        } catch (Exception e) {
            e.printStackTrace();
            driver.close();
            throw new WebDriverException();
        }
    }
}
