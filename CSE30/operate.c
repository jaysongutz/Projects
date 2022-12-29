#include <stdio.h>
#include <stdlib.h>

#include "instruction.h"
#include "stack.h"
#include "operate.h"

/// operate on the instruction pointed by inst which is located at the given pc.  Return
/// the new PC or -1 if there was an error
///
/// errors may include:
///   insufficent operands on the stack
///   unrecognized instruction.
int operate(int pc, instr_t* inst) {

	switch (inst->opcode) {
		case PUSH: {/* perform push expression */
			push((*inst).operand);
			pc++;
			break;
		}
		case POP: {/* perform pop expression */
			if(check_stack(1, pc) != -1) {
				int dummy = 0;
				pop(&dummy);
				pc++;
			}
			else {
				pc = -1;
			}
			break;
		}
		    /* add other instruction handling here. */
		case SWAP: {
			//pop top two values and store in temp vars
			if (check_stack(2, pc) != -1) {
				int firstval = 0, secondval = 0;
				
				//top most element
				pop(&firstval);

				//second highest element
				pop(&secondval);

				//pushes initial top most element
				push(firstval);

				//pushes initial second highest element
				push(secondval);

				pc++;
			}
			else {
				pc = -1;
			}
			break;
		}
		case ROT: {

			//checks for at least two elements
			if (check_stack(2,pc) != -1) {
				rot();
				pc++;
			}
			//failure
			else {
				pc = -1;
			}

			break;
		}
		case DUP: {
			
			//checks for a val to dup
			if (check_stack(1,pc) != -1) {
				int dupVal = 0;

				//pops top val of stack
				pop(&dupVal);

				//pushes val twice to dup
				push(dupVal);
				push(dupVal);
				pc++;
			}
			//can't dup
			else {
				pc = -1;
			}
			break;
		}
		case GET: {

			int input = 0;

			//gets input from user
			scanf("%d", &input);

			//pushes input to stack
			push(input);
			pc++;

			break;
		}
		case PRINT: {
			
			if (check_stack(1,pc) != -1) {

				//gets top most val
				int top = 0;
				pop(&top);
				push(top);

				//prints it to output
				printf("%d\n", top);
				pc++;
			}
			else {
				pc = -1;
			}

			break; 

		}
		case PRINTSTACK: {

			//checks for something in the stack
			if(check_stack(1, pc) != -1) {
				printstack();
				pc++;
			}

			//stack empty
			else {
				pc = -1;
			}
			break;
		}
		case BTRUE: {
			
			if(check_stack(1, pc) != -1) {
				//gets the top element
				int top = 0;
				pop(&top);

				//increments pc by operand
				if (top != 0) {
					pc = pc + inst->operand;
				}
				else {
					pc++;
				}
			}
			else {
				pc = -1;
			}
			break;
		}
		case CMPI: {
			if(check_stack(1, pc) != -1) {
				//gets the top element
				int top = 0;
				pop(&top);
				push(top);

				//compares top of stack with operand
				if (top == inst->operand) {
					push(1);
				}
				else {
					push(0);
				}
				pc++;
			}
			else {
				pc = -1;
			}
			break;
		}
		case HALT: {

			//frees all memory in stack
			delete_stack();
			inst = NULL;

			//breaks from loop
			return -1;
		} 
		case ADD: {
			
			if(check_stack(2,pc) != -1) {

				//gets top 2 values of stack
				int val1 = 0, val2 = 0;
				pop(&val1);
				pop(&val2);
				
				//pushes their sum
				push(val1 + val2);
				pc++;
			}
			else {
				pc = -1;
			}
			break;
		}
		case SUB: {

			if(check_stack(2,pc) != -1) {

				//gets top 2 values of stack
				int val1 = 0, val2 = 0;
				pop(&val1);
				pop(&val2);
				
				//pushes their difference
				push(val2 - val1);
				pc++;
			}
			else {
				pc = -1;
			}
			break;
		}
		case MULT: {
			
			if(check_stack(2,pc) != -1) {
				
				//gets top 2 values of stack
				int val1 = 0, val2 = 0;
				pop(&val1);
				pop(&val2);

				//pushes their product
				push(val1 * val2);
				pc++;
			}
			else {
				pc = -1;
			}
			break;
		}
		case NOT: {
			
			if(check_stack(1,pc) != -1) {
				
				//gets top value of stack
				int top = 0;
				pop(&top);
				
				//pushes its not
				push(!top);
				pc++;
			}
			else {
				pc = -1;
			}
			break;
		}
		default:
		    fprintf(stderr, "Illegal opcode 0x%04x at pc %04d\n", inst->opcode, pc);
		    exit(EXIT_FAILURE);
	    }

	return pc;
}

int check_stack(unsigned int x, int pc) {
	if (get_stack_size() < x) {
		return -1;
	}
	else {
		return pc;
	}
}
