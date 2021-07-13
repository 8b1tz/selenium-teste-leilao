package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesPage {
	private static final String URL_LEILOES = "http://localhost:8080/leiloes";
	private WebDriver browser;

	public LeiloesPage() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\2019-selenium-java-projeto_inicial\\2019-selenium-java-projeto_inicial\\drivers\\chromedriver.exe");
		this.browser = new ChromeDriver();
		browser.navigate().to(URL_LEILOES);
	}

	public void fechar() {
		this.browser.quit();
	}

}
