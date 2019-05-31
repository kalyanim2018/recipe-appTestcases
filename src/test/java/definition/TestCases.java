package definition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
public class TestCases {
    private static WebDriver driver;
    private static Scenario testScenario;
    private static  String ExpectedUrl;


    @Before
    public void prepareEnvironment(Scenario scenario) throws Exception {testScenario = scenario;
    }


    @Given("^that the tests are to be run on \"([^\"]*)\" using \"([^\"]*)\"  browser$")
    public void that_the_tests_are_to_be_run_on_using_browser(String arg1, String arg2) throws Throwable {

        if(arg2.equalsIgnoreCase("chrome")) {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            options.addArguments("--headless");
            String driverFile = "chromedriver.exe";
            File file = new File(driverFile);
            System.setProperty("webdriver.chrome.driver", driverFile);
            driver = new ChromeDriver(options);
        }
    }

    @Given("^user go to \"([^\"]*)\" in \"([^\"]*)\"$")
    public void user_go_to_in(String arg1, String arg2) throws Throwable {

        if(arg2.equalsIgnoreCase("prod")) {
            driver.get("https://receipe-app.herokuapp.com/recipes");
        }
        else {
            driver.get("http://localhost:4200/recipes");
        }
        waitForPageToBeReady();
        String ExpectedPageTitle = "RecipeApp";
        String PageTitle = driver.getTitle();
        if (ExpectedPageTitle.equalsIgnoreCase(PageTitle)) {
            System.out.println("Page is  successfully loaded");
        } else {
            System.out.println("Page is not successfully loaded");
        }

        }

    @When("^user chooses \"([^\"]*)\" recipe and select \"([^\"]*)\" option from \"([^\"]*)\" dropdown$")
    public void user_chooses_recipe_and_select_option_from_dropdown(String arg1, String arg2, String arg3) throws Throwable {

            WebDriverWait wait = new WebDriverWait(driver, 1000);
               if(arg1.equalsIgnoreCase("Chinese Chicken")) {
            driver.findElement(By.xpath("//a[@href='/recipes/0']")).click();
            waitForPageToBeReady();
            Assert.assertTrue("Chinese Chicken with sweet and sour sauce", true);
        }
        else if (arg1.equalsIgnoreCase("Sausage Casserole")){
            driver.findElement(By.xpath("//a[@href='/recipes/1']")).click();
        }
        else if (arg1.equalsIgnoreCase("Taco Meat Recipe")){
            driver.findElement(By.xpath("//a[@href='/recipes/2']")).click();
        }
        else if (arg1.equalsIgnoreCase("Egg delight")){
            driver.findElement(By.xpath("//a[@href='/recipes/3']")).click();
        }
        else if (arg1.equalsIgnoreCase("Fried EggPlant")){
            driver.findElement(By.xpath("//a[@href='/recipes/4']")).click();
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/app-recipes/div/div[2]/app-recipe-detail/div[3]/div/div/button"))).click();
        waitForPageToBeReady();
        driver.findElement(By.xpath("//*[@id=\"dropdown\"]/li[1]/button")).click();
        }


    @Then("^the user will be redirected to \"([^\"]*)\" page in \"([^\"]*)\"$")
    public void the_user_will_be_redirected_to_page_in(String arg1, String arg2) throws Throwable {
        Thread.sleep(3000);
        String CurrentUrl=  driver.getCurrentUrl();
        System.out.println("Current url is" + CurrentUrl);
        if(arg2.equalsIgnoreCase("prod")) {
            ExpectedUrl = "https://receipe-app.herokuapp.com/shopping-list";
        }
        else{
             ExpectedUrl = "http://localhost:4200/shopping-list";
        }
        if(CurrentUrl.equalsIgnoreCase(ExpectedUrl)){
            System.out.println("Redirected to ShoppingList page");
        }
        else {
            System.out.println("Error");
        }

    }
    @Then("^the user chooses to \"([^\"]*)\" the selected \"([^\"]*)\" recipe portions on \"([^\"]*)\" page and \"([^\"]*)\" it accordingly$")
    public void the_user_chooses_to_the_selected_recipe_portions_on_page_and_it_accordingly(String arg1, String arg2, String arg3, String arg4) throws Throwable {

          driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-shopping-list/div/div/ul/a[1]")).click();
           if(arg1.equalsIgnoreCase("Update")){
            driver.findElement(By.xpath("//*[@id=\"amount\"]")).clear();
            driver.findElement(By.xpath("//*[@id=\"amount\"]")).sendKeys("10");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"buttons\"]/button[1]")).click();
                }
                else if(arg1.equalsIgnoreCase("Delete")){
            driver.findElement(By.xpath("//*[@id=\"buttons\"]/button[2]"));
                 }

        else if(arg1.equalsIgnoreCase("Clear")){
            driver.findElement(By.xpath("//*[@id=\"buttons\"]/button[3]"));
                }
            }


   public void waitForPageToBeReady() {
                    ExpectedCondition<Boolean> pageLoadCondition = new
                            ExpectedCondition<Boolean>() {
                                public Boolean apply(WebDriver driver) {
                       return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                                }
                            };
                    WebDriverWait wait = new WebDriverWait(driver, 5000);
                    wait.until(pageLoadCondition);
    }


    @After
    public void endTests() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }

}
