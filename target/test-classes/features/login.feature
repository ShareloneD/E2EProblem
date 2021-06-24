Feature: Login into Application 

Scenario Outline: Positive test validating login 
	Given initialize the browser with chrome 
	And Navigate to "http://qaclickacademy.com/" site 
	And Click on Login link in home page to land on Secure sign in Page 
	When User enters "<username>" and "<password>" and logs in 
	Then Verify that user is successfully logged in 
	And Close browsers
	
	Examples:
	|username				|password	|
	|susbaka@gmail.com		|sussybaka	|
	|joe					|mama		|