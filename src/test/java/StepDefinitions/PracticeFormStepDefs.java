package StepDefinitions;

import Pages.PracticeFormPage;
import Utilities.BrowserUtilities;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import io.cucumber.java.en.*;

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
        new PracticeFormPage().subject.sendKeys(subject);
    }
    @When("The user fills hobbies {string}")
    public void the_user_fills_hobbies(String hobby) {
        new PracticeFormPage().chooseHobby(hobby);
        BrowserUtilities.waitFor(2);
    }
    @When("The user clicks the submit button")
    public void the_user_clicks_the_submit_button() {
        new PracticeFormPage().submitButton.click();
        BrowserUtilities.waitFor(5);
    }
    @Then("The user should see the popup window with form details")
    public void the_user_should_see_the_popup_window_with_form_details() {
        System.out.println("verify");
    }


}
