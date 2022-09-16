
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

    public void crawlSchedule() {

        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            base_url = "https://sports.news.naver.com/wfootball/schedule/index?year=2022&month=09&category=epl";
            driver.get(base_url);
            System.out.println(driver.getPageSource());
            WebElement container = driver.findElement(By.id("_monthlyScheduleList"));
            String text = container.getText();

            System.out.println(text);
            /**
             * 요일별 분기처리가 필요함
             */
            for (String s : text.split("\n")) {
                System.out.println("s = " + s);
            }


        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            driver.close();
        }

    }


}
