
General Information on Automation Framework:

I have created Maven Project impelementing BDD framework using Cucumber and Jnuit.
The project is named as TestCCQA. The feature file is named as login.feature. 
I have created five test scenarios out of which two, tagged as @Smoke can be executed. 
I have used Chrome browser to validate the scenarios.
Properties file has been used to read URL variable.

Notes:
Chrome driver exe file has been placed in ChromeDriver folder in the project itself.
@Smoke tag has been marked above two test cases to execute those only.

Steps to execute the automated test scenarios:

1. Download the project from git.
2. Import existing Maven project onto Elipse/IntelliJ.
3. Run the project as Junit Test.
4. Go to Testrun.java and right click->Run As->jUnit Test
5. The two scenarios, 'LoginSuccess' to test the login functionality with valid credentials and the other
'LoginInvalid' to test that login fails on invalid credentials would execute on chrome browser.


Other way to run the project:
Run the project as Maven Build with Goal as "clean test".