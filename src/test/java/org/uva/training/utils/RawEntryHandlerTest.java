package org.uva.training.utils;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.uva.training.entity.Item;

@RunWith(JUnit4.class)
public class RawEntryHandlerTest {
   private RawEntryHandler rawEntryHandler;

   @Before
   public void before() {
      rawEntryHandler = new RawEntryHandler();
   }

   @Test
   public void testHandleWithAValidRawEntry() {
      RawEntry rawEntry = new RawEntry("1", "livre", "10.5");
      Item bookItem = rawEntryHandler.handle(rawEntry);
      assertNotNull(bookItem);
   }

   @Test
   public void testHandleWithAInvalidRawEntry() {
      RawEntry rawEntry = new RawEntry("1", "playstation3", "200.5");
      Item itemNotFound = rawEntryHandler.handle(rawEntry);
      assertNull(itemNotFound);
   }
}
