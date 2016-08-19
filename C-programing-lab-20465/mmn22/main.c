#include "set.h"

/* a struct connects sets names and pointers */
struct {
	char name;
	set* theset;
} sets[] = { { 'A', &A }, { 'B', &B }, { 'C', &C }, { 'D', &D }, { 'E', &E }, {
		'F', &F }, { '#', NULL } };

/* a struct connects command names and pointers */
struct {
	char *name;
	void (*func)(void);
} cmd[] = { { "read_set", read_set }, { "print_set", print_set }, { "union_set",
		union_set }, { "intersect_set", intersect_set }, { "sub_set", sub_set },
		{ "halt", halt }, { "not_valid", NULL } };

int main() {

	char command[COMMAND];
	int i;

	printf("\n"
			"this program handles sets\n"
			"sets names are: A,B,C,D,E,F\n"
			"list of commands: read_set, print_set, union_set,\n"
			"intersect_set, sub_set, halt - for exit\n"
			"rang of numbers 0 -> 127\n"
			"numbers will be followed by a ','\n"
			"-1 , represent end of row\n"
			"sample command: read_set A,5,3,44,0,103,-1\n");

	Initialized();
	/* program loop until halt command is given */
	while (true) {
		for (i = 0; i < COMMAND; ++i) {
			command[i] = '\0';
		}
		printf("\n" "insert command:");
		if (scanf("%s", command) == 1) {
			/* out of loop means find command or null*/
			for (i = 0;
					((cmd[i].func) != NULL)
							&& (strcmp(command, cmd[i].name) != 0); ++i)
				;
			/*check for null or executing command*/
			if (cmd[i].func == NULL) {
				printf("Command does not exist: %s\n", command);
				gets(command);
			} else {
				(*(cmd[i].func))();
			}
		}
	}
	return 0;
}

void Initialized() {
	set_To_Zero(A);
	set_To_Zero(B);
	set_To_Zero(C);
	set_To_Zero(D);
	set_To_Zero(E);
	set_To_Zero(F);
}

void read_set(void) {
	char command[COMMAND], *p;
	int i;
	/*get command and empty the standard input*/
	gets(command);
	p = command;
	p++;
	/*use function check_for_set to find if set is valid*/
	if ((i = check_for_set(*p)) == -1) {
		printf("No such set-> %c\n", *p);
		return;
	} else {
		/*use tempParam for the parameter*/
		tempParam.firstParam = sets[i].theset;
		get_data(tempParam.firstParam, ++p);
	}
}

void print_set(void) {
	char command[COMMAND], *p;
	int i, j, flag = 0, count = 0;
	gets(command);
	p = command;
	p++;
	if ((i = check_for_set(*p)) == -1) {
		printf("No such set->%c\n", *p);
		return;
	} else {
		if (*(++p) != '\0') {
			printf("Wrong to many args-> %s\n", p);
			return;
		}
		tempParam.firstParam = sets[i].theset;
		for (j = 0; j < 128; j++) {
			if (set_cheake_int(*tempParam.firstParam, j)) {
				printf(" %d ", j);
				flag = true;
				count++;
				if (count % 10 == 9) {
					printf("\n");
				}
			}
		}
		if (!flag) {
			printf("set is empty\n");
		}
		printf("\n");

	}

}

void union_set(void) {
	char command[COMMAND], *p;
	gets(command);
	p = command;
	p++;
	if (check_for_3_params(p)) {
		exe_union();
	}

}

void intersect_set(void) {
	char command[COMMAND], *p;
	gets(command);
	p = command;
	p++;
	if (check_for_3_params(p)) {
		exe_intersect(tempParam);
	}
}

void sub_set(void) {
	char command[COMMAND], *p;
	gets(command);
	p = command;
	p++;
	if (check_for_3_params(p)) {
		exe_sub(tempParam);
	}
}

/* Terminate the program */
void halt(void) {
	exit(0);
}

int check_for_set(char c) {
	int i;
	for (i = 0; (sets[i].name != '#') && (sets[i].name != c); ++i)
		;
	if (sets[i].name == '#') {
		return -1;
	} else
		return i;
}

/* check valid parameters and use tempParam*/
int check_for_3_params(char *p) {
	int i;
	if ((i = check_for_set(*p)) == -1) {
		printf("No such set->%c\n", *p);
		return false;
	} else {
		tempParam.firstParam = sets[i].theset;
	}
	if (*(++p) != ',') {
		printf("missing ','");
		return false;
	}
	if ((i = check_for_set(*(++p))) == -1) {
		printf("No such set->%c\n", *p);
		return false;
	} else {
		tempParam.secondParam = sets[i].theset;
	}
	if (*(++p) != ',') {
		printf("missing ','");
		return false;
	}
	if ((i = check_for_set(*(++p))) == -1) {
		printf("No such set->%c\n", *p);
		return false;
	} else {
		tempParam.result = sets[i].theset;
	}
	if (*(++p) != '\0') {
		printf("Wrong to many args-> %s\n", p);
		return false;
	}
	return 1;
}

void get_data(set* sptr, char* str) {
	int tmp;
	char *end, *p1;

	for (end = str; *end != '\0'; end++)
		;
	if (*--end != '1') {
		printf("missing '-1'\n");
		return;
	}
	if (*--end != '-') {
		printf("missing '-1'\n");
		return;
	}
	if (*--end != ',') {
		printf("missing ','\n");
		return;
	}

	p1 = str;
	if (*p1 != ',') {
		printf("missing ','");
		return;
	}
	while (p1 < end) {
		for (; (p1 < end); p1++) {
			if (((*p1 < '0') && (*p1 != ','))
					|| ((*p1 > '9') && (*p1 != ','))) {
				printf("Wrong data-> %s\n", str);
				return;
			}

		}
	}
	p1 = str;
	for (p1++; (p1 < end); p1++) {
		tmp = atoi(p1);
		if (tmp < 0 || 127 < tmp) {
			printf("%d is out of range\n", tmp);
			return;
		}
		set_read_int(*sptr, tmp);
		for (; *p1 != ','; p1++)
			;
	}
}

void exe_union() {
	int i;
	for (i = 0; i < SETSIZE * BITNUM; i++) {
		if (set_cheake_int(*tempParam.firstParam, i)) {
			set_read_int(*tempParam.result, i);
		}
	}
	for (i = 0; i < SETSIZE * BITNUM; i++) {
		if (set_cheake_int(*tempParam.secondParam, i)) {
			set_read_int(*tempParam.result, i);
		}
	}
}

void exe_intersect() {
	int i;
	for (i = 0; i < SETSIZE * BITNUM; i++) {
		if (set_cheake_int(*tempParam.firstParam, i)) {
			if (set_cheake_int(*tempParam.secondParam, i)) {
				set_read_int(*tempParam.result, i);
			}
		}
	}
}

void exe_sub() {
	int i;
	for (i = 0; i < SETSIZE * BITNUM; i++) {
		if (set_cheake_int(*tempParam.firstParam, i)) {
			set_read_int(*tempParam.result, i);
		}
	}

	for (i = 0; i < SETSIZE * BITNUM; i++) {
		if (set_cheake_int(*tempParam.secondParam, i)) {
			set_delete_int(*tempParam.result, i);
		}
	}
}

