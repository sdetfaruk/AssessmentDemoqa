package Pages;

import Utilities.BrowserUtilities;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeFormPage {
    public PracticeFormPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement email;

    @FindBy(id = "userNumber")
    public WebElement mobile;

    @FindBy(xpath = "//*[@id='subjectsContainer']//input")
    public WebElement subject;

    @FindBy (id = "submit")
    public WebElement submitButton;

    @FindBy (id = "example-modal-sizes-title-lg")
    public WebElement successMessage;

    public void chooseGender(String gender){
        String path = "//*[@id='genterWrapper']//*[@value='"+gender+"']";
        BrowserUtilities.clickWithJS(Driver.get().findElement(By.xpath(path)));
    }

    public void chooseHobby(String hobby) {
        String path = "//*[@id='hobbiesWrapper']//label[.='" + hobby + "']/preceding-sibling::*";
        BrowserUtilities.clickWithJS(Driver.get().findElement(By.xpath(path)));
    }


}
