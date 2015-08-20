package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_multiple_args {
public static void main (String[] a) {
	if (a.length == 0){
		System.out.println("No arguments");
		System.exit(1);
	}
	WebDriver driver = new FirefoxDriver();
	for (int i = 0; i < a.length; i++){
		String test_case_id = "Test001.0" + (i + 1);
		String param[] = a[i].split("\\|");
		
		String url = param[0];
		String title_expected = param[1];
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title_actual = driver.getTitle();
		System.out.println("");
		if (title_expected.equals(title_actual)){
			System.out.println("Test Case ID: \t\t" + test_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "PASSED");
		} else {
			System.out.println("Test Case ID: \t\t" + test_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "FAILED");
		}
	}
	driver.quit();
}

}
