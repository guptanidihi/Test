Review of search.feature

Technical Issue:
1. This feature wont run as it has 'Scenario Outline' structure with no example section. The Scenario Outline steps provide a template which is never directly run. A Scenario Outline is run once for each row in the Examples section. 

Resolution of Technical Issue:
Instead of 'Scenario Outline' we should use 'Scenario' structure. Their is no need to use 'Scenario Outline' as we are not searching on the Clear Channels website with multiple sets of data.


Improvements:
1. The english in the feature is not clear and simple which is the main purpose of BDD.
2. The gherkin syntax is insufficient. Their is no 'Then' keyword to depict the outcome of the search. we can add THEN to validate the search results as well.
3. There are no tags. We can add tags for selective execution of scenarios.

Resolution of the issues above:

Feature: Searching on the clear channel website
I want to be able to search the website so that I can find the information I am looking for

@Search
Scenario: User is able to search

Given I go to https://www.clearchannelinternational.com/
When I go to the the header
And I click on the icon on the right 
Then It should take me to the page where I can search

@Searchresults
Scenario: User finds the information based on his search

Given I have reached the page where I can search
When I enter test 
And I click on the icon on the right to execute search
Then It should take me to the search results page

	