package org.uva.training.entity;

import java.util.Collection;

public class Bill {
   private Collection<Item> items;
   private float ttcValue;
   private float taxesValue;

   public Bill(Collection<Item> items) {
      this.items = items;

      for (Item item : items) {
         taxesValue += item.taxesValue();
         ttcValue += item.ttcValue();
      }
   }

   public Collection<Item> getItems() {
      return items;
   }

   public float getTtcValue() {
      return ttcValue;
   }

   public float getTaxesValue() {
      return taxesValue;
   }
}
