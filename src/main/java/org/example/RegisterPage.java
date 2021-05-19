package org.example;

import org.openqa.selenium.By;

import java.sql.Timestamp;

public class RegisterPage extends Utils{

    LoadProperty loadProperty = new LoadProperty();
    private By _register = By.linkText("Register");
    private By _firstName = By.id("FirstName");
    private By _lastName = By.id("LastName");
    private By _dateOfBirth = By.name("DateOfBirthDay");
    private By _monthOfBirth = By.name("DateOfBirthMonth");
    private By _yearOfBirth = By.name("DateOfBirthYear");
    private By _emailId = By.xpath("//input[@id='Email']");
    private By _companyName = By.xpath("//input[@id='Company']");
    private By _password = By.id("Password");
    private By _confirmPassword = By.name("register-button");

    public void enterRegisterationDetails(){
        // timestamp for current time - to cr
        // create unique value each time we run the program
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        // wait before clicking on Register button
        waitForClickable (_register,6000);
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
