package com.complaints;

import java.util.Date;  
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.text.ParseException;

import com.complaints.Complaint;

public class ComplaintFactory {
  public static Complaint build() {
    Scanner reader = new Scanner(System.in);
    System.out.println("Insert the complaint's code");
    String code = reader.next();
    System.out.println("Insert the occurrence's day, e.g: 14/07/2000");
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = null;
    while (date == null) {
      try {
        date = formatter.parse(reader.next());
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Insert the complaint's description, caracteres is limited to 255");
    String description = reader.next();
    return new Complaint(code, date, description);
  }
}
