package com.g2.t5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions;
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
        usernameInput.sendKeys("Ale");

        // Trova il campo di input della password e immetti la password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("Beppe");

        // Trova il pulsante di login e premilo
        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();

        String expectedNextPage = "Choose your enemy";
        String actualNextPage = driver.getTitle();

        if (actualNextPage.equals(expectedNextPage)) {
            // La pagina successiva corrisponde al nome specifico
            System.out.println("La pagina successiva corrisponde al nome specifico: " + expectedNextPage);
            assertTrue(true);
        } else {
            // La pagina successiva non corrisponde al nome specifico
            System.out.println("La pagina successiva non corrisponde al nome specifico: " + expectedNextPage);
            assertFalse(false, "La pagina successiva non corrisponde al nome specifico: " + expectedNextPage);
        }
    }
    
}
