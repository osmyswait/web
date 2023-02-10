package ru.netology.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class webPositiveTest {
    private WebDriver driver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");
    }

    @AfterEach
    public void afterEach() {
        driver.quit();

        @Test
        public void test() {
            driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys(Cеменов Семен-Петр Семенович);
            driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79373714484");
            driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
            driver.findElement(By.cssSelector("button.button")).click();
            var actualText = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
            assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", actualText);
        }
    }
}
