package allTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class UITests {
    public static ChromeDriver driver;
    WebElement element;
    String startPage = "http://testingchallenges.thetestingmap.org/index.php";
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();

        try {
            driver = new ChromeDriver();
        }
        catch (NoSuchSessionException exception) {
            driver = new ChromeDriver();
        }

        //   driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

//   @After
//    public void closeBrowser() {
//        driver.close();
//    }

    @Test
    public void test1() {
        driver.get(startPage);
        //  <input type="text" id="firstname" class="inputbox" name="firstname">
        challenge1("");
    }

    @Test
    public void test2() {
        try {
            driver.get(startPage);
        }
        catch (NoSuchSessionException exception) {
            driver = new ChromeDriver();
            driver.get(startPage);
        }

        challenge1("asdghjfyqwieorptfldksssakajdjhdjsjsjsjsjss"); //more than 30 symbols
    }

    @Test
    public void test3() {
        try {
            driver.get(startPage);
        }
        catch (NoSuchSessionException exception) {
            driver = new ChromeDriver();
            driver.get(startPage);
        }

        challenge1("123657"); //Other chars then alphabetic
    }

    @Test
    public void test4() {
        try {
            driver.get(startPage);
        }
        catch (NoSuchSessionException exception) {
            driver = new ChromeDriver();
            driver.get(startPage);
        }

        challenge1("sdkfnlsd sss"); //Space in the middle
    }

    @Test
    public void test5() {
        try {
            driver.get(startPage);
        }
        catch (NoSuchSessionException exception) {
            driver = new ChromeDriver();
            driver.get(startPage);
        }

        challenge1("     "); //Space
    }

    @Test
    public void test6() {
        try {
            driver.get(startPage);
        }
        catch (NoSuchSessionException exception) {
            driver = new ChromeDriver();
            driver.get(startPage);
        }

        challenge1("sdsdsd     "); //Space AT THE END
    }


    @Test
    public void test7() {
        try {
            driver.get(startPage);
        }
        catch (NoSuchSessionException exception) {
            driver = new ChromeDriver();
            driver.get(startPage);
        }

        challenge1("    sdsdsDSFGDSd"); //Space AT begin
    }

    @Test
    public void test8() {
        try {
            driver.get(startPage);
        }
        catch (NoSuchSessionException exception) {
            driver = new ChromeDriver();
            driver.get(startPage);
        }

        challenge1("!@^#"); //other symbols
    }


    public void challenge1(String username) {
        //  <input type="text" id="firstname" class="inputbox" name="firstname">
        driver.findElement(By.id("firstname")).sendKeys(username);
        //<input type="submit" name="formSubmit" tabindex="-1" class="button" value="Submit">
        driver.findElement(By.name("formSubmit")).click();
    }

    public void challenge2(String username) {
        try {
            driver.get("http://testingchallenges.thetestingmap.org/challenge2.php");
        }
        catch (NoSuchSessionException exception) {
            driver = new ChromeDriver();
            driver.get("http://testingchallenges.thetestingmap.org/challenge2.php");
        }

        driver.findElement(By.xpath("//input[@name='valuesadded']")).sendKeys(username);
        driver.findElement(By.name("formSubmit")).click();
    }

    @Test
    public void challenge2test1() {
        challenge2("1"); //
    }

    @Test
    public void challenge2test2() {
        challenge2("1000000000000000000"); //
    }

    @Test
    public void challenge2test3() {
        challenge2("1.3"); //
    }

    @Test
    public void challenge2test4() {
        challenge2("0"); //
    }

    @Test
    public void challenge2test5() {
        challenge2("-5.7"); //
    }

    public void challenge6(String username) {
        try {
            driver.get("http://testingchallenges.thetestingmap.org/challenge6.php");
        }
        catch (NoSuchSessionException exception) {
            driver = new ChromeDriver();
            driver.get("http://testingchallenges.thetestingmap.org/challenge6.php");
        }

        //<input type="text" class="inputbox" name="date_time" value="15/03/2017 18:32">
        driver.findElement(By.xpath("//input[@name='date_time']")).sendKeys(username);
        driver.findElement(By.name("formSubmit")).click();
    }

    @Test
    public void challenge6test1() {
     /*   Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(formatter.format(calendar.getTime()));
      */

        challenge6("16/03/2017 18:38"); //
    }

    @Test
    public void challenge6test2() {
        challenge6("14/03/2017 18:38"); //
    }

    @Test
    public void challenge6test3() {
        challenge6("15/02/2017 18:38"); //
    }

    @Test
    public void challenge6test4() {
        challenge6("15/04/2017 18:38"); //
    }

    @Test
    public void challenge6test5() {
        challenge6("15/03/2018 18:38"); //
    }

    @Test
    public void challenge6test6() {
        challenge6("15/03/2016 18:38"); //
    }

    @Test
    public void challenge6test7() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(formatter.format(calendar.getTime()));

        challenge6(formatter.format(calendar.getTime()));
    }

    public void challenge7(String text) {
        try {
            driver.get("http://testingchallenges.thetestingmap.org/challenge7.php");
        }
        catch (NoSuchSessionException exception) {
            driver = new ChromeDriver();
            driver.get("http://testingchallenges.thetestingmap.org/challenge7.php");
        }

        driver.findElement(By.name("scenario")).sendKeys(text);
        driver.findElement(By.name("formSubmit")).click();
    }

    @Test
    public void challenge7test1() {
        String text = "Some text";
        challenge7(text);
    }

    public void challenge10(String username, String password, String firstname, String lastname) {
        try {
            driver.get("http://testingchallenges.thetestingmap.org/challenge10.php");
        }
        catch (NoSuchSessionException exception) {
            driver = new ChromeDriver();
            driver.get("http://testingchallenges.thetestingmap.org/challenge10.php");
        }

        driver.findElement(By.name("username")).sendKeys(username); //<input type="text" name="username">
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("firstname")).sendKeys(firstname);
        driver.findElement(By.name("firstname")).sendKeys(lastname);
        driver.findElement(By.xpath("//input[@value='Submit']")).click(); //<input type="submit" value="Submit">

        driver.get("http://testingchallenges.thetestingmap.org/login/login.php");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("username")))); //Проверяем видимость поля ввода
//<input type="text" name="username">
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        //<button type="submit" formmethod="post" formaction="login.php">log in</button>
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h1[]"), "Wellcome To Your Personal Road Assitance"));
    }

    @Test
    public void challenge10test1() {
        challenge10("Username", "Password", "Firstname", "Lastname");
    }
}

