package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import base.BaseTest;

public class TestDrops extends BaseTest {

    @Test
    public void verifyDropdownSelection() throws InterruptedException {
        //driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");  // Example URL with dropdown

        
        WebElement dropdownElement = driver.findElement(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//p//select"));
        Thread.sleep(4000);
        
        Select dropdown = new Select(dropdownElement);
        Thread.sleep(4000);

        
        dropdown.selectByVisibleText("Algeria");
        Thread.sleep(4000);

        //select by value
        // dropdown.selectByValue("1");

        // Or by index
        // dropdown.selectByIndex(2);

        
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        System.out.println("Selected Option: " + selectedOption.getText());
    }
}
