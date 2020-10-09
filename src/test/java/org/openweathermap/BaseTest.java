package org.openweathermap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.openweathermap.utils.Constant.BASE_URL;
import static org.openweathermap.utils.Constant.SEARCH_CITY_WEATHER;

public abstract class BaseTest {

    protected WebDriver driver;
    protected RequestSpecification request;
    protected Response response;

    @BeforeMethod
    public void setup() {
        request = RestAssured.given();
        response = request.
                param("q","London").
                param("appid","d487dc4d1e75e13db4a4e0b2122e7a99").
                get(BASE_URL+SEARCH_CITY_WEATHER);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Вероника\\Documents\\GitHub\\restapi-1\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://openweathermap.org/city/2643743");

    }

   @AfterMethod
    public void cleanup() {
           this.driver.close();
    }
}
