package org.uva.training.tax;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.math.util.MathUtils;
import org.uva.training.entity.Item;
import org.uva.training.entity.Type;

/**
 * This tax calculates her value based on price (HT) and if the product is not of type: {@link Type.BOOK}, {@link Type.FOOD}, {@link Type.DRUG}.<br/>
 * We could split the calculation of tax to another implementation (for better performance...) and the rule.
 * 
 * @author uvachon
 */
public class TVATax implements Tax {
   private final Type[] excludedTypes = {Type.BOOK, Type.FOOD, Type.DRUG};
   private float value = 0f;

   @Override
   public void compute(Item item) {
      if (ArrayUtils.contains(excludedTypes, item.getProduct().getType())) {
         return;
      }
      value = (item.getPrice() * 0.1f);
   }

   @Override
   public float getValue() {
      return value;
   }

   public static void main(String[] args) {
      System.out.println(MathUtils.nextAfter(1.01f, 0));

   }
}
