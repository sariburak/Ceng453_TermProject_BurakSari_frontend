package com.ceng453group15.frontend;

import com.ceng453group15.frontend.GameLogic.Player;
import com.ceng453group15.frontend.GameLogic.Property;
import com.ceng453group15.frontend.GameLogic.PropertyType;
import org.junit.jupiter.api.Test;

import static com.ceng453group15.frontend.GameLogic.GameConstants.DEFAULT_PLAYER_BUDGET;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PropertyTest {
    @Test
    void Property_initialization_success(){
        Property property = new Property(100, PropertyType.REGULAR);
        assertTrue(property.getType() == PropertyType.REGULAR && property.getPrice() == 100);
    }

    @Test
    void Property_getSold_success(){
       Property property = new Property(100, PropertyType.REGULAR);
       Player player = new Player();

       property.getSold(player);

        assertTrue(property.getOwner() == player && player.getBudget() == DEFAULT_PLAYER_BUDGET - property.getPrice());
    }


}
