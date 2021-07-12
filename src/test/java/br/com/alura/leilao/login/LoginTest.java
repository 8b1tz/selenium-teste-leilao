package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	private WebDriver browser;

	@BeforeAll
	public static void BeforeAll() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\2019-selenium-java-projeto_inicial\\2019-selenium-java-projeto_inicial\\drivers\\chromedriver.exe");
	}

	@BeforeEach
	public void BeforeEach() {
		this.browser = new ChromeDriver();
		browser.navigate().to("http://localhost:8080/login");
	}

	@AfterEach
	public void AfterEach() {
		browser.quit();
	}

	@Test
	public void deveriaEfeturLoginComDadosValidos() {

		browser.findElement(By.id("username")).sendKeys("fulano");
		browser.findElement(By.id("password")).sendKeys("pass");
		browser.findElement(By.id("login-form")).submit();

		Assert.assertEquals(browser.getCurrentUrl(), "http://localhost:8080/leiloes");
		Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());
	}

	@Test
	public void naoDeveriaLogarComDadosInvalidos() {

		browser.findElement(By.id("username")).sendKeys("invalido");
		browser.findElement(By.id("password")).sendKeys("123123");
		browser.findElement(By.id("login-form")).submit();

		Assert.assertEquals(browser.getCurrentUrl(), "http://localhost:8080/login?error");
		Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos"));
		Assert.assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado")));
	}

	@Test
	public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
		browser.navigate().to("http://localhost:8080/leiloes/2");

		Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login"));
		Assert.assertFalse(browser.getPageSource().contains("Dados do Leilão"));
	}
}
