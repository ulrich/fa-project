package org.uva.training.entity;

import static junit.framework.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import org.junit.After;
import org.junit.Test;
import org.uva.training.TaxParser;

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

   /*
    * --------------------------------
   | Taxe calculée | Taxe imputée |
   --------------------------------
   |          0.99 |         1.00 |
   --------------------------------
   |          1.00 |         1.00 |
   --------------------------------
   |          1.01 |         1.05 |
   --------------------------------
   |          1.02 |         1.05 |
   --------------------------------
    */

   public static void main(String[] args) {
      //      BigDecimal value = new BigDecimal(1.899f);
      //      value = value.setScale(2, RoundingMode.DOWN);

      System.out.println(round(1.889f));
      System.out.println(round(0.99f));
   }

   public static float round(float value) {
      BigDecimal tax = new BigDecimal(value);
      tax = tax.setScale(2, RoundingMode.DOWN);

      String s = String.valueOf(tax);

      String b = String.valueOf(s.charAt(2));
      String c = String.valueOf(s.charAt(3));
      if (Integer.parseInt(c) <= 5) {
         c = "5";
      } else {
         c = "0";
         b = String.valueOf(Integer.parseInt(b) + 1);
      }

      s = s.charAt(0) + "" + s.charAt(1) + "" + b + c;

      return Float.parseFloat(s);
   }
}
