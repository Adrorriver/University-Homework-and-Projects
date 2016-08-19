#ifndef SET_H_
#define SET_H_

#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

#define SETSIZE 16
#define BITNUM 8
#define COMMAND 250

enum boolean {
	false, true
};

typedef unsigned char set[SETSIZE];

set A, B, C, D, E, F;

/* a struct for the command parameters */
typedef struct  {
	set* firstParam;
	set* secondParam;
	set* result;
} params;

params tempParam;

void set_To_Zero(set X);
void set_read_int(set X, int num);
int set_cheake_int(set X, int num);
void set_delete_int(set X, int num);


void Initialized();
void read_set(void);
void print_set(void);
void union_set(void);
void intersect_set(void);
void sub_set(void);
void halt(void);

int check_for_set(char c);
int check_for_3_params(char *p);
void get_data(set* sptr, char* str);

void exe_union();
void exe_intersect();
void exe_sub();



#endif /* SET_H_ */

