package PageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class BasePage {

    public WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {

        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream(
            "C://Users//Shree//eclipse-workspace//Amazon//src//test//java//resources//config.properties"
        );

        prop.load(fis);

        String browserName = prop.getProperty("browser");
   

        if (browserName.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        } else {

            throw new RuntimeException("Invalid browser name: " + browserName);
        }

        String urlname = prop.getProperty("url");
        driver.get(urlname);
        driver.manage().window().maximize();
    }
    

	public List <HashMap <String ,String>> getJsonDataToMAp(String filePath) throws IOException
	{
		//reading json to string
		String jsonreader = FileUtils.readFileToString(new File(filePath));
		
		//covert string to hashmap jackson Databind
		ObjectMapper mapper = new ObjectMapper();
		List <HashMap <String ,String>> data = mapper.readValue(jsonreader , new TypeReference<List <HashMap <String , String >>>() {
		});
		return data;
		
	}
    
	public void screenshot()
	
	{
		//TakesScreenshot ts = 
		
	}
   
}
