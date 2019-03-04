Feature: Debtor - Verify required fields

Scenario Outline: Fields - Family house? Yes - Is the consenting spouse debtor? No
		  
Given user "Consultant1" is already logged in
Given user click on New dossier
Given user select modify existing credit business and click continue
Given user search for customer "Wenger" and click continues
Then system create a new dossier

Given user click on Financing tab
Given user click on Debtor tab
Given user click on Financing tab
Given user click on Debtor tab

Then user should see errors display
And user should see messages

Given user click on Debtor - C.Kent
Then user click on Debtor - T.Stark
Then user click on Debtor - C.Kent
Then user should see errors display
And user should see messages

Given user click on Debtor - K.Jack
Then user click on Debtor - T.Stark
Then user click on Debtor - K.Jack
Then user should see errors display
And user should see messages
