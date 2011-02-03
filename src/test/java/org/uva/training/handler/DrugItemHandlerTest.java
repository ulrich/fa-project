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
 * This class tests essentially the behavior with drug and other entries.<br/>
 * The error handler are testing in this class {@link DummyItemHandlerTest}.
 * 
 * @author uvachon
 */
@RunWith(JUnit4.class)
public class DrugItemHandlerTest {
   private DrugItemHandler drugItemHandler;

   @Before
   public void before() {
      drugItemHandler = new DrugItemHandler(null);
   }

   @Test
   public void testHandlerRequestWithDrugTypeRawEntry() {
      RawEntry rawEntry = new RawEntry("7", "pilule", "12");
      Item item = drugItemHandler.handlerRequest(rawEntry);
      assertNotNull(item);
   }

   @Test
   public void testHandlerRequestWithDrugAndVariationTypeRawEntry() {
      RawEntry rawEntry = new RawEntry("7", "pilules", "12");
      Item item = drugItemHandler.handlerRequest(rawEntry);
      assertNotNull(item);
   }

   @Test
   public void testHandlerRequestWithAnotherTypeRawEntry() {
      RawEntry rawEntry = new RawEntry("7", "ordinateur", "21");
      Item item = drugItemHandler.handlerRequest(rawEntry);
      assertNull(item);
   }
}
