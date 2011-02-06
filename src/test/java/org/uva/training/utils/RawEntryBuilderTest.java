package org.uva.training.utils;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RawEntryBuilderTest {
   private String[] goodEntries = {"1 livre � 12.49", "1 CD musical � 14.99", "1 barre de chocolat � 0.85", "1 boite de chocolats import�e � 10.00",
         "1 flacon de parfum import� � 47.50", "1 flacon de parfum import � 27.99", "1 flacon de parfum � 18.99",
         "1 boite de pilules contre la migraine � 9.75", "1 boite de chocolats import�s � 11.25"};
   private String[] badEntries = {"livre � 12.49", "1 14.99", "1 0.85 barre de chocolat"};

   @Test
   public void testValidateWithGoodEntries() {
      for (String entry : goodEntries) {
         assertNotNull(RawEntryBuilder.build(entry));
      }
   }

   @Test
   public void testValidateWithBadEntries() {
      for (String entry : badEntries) {
         assertNull(RawEntryBuilder.build(entry));
      }
   }

   @Test
   public void testValidateOutput() {
      RawEntry entry = RawEntryBuilder.build(goodEntries[0]);
      assertNotNull(entry);
      assertEquals("1", entry.getQuantity());
      assertEquals("livre", entry.getName());
      assertEquals("12.49", entry.getPrice());
   }
}
