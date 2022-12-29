// Name: Jayson Gutierrez
// PID: A16166652
// cs30wi22 user name: cs30wi22bq
// 2104367
#include <stdio.h>
#include <stdlib.h> 
#include <string.h>
#include <unistd.h>

#define ENDSENTINAL "********"
//
// node structure
//
typedef struct node  {
  char *plain;
  struct node *next;
} node_t;

void printList(node_t *t){
  while (t != NULL){
    printf("%s\n", t->plain);
    t = t->next;
  }
}

// TODO
int countMatches(node_t *head, char *s){
	node_t *temp = head;
	
	int count = 0;

	while (temp != NULL) {
		if (strcmp((*temp).plain, s) != 0) {
			temp = (*temp).next;
			continue;
		}
		count = count + 1;
		temp = (*temp).next;
	}
	
	return count;
}

// TODO
node_t *deleteHead(node_t *head){

	while (head != NULL) {

		node_t *temp = (*head).next;

		free((*head).plain);
		(*head).plain = NULL;

		free(head);

		head = temp;

	}

	return head;
}

void deleteList(node_t *head){
  while(head != NULL){
    head = deleteHead(head);
  }
}

node_t* addNode(node_t *head, char *plain){
  node_t *newNode = malloc(sizeof(node_t));
  newNode->plain = malloc(strlen(plain)+1);
  strcpy(newNode->plain, plain);
  newNode->next = head;
  head = newNode;
  return head;
}

// TODO
int rotN(char x){

	if ( x >= 'a' && x <= 'z' ) {
		x = (x - 'a' + 100) % ('z' - 'a' + 1) + 'a';
	}
	else if( x >= 'A' && x <= 'Z') {
		x = (x - 'A' + 100) % ('Z' - 'A' + 1) + 'A';
	}
	
	return (int) x;
	
}

int main(int argc, char *argv[]){
  if (argc != 2){
    fprintf(stderr, "usage: %s searchString\n", argv[0]);
    return EXIT_FAILURE;
  }
  printf("user = %s\n", getlogin());

  node_t *head = NULL;
  FILE *fp = NULL;
  if ((fp = fopen("input.enc", "r")) == NULL){
    fprintf(stderr, "%s couldn't open file %s\n", argv[0], "input.enc");
    return EXIT_FAILURE;
  }

  char buf[128];
  int lineCount = 0;
  int gotSentinal = 0;
  while (fgets(buf, 128, fp) != NULL){
    char *bp = buf;
        if (strncmp(buf, ENDSENTINAL, strlen(ENDSENTINAL)) == 0){
      gotSentinal = 1;
      break;
    }
    lineCount++;
    while (*bp != '\0'){
      if (*bp == '\n'){
        *bp = '\0';
        break;
      }
      *bp = rotN(*bp);
      bp++;
    }
    printf("adding: %s\n", buf);
    head = addNode(head, buf);
  }
  fclose(fp);

  if (!gotSentinal) {
    printf("possible truncated input, did not read  %s\n", ENDSENTINAL);
  }
  printf("read %d lines\n", lineCount);
  printList(head);
  printf("%s occurs %d times\n", argv[1], countMatches(head, argv[1]));
    deleteList(head);
  head = NULL;
  return EXIT_SUCCESS;
}
