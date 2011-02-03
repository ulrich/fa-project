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
 * This class tests essentially the behavior with book and other entries.<br/>
 * The error handler are testing in this class {@link DummyItemHandlerTest}.
 * 
 * @author uvachon
 */
@RunWith(JUnit4.class)
public class BookItemHandlerTest {
   private BookItemHandler bookItemHandler;

   @Before
   public void before() {
      bookItemHandler = new BookItemHandler(null);
   }

   @Test
   public void testHandlerRequestWithBookTypeRawEntry() {
      RawEntry rawEntry = new RawEntry("1", "livre", "12.10");
      Item item = bookItemHandler.handlerRequest(rawEntry);
      assertNotNull(item);
   }

   @Test
   public void testHandlerRequestWithBookAndVariationTypeRawEntry() {
      RawEntry rawEntry = new RawEntry("1", "livres", "12.10");
      Item item = bookItemHandler.handlerRequest(rawEntry);
      assertNotNull(item);
   }

   @Test
   public void testHandlerRequestWithAnotherTypeRawEntry() {
      RawEntry rawEntry = new RawEntry("1", "CD", "12.10");
      Item item = bookItemHandler.handlerRequest(rawEntry);
      assertNull(item);
   }
}
