package org.uva.training.io.writer;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;

import org.antlr.stringtemplate.StringTemplate;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.uva.training.entity.Bill;
import org.uva.training.entity.Item;

/**
 * Very basic writer using StringTemplate for rendering.
 * 
 * @author uvachon
 */
public class BillWriter {
   private static Log LOG = LogFactory.getLog(BillWriter.class);
   private static final String BILL_TEMPLATE_FILENAME = "org/uva/training/io/writer/bill.st";

   public void write(Bill bill, File output) {
      String fillBillTemplate = fillBillTemplate(bill);

      try {
         FileUtils.writeStringToFile(output, fillBillTemplate);
      } catch (IOException e) {
         throw new RuntimeException("An unexepected error occurred while writing bill file", e);
      }
   }

   // filling template file
   private String fillBillTemplate(Bill bill) {
      File file = null;
      try {
         file = new File(BillWriter.class.getClassLoader().getResource(BILL_TEMPLATE_FILENAME).toURI());
      } catch (URISyntaxException e) {
         throw new RuntimeException("An unexepected error occurred while retrieving bill template file", e);
      }
      if (!file.exists()) {
         throw new RuntimeException("Unable to locate the bill template file");
      }

      StringTemplate template = null;
      try {
         template = new StringTemplate(FileUtils.readFileToString(file));
      } catch (IOException e) {
         throw new RuntimeException("Unable to read bill template file");
      }

      LOG.info("Bill template file found, filling...");
      template.setAttribute("items", prepareItemList(bill.getItems()));
      template.setAttribute("taxesValue", bill.getTaxesValue());
      template.setAttribute("ttcValue", bill.getTtcValue());

      return template.toString();
   }

   // oops, I thought we could use ST for iterate elements...
   private String prepareItemList(Collection<Item> items) {
      StringBuilder result = new StringBuilder();
      for (Item item : items) {
         result.append(item.getQuantity()).append(" ").append(item.getProduct().getName()).append(" ").append(item.ttcValue()).append(" ").append("\n");
      }
      return result.toString();
   }
}
