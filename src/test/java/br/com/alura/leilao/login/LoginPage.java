package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	private WebDriver browser;

	public LoginPage() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\2019-selenium-java-projeto_inicial\\2019-selenium-java-projeto_inicial\\drivers\\chromedriver.exe");
		this.browser = new ChromeDriver();
		browser.navigate().to("http://localhost:8080/login");
	}

	public void fechar() {
		this.browser.quit();
	}

	public void preencheFormularioDeLogin(String username, String password) {
		browser.findElement(By.id("username")).sendKeys(username);
		browser.findElement(By.id("password")).sendKeys(password);
	}

	public void efetuLogin() {
		browser.findElement(By.id("login-form")).submit();
	}

	public boolean isUrlLogin() {
		return browser.getCurrentUrl().equals("http://localhost:8080/login");

	}

	public Object getNomeUsuarioLogado() {
		try {
			return browser.findElement(By.id("usuario-logado")).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public void navegaParaPaginaDeLances() {
		this.browser.navigate().to("http://localhost:8080/leiloes/2");

	}

	public boolean contemTexto(String texto) {
		return browser.getPageSource().contains(texto);
	}

	public boolean isUrlLoginComDadosInvalidos() {
		return browser.getCurrentUrl().equals("http://localhost:8080/login?error");
	}

}