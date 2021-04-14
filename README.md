# AT Lab 2021CW4

Examples:

1. If you want to run tests with Maven on Chrome browser:

mvn -Dbrowser=chrome -Dtests-data=tests-data -Dsurefire.suiteXmlFiles=src/test/resources/yourtest.xml clean test

(insert your test suite instead of yourtest.xml)

2. If you want to run test in Intellij Idea add environment variable "environment=env1"

(you can change browser type in env1.properties or add another .properties file)

# [To integrate framework with Report Portal step by step](https://git.epam.com/pavel_verkhovtsov/at-lab-2021cw4/-/wikis/To-integrate-framework-with-Report-Portal-step-by-step)

What was done:
Created test cases (UI, API, Mobile), 
automated test cases, 
created Test Automation Framework core classes, 
implemented Jenkins jobs, 
tests implementation via BDD tools, 
running tests using Selenium Grid with Docker, 
analyzing test results with Report Portal (created dashboard), 
implemented sharing state between steps, 
used Reflection API and PicoContainer for DI.

Tools:
Intellij IDEA, 
JDK 11.0.10, 
Apache Maven 3.6.3, 
Checkstyle plugin, 
SonarQube scanner, 
Selenium, 
Selenium Grid, 
TestNG, 
Cucumber, 
GitLab, 
Jenkins, 
Report Portal, 
AVD Manager, 
Appium, 
EPAM Mobile cloud, 
Sauce Labs, 
WebDriver manager, 
Rest Assured, 
Docker, 
Jira

