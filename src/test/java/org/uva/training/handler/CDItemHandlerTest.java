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
 * This class tests essentially the behavior with CD and other entries.<br/>
 * The error handler are testing in this class {@link DummyItemHandlerTest}.
 * 
 * @author uvachon
 */
@RunWith(JUnit4.class)
public class CDItemHandlerTest {
   private CDItemHandler cdItemHandler;

   @Before
   public void before() {
      cdItemHandler = new CDItemHandler(null);
   }

   @Test
   public void testHandlerRequestWithCDTypeRawEntry() {
      RawEntry rawEntry = new RawEntry("3", "cd", "8");
      Item item = cdItemHandler.handlerRequest(rawEntry);
      assertNotNull(item);
   }

   @Test
   public void testHandlerRequestWithCDAndVariationTypeRawEntry() {
      RawEntry rawEntry = new RawEntry("3", "CD", "8");
      Item item = cdItemHandler.handlerRequest(rawEntry);
      assertNotNull(item);
   }

   @Test
   public void testHandlerRequestWithAnotherTypeRawEntry() {
      RawEntry rawEntry = new RawEntry("3", "journal", "8");
      Item item = cdItemHandler.handlerRequest(rawEntry);
      assertNull(item);
   }
}
