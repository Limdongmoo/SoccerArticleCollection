package com.example.SoccerArticleCollection.domain.player;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class PlayerCrawler {
    private WebDriver driver;

    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "/Users/imjongho/Downloads/chromedriver";

    private String base_url;

    public PlayerCrawler() {
        super();

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        this.driver = new ChromeDriver();
    }

    public List<TopPlayer> scoreRankCrawler() {
        try {
            base_url = "https://www.bbc.com/sport/football/premier-league/top-scorers";

            driver.get(base_url);
            System.out.println(driver.getPageSource());

            WebElement element = driver.findElement(By.className("gel-long-primer"));
            List<WebElement> tr = element.findElements(By.tagName("tr"));
            List<TopPlayer> goalRanking = new ArrayList<>();
            for (WebElement webElement : tr) {
                List<WebElement> td = webElement.findElements(By.tagName("td"));
                String[] split = td.get(1).getText().split("\n");
                String name = split[0];
                String team = split[2];

                TopPlayer build = TopPlayer.GoalRankingBuilder()
                        .name(name)
                        .team(team)
                        .ranking(parseInt(td.get(0).getText()))
                        .goals(parseInt(td.get(2).getText()))
                        .assists(parseInt(td.get(3).getText()))
                        .played(parseInt(td.get(4).getText()))
                        .goalsPer90(Double.parseDouble(td.get(5).getText()))
                        .minsPerGoal(parseInt(td.get(6).getText()))
                        .totalShots(parseInt(td.get(7).getText()))
                        .goalConversion(td.get(8).getText())
                        .shotAccuracy(td.get(9).getText()).build();

                goalRanking.add(build);
            }

            driver.close();
            return goalRanking;
        } catch (Exception e) {
            driver.close();
            e.printStackTrace();
            throw new WebDriverException();
        }
    }

    public List<TopPlayer> assistsRankCrawler() {
        try {
            base_url = "https://www.bbc.com/sport/football/premier-league/top-scorers/assists";
            driver.get(base_url);

            WebElement element = driver.findElement(By.className("gel-long-primer"));
            List<WebElement> tr = element.findElements(By.tagName("tr"));
            List<TopPlayer> goalRanking = new ArrayList<>();
            for (WebElement webElement : tr) {
                List<WebElement> td = webElement.findElements(By.tagName("td"));
                String[] split = td.get(1).getText().split("\n");
                String name = split[0];
                String team = split[2];

                TopPlayer build = TopPlayer.AssistsRankingBuilder()
                        .name(name)
                        .team(team)
                        .ranking(parseInt(td.get(0).getText()))
                        .assists(parseInt(td.get(2).getText()))
                        .goals(parseInt(td.get(3).getText()))
                        .played(parseInt(td.get(4).getText()))
                        .chancesCreated(parseInt(td.get(5).getText()))
                        .chancesPer90(Double.parseDouble(td.get(6).getText()))
                        .totalPasses(parseInt(td.get(7).getText()))
                        .chancesComplete(parseInt(td.get(8).getText()))
                        .chancesIncomplete(parseInt(td.get(9).getText()))
                        .passAccuracy(td.get(10).getText())
                        .build();


//                        .totalShots()
//                        .goalConversion(td.get(8).getText())
//                        .shotAccuracy(td.get(9).getText()).build();

                goalRanking.add(build);
            }

            driver.close();
            return goalRanking;
        } catch (Exception e) {
            driver.close();
            e.printStackTrace();
            throw new WebDriverException();
        }

    }
}
