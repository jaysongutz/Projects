#include "stack.h"
#include <stdio.h>
#include <stdlib.h>

/*
 * You might want to declare some global variables to
 * help you maintain the stack, and the state of the stack.
 * Once you have implemented push and pop here and corresponding
 * parts in operate.c - we highly recommend checking out
 * tests/stack_test and running it to see if you are getting expected
 * output - to check basic stack functionality. You could write similar
 * tests for other functionalities.
 */

node_t* stack = NULL;

/* push a value to the stack */
void push(int val) {
	if (stack == NULL) {
		stack = (node_t *) malloc(sizeof(node_t));
		(*stack).val = val;
		(*stack).next = NULL;
	}
	else {
		node_t* oldTop = stack;
		stack = (node_t *) malloc(sizeof(node_t));
		(*stack).val = val;
		(*stack).next = oldTop;
	}
}

/* pop a value from the stack
 * return 0 if pop failed, else return 1 and set *v
 */
int pop(int* v) {
	if (stack == NULL) {
		return 0;
	}
	else {
		//temp var for new top of stack (holds address of next node)
		node_t* newStack = (*stack).next;

		//handles freeing the memory at address of current top of stack
		*v = (*stack).val;
		free(stack);
		stack = NULL;

		//top of stack points to address of new top of stack
		stack = newStack;

		return *v;
	}
}

/* print the entire stack */
void printstack() {
	node_t* iter = stack;
	int i = 0;
	while(iter != NULL) {
		printf("\tS%d:\t%d\n", (get_stack_size() - i - 1), (*iter).val);
		i++;
		
		if ((*iter).next != NULL) {
			iter = (*iter).next;
		}
		else {
			iter = NULL;
		}
	}

}

/* the topmost entry becomes the lowest entry in the stack */
void rot() {

	//temp var for old top of stack
	int oldTop = 0;

	//removes top of stack and shifts stack up
	pop(&oldTop);

	//iter variable
	node_t* iter = stack;

	//while the iter node has a next node, iterate
	while ((*iter).next != NULL) {iter = (*iter).next;}

	//end of stack reached, places oldTop at end of stack
	(*iter).next = (node_t *) malloc(sizeof(node_t));
	iter = (*iter).next;
	(*iter).val = oldTop;	
	(*iter).next = NULL;

}

/* returns the size of the stack */
unsigned int get_stack_size() {
	unsigned int counter = 0;

	node_t* iter = stack;

	while (iter != NULL) {
		counter++;
		iter = (*iter).next;
	}

	return counter;
}

/* delete all entries in the stack, free all memory associated with it */
void delete_stack() {
	int dummy = 0;

	while (get_stack_size()) {
		pop(&dummy);
	};

}
