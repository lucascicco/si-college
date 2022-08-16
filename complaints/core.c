#include "utils.c"
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

// Complaints
// Structs
typedef struct {
  int year;
  int month;
  int day;
} Date;

typedef struct {
  char code[50];
  Date date;
  char description[255];
} Complaint;

typedef struct {
  Complaint *array;
  size_t size;
} Complaints;

// Initialization
void initComplaints(Complaints *a) {
  Complaint *complaint_pointer;
  complaint_pointer = (Complaint *)malloc(sizeof(Complaint));
  if (complaint_pointer != NULL) {
    a->array = complaint_pointer;
    a->size = 0;
  } else {
    printf("Unable to allocate memory, exiting.\n");
    free(complaint_pointer);
    exit(0);
  }
}

// Remove
void removeComplaints(Complaints *a) {
  free(a->array);
  a->array = NULL;
}

// Show
void showComplaint(Complaint *r) {
  printf("======= Complaint =======\n");
  printf("Code: %s \n", r->code);
  printf("Date of the occurrence: %d/%d/%d \n", r->date.day, r->date.month,
         r->date.year);
  printf("Description: %s \n", r->description);
}
void showComplaints(Complaints *a) {
  int index;
  printf("All complaints \nTotal %zu \n", a->size);
  for (index = 0; index < a->size; index++) {
    Complaint r = a->array[index];
    showComplaint(&r);
  };
}

int checkComplaintIsNew(Complaints *a, char newCode[50]) {
  int i;
  for (i = 0; i < a->size; i++) {
    if (a->array[i].code == newCode) {
      return 0;
    };
  };
  return 1;
};

// Insertion
void inputComplaint(Complaints *a, Complaint *r) {
  bool mustInsertCode = true;
  while (mustInsertCode) {
    printf("Insert the complaint's code \n");
    scanf("%s", r->code);
    if (checkComplaintIsNew(a, r->code)) {
      mustInsertCode = false;
    }
  }
  printf("Insert the occurrence's day, e.g: 14/07/2000 \n");
  char date[10];
  char **dates;
  scanf("%s", date);
  dates = str_split(date, '/');
  r->date.day = atoi(dates[0]);
  r->date.month = atoi(dates[1]);
  r->date.year = atoi(dates[2]);
  printf("Insert the complaint's description, caracteres is limited to 255 \n");
  scanf("%s", r->description);
}
void insertComplaint(Complaints *a, Complaint *r) {
  Complaint element;
  element = *r;

  Complaint *complaint_pointer;
  a->size += 1;
  complaint_pointer =
      (Complaint *)realloc(a->array, a->size * sizeof(Complaint));

  if (complaint_pointer != NULL) {
    a->array = complaint_pointer;
    a->array[a->size - 1] = element;
  } else {
    printf("Unable to reallocate memory, exiting.\n");
    free(complaint_pointer);
    exit(0);
  }
}
void createComplaint(Complaints *a) {
  Complaint newComplaint;
  inputComplaint(a, &newComplaint);
  insertComplaint(a, &newComplaint);
  printf("Complaint has been created successfully!\n");
};
