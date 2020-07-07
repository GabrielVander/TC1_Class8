package org.example.untitled;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest {

  private final WebDriver browser = new FirefoxDriver();

  @Test
  public void openPage() throws InterruptedException {
    System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");

    browser.get("http://localhost:3000/class8");

    //First topic
    browser.findElement(By.cssSelector("#forgottenPasswordLink")).click();

    // Third topic
    Thread.sleep(2000);

    // Second topic
    String title = browser.getTitle();
    assertEquals("Revisão", title);

    browser.findElement(By.cssSelector("#backLink")).click();

    Thread.sleep(2000);

    assertEquals("http://localhost:3000/01_Login.html", browser.getCurrentUrl());

    //Fourth topic
    WebElement usernameInput = browser.findElement(By.cssSelector("#emailLogin"));
    usernameInput
        .sendKeys("username");

    assertEquals("username", usernameInput.getAttribute("value"));

    WebElement passwordInput = browser.findElement(By.cssSelector("#senhaLogin"));
    passwordInput
        .sendKeys("password");

    assertEquals("password", passwordInput.getAttribute("value"));

    browser
        .findElement(By.cssSelector("#enterBtn"))
        .click();

    Thread.sleep(2000);

    assertEquals("http://localhost:3000/03_Principal.html", browser.getCurrentUrl());

    browser.navigate().back();

    assertEquals("http://localhost:3000/01_Login.html", browser.getCurrentUrl());

  }
}