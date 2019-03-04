Feature: Shopping cart process

Scenario Outline: Consultant1 with invalid conditions is NOT able to checkout
		  Corresponding message is displayed
		  
Given user "Consultant1" is already logged in
Given user click on New dossier
Given user select modify existing credit business and click continue
Given user search for customer "Wenger" and click continues
Then system create a new dossier

Given user click on product tab
Then user should see only one tranche
Given user click on the tranche
When user click on modify
Then user should see the shopping cart tab

#Then user should see the message "Spouse/partner information is missing." on Alerts section
#When user click on checkout button
#Then user should see error message "<message>"
#When user click on OK on error popup
#Then user should not see error message "<message>"
#When user click on logout
#Then user should see confirmation message "You are about to leave a task in progress, so you may lose your current work. Do you want to leave?"
#When user click on OK on confirm popup
#Then user should logout

Given user "CrdOfficeMidWest" is already logged in
Given user click Dossier Overview page
When user search for dossier id
Then verify dossier exists

Examples:
|message|
|To proceed to checkout, data has to be completed and alerts with severity error have to be resolved|



#Scenario: User with invalid conditions is NOT able to checkout
#		  Corresponding message is displayed

#Given user "CrdOfficeMidWest" is already logged in
#Given user select modify existing credit business and click continue
#Given user search for customer "Wenger" and click continues
#Given user click on product tab
#Then user should see only one tranche
#Given user click on the tranche
#When user click on modify
#Then user should see the shopping cart tab
#Then user should see the message "Spouse/partner information is missing." on Alerts section
#When user click on checkout button
#Then user should see error message "To proceed to checkout, data has to be completed and alerts with severity error have to be resolved"