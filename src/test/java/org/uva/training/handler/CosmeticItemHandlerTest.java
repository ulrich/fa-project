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
 * This class tests essentially the behavior with cosmetic and other entries.<br/>
 * The error handler are testing in this class {@link DummyItemHandlerTest}.
 * 
 * @author uvachon
 */
@RunWith(JUnit4.class)
public class CosmeticItemHandlerTest {
   private CosmeticItemHandler cosmeticItemHandler;

   @Before
   public void before() {
      cosmeticItemHandler = new CosmeticItemHandler(null);
   }

   @Test
   public void testHandlerRequestWithCosmeticTypeRawEntry() {
      RawEntry rawEntry = new RawEntry("2", "parfum", "10");
      Item item = cosmeticItemHandler.handlerRequest(rawEntry);
      assertNotNull(item);
   }

   @Test
   public void testHandlerRequestWithCosmeticAndVariationTypeRawEntry() {
      RawEntry rawEntry = new RawEntry("2", "parfums", "10");
      Item item = cosmeticItemHandler.handlerRequest(rawEntry);
      assertNotNull(item);
   }

   @Test
   public void testHandlerRequestWithAnotherTypeRawEntry() {
      RawEntry rawEntry = new RawEntry("5", "jambon", "33");
      Item item = cosmeticItemHandler.handlerRequest(rawEntry);
      assertNull(item);
   }
}
