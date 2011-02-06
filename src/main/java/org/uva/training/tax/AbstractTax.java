package org.uva.training.tax;

/**
 * This abstract class contains only common method(s) to compute a tax value.<br/>
 * 
 * <pre>
 * --------------------------------
 * | Taxe calculée | Taxe imputée |
 * --------------------------------
 * |          0.99 |         1.00 |
 * --------------------------------
 * |          1.00 |         1.00 |
 * --------------------------------
 * |          1.01 |         1.05 |
 * --------------------------------
 * |          1.02 |         1.05 |
 * --------------------------------
 * </pre>
 * 
 * <br/>
 * The around method must follows this rules.
 * 
 * @author uvachon
 */
public abstract class AbstractTax implements Tax {

   /**
    * Takes a tax and around it.
    * 
    * @param value the tax value to compute.
    * @return the rounded value.
    */
   protected float around(float value) {
      return value;
   }
}
