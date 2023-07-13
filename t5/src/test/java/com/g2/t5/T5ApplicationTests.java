package com.g2.t5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions;
import java.lang.Thread;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class T5ApplicationTests {

	private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Imposta il percorso del driver di Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Documents\\GitHub\\G2_Progetto_SAD\\t5\\src\\test\\java\\drivers\\chromedriver.exe");

        // Crea un'istanza del WebDriver per Chrome
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        // Chiudi il driver e il browser
        driver.quit();
    }

    @Test
    public void testLogin() {
        // Naviga alla pagina di login
        driver.get("http://localhost:8080/login");

        // Trova il campo di input dell'username e immetti l'username
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("Test");       
        try {// sleep messe solo per una cosa prettamente grafica
        	Thread.sleep(1000);
        } catch(InterruptedException e) {
        	e.printStackTrace();
        }
        // Trova il campo di input della password e immetti la password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("test");
        
        try { // sleep messe solo per una cosa meramente grafica
        	Thread.sleep(1000);
        } catch(InterruptedException e) {
        	e.printStackTrace();
        }
        
        // Trova il pulsante di login e premilo
        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();
        
        //Bisogna disattivare gli alert dalla pagina di login quando vengono inviati i dati
        // attendi che la pagina successiva si carichi completamente
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Choose your enemy"));

        String expectedNextPage = "Choose your enemy";
        String actualNextPage = driver.getTitle();
        System.out.println(actualNextPage);
        
        assertTrue(actualNextPage.equals(expectedNextPage));
    }
    
}
