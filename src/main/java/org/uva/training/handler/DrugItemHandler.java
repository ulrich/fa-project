package org.uva.training.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.uva.training.entity.Item;
import org.uva.training.entity.Type;
import org.uva.training.utils.RawEntry;

/**
 * Handler used to find drug product in the entry.
 * 
 * @author uvachon
 */
public class DrugItemHandler extends ProductItemHandler {
   private static final String[] KEYWORDS = {"pilules", "comprimés"};
   private static final Log LOG = LogFactory.getLog(DrugItemHandler.class);

   public DrugItemHandler(Handler<Item, RawEntry> successor) {
      super(successor);
   }

   @Override
   public Item handlerRequest(RawEntry rawEntry) {
      if (null == rawEntry) {
         return null;
      }
      Item item = buildItem(rawEntry, Type.DRUG, KEYWORDS);
      if (null != item) {
         LOG.debug("Found and built a drug item");
         return item;
      }
      return super.handlerRequest(rawEntry);
   }
}
