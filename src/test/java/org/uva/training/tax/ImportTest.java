package org.uva.training.tax;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;
import org.uva.training.entity.Item;
import org.uva.training.entity.Product;
import org.uva.training.entity.Type;
import org.uva.training.tax.ImportTax;
import org.uva.training.tax.Tax;

public class ImportTest {

   @Test
   public void testComputeWithImport() {
      float computedPrice = 0.52500004f;

      Product product = new Product(Type.CD, "Muse", true);
      Item item = new Item(product, 1, 10.50f);

      Tax importTax = new ImportTax();
      importTax.compute(item);
      assertEquals(computedPrice, importTax.getValue());
   }
}
