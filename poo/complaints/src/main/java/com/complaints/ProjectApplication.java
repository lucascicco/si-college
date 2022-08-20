package com.complaints.main;

import java.util.*;  

import com.complaints.Complaint;
import com.complaints.Complaints;
import com.complaints.ComplaintFactory;

public class ProjectApplication {

  public static void main(String[] args) {
    System.out.println("Create a complaint, type: create");
    System.out.println("Show complaints, type: show");
    System.out.println("Close program, type: exit");
      
    Complaints complaints = new Complaints();
    Scanner reader = new Scanner(System.in);
    boolean isRunning = true;
    
    while(isRunning) {
      String cmd = reader.next();
      switch (cmd) {
        case "create":
          boolean hasCreated = false;
          while (!hasCreated) {
            Complaint newComplaint = ComplaintFactory.build();
            hasCreated = complaints.addComplaint(newComplaint);
          }
          break;
        case "show":
          complaints.show();
          break;
        case "exit":
          isRunning = false; 
          break;
        default:
          break;
      }
    }

    reader.close();
  }

}
