#include "utils.c"
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
void init_complaints(Complaints *a) {
  Complaint *p_complaint;
  p_complaint = (Complaint *)malloc(sizeof(Complaint));
  if (p_complaint != NULL) {
    a->array = p_complaint;
    a->size = 0;
  } else {
    printf("Unable to allocate memory, exiting.\n");
    free(p_complaint);
    exit(0);
  }
}

// Remove
void remove_complaints(Complaints *a) {
  free(a->array);
  a->array = NULL;
}

// Show
void show_complaint(Complaint *r) {
  printf("======= Complaint =======\n");
  printf("Code: %s \n", r->code);
  printf("Date of the occurrence: %d/%d/%d \n", r->date.day, r->date.month,
         r->date.year);
  printf("Description: %s \n", r->description);
};

void show_complaints(Complaints *a) {
  int index;
  printf("All complaints \nTotal %zu \n", a->size);
  for (index = 0; index < a->size; index++) {
    Complaint r = a->array[index];
    show_complaint(&r);
  };
}

int check_complaint_is_new(Complaints *a, char newCode[50]) {
  int i;
  for (i = 0; i < a->size; i++) {
    if (strcmp(a->array[i].code, newCode) == 0) {
      return 0;
    };
  };
  return 1;
};

// Insertion
void input_complaint(Complaints *a, Complaint *r) {
  int mustInsertCode = 1;
  while (mustInsertCode) {
    printf("Insert the complaint's code \n");
    char newCode[50];
    scanf("%s", newCode);
    if (check_complaint_is_new(a, newCode)) {
      mustInsertCode = 0;
      strcpy(r->code, newCode);
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
void insert_complaint(Complaints *a, Complaint *r) {
  Complaint element;
  element = *r;

  Complaint *p_complaint;
  a->size += 1;
  p_complaint = (Complaint *)realloc(a->array, a->size * sizeof(Complaint));

  if (p_complaint != NULL) {
    a->array = p_complaint;
    a->array[a->size - 1] = element;
  } else {
    printf("Unable to reallocate memory, exiting.\n");
    free(p_complaint);
    exit(0);
  }
}
void create_complaint(Complaints *a) {
  Complaint newComplaint;

  input_complaint(a, &newComplaint);
  insert_complaint(a, &newComplaint);

  printf("Complaint has been created successfully!\n");
};
