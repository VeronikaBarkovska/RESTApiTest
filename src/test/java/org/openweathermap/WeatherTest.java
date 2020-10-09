package org.openweathermap;

import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class WeatherTest extends BaseTest{

    private WeatherPage weatherPage;

    @BeforeMethod
    public void beforeMethod(){
        weatherPage= new WeatherPage(driver);
    }

    @Test
    public void testCanGetOpenweathermap(){
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.getContentType().contentEquals(ContentType.JSON.toString()));
                response.body().prettyPrint();
    }

   @Test
    public void verifyWeatherTemperatureData(){
       System.out.println("Verify that temperature from API is matched to Website temperature");
       Assertions.assertThat(response.statusCode()).isEqualTo(200);
       Assertions.assertThat(response.getContentType().contentEquals(ContentType.JSON.toString()));
       Assertions.assertThat(response.then().body("main.temp", equalTo(weatherPage.getTempInKelvin())));
    }

    @Test
    public void verifyWeatherMinTemperatureData(){
        System.out.println("Verify that min temperature from API is matched to Website temperature");
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.getContentType().contentEquals(ContentType.JSON.toString()));
        Assertions.assertThat(response.then().body("main.temp_min", equalTo(weatherPage.getMinTemperetureInKelvin())));
    }

    @Test
    public void verifyWeatherMaxTemperatureData(){
        System.out.println("Verify that max temperature from API is matched to Website temperature");
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.getContentType().contentEquals(ContentType.JSON.toString()));
        Assertions.assertThat(response.then().body("main.temp_max", equalTo(weatherPage.getMaxTemperetureInKelvin())));
    }
    @Test
    public void verifyWeatherWindData(){
        System.out.println("Verify that wind from API is matched to Website wind");
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.getContentType().contentEquals(ContentType.JSON.toString()));
        Assertions.assertThat(response.then().body("wind.speed", equalTo(weatherPage.getWind())));
    }
    @Test
    public void verifyWeatherVisibilityData(){
        System.out.println("Verify that Visibility from API is matched to Website Visibility");
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.getContentType().contentEquals(ContentType.JSON.toString()));
        Assertions.assertThat(response.then().body("visibility", equalTo(weatherPage.getVisibilityInMeters())));
    }
    @Test
    public void verifyWeatherPressureData(){
        System.out.println("Verify that Pressure from API is matched to Website Pressure");
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.getContentType().contentEquals(ContentType.JSON.toString()));
        Assertions.assertThat(response.then().body("main.pressure", equalTo(weatherPage.getPressure())));
    }
    @Test
    public void verifyWeatherHumidityData(){
        System.out.println("Verify that Humidity from API is matched to Website Humidity");
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.getContentType().contentEquals(ContentType.JSON.toString()));
        Assertions.assertThat(response.then().body("main.humidity", equalTo(weatherPage.getHumidity())));
    }
    }


