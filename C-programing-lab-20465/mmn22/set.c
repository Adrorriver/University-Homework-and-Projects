#include "set.h"

void set_To_Zero(set X) {
	int i;
	for (i = 0; i < SETSIZE; ++i) {
		X[i] &= 0;
	}
} 

/* gets int and set, put the int inside the set */
void set_read_int(set X, int num) {
	X[num / BITNUM] |= 1 << (num % BITNUM);
}

/* gets int and set, cheak for the int inside the set
return true or false   */

int set_cheake_int(set X, int num) {
	unsigned char temp;
	temp = 1 << (num % BITNUM);
	if ((X[num / BITNUM]) & temp)
		return true;
	else
		return false;
}

/* gets int and set, delete the int from the set */
void set_delete_int(set X, int num) {
	if (set_cheake_int(X, num)) {
		char tmp = '\0';
		tmp |= 1 << (num % BITNUM);
		tmp = ~tmp;
		X[num / BITNUM] &= tmp;
	}
}



