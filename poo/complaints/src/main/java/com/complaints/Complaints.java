package com.complaints;

import com.complaints.Complaint;

import java.util.*;

public class Complaints {
  protected ArrayList<Complaint> complaints = new ArrayList<Complaint>();

  private boolean checkComplaintIsNew(Complaint newComplaint) {
    Iterator<Complaint> iterate = this.complaints.iterator();
    while(iterate.hasNext()) {
      Complaint currentComplaint = iterate.next();
      if (currentComplaint.getCode().equals(newComplaint.getCode())) {
        System.out.println("A complaint with the code provided already exists.");
        return false;    
      }
    }
    return true;
  }

  private void insert(Complaint newComplaint) {
      this.complaints.add(newComplaint);
  }

  public boolean addComplaint(Complaint newComplaint) {
    if (this.checkComplaintIsNew(newComplaint)) {
      this.insert(newComplaint);
      System.out.println("Complaint was created successfully");
      return true;
    }
    return false;
  }

  public int getLength() {
    return this.complaints.size();
  }

  public void reset() {
    this.complaints.clear();
  }

  public void show() {
    Iterator<Complaint> iterate = this.complaints.iterator();
    while(iterate.hasNext()) {
      Complaint currentComplaint = iterate.next();
      currentComplaint.show();
    }
  } 
}
