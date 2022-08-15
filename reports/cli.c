#include "reports.c"
#include <stdio.h>
#include <stdlib.h>

int main() {
  printf("Para criar uma denúncia, digite: create\n");
  printf("Para mostrar todas denúncias, digite: show\n");
  printf("Para encerrar o programa, digite: exit\n");

  int isPlaying = 1;
  Reports reports;
  initReports(&reports);

  while (isPlaying) {
    char input[5];
    scanf("%s", input);
    if (strcmp(input, "create") == 0) {
      // FIXME:
      // https://stackoverflow.com/questions/60808420/c-programming-allocation-of-pointer-lost-even-when-done-on-the-contents-of-a-do
      Report newReport;
      Report *new_report_pointer = (Report *)malloc(sizeof(Report));
      if (new_report_pointer == NULL) {
        printf("Unable to allocate memory, exiting.\n");
        free(new_report_pointer);
        exit(0);
      }
      new_report_pointer = &newReport;
      inputReport(&reports, &newReport);
      if (reports.array != NULL) {
        printf("BEFORE => Is not NULL");
      }
      showReport(&newReport);
      if (reports.array != NULL) {
        printf("AFTER => Is not NULL");
      }
      addReport(&reports, &newReport);
      printf("Denúncia criada com sucesso!\n");
    } else if (strcmp(input, "show") == 0) {
      showReports(&reports);
    } else if (strcmp(input, "exit") == 0) {
      removeReports(&reports);
      // isPlaying = 0;
    } else {
      printf("Comando inválido (%s), tente novamente!\n", input);
    }
  }

  return (0);
};
