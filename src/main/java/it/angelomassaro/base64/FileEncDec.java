package it.angelomassaro.base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.Base64;

import org.apache.commons.io.FileUtils;

public class FileEncDec
{
   public static void main(String[] args)
   {
	  
	  File file = new File ("C:/temp/Esempio.pdf");
	  
	  
      try (FileInputStream fis = new FileInputStream(file))
      {
         Base64.Encoder enc1 = Base64.getEncoder();
         Base64.Encoder enc2 = Base64.getMimeEncoder();
         Base64.Encoder enc3 = Base64.getUrlEncoder();
         OutputStream os1 = enc1.wrap(new FileOutputStream(file + "1.enc"));
         OutputStream os2 = enc2.wrap(new FileOutputStream(file + "2.enc"));
         OutputStream os3 = enc3.wrap(new FileOutputStream(file + "3.enc"));
         
         
         
         int _byte;
         while ((_byte = fis.read()) != -1)
         {
            os1.write(_byte);
            os2.write(_byte);
            os3.write(_byte);
         }
         os1.close();
         os2.close();
         os3.close();
      }
      catch (IOException ioe)
      {
         System.err.printf("I/O error: %s%n", ioe.getMessage());
      }
      
      try (FileOutputStream fos1 = new FileOutputStream(file + "4.dec");
           FileOutputStream fos2 = new FileOutputStream(file + "5.dec");
           FileOutputStream fos3 = new FileOutputStream(file + "6.dec"))
      {
         Base64.Decoder dec1 = Base64.getDecoder();
         Base64.Decoder dec2 = Base64.getMimeDecoder();
         Base64.Decoder dec3 = Base64.getUrlDecoder();
         InputStream is1 = dec1.wrap(new FileInputStream(file + "1.enc"));
         InputStream is2 = dec2.wrap(new FileInputStream(file + "2.enc"));
         InputStream is3 = dec3.wrap(new FileInputStream(file + "3.enc"));
         int _byte;
         while ((_byte = is1.read()) != -1)
            fos1.write(_byte);
         while ((_byte = is2.read()) != -1)
            fos2.write(_byte);
         while ((_byte = is3.read()) != -1)
            fos3.write(_byte);
         is1.close();
         is2.close();
         is3.close();
      }
      catch (IOException ioe)
      {
         System.err.printf("I/O error: %s%n", ioe.getMessage());
      }
      
   }
}