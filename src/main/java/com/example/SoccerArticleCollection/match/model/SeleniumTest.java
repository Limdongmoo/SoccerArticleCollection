package com.example.SoccerArticleCollection.match.model;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class SeleniumTest {

    public static void main(String[] args) {

        SeleniumTest selTest = new SeleniumTest();
        selTest.crawlSchedule();

    }


    //WebDriver
    private WebDriver driver;

    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "/Users/imjongho/Downloads/chromedriver";

    //크롤링 할 URL
    private String base_url;

    public SeleniumTest() {
        super();

        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        //Driver SetUp
        driver = new ChromeDriver();

    }

    /**
     * EPL 전체 순위 크롤링
     */
    public void crawlRanking() {

        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            base_url = "https://sports.news.naver.com/wfootball/record/index.nhn?category=epl&year=2022";
            driver.get(base_url);
            System.out.println(driver.getPageSource());
            WebElement container = driver.findElement(By.id("container"));
            String text = container.getText();

            System.out.println(text);
            // 팀별 분기처리
            for (String s : text.split("\n")) {
                System.out.println("s = " + s);
            }


        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            driver.close();
        }

    }

//    /**
//     * 매치별 정보 링크 크롤링
//     */
//    public void crawlScheduleWithNaverMatchLink() {
//
//        try {
//            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
//            base_url = "https://sports.news.naver.com/wfootball/schedule/index?year=2022&month=09&category=epl";
//            driver.get(base_url);
//            System.out.println(driver.getPageSource());
//            WebElement monthlySchedule = driver.findElement(By.id("_monthlyScheduleList"));
//            List<WebElement> monthlyScheduleElements = monthlySchedule.findElements(By.className("broadcast"));
//
//            for (WebElement webElement : monthlyScheduleElements) {
//                WebElement inner = webElement.findElement(By.className("inner"));
//                WebElement a1 = inner.findElement(By.tagName("a"));
//                System.out.println("a1 = " + a1.getAttribute("href"));
//            }
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//        } finally {
//
//            driver.close();
//        }
//
//    }

    /**
     * 경기 일정 및 결과 / 네이버 매치 링크 크롤링  -  경기 날짜 반영 완료
     * 최종 크롤링 결과물 , DTO 에 저장
     */
    public void crawlSchedule() {

        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            base_url = "https://sports.news.naver.com/wfootball/schedule/index?year=2022&month=09&category=epl";
            driver.get(base_url);
            System.out.println(driver.getPageSource());
            WebElement monthlySchedule = driver.findElement(By.id("_monthlyScheduleList"));
            List<WebElement> monthlyScheduleElements = monthlySchedule.findElements(By.tagName("tr"));
            String date = "";
            List<Match> matches = new ArrayList<>();
            for (WebElement webElement : monthlyScheduleElements) {
                boolean containDate = isContainDate(webElement);
                List<WebElement> td = webElement.findElements(By.tagName("td"));
                if (containDate) {
                    date = webElement.findElement(By.tagName("th")).getText();
                }
                if (td.size() > 2) {
                    matches.add(new ExistMatch(date, td.get(0).getText(), td.get(1).getText(),
                            webElement.findElement(By.className("broadcast")).findElement(By.tagName("a")).getAttribute("href")));
                } else {
                    matches.add(new NoMatchDate(date));
                }

            }
        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            driver.close();
        }

    }

    private boolean isContainDate(WebElement webElement) {
        try {
            webElement.findElement(By.tagName("th"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

}
