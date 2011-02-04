package org.uva.training;

import org.uva.training.entity.Item;
import org.uva.training.tax.ImportTax;
import org.uva.training.tax.TVATax;
import org.uva.training.tax.Tax;

/**
 * In this parser, we could pull taxes from <i>TaxService</i> for others taxes.
 * 
 * @author uvachon
 */
public class TaxParser {

   public void parse(Item item) {
      Tax tvaTax = new TVATax();
      apply(item, tvaTax);
      //
      Tax importTax = new ImportTax();
      apply(item, importTax);
   }

   private void apply(Item item, Tax tax) {
      if (tax.isApplicable(item)) {
         item.addTax(tax);
      }
   }
}
