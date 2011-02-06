package org.uva.training.tax;

/**
 * Any tax profile.
 * 
 * @FIXME: don't use float I think...
 * @author uvachon
 */
public interface Tax {
   boolean isApplicable();

   float getValue();
}
