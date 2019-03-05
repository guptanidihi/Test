@LoginPage
Feature: Login Functionality Feature
  I want to test the login functionlity on the http://the-internet.herokuapp.com/login page

@Smoke
  @LoginSuccess
  Scenario: Login Functionality with valid username and password
    Given user navigates to http://the-internet.herokuapp.com/login
    When user logs in using Username as "tomsmith" and Password "SuperSecretPassword!"
    And click on submit button
    Then login should be successful
@Smoke
  @LoginInvalid
  Scenario: Login Functionality with invalid username and password
    Given user navigates to http://the-internet.herokuapp.com/login
    When user logs in using Username as "USER1" and Password "PASSWORD1"
    And click on submit button
    Then login should be unsuccessful

  @LoginInvUser
  Scenario: Login Functionality with invalid username and valid password
    Given user navigates to http://the-internet.herokuapp.com/login
    When user logs in using Username as "USER1" and Password "SuperSecretPassword!"
    And click on submit button
    Then login should be unsuccessful

  @LoginInvPwd
  Scenario: Login Functionality with valid username and invalid password
    Given user navigates to http://the-internet.herokuapp.com/login
    When user logs in using Username as "tomsmith" and Password "PASSWORD1"
    And click on submit button
    Then login should be unsuccessful

  @LoginBlank
  Scenario: Login Functionality with blank username and password
    Given user navigates to http://the-internet.herokuapp.com/login
    When user logs in using Username as " " and Password " "
    And click on submit button
    Then login should be unsuccessful
