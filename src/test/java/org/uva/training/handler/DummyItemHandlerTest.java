package org.uva.training.handler;

import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.uva.training.entity.Item;
import org.uva.training.utils.RawEntry;

/**
 * This class test essentially the behavior with bad values entries.
 * 
 * @author uvachon
 */
@RunWith(JUnit4.class)
public class DummyItemHandlerTest {
   private BookItemHandler dummyItemHandler;

   @Before
   public void before() {
      dummyItemHandler = new BookItemHandler(null);
   }

   @Test
   public void testHandlerRequestWithErrorRawEntry() {
      RawEntry rawEntry = new RawEntry("1", "", "12.10");
      Item item = dummyItemHandler.handlerRequest(rawEntry);
      assertNull(item);
   }

   @Test(expected = NumberFormatException.class)
   public void testHandlerRequestWithNumberFormatExceptionForQuantityInRawEntry() {
      RawEntry rawEntry = new RawEntry("foo", "livre", "12.10");
      dummyItemHandler.handlerRequest(rawEntry);
   }

   @Test(expected = NumberFormatException.class)
   public void testHandlerRequestWithNumberFormatExceptionForPriceInRawEntry() {
      RawEntry rawEntry = new RawEntry("1", "livre", "bar");
      dummyItemHandler.handlerRequest(rawEntry);
   }
}
