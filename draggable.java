package com.draggable;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class draggable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\thasleem\\Dropbox\\PC\\Downloads\\edgedriver_win64 (2)\\edgedriver.exe");

        WebDriver driver = new EdgeDriver();
		driver.get("https://www.way2automation.com/demo.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//*[text()='Registration'])[1]")).click();
		Set<String> wh=driver.getWindowHandles();
		Iterator<String> i1=wh.iterator();
		String mainwindow=driver.getWindowHandle();
		System.out.print(mainwindow);
		System.out.print(wh);

		while(i1.hasNext())
		{
			String childwindow=i1.next(); 
			if(!mainwindow.equalsIgnoreCase(childwindow))
			{
				driver.switchTo().window(childwindow);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='load_box']//a[@class='fancybox'][normalize-space()='ENTER TO THE TESTING WEBSITE']")).click();
				driver.findElement(By.xpath("//a[@href='draggable.php']//figure")).click();
				Set<String> wh1=driver.getWindowHandles();
				Iterator<String> i2=wh1.iterator();
				while(i2.hasNext())
				{
					String childwindow1=i2.next(); 
					if(!mainwindow.equalsIgnoreCase(childwindow1) && !childwindow.equalsIgnoreCase(childwindow1))
					{
						driver.switchTo().window(childwindow1);
						Thread.sleep(3000);
						driver.switchTo().frame(0);
						WebElement e=driver.findElement(By.xpath("//*[@id='draggable']"));
						Actions a=new Actions(driver);
						a.clickAndHold(e).dragAndDropBy(e, 100, 100).build().perform();
						
						a.release(e).build().perform();
					}
				}

	}

}
	}
}


