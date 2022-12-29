/*
 * CSE30 WI22 HW6
 * CSE30 username: cs30wi22bq 
 * Not sure if I should've left the 'c' sorry if I was supposed to
 * was originally 'cs30wi22cXX' so I guess would be 'cs30wi22cbq'
 */

#include "poll_lookup.h"

/*
 * !!! DO NOT EDIT THIS FUNCTION !!!
 * main
 *
 * Arguments: argc, argv
 *
 * Operation: Main driver for the program, calls other funttions to:
 *            parse the options, allocate the hash table, load the table, print
 *out the table stats
 *            and make print population stats of the desired city/state
 * Returns:   EXIT_SUCCESS if all ok, EXIT_FAILURE otherwise
 * !!! DO NOT EDIT THIS FUNCTION !!!
 */
int main(int argc, char *argv[]) {
  node **table;
  unsigned long size = TABLE_SIZE;
  // name of csv file
  char *filename;
  int info = 0;

  // Indicates days we want stats for/to remove
  char *date = NULL;
  char *del_date = NULL;

  // Parse options
  if (!parse_opts(argc, argv, &filename, &size, &info, &date, &del_date)) {
    return EXIT_FAILURE;
  }

  // Allocate space for table
  if ((table = calloc(size, sizeof(node *))) == NULL) {
    fprintf(stderr, "%s: Unable to allocate space for hash table\n", argv[0]);
    return EXIT_FAILURE;
  }

  // Load records from file
  if (load_table(table, size, filename)) {
    return EXIT_FAILURE;
  }

  // Delete data first
  if (del_date) {
    char *stripped_date = strip_date(del_date);
    if (stripped_date) { // no malloc fail
      delete_date(table, size, stripped_date);
      free(stripped_date);
    } else {
      return EXIT_FAILURE;
    }
  }

  // Produce data for a single date
  if (date) {
    char *stripped_date = strip_date(date);
    if (stripped_date) { // no malloc fail
      print_date_stats(table, size, stripped_date);
      free(stripped_date);
    } else {
      return EXIT_FAILURE;
    }
  }

  // Print metadata
  if (info)
    print_info(table, size);

  // Clean up
  delete_table(table, size);

  return EXIT_SUCCESS;
}

/*
 * !!! DO NOT EDIT THIS FUNCTION !!!
 * hash
 *
 * Arguments: a null terminated string
 *
 * Operation: calculates a hash value for the string
 *
 * returns:   the hash value
 * !!! DO NOT EDIT THIS FUNCTION !!!
 */
unsigned long hash(char *str) {
  unsigned long hash = 0;
  unsigned int c;
#ifdef C_HASH
  while ((c = (unsigned char)*str++) != '\0') {
    hash = c + (hash << 6) + (hash << 16) - hash;
  }
#else
  while ((c = (unsigned char)*str++) != '\0') {
    hash = hashFun((unsigned long)c, hash);
  }
#endif
  return hash;
}

/*
 * node_lookup
 * Searches for the first node with this year, month, day, and hour
 * in this chain, and returns a pointer to it.
 *
 * Arguments: linked list chain pointer head, year, month, day, hour
 */
node *node_lookup(node *front, int year, int month, int day, int hour) {

	//iter variable
	node *iter = front;
	
	//checks for a node to compare
	while (iter != NULL) {

		//if any field is different, iterates to the next
		if ((*iter).year != year) {
			iter = (*iter).next;
			continue;
		}

		if ((*iter).month != month) {
			iter = (*iter).next;
			continue;
		}

		if ((*iter).day != day) {
			iter = (*iter).next;
			continue;
		}
		
		if ((*iter).hour != hour) {
			iter = (*iter).next;
			continue;
		}

		//fields match, returns pointer to this node
		return iter;

	}

	//node not found
	return NULL;
}

/*
 * add_node
 * Adds a node with the provided data to the end of the given linked list.
 *
 * Arguments: linked list pointer head, year, month, day, hour, pm25, temp, iws
 * Return:  NULL    if there was an error
 *          the head of the chain otherwise
 */
node *add_node(node *front, int year, int month, int day, int hour, int pm25,
               int temp, float iws) {

	//iter variable
	node *iter = front;
	
	//sets iter to the current tail
	while ((*iter).next != NULL) {
		iter = (*iter).next;
	}

	//error checking
	errno = 0;

	//allocates memory for the new tail
	(*iter).next = (node *) malloc(sizeof(node));

	//malloc error
	if (errno != 0) {
		return NULL;
	}

	//iter points to new inserted tail
	iter = (*iter).next;

	//initializes the fields
	(*iter).year = year;
	(*iter).month = month;
	(*iter).day = day;
	(*iter).hour = hour;
	(*iter).temp = temp;
	(*iter).pm25 = pm25;
	(*iter).iws = iws;
	(*iter).next = NULL;
	
	return iter;

}

/*
 * print_date_stats
 * Print the average stats for this date
 *
 * Arguments: pointer to hash table, hash table size, date as a string in the
 *form YYYY-MM-DD
 */
void print_date_stats(node **table, unsigned long size, char *datestr) {

	unsigned long hashDex = hash(datestr) % size;

	char *year = NULL;
	char *month = NULL;
	char *day = NULL;

	//YYYY-MM-DD
	if(strlen(datestr) == 10) {

		//deep copies year
		year = (char *) malloc(sizeof(char) * 5);
		strcpy(year, datestr);
		*(year + 4) = '\0';

		//deep copies month
		month = (char *) malloc(sizeof(char) * 3);
		strcpy(month, datestr + 5);
		*(month + 2) = '\0';

		//deep copies day
		day = (char *) malloc(sizeof(char) * 3);
		strcpy(day, datestr + 8);
		*(day + 2) = '\0';
	}
	else if (strlen(datestr) == 9) {

		//YYYY-M-DD
		if (*(datestr + 6) == '-') {
			//deep copies year
			year = (char *) malloc(sizeof(char) * 5);
			strcpy(year, datestr);
			*(year + 4) = '\0';

			//deep copies month
			month = (char *) malloc(sizeof(char) * 3);
			strcpy(month, datestr + 5);
			*(month + 1) = '\0';

			//deep copies day
			day = (char *) malloc(sizeof(char) * 3);
			strcpy(day, datestr + 7);
			*(day + 2) = '\0';
		}
		//YYYY-MM-D
		else {
			//deep copies year
			year = (char *) malloc(sizeof(char) * 5);
			strcpy(year, datestr);
			*(year + 4) = '\0';

			//deep copies month
			month = (char *) malloc(sizeof(char) * 3);
			strcpy(month, datestr + 5);
			*(month + 2) = '\0';

			//deep copies day
			day = (char *) malloc(sizeof(char) * 3);
			strcpy(day, datestr + 8);
			*(day + 1) = '\0';
		}

	}
	//YYYY-M-D
	else {
		//deep copies year
		year = (char *) malloc(sizeof(char) * 5);
		strcpy(year, datestr);
		*(year + 4) = '\0';

		//deep copies month
		month = (char *) malloc(sizeof(char) * 3);
		strcpy(month, datestr + 5);
		*(month + 2) = '\0';

		//deep copies day
		day = (char *) malloc(sizeof(char) * 3);
		strcpy(day, datestr + 7);
		*(day + 1) = '\0';
	}

	//converts year, month, day to ints
	int yrInt = atoi(year);
	int mInt = atoi(month);
	int dInt = atoi(day);
	int emptyHour = 0;	//counter for each empty hour entry for a date

	//data to calculate
	int minpm = 0, maxpm = 0, sumpm = 0;
	int mintemp = 0, maxtemp = 0, sumtemp = 0;
	float miniws = 0, maxiws = 0, sumiws = 0;

	int infoSet = 0;

	for (int i = 0; i < 24; i++) {
		node *search = node_lookup(table[hashDex], yrInt, mInt, dInt, i);
		
		//checks if node not found
		if (search == NULL) {
			emptyHour++;
			continue;
		}

		//checks if data has been set or not
		if (!infoSet) {
			
			minpm = (*search).pm25;
			maxpm = (*search).pm25;
			
			mintemp = (*search).temp;
			maxtemp = (*search).temp;

			miniws = (*search).iws;
			miniws = (*search).iws;

			infoSet = 1;
		}

		
		sumpm += (*search).pm25;
		sumtemp += (*search).temp;
		sumiws += (*search).iws;

		if ((*search).pm25 < minpm) {
			minpm = (*search).pm25; 
		}

		if ((*search).pm25 > maxpm) {
			maxpm = (*search).pm25;
		}

		if ((*search).temp < mintemp) {
			mintemp = (*search).temp; 
		}

		if ((*search).temp > maxtemp) {
			maxtemp = (*search).temp;
		}

		if ((*search).iws < miniws) {
			miniws = (*search).iws; 
		}

		if ((*search).iws > maxiws) {
			maxiws = (*search).iws;
		}

	}

	free(year);
	year = NULL;
	free(month);
	month = NULL;
	free(day);
	day = NULL;

	//checks if any data was found
	if (emptyHour == 24) {
		printf("Unable to find any data for the date %s.\n", datestr);
		return;
	}

  
  	fprintf(stdout, "Minimum pm2.5: %d\tMaximum pm2.5: %d\tAverage pm2.5: %d\n", minpm, maxpm, (sumpm / (24-emptyHour)));
	fprintf(stdout, "Minimum temp: %d\tMaximum temp: %d\tAverage temp: %d\n", mintemp, maxtemp, (sumtemp / (24-emptyHour)));
	fprintf(stdout, "Minimum iws: %f\tMaximum iws: %f\tAverage iws: %f\n", miniws, maxiws, (sumiws / (24-emptyHour)));

	
}

/*
 * load_table
 * Allocate memory for the hash table of node*s
 *
 * Arguments: pointer to hash table, hash table size, file name
 */
int load_table(node **table, unsigned long size, char *filename) {
 
	errno = 0; 
	FILE *inFile;
	if ((inFile = fopen(filename, "r")) == NULL && errno != 0) {
		perror("load_table filename open");
		return 1;
	}

	//initializes the hash table to have null entries
	for (unsigned long i = 0; i < size; i++) {
		table[i] = NULL;
	}

	size_t bufSize = LINE_SIZE - 1;	
	char *buf = NULL;

	//error indicator
	errno = 0;
	while (getline(&buf, &bufSize, inFile) != -1) {
		
		//error check for getline
		if (errno != 0) {
			perror("load table malloc");
			return 1;
		}
		
		//fields for a node
		char *iter = buf, *year = buf, *month = NULL, *day = NULL, *hour = NULL, *pmChar = NULL, *temp = NULL, *iws = NULL; 
		//index corresponding to a field
		int fieldIndex = 1;
		
		//iterates through buffer to initialize fields for a node
		while (*iter != '\n') {
			
			if (*iter == ',') {
				if (fieldIndex == COL_MONTH) {
					month = iter + 1;
				}
				else if (fieldIndex == COL_DAY) {
					day = iter + 1;
				}
				else if (fieldIndex == COL_HOUR) {
					hour = iter + 1;
				} 
				else if (fieldIndex == COL_PM25) {
					pmChar = iter + 1;
				}
				else if (fieldIndex == COL_TEMP) {
					temp = iter + 1;
				}
				else if (fieldIndex == COL_IWS) {
					iws = iter + 1;
				}

				*iter = '\0';
				fieldIndex++;
			}
			iter++;
		}
		*iter = '\0';

		char *date = (char *) malloc(sizeof(char) * 11);
		*(date + 4) = '-';
		*(date + 7) = '-';
		*(date + 10) = '\0';
		
		//hard copies record year
		for (int i = 0; i < 4; i++) {
			*(date + i) = *(year + i);
		}

		//hard copies month
		if (atoi(month) > 9) {
			*(date + 5) = *month;
			*(date + 6) = *(month + 1);
		}
		else {
			*(date + 5) = '0';
			*(date + 6) = *month;
		}

		//hard copies day
		if (atoi(day) > 9) {
			*(date + 8) = *day;
			*(date + 9) = *(day + 1);
		}
		else {
			*(date + 8) = '0';
			*(date + 9) = *day;
		}

		//check for pm for NA value
		int pm = 0;
		char NA[] = "NA\0";
		if (strcmp(pmChar, NA)) {
			pm = atoi(pmChar);
		}

		//gets the index of the hashed value
		unsigned long hashDex = hash(strip_date(date)) % size;

		free(date);
		date = NULL;

		//if node exists then print error
		if (node_lookup(table[hashDex], atoi(year), atoi(month), atoi(day), atoi(hour)) != NULL) {
			
			fprintf(stderr, "load_table duplicate entry: %d-%d-%d %d\n", atoi(year), atoi(month), atoi(day), atoi(hour));

		}
		else {

			//checks for empty bucket
			if (table[hashDex] == NULL) {
				
				errno = 0;
				
				table[hashDex] = (node *) malloc(sizeof(node));

				if (errno != 0) {
					fprintf(stderr, "load_table could not add %s\n", buf);
					return 1;
				}

				(*table[hashDex]).year = atoi(year);
				(*table[hashDex]).month = atoi(month);
				(*table[hashDex]).day = atoi(day);
				(*table[hashDex]).hour = atoi(hour);
				(*table[hashDex]).pm25 = pm;
				(*table[hashDex]).temp = atoi(temp);
				(*table[hashDex]).iws = atof(iws);
				(*table[hashDex]).next = NULL;

			}
			//if add_node is successful it returns pointer to node added, on failure returns NULL
			else  {

				node *newNode = add_node(table[hashDex], atoi(year), atoi(month), atoi(day), atoi(hour), pm, atoi(temp), atof(iws));

				if (newNode == NULL) {
					fprintf(stderr, "load_table could not add %s\n", buf);
					return 1;
				}
			}
		}
		
		errno = 0;
		bufSize = LINE_SIZE - 1;
		free(buf);
		buf = NULL;

	}
	
	free(inFile);
	inFile = NULL;

	return 0;
}

/*
 * delete_date
 * Delete all nodes associated with a given date of form YYYY-MM-DD
 * All leading zeros have already been removed in the date string,
 * so you do not have to worry about 2010-01-01 versus 2010-1-1.
 */
void delete_date(node **table, unsigned long size, char *datestr) {

	int hashDex = hash(datestr) % size;

	char *year = NULL;
	char *month = NULL;
	char *day = NULL;

	//YYYY-MM-DD
	if(strlen(datestr) == 10) {

		//deep copies year
		year = (char *) malloc(sizeof(char) * 5);
		strcpy(year, datestr);
		*(year + 4) = '\0';

		//deep copies month
		month = (char *) malloc(sizeof(char) * 3);
		strcpy(month, datestr + 5);
		*(month + 2) = '\0';

		//deep copies day
		day = (char *) malloc(sizeof(char) * 3);
		strcpy(day, datestr + 8);
		*(day + 2) = '\0';
	}
	else if (strlen(datestr) == 9) {

		//YYYY-M-DD
		if (*(datestr + 6) == '-') {
			//deep copies year
			year = (char *) malloc(sizeof(char) * 5);
			strcpy(year, datestr);
			*(year + 4) = '\0';

			//deep copies month
			month = (char *) malloc(sizeof(char) * 3);
			strcpy(month, datestr + 5);
			*(month + 2) = '\0';

			//deep copies day
			day = (char *) malloc(sizeof(char) * 3);
			strcpy(day, datestr + 7);
			*(day + 2) = '\0';
		}
		//YYYY-MM-D
		else {
			//deep copies year
			year = (char *) malloc(sizeof(char) * 5);
			strcpy(year, datestr);
			*(year + 4) = '\0';

			//deep copies month
			month = (char *) malloc(sizeof(char) * 3);
			strcpy(month, datestr + 5);
			*(month + 2) = '\0';

			//deep copies day
			day = (char *) malloc(sizeof(char) * 3);
			strcpy(day, datestr + 8);
			*(day + 2) = '\0';
		}

	}
	//YYYY-M-D
	else {
		//deep copies year
		year = (char *) malloc(sizeof(char) * 5);
		strcpy(year, datestr);
		*(year + 4) = '\0';

		//deep copies month
		month = (char *) malloc(sizeof(char) * 3);
		strcpy(month, datestr + 5);
		*(month + 2) = '\0';

		//deep copies day
		day = (char *) malloc(sizeof(char) * 3);
		strcpy(day, datestr + 7);
		*(day + 1) = '\0';
	}

	//converts year, month, day to ints
	int yrInt = atoi(year);
	int mInt = atoi(month);
	int dInt = atoi(day);

	node *iter = (*table[hashDex]).next; 
	node *prev = table[hashDex];

	//starts iteration at the second element in list
	while (iter != NULL) {

		//desired date found
		if ((*iter).year == yrInt &&
			(*iter).month == mInt &&
			(*iter).day == dInt) {
			
			(*prev).next = (*iter).next;

			free(iter);
			
			iter = (*prev).next;

		}
		
		else {
			
			prev = iter;
			iter = (*iter).next;
		}

	}

	//checks first element of list
	if ((*table[hashDex]).year == yrInt &&
			(*table[hashDex]).month == mInt &&
			(*table[hashDex]).day == dInt &&
			(*table[hashDex]).next != NULL) {
		
		node *temp = table[hashDex];

		table[hashDex] = (*table[hashDex]).next;

		free(temp);
		temp = NULL;

	}
	else if ((*table[hashDex]).year == yrInt &&
			(*table[hashDex]).month == mInt &&
			(*table[hashDex]).day == dInt &&
			(*table[hashDex]).next == NULL) {
		
		free(table[hashDex]);
		table[hashDex] = NULL;
	}
	

}

/*
 * print_info
 *
 * Arguments: pointer to a hash table, number of elements
 */
void print_info(node **table, unsigned long size) {

	printf("Table size: %lu\n", size);

	unsigned long sizeIter = 0;
	unsigned long entries = 0;
	unsigned long longest = 0;
	unsigned long shortest = 0;
	unsigned long empty = 0;
	unsigned long length = 0;

	int infoSet = 0;

	while (sizeIter < size) {

		//check for empty bucket
		if (table[sizeIter] != NULL) {

			//var to iter through linked list
			node *iter = table[sizeIter];

			//iterates until tail reached
			while (iter != NULL) {
				
				length = length + 1;
				iter = (*iter).next;

			}

			//updates num of entries
			entries = entries + length;

			if (!infoSet) {
				longest = length;
				shortest = length;
				infoSet = 1;
			}

			//checks for longest
			if (length > longest) {
				longest = length;
			}

			//checks for shortest
			if (length < shortest) {
				shortest = length;
			}
			
			//resets length
			length = 0;
		}
		else {
			empty = empty + 1;
		}

		sizeIter = sizeIter + 1;

	}

	fprintf(stdout, "Total entries: %lu\n", entries);
	fprintf(stdout, "Longest chain: %lu\n", longest);
	fprintf(stdout, "Shortest chain: %lu\n", shortest);
	fprintf(stdout, "Empty buckets: %lu\n", empty);
}

/*
 * delete_table
 *
 * Arguments: pointer to hash table, hash table array size
 */
void delete_table(node **table, unsigned long size) {

	unsigned long sizeIter = 0;

	while (sizeIter < size) {

		//check for empty bucket
		if (table[sizeIter] == NULL) {
			sizeIter++;
			continue;
		}

		//vars to iterate through chain
		node *iter = table[sizeIter];
		node *tempNext = NULL;

		//iterates to tail and frees all nodes
		while(iter != NULL) {
			
			//iterates temp
			tempNext = (*iter).next;
			
			//breaks connection to next Node
			(*iter).next = NULL;

			//frees memory of node
			free(iter);

			iter = tempNext;
			
		}
		
		sizeIter++;

	}

	free(table);
	table = NULL;
}
