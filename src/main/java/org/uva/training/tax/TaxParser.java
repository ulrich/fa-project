package org.uva.training.tax;

import org.uva.training.entity.Item;

/**
 * In this parser, we could pull taxes from <i>TaxService</i> for others taxes.
 * 
 * @author uvachon
 */
public class TaxParser {

   public void parse(Item item) {
      Tax tvaTax = new TVATax(item);
      apply(item, tvaTax);
      //
      Tax importTax = new ImportTax(item);
      apply(item, importTax);
   }

   private void apply(Item item, Tax tax) {
      if (tax.isApplicable()) {
         item.addTax(tax);
      }
   }
}
