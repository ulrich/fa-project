package org.uva.training.tax;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.uva.training.entity.Item;
import org.uva.training.entity.Product;
import org.uva.training.entity.Type;
import org.uva.training.tax.TVATax;
import org.uva.training.tax.Tax;

@RunWith(JUnit4.class)
public class TVATest {

   @Test
   public void testComputeWithTVA() {
      float computedPrice = 1.21f;

      Product product = new Product(Type.COSMETIC, "Parfum1", false);
      Item item = new Item(product, 1, 12.10f);

      Tax tvaTax = new TVATax();
      tvaTax.compute(item);
      assertEquals(computedPrice, tvaTax.getValue());
   }

   @Test
   public void testComputeWithoutTVA() {
      float computedPrice = 0f;

      Product product = new Product(Type.FOOD, "chocolat", false);
      Item item = new Item(product, 1, 8.10f);

      Tax tvaTax = new TVATax();
      tvaTax.compute(item);
      assertEquals(computedPrice, tvaTax.getValue());
   }
}
