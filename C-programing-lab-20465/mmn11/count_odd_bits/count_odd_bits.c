#include <stdio.h>

/* count the number of odd bits turn on */
int count_odd_bits(unsigned long num) {
	int count = 0;
	unsigned long x;
	while (num != 0) {
		x = num & 02; /*mask for the 2 bit */
		if (x != 0)
			count++;
		num = num >> 2;
	}
	return count;
}

/* uses the function count odd bits */
int main(){
	unsigned long num;
	printf("Enter a valid number\t");
	scanf("%lu",&num);
 	printf("%d\n",count_odd_bits(num));
	return 0;
}

