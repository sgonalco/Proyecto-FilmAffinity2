#language: en
Feature: Actor API

  Scenario: return an Actor using ID
    Given I have an actor with existing ID 1
    When I request GET "/api/actores/1"
    Then response status should be 200
    And response should contain name "Leonardo DiCaprio"
