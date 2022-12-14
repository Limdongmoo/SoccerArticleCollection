package com.example.SoccerArticleCollection.domain.match;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class MatchCrawler {
//    public static void main(String[] args) {
//        SeleniumCrawler seleniumCrawler = new SeleniumCrawler();
//        UrlMaker urlMaker = new UrlMaker();
//
//        urlMaker.setYear("year=2022");
//        urlMaker.setMonth("&month=09");
//        seleniumCrawler.crawlSchedule(urlMaker);
//    }

    //WebDriver
    private WebDriver driver;

    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "/Users/imjongho/Downloads/chromedriver";

    //크롤링 할 URL
    private String base_url;

    public MatchCrawler() {
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
    public List<Match> crawlSchedule(UrlMaker urlMaker) {

        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            base_url = "https://sports.news.naver.com/wfootball/schedule/index?" + urlMaker.getYear() + urlMaker.getMonth() + urlMaker.getCategory();
            driver.get(base_url);
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
                    MatchFromCrawler matchFromCrawler = new MatchFromCrawler(td.get(0).getText(), td.get(1).getText(),
                            webElement.findElement(By.className("broadcast")).findElement(By.tagName("a")).getAttribute("href"));
                    String[] splittedMatchInfo = matchFromCrawler.getMatchName().split("\n");

                    if (splittedMatchInfo.length == 2) {
                        Match from = MatchFromCrawler.from(matchFromCrawler, splittedMatchInfo[0], splittedMatchInfo[1]);
                        from.setDate(Date.valueOf(convertDateRegex(from.getMatchLink().substring(35, 43))));

                        matches.add(from);
                    } else if (splittedMatchInfo.length == 4) {
                        Match from = MatchFromCrawler.from(matchFromCrawler, splittedMatchInfo[0], Integer.parseInt(splittedMatchInfo[1]),
                                splittedMatchInfo[2], Integer.parseInt(splittedMatchInfo[3]), "무승부");
                        from.setDate(Date.valueOf(convertDateRegex(from.getMatchLink().substring(35, 43))));
                        matches.add(from);
                    } else if (splittedMatchInfo.length == 5) {
                        Match from;
                        if (splittedMatchInfo[2].equals("승리팀")) {
                            from = MatchFromCrawler.from(matchFromCrawler, splittedMatchInfo[0], Integer.parseInt(splittedMatchInfo[1]),
                                    splittedMatchInfo[3], Integer.parseInt(splittedMatchInfo[4]), splittedMatchInfo[0]);
                        }
                        else{
                            from = MatchFromCrawler.from(matchFromCrawler, splittedMatchInfo[0], Integer.parseInt(splittedMatchInfo[1]),
                                    splittedMatchInfo[2], Integer.parseInt(splittedMatchInfo[3]), splittedMatchInfo[2]);
                        }
                        from.setDate(Date.valueOf(convertDateRegex(from.getMatchLink().substring(35, 43))));
                        matches.add(from);
                    }
                } else {
                    String year = urlMaker.getYear().replaceAll("year=","");
                    String month = urlMaker.getMonth().replace("&month=","");
                    String[] split = date.split("\\.");
                    String[] s = split[1].split(" ");
                    String day = "";
                    if (s[0].length() < 2) {
                        day = "0" + s[0];
                    } else {
                        day = s[0];
                    }
                    date = year +"-"+ month +"-"+ day;
                    matches.add(new Match(Date.valueOf(date)));
                }

            }
            driver.close();
            return matches;

        } catch (Exception e) {
            driver.close();
            e.printStackTrace();
            throw new WebDriverException();

        }
    }

    /**
     * Played Match Crawler
     */
    public void playedMatchCrawler() {

        List<WebElement> bx_end = driver.findElements(By.cssSelector("div.bx.end"));

            for (WebElement webElement : bx_end) {
                System.out.println("webElement.getText() = " + webElement.getText());
            }
        System.out.println("bx_end.size() = " + bx_end.size());
            driver.close();
        String s ="MatchBox_score__33SVc";

//        } catch (Exception e) {
//            e.printStackTrace();
//            driver.close();
//        }
    }




    private boolean isContainDate(WebElement webElement) {
        try {
            webElement.findElement(By.tagName("th"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    private String convertDateRegex(String date) {
        StringBuilder sb = new StringBuilder();
        sb.append(date,0, 4).append("-").append(date, 4, 6).append("-").append(date, 6, 8);
        return sb.toString();
    }

}
