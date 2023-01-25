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
    | Space         | SpaceX Backpack |     3     |


