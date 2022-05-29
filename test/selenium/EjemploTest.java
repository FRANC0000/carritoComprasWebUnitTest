package selenium;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author TecCalidad
 */
public class EjemploTest {
    WebDriver driver;
    
    public EjemploTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        String baseUrl = "http://localhost:8080/CarritoComprasWeb";
        String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    
    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testMain() {
        driver.manage().window().maximize();
        driver.findElement(By.partialLinkText("Iniciar Sesión")).click();
        assertTrue(driver.findElement(By.name("txtuser")).isDisplayed());
    }

}
