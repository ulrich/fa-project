package org.uva.training.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.uva.training.entity.Item;
import org.uva.training.handler.BookItemHandler;
import org.uva.training.handler.CDItemHandler;
import org.uva.training.handler.CosmeticItemHandler;
import org.uva.training.handler.DrugItemHandler;
import org.uva.training.handler.FoodItemHandler;
import org.uva.training.handler.Handler;

/**
 * This class aims to found the corresponding handler by an RawEntry and return an Item.
 * 
 * @author uvachon
 */
public class RawEntryHandler {
   private static final Log LOG = LogFactory.getLog(RawEntryHandler.class);
   private final Handler<Item, RawEntry> entryPoint;

   public RawEntryHandler() {
      Handler<Item, RawEntry> foodItemHandler = new FoodItemHandler(null);
      Handler<Item, RawEntry> drugItemHandler = new DrugItemHandler(foodItemHandler);
      Handler<Item, RawEntry> cosmeticItemHandler = new CosmeticItemHandler(drugItemHandler);
      Handler<Item, RawEntry> cdItemHandler = new CDItemHandler(cosmeticItemHandler);
      entryPoint = new BookItemHandler(cdItemHandler);
   }

   /**
    * Handles an {@link RawEntry}.
    * 
    * @param rawEntry the raw entry used to retrieve an item.
    * @return the corresponding item or null.
    */
   public Item handle(RawEntry rawEntry) {
      Item item = entryPoint.handlerRequest(rawEntry);
      if (null == item) {
         LOG.warn("No handler found for the entry: " + rawEntry.getName());
      }
      return item;
   }
}
