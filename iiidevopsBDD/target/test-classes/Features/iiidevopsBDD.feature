Feature: iiidevops test
  A working cucumber sample

  Scenario: Log in iiidevops
    Given Open a new chrome browser and navigate to iiidevops
    When Log in iiidevops with username "ninox" and password "Ninox5432"
    And Wait for 5.0 seconds
    Then Successfully log into iiidevops
    
  Scenario: Cleanup
    When close browser

