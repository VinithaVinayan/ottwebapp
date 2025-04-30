Feature: Login to the OTT app

Scenario: Valid user login
	Given user launches ott app first launch screen
	When User enters username "admin" and password "admin123"
	And user logged into the application
	Then user is on home screen