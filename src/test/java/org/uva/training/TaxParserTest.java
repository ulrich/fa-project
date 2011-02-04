package org.uva.training;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.uva.training.entity.Item;
import org.uva.training.entity.Product;
import org.uva.training.entity.Type;

@RunWith(JUnit4.class)
public class TaxParserTest {

   @Test
   public void testParseWithItemWithoutTaxes() {
      Product product = new Product(Type.FOOD, "Gâteau", false);
      Item item = new Item(product, 1, 7.50f);

      TaxParser taxParser = new TaxParser();
      taxParser.parse(item);
      assertEquals(0, item.getTaxes().size());
   }

   @Test
   public void testParseWithItemWithTVA() {
      Product product = new Product(Type.CD, "Muse", false);
      Item item = new Item(product, 1, 10.50f);

      TaxParser taxParser = new TaxParser();
      taxParser.parse(item);
      assertEquals(1, item.getTaxes().size());
   }

   @Test
   public void testParseWithItemWithImportTax() {
      Product product = new Product(Type.DRUG, "Doliprane", true);
      Item item = new Item(product, 1, 2.50f);

      TaxParser taxParser = new TaxParser();
      taxParser.parse(item);
      assertEquals(1, item.getTaxes().size());
   }

   @Test
   public void testParseWithItemWithImportTaxAndTVA() {
      Product product = new Product(Type.COSMETIC, "Makeup", true);
      Item item = new Item(product, 1, 5.50f);

      TaxParser taxParser = new TaxParser();
      taxParser.parse(item);
      assertEquals(2, item.getTaxes().size());
   }
}
