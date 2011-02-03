package org.uva.training.entity;

/**
 * This class aims to store basics elements like:
 * <ul>
 * <li>Type,</li>
 * <li>name,</li>
 * <li>origin.</li>
 * </ul>
 * 
 * @author uvachon
 */
public class Product {
   private final Type type;
   private final String name;
   private final boolean imported;

   public Product(Type type, String name, boolean imported) {
      this.type = type;
      this.name = name;
      this.imported = imported;
   }

   public Type getType() {
      return type;
   }

   public String getName() {
      return name;
   }

   public boolean isImported() {
      return imported;
   }
}
