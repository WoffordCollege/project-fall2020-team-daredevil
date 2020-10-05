Feature: Play the Phase 6 version of the game with one human and one, two, or three random AI players.
  
  The user should be able to play the Phase 6 version of the game against random AI players.


  Scenario: The user runs the program in "phase6" mode with one AI opponent.
    When the program is run as "phase6" with argument "2"
    Then the game log should be accurate using the "standard" market

  Scenario: The user runs the program in "phase6" mode with two AI opponents.
    When the program is run as "phase6" with argument "3"
    Then the game log should be accurate using the "standard" market

  Scenario: The user runs the program in "phase6" mode with three AI opponents.
    When the program is run as "phase6" with argument "4"
    Then the game log should be accurate using the "standard" market
