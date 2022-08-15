#include "string_trim.c"
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct {
  int year;
  int month;
  int day;
} Date;

typedef struct {
  char code[50];
  Date date;
  char description[255];
} Report;

typedef struct {
  Report *array;
  size_t size;
} Reports;

void initReports(Reports *a) {
  Report *report_pointer;
  report_pointer = (Report *)malloc(sizeof(Report));
  if (report_pointer != NULL) {
    a->array = report_pointer;
    a->size = 0;
  } else {
    printf("Unable to allocate memory, exiting.\n");
    free(report_pointer);
    exit(0);
  }
}

void addReport(Reports *a, Report *r) {
  Report element;
  element = *r;

  Report *report_pointer;
  a->size += 1;
  if (a->array != NULL) {
    printf("Is not NULL");
  }
  report_pointer = (Report *)realloc(a->array, a->size * sizeof(Report));

  if (report_pointer != NULL) {
    a->array = report_pointer;
    a->array[a->size - 1] = element;
  } else {
    printf("Unable to reallocate memory, exiting.\n");
    free(report_pointer);
    exit(0);
  }
}

void removeReports(Reports *a) {
  free(a->array);
  a->array = NULL;
}

int checkReportIsNew(Reports *a, char newCode[50]) {
  int i;
  for (i = 0; i < a->size; i++) {
    if (a->array[i].code == newCode) {
      return 0;
    };
  };
  return 1;
};

void showReport(Report *r) {
  printf("======= DENÚNCIA =======\n");
  printf("Código: %s \n", r->code);
  printf("Data: %d/%d/%d \n", r->date.day, r->date.month, r->date.year);
  printf("Descrição: %s \n", r->description);
}

void inputReport(Reports *a, Report *r) {
  bool mustInsertCode = true;
  while (mustInsertCode) {
    printf("Insira o código da denúncia\n");
    scanf("%s", r->code);
    if (checkReportIsNew(a, r->code)) {
      mustInsertCode = false;
    }
  }
  printf("Insira a data da denúncia, exemplo: 14/07/2000\n");
  char date[10];
  char **dates;
  scanf("%s", date);
  dates = str_split(date, '/');
  r->date.day = atoi(dates[0]);
  r->date.month = atoi(dates[1]);
  r->date.year = atoi(dates[2]);
  printf("Insira a descrição da denúncia, número máximo de caracteres é 255\n");
  scanf("%s", r->description);
}

void showReports(Reports *a) {
  int index;
  printf("Todas as denúncias existentes / Total %zu \n", a->size);
  for (index = 0; index < a->size; index++) {
    Report r = a->array[index];
    showReport(&r);
  };
}
