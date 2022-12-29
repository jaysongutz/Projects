/**
 * Assignment-1
 * CSE30 Username: cs30wi22 (fill out your username)
 * Class: UCSD CSE30-WI22
 */
#include <stdio.h>
#include <stdlib.h>


int main(int argc, char* argv[]) {


    if (argc != 2) {
        fprintf(stderr, "%s wrong number of arguments\n", argv[0]);
        return EXIT_FAILURE;
    }


    unsigned int population = (unsigned) atoi(argv[1]);

    unsigned int zero = 0;

    unsigned int result = population;

    unsigned int remainder;

    unsigned int power = 0;



    while (result > zero) {
    
	    remainder = result % 2;
	    result = result / 2;

	    printf("%d * 2^%d\n", remainder, power++);

    }


    return EXIT_SUCCESS; 
}
