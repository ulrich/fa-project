package org.uva.training.entity;

import static junit.framework.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.uva.training.tax.TaxParser;

public class BillTest {
   private Bill bill;
   private TaxParser taxParser = new TaxParser();

   @After
   public void after() {
      bill = null;
   }

   //1 livre à 12.49
   //1 CD musical à 14.99
   //1 barre de chocolat à 0.85
   @Test
   @Ignore
   public void testGetItems() {
      Item item1 = new Item(new Product(Type.BOOK, "livre", false), 1, 12.49f);
      Item item2 = new Item(new Product(Type.CD, "CD musical", false), 1, 14.99f);
      Item item3 = new Item(new Product(Type.FOOD, "barre de chocolat", false), 1, 0.85f);

      bill = makeBuild(item1, item2, item3);

      assertEquals(1.50f, bill.getTaxesValue());
      assertEquals(29.83f, bill.getTtcValue());
   }

   private Bill makeBuild(Item... items) {
      for (Item item : items) {
         taxParser.parse(item);
      }
      return new Bill(Arrays.asList(items));
   }
}
