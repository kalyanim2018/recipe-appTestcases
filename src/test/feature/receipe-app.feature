Feature: recipe-app
  As a user of the recipe-app application
  I want to view the recipes and add them to the shopping list
  so that I can manage the shopping list along with the quantities


  Scenario Outline: Recipe-app System Integration Testing

    Given that the tests are to be run on "<testenvironment>" using "<browser>"  browser
    And user go to "url" in "<testenvironment>"
    When user chooses "<recipe>" recipe and select "<dropdown>" option from "Manage Recipes" dropdown
    Then the user will be redirected to "<option>" page in "<testenvironment>"
    And the user chooses to "<modify>" the selected "<recipe>" recipe portions on "<option>" page and "<modify>" it accordingly


  @prod
  Examples:

    |testenvironment  | browser   |recipe|dropdown|option|modify|
    |prod         |chrome |Chinese Chicken |Add to shopping List|shopping List        |Update|
    |prod         |chrome |Sausage Casserole |Add to shopping List|ShoppingList        |Update|
    |prod         |chrome |Taco Meat Recipe |Add to shopping List|ShoppingList        |Update|
    |prod         |chrome |Egg delight |Add to shopping List|ShoppingList        |Update|
    |prod         |chrome |Fried EggPlant |Add to shopping List|ShoppingList        |Update|
    |prod         |chrome |Chinese Chicken |Add to shopping List|shopping List        |Delete|
    |prod         |chrome |Sausage Casserole |Add to shopping List|ShoppingList        |Delete|
    |prod         |chrome |Taco Meat Recipe |Add to shopping List|ShoppingList        |Delete|
    |prod         |chrome |Egg delight |Add to shopping List|ShoppingList        |Delete|
    |prod         |chrome |Fried EggPlant |Add to shopping List|ShoppingList        |Delete|
    |prod         |chrome |Chinese Chicken |Add to shopping List|shopping List        |Clear|
    |prod         |chrome |Sausage Casserole |Add to shopping List|ShoppingList        |Clear|
    |prod         |chrome |Taco Meat Recipe |Add to shopping List|ShoppingList        |Clear|
    |prod         |chrome |Egg delight |Add to shopping List|ShoppingList        |Clear|
    |prod         |chrome |Fried EggPlant |Add to shopping List|ShoppingList        |Clear|



  @test
  Examples:

    |testenvironment  | browser   |recipe|dropdown|option|modify|
    |dev         |chrome |Chinese Chicken |Add to shopping List|shopping List        |Update|
    |dev         |chrome |Sausage Casserole |Add to shopping List|ShoppingList        |Update|
    |dev         |chrome |Taco Meat Recipe |Add to shopping List|ShoppingList        |Update|
    |dev         |chrome |Egg delight |Add to shopping List|ShoppingList        |Update|
    |dev         |chrome |Fried EggPlant |Add to shopping List|ShoppingList        |Update|
    |dev         |chrome |Chinese Chicken |Add to shopping List|shopping List        |Delete|
    |dev         |chrome |Sausage Casserole |Add to shopping List|ShoppingList        |Delete|
    |dev         |chrome |Taco Meat Recipe |Add to shopping List|ShoppingList        |Delete|
    |dev         |chrome |Egg delight |Add to shopping List|ShoppingList        |Delete|
    |dev         |chrome |Fried EggPlant |Add to shopping List|ShoppingList        |Delete|
    |dev         |chrome |Chinese Chicken |Add to shopping List|shopping List        |Clear|
    |dev         |chrome |Sausage Casserole |Add to shopping List|ShoppingList        |Clear|
    |dev         |chrome |Taco Meat Recipe |Add to shopping List|ShoppingList        |Clear|
    |dev         |chrome |Egg delight |Add to shopping List|ShoppingList        |Clear|
    |dev         |chrome |Fried EggPlant |Add to shopping List|ShoppingList        |Clear|