package org.openweathermap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openweathermap.utils.TestHelper;

public class WeatherPage {

    private WebDriver driver;

    @FindBy(xpath = "//ul[@class='weather-items text-container orange-side standard-padding']/li[contains(text(),'km')]")
    private WebElement visibilityFld;

    @FindBy(xpath = "//ul[@class='weather-items text-container orange-side standard-padding']/li[contains(text(),'hPa')]")
    private WebElement pressureFld;

    @FindBy(xpath = "//ul[@class='weather-items text-container orange-side standard-padding']/li/div[contains(text(),'mph') or contains(text(),'m/s')]")
    private WebElement windFld;

    @FindBy(xpath = "//ul[@class='weather-items text-container orange-side standard-padding']/li[contains(text(),'%')]")
    private WebElement humidityFld;

    @FindBy(xpath = "//ul[@class='weather-items text-container orange-side standard-padding']/li/span[contains(text(),'UV')]/parent::li")
    private WebElement uvFld;

    @FindBy(xpath = "//ul[@class='weather-items text-container orange-side standard-padding']/li/span[contains(text(),'Dew')]/parent::li")
    private WebElement dewPointFld;

    @FindBy(xpath = "//span[@class='heading']")
    private WebElement tempFld;

    @FindBy(xpath = "//div[@class='scrolling-container-header']")
    private WebElement dayDropDown;

    @FindBy(xpath = "//div[@class='scrolling-container-header']")
    private WebElement currentDayDropDown;

    @FindBy(xpath = "(//ul[@class='day-list']/li/div/div/span)[1]")
    private WebElement minAndMaxTemperature;

    public WeatherPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public int getVisibilityInMeters(){
        new TestHelper(driver).isPageLoad();
        String visibilityData = visibilityFld.getText().replace("Visibility:\n","").replace("km","").replace(".0","");
        int visibilityInteger = Integer.parseInt(visibilityData);
       return visibilityInteger*1000;
    }

    public int getPressure(){
        new TestHelper(driver).isPageLoad();
        String pressureData = pressureFld.getText().replace("\n","").replace("hPa","");
        int pressureInteger = Integer.parseInt(pressureData);
        return pressureInteger;
    }
    public double getWind(){
        new TestHelper(driver).isPageLoad();
        String windData = windFld.getText().replace("m/s","").replace("mph","").replaceAll("[A-Z]","").replace(" ","");
        double windInteger = Double.parseDouble(windData);
        return windInteger;
    }
    public int getHumidity(){
        new TestHelper(driver).isPageLoad();
        String humidityData = humidityFld.getText().replace("Humidity:\n","").replace("%","");
        int humidityInteger = Integer.parseInt(humidityData);
        return humidityInteger;
    }
    public int getUV(){
        String uvData = uvFld.getText().replace("UV:\n","");
        int uvInteger = Integer.parseInt(uvData);
        return uvInteger;
    }
    public int getDewPoint(){
        String dewPointData = dewPointFld.getText().replace("Dew point:\n","").replace("°F","").replace("°C","");
        int dewPointInteger = Integer.parseInt(dewPointData);
        return dewPointInteger;
    }

    public double getTempInKelvin(){
        new TestHelper(driver).isPageLoad();
        String tempData = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(tempFld)).getText().replace("°F","").replace("°C","");
        int tempInteger = Integer.parseInt(tempData);
        return tempInteger+273.15;
    }

    public double getMinTemperetureInKelvin(){
        new TestHelper(driver).isPageLoad();
        String my_string = minAndMaxTemperature.getAttribute("innerHTML");
        String[] stringParts = my_string.replace("°F","").replace("°C","").replace(" / ","\n").split("\n");
        String partA = stringParts[1];
        int minTempInt = Integer.parseInt(partA);
        return minTempInt+273.15;
    }
    public double getMaxTemperetureInKelvin(){
        new TestHelper(driver).isPageLoad();
        String my_string = minAndMaxTemperature.getAttribute("innerHTML");
        String[] stringParts = my_string.replace("°F","").replace("°C","").replace(" / ","\n").split("\n");
        String partB = stringParts[0];
        int maxTempInt = Integer.parseInt(partB);
        return maxTempInt+273.15;
    }

    public void clickDayDropDown(){
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(dayDropDown)).click();
    }

}
