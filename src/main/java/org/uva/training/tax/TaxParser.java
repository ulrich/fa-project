package org.uva.training.tax;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.uva.training.entity.Item;

/**
 * In this parser, we could pull taxes from <i>TaxService</i> for grab others taxes.
 * 
 * @author uvachon
 */
public class TaxParser {
   private static Log LOG = LogFactory.getLog(TaxParser.class);

   /**
    * Parses item and decides if the tax must be applied.
    * 
    * @param item the item to analyze.
    */
   public void parse(Item item) {
      apply(item, new TVATax(item));
      apply(item, new ImportTax(item));
   }

   // decides if the tax must be applied
   private void apply(Item item, Tax tax) {
      if (tax.isApplicable()) {
         LOG.debug("Parsing and applying tax: " + tax.getClass().getName() + " for the following item: " + item.getProduct().getName());
         item.addTax(tax);
      }
   }
}
