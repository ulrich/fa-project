package org.uva.training.handler;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.uva.training.entity.Item;
import org.uva.training.utils.RawEntry;

/**
 * This class tests essentially the behavior with food and other entries.<br/>
 * The error handler are testing in this class {@link DummyItemHandlerTest}.
 * 
 * @author uvachon
 */
@RunWith(JUnit4.class)
public class FoodItemHandlerTest {
   private FoodItemHandler foodItemHandler;

   @Before
   public void before() {
      foodItemHandler = new FoodItemHandler(null);
   }

   @Test
   public void testHandlerRequestWithFoodTypeRawEntry() {
      RawEntry rawEntry = new RawEntry("4", "chocolat", "7");
      Item item = foodItemHandler.handlerRequest(rawEntry);
      assertNotNull(item);
   }

   @Test
   public void testHandlerRequestWithFoodAndVariationTypeRawEntry() {
      RawEntry rawEntry = new RawEntry("4", "chocolats", "7");
      Item item = foodItemHandler.handlerRequest(rawEntry);
      assertNotNull(item);
   }

   @Test
   public void testHandlerRequestWithAnotherTypeRawEntry() {
      RawEntry rawEntry = new RawEntry("2", "lampe", "21.5");
      Item item = foodItemHandler.handlerRequest(rawEntry);
      assertNull(item);
   }
}
