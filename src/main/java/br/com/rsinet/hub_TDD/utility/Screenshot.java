package br.com.rsinet.hub_TDD.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static String getTimeStamp() {
        return new SimpleDateFormat("dd_MM_yyyy HH.mm.ss").format(Calendar.getInstance().getTime());
    }
    
    public static void PrintScreenshot(WebDriver driver, String nome) throws InterruptedException{
    	Thread.sleep(1000);
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
        try {
            FileUtils.copyFile(file, new File("target/screenshot/"+ nome + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}