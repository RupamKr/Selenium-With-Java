Feature: Find the broken link on Flipkart application

  Scenario: Actor finds the broken link on Flipkart application
    Given "Rupam" open Flipkart application
    Then he validate the title page of Flipkart
    And he find out the broken link
    And he quit the browser