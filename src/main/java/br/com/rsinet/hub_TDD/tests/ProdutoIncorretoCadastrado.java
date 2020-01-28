package br.com.rsinet.hub_TDD.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_TDD.utility.Screenshot;

public class ProdutoIncorretoCadastrado {
public static WebDriver driver;
ExtentReports extensao;
ExtentTest logger;
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.advantageonlineshopping.com/#/");
	}
	
	@Test
	public void pesquisaProduto() throws Exception {
		ExtentHtmlReporter reporte = new ExtentHtmlReporter("target/reports/ProdutoIncorretoCadastrado.html");
        extensao = new ExtentReports();
        extensao.attachReporter(reporte);
        logger = extensao.createTest("ProdutoIncorretoCadastrado");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"follow\"]/a[3]/img")));
		driver.findElement(By.id("details_10")).click();
		Screenshot.PrintScreenshot(driver, "ProdutoIncorretoCadastrado");
		Assert.assertTrue(driver.getPageSource().contains("HP CHROMEBOOK 14 G1(ES)"));
	}
	
	@AfterMethod
	public void afterMethod() throws Exception {
		extensao.flush();
		driver.quit();
	}
}

