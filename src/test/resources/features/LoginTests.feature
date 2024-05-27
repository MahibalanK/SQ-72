Feature: Search the product and add product to cart

  @AddProductToCart
  Scenario Outline: User navigates to Space X portal in android Emulator ,then user
    Searches Space products ,increase the quantity ,then adding to cart with validation.

    Given : User Launch Android native browser with spaceX home page
    And : User Verify the landing page has "Shop SpaceX" image
    Then : User Search the product "<SearchProduct>" in landing screen
    And : User Fetch the "product name" and "product price" in the searched page
    Then : User add the product "<Cartproduct>" with "<Quantity>" to verify the amount displayed in the app

    Examples:
    | SearchProduct | Cartproduct     |  Quantity |
    | Space         | SpaceX Backpack |     2     |

@starwars
  Scenario Outline: User launches satrt wars and verify the sorting functionality

    Given : User Launch Chrome browser and load the star wars application
    And : User sort the movies by "<Column>" and verify the last movie as "<lastMovie>"
    Then : User clicks the movie "The Empire Strikes Back" and vefify the species has "Wookie"
    And : User verify that "Planets", "Camino" is not part of "<lastMovie>"

    Examples:
      | Column   | lastMovie          |
      | Title    | The Phantom Menace  |





