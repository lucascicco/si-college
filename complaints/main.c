#include "core.c"
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
  printf("Create a complaint, type: create\n");
  printf("Show complaints, type: show\n");
  printf("Close program, type: exit\n");

  static Complaints complaints;
  init_complaints(&complaints);

  while (true) {
    char input[5];
    scanf("%s", input);

    if (strcmp(input, "create") == 0) {
      create_complaint(&complaints);
      continue;
    }

    if (strcmp(input, "show") == 0) {
      show_complaints(&complaints);
      continue;
    }

    if (strcmp(input, "exit") == 0) {
      remove_complaints(&complaints);
      break;
    }

    printf("Type a valid command! \n");
  }

  return (0);
};
