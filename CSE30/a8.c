#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node {
  char* aString;     // a string
  struct node* next; // next node
  struct node* prev; // previous node
} node;

static node* front = NULL; // front of the link list
static node* back = NULL; // end of the link list
//
// this file implements a double linked list.  Each
// node contains a next and prev pointer.  Nodes at the ends of the list
// are pointed to by front and back pointers.
//
// The next/prev pointers of the back/front nodes are NULL.
// Each node contains a copy of the string passed to addNode.
//
// addNode with string
// to the *back* of the list
// - allocate new Node
// - allocate space for the string
// - copy the string to the new space
// - insert list at end
//   -    if list is empty, then node becomes front and back of list
//   -    tail's next is set to newNode
//   -    newNodes prev is set to tail
//   -    newNodes next is set to NULL
//   -    tail is set to newNode.
//
void addNode(char* string) {
  node* newNode = malloc(sizeof(node));
  newNode->aString = malloc(strlen(string) + 1);
  strcpy(newNode->aString, string);
  if (front == NULL) {
    front = newNode;
  }
  if (back != NULL) {
    back->next = newNode;
  }
  newNode->prev = back;
  newNode->next = NULL;
  back = newNode;
}

/// print list forward
///
void printListFwd() {
  node* t = front;
  while (t != NULL) {
    printf("%s", t->aString);
    t = t->next;
  }
}

/// TODO
/// print list reverse
///
void printListRev() {
	node *t = back;
	while (t != NULL) {
		printf("%s", t->aString);
		t = t->prev;
	}
}

/// TODO:
///
/// delete the entire list
/// and all storage associated with it.
///
void cleanUp() {
	node *t = front;
	while (t != NULL) {
		node *temp = t->next;
		free(t);
		t = temp;
	}
}

///
/// usage: argv[1] is file to open
///
int main(int argc, char* argv[]) {
  FILE* fp;

  if ((fp = fopen(argv[1], "r")) == NULL) {
    if (argc < 2) {
      fprintf(stderr, "%s: no file given\n", argv[0]);
    } else {
      fprintf(stderr, "%s can't open file %s\n", argv[0], argv[1]);
    }
    return EXIT_FAILURE;
  }
  char buf[128];

  // read each line, and insert it into the link list
  //
  while ((fgets(buf, 128, fp)) != NULL) {
    if (buf[0] == '\n') break;
    addNode(buf);
  }
  fclose(fp);

  // print the list going forward
  printf("forward:\n");
  printf("--------\n");
  printListFwd();
  printf("\n");

  // print the list going backwards
  printf("reverse:\n");
  printf("--------\n");
  printListRev();

  cleanUp();

  printf("list should be empty now\n");
  printf("------------------------\n");
  printListFwd();
  return EXIT_SUCCESS;
}
