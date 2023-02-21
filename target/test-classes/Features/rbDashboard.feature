
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Search for Buses
    Given I want to be in Home Page URL "https://www.redbus.in/"
    When I want to Enter From City
    Then I want to Select From City
    When I want to Enter To City
    Then I want to Select To City
    When I want to Click on Swap Circle
    Then I want to select Date
    Then I want to search Buses

Example:"datafile"-"/RedBus/Test-data/Value.xlsx", sheetName ;:
  
