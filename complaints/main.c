#include "core.c"
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
  printf("Create a complaint, type: create\n");
  printf("Show complaints, type: show\n");
  printf("Close program, type: exit\n");

  static Complaints complaints;
  initComplaints(&complaints);

  while (true) {
    char input[5];
    scanf("%s", input);

    if (strcmp(input, "create") == 0) {
      createComplaint(&complaints);
      continue;
    }

    if (strcmp(input, "show") == 0) {
      showComplaints(&complaints);
      continue;
    }

    if (strcmp(input, "exit") == 0) {
      removeComplaints(&complaints);
      break;
    }

    printf("Type a valid command! \n");
  }

  return (0);
};
