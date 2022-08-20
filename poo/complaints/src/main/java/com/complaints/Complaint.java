package com.complaints;

import java.util.Date;  
import java.text.SimpleDateFormat;  
import java.util.Scanner;

public class Complaint {
  private String code;
  private Date date;
  private String description;
  
  Complaint(String code, Date date, String description) {
    this.code = code;
    this.date = date;
    this.description = description;
  }
  
  public String getCode() {
    return this.code;
  }

  public Date getDate() {
    return this.date;
  }

  public String getDescription() {
    return this.description;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void setDate(Date date) {
    this.date = date;
  }
  public void getDescription(String description) {
    this.description = description;
  }

  public void show() {
    System.out.println("======= Complaint =======");
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String formattedDate = dateFormat.format(this.date);
    System.out.println("Code:" + this.code);
    System.out.println("Date of the occurrence:" + formattedDate);
    System.out.println("Description:" + this.description);
  }
}

