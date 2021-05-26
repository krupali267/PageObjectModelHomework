package org.example;

import org.openqa.selenium.By;

import java.sql.Timestamp;

public class RegisterPage extends Utils{

    LoadProperty loadProperty = new LoadProperty();
    private By _register = By.xpath("//a[text()='Register']");
    private By _firstName = By.cssSelector("input#FirstName");
    private By _lastName = By.cssSelector("input#LastName");
    private By _dateOfBirth = By.xpath("//select[contains(@name, 'DateOfBirthDay')]");
    private By _monthOfBirth = By.xpath("//select[contains(@name, 'DateOfBirthMonth')]");
    private By _yearOfBirth = By.xpath("//select[contains(@name, 'DateOfBirthYear')]");
    private By _emailId = By.cssSelector("input#Email");
    private By _companyName = By.cssSelector("input#Company");
    private By _password = By.cssSelector("input#Password");
    private By _confirmPassword = By.cssSelector("input#ConfirmPassword");

    public void enterRegisterationDetails(){
        // timestamp for current time - to cr
        // create unique value each time we run the program
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        // wait before clicking on Register button
        waitForClickable (_register,5000);
        //select gender
        clickOnElement(By.xpath("//input[@id='gender-male']"));
        // type first name
        enterText(_firstName,loadProperty.getProperty("firstname") );
        // type last name
        enterText(_lastName,loadProperty.getProperty("lastname"));
        // select date of birth
        selectFromDropDownByValue(_dateOfBirth,loadProperty.getProperty("dateofbirth"));
        // select month of birth
        selectFromDropdownByVisibleText(_monthOfBirth,loadProperty.getProperty("monthofbirth"));
        // select year of birth
       selectFromDropDownByValue(_yearOfBirth,loadProperty.getProperty("yearofbirth"));
        // type email id
        enterText(_emailId, loadProperty.getProperty("emailId")+timestamp.getTime()+"@test.com");
        // type company name
        enterText(_companyName,loadProperty.getProperty("companyname"));
        // click on the checkbox of Newsletter
        clickOnElement(By.xpath("//input[@type = 'checkbox']"));
        // type password
        enterText(_password, loadProperty.getProperty("password"));
        // retype password
        enterText(_confirmPassword, loadProperty.getProperty("confirmpassword"));
        // click on Register Button
        clickOnElement(By.name("register-button"));
    }

}
