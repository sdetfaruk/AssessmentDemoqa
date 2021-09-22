package StepDefinitions;

import Pages.PracticeFormPage;
import Utilities.BrowserUtilities;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PracticeFormStepDefs {

    @Given("The user is on the practice form page")
    public void the_user_is_on_the_practice_form_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }


    @When("The user fills full name with {string} and {string}")
    public void the_user_fills_full_name_with_and(String firstName, String lastName) {
        PracticeFormPage practiceFormPage = new PracticeFormPage();
        practiceFormPage.firstName.sendKeys(firstName);
        practiceFormPage.lastName.sendKeys(lastName);
    }
    @When("The user fills contact info with {string} and {string}")
    public void the_user_fills_contact_info_with_and(String email, String mobile) {
        PracticeFormPage practiceFormPage = new PracticeFormPage();
        practiceFormPage.email.sendKeys(email);
        practiceFormPage.mobile.sendKeys(mobile);
    }
    @When("The user choses gender {string}")
    public void the_user_choses_gender(String gender) {
        new PracticeFormPage().chooseGender(gender);
    }

    @When("The user fills subject {string}")
    public void the_user_fills_subject(String subject) {
        if (!subject.isEmpty()) {
            new PracticeFormPage().subject.sendKeys(subject);
        }
    }

    @When("The user fills hobbies {string}")
    public void the_user_fills_hobbies(String hobby) {
        if(!hobby.isEmpty()) {
            new PracticeFormPage().chooseHobby(hobby);
        }
    }
    @When("The user clicks the submit button")
    public void the_user_clicks_the_submit_button() {
        PracticeFormPage practiceFormPage = new PracticeFormPage();
        BrowserUtilities.clickWithJS(practiceFormPage.submitButton);
        BrowserUtilities.waitForVisibility(practiceFormPage.successMessage,5);
    }

    @When("The user clicks the submit button with invalid data")
    public void the_user_clicks_the_submit_button_with_invalid_data() {
        PracticeFormPage practiceFormPage = new PracticeFormPage();
        BrowserUtilities.clickWithJS(practiceFormPage.submitButton);
    }

    @Then("The user should see the popup window with form details")
    public void the_user_should_see_the_popup_window_with_form_details() {
        String expectedText = "Thanks for submitting the form";
        String actualText = new PracticeFormPage().successMessage.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Then("The user should not be able to submit the form")
    public void the_user_should_not_be_able_to_submit_the_form() {
        Assert.assertTrue(Driver.get().findElements(By.id("example-modal-sizes-title-lg")).size()<1);
    }



}
