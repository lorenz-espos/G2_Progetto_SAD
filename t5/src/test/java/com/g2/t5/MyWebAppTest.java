package com.g2.t5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyWebAppTest {

    @Autowired
    private WebDriver webDriver;

    @Test
    public void testHomePageTitle() {
        webDriver.get("http://localhost:8080");  // Imposta l'URL della tua web app
        String pageTitle = webDriver.getTitle();
        assertEquals("Titolo della tua pagina", pageTitle);
    }
}
