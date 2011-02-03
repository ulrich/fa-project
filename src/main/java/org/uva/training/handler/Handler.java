package org.uva.training.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.uva.training.entity.Item;
import org.uva.training.entity.Product;

/**
 * This is the base class of chain of responsibility used to identify elements.
 * 
 * @author uvachon
 * @param <U> type like {@link Product}.
 * @param <V> type like {@link Item}.
 */
public abstract class Handler<U, V> {
   protected Log log = LogFactory.getLog(this.getClass());
   protected Handler<U, V> successor = null;

   public Handler(Handler<U, V> successor) {
      this.successor = successor;
   }

   /**
    * This method returns an handler able to manage element or null.
    * 
    * @param t the typed handler.
    * @return an handler able to manage element or null.
    */
   public U handlerRequest(V v) {
      if (null == successor) {
         return null;
      }
      return successor.handlerRequest(v);
   }
}
