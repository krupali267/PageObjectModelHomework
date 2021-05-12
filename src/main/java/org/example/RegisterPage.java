package org.example;

import org.openqa.selenium.By;

import java.sql.Timestamp;

public class RegisterPage extends Utils{

    public void enterRegistertationDetails(){
        // timestamp for current time - to create unique value each time we run the program
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        // wait before clicking on Register button
        waitForClickable(By.linkText("Register"),6000);
        //select gender
        clickOnElement(By.xpath("//input[@id='gender-male']"));
        // type first name
        enterText(By.id("FirstName"),"Ajay");
        // type last name
        enterText(By.id("LastName"),"Patel");
        // select date of birth
        selectFromDropdownByVisibleText(By.name("DateOfBirthDay"),"26");
        // select month of birth
        selectFromDropDownByValue(By.name("DateOfBirthMonth"),"3");
        // select year of birth
        selectFromDropDownByIndex((By.name("DateOfBirthYear")),60);
        // type email id
        enterText(By.xpath("//input[@id='Email']"),"krupali"+timestamp.getTime()+"@test.com");
        // type company name
        enterText(By.xpath("//input[@id='Company']"),"XYZ Limited");
        // click on the checkbox of Newsletter
        clickOnElement(By.xpath("//input[@type = 'checkbox']"));
        // type password
        enterText(By.id("Password"),"testtest");
        // retype password
        enterText(By.id("ConfirmPassword"),"testtest");
        // click on Register Button
        clickOnElement(By.name("register-button"));
    }

}
