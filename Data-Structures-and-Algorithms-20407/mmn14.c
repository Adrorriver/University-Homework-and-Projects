#include <stdio.h>
#include <ctype.h>


#define N 512
#define K 8
int count = 0;

typedef struct h {
	int length;
	int heapsize;
	int *arr;
} heap;

void readFileToArray(int arr[]);
int getNextInt(int *pn);
void buildHeaps(int arr[], heap *heaps);
void buildMaxHeap(heap *newheap);
void maxHeapify(heap *newheap, int i);
int heapExtractMax(heap *heapptr);
int heapMaximum(heap *heapptr);
void sortOut(heap heaps[]);
int Left(int i);
int Right(int i);
void exchange(int *px, int *py);

int main() {
	int arr[N + 1];
	heap heaps[K + 1];

	readFileToArray(arr);
	buildHeaps(arr, heaps);
	sortOut(heaps);

	printf("\n""count-> %d\n",count);
	return 0;
}

void readFileToArray(int arr[]) {
	int i;
	arr[0] = 0;
	for (i = 1; i <= N; i++) {
		getNextInt(&arr[i]);
	}
}

/* getNextInt: get next integer from input into *pn */
int getNextInt(int *pn) {
	int c, sign;
	while (isspace(c = getchar()))
		/*skip white spaces */
		;
	if (!isdigit(c) && c != EOF && c != '+' && c != '-') {
		return 0;
	} else
		sign = (c == '-') ? -1 : 1;
	if (c == '+' || c == '-') {
		c = getchar();
	}
	for (*pn = 0; isdigit(c); c = getchar()) {
		*pn = 10 * *pn + (c - '0');
	}
	*pn *= sign;
	return c;
}

void buildHeaps(int arr[], heap *heaps) {

	int i, j = 0;
	for (i = 1; i < K; ++i) {
		heaps[i].length = N / K;
		heaps[i].arr = &arr[j];
		heaps[i].heapsize = heaps[i].length;
		buildMaxHeap(&heaps[i]);
		j += N / K;
	}
	heaps[K].length = N - j;
	heaps[K].arr = &arr[j];
	heaps[K].heapsize = heaps[K].length;
	buildMaxHeap(&heaps[K]);
}

void buildMaxHeap(heap *newheap) {
	int i;

	for (i = newheap->length / 2; i >= 1; --i) {
		maxHeapify(newheap, i);
	}
}

void maxHeapify(heap *newheap, int i) {
	int l = 0, r = 0, largest;
	l = Left(i);
	r = Right(i);
	count++;
	if (l <= newheap->heapsize && newheap->arr[l] > newheap->arr[i]) {
		largest = l;
	} else{
		largest = i;
	}

	count++;
	if (r <= newheap->heapsize && newheap->arr[r] > newheap->arr[largest]) {
		largest = r;
	}

	count++;
	if (largest != i) {
		exchange(&(newheap->arr[i]), &(newheap->arr[largest]));
		maxHeapify(newheap, largest);
	}
}

void sortOut(heap heaps[]) {
	int i, tmp, index, max = 0;
	while (max != -1) {
		max = -1;
		for (i = 1; i <= K; ++i) {
			if (heaps[i].heapsize > 0) {
				tmp = heapMaximum(&heaps[i]);
				count++;
				if (max < tmp) {
					max = tmp;
					index = i;
				}
			}
		}
		if (max != -1) {
			printf("%d\n", heapExtractMax(&heaps[index]));
		}
	}
}

int heapExtractMax(heap *heapptr) {
	int max;
	if (heapptr->heapsize < 1)
		printf("error heap underflow");
	max = heapptr->arr[1];
	heapptr->arr[1] = heapptr->arr[heapptr->heapsize];
	heapptr->heapsize -= 1;
	maxHeapify(heapptr, 1);
	return max;
}

int heapMaximum(heap *heapptr) {
	return heapptr->arr[1];
}


int Left(int i) {
	return 2 * i;
}

int Right(int i) {
	return ((i * 2) + 1);
}

void exchange(int *px, int *py) {
	int temp;
	temp = *px;
	*px = *py;
	*py = temp;
}

