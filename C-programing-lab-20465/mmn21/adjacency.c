/*
 ============================================================================
 Name        : mmn21.c
 Author      : Amir Dror
 Version     :
 Copyright   : Amir Dror
 Description : find path in adjacency tree
 ============================================================================
 */

#include <stdio.h>

#define Node 4

typedef int adj_mat[Node][Node];
enum boolean {
	false, true
};

/* return parent number, or -1 if no parent or wrong input (not a tree)*/
int findParent(adj_mat A, int son, int count) {
	int i;
	if (count == 0)
		return -1;
	for (i = 0; i < Node; i++) {
		if (A[i][son] == true)
			return i;
	}
	return -1;
}
/*check for path from parent to son */
int path(adj_mat A, int parent, int son, int count) {
	int temp = 0;
	if (parent == son)
		return true;
	else {
		temp = findParent(A, son, count);
		if (temp == -1)
			return false;
	}
	return path(A, parent, temp, count - 1); /* recursive call*/
}

int main() {
	adj_mat adjtree;
	int i, j;
	int parent = 0, son = 0, again = 0, count = Node;

	printf("Please enter values for adjacency tree,\n"
			"all numbers except zero will be count as 1\n");
	for (i = 0; i < Node; i++) {
		for (j = 0; j < Node; j++) {
			printf("value %d,%d -> is %d son of %d\n", i + 1, j + 1, j + 1,
					i + 1);
			scanf("%d", &adjtree[i][j]);

			if (adjtree[i][j] != false)
				adjtree[i][j] = true; /*all numbers except zero will be count as 1*/
		}
	}



	do {
		printf("enter parent node -\n");
		scanf("%d", &parent);
		printf("enter son node -\n");
		scanf("%d", &son);

		if (path(adjtree, parent - 1, son - 1, count)) {
			printf("is %d parent of %d - true\n\n", parent, son);
		} else
			printf("is %d parent of %d - false\n\n", parent, son);

		printf("enter 1 for another check\n");
		scanf("%d", &again);
	} while (again == 1);

	return 0;
}

