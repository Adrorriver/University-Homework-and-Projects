all: set

set : main.o set.o
	gcc -g -Wall -ansi -pedantic set.o main.o -o set

main.o: main.c
	gcc -c -Wall -ansi -pedantic main.c -o main.o

set.o : set.c
	gcc -c -Wall -ansi -pedantic set.c -o set.o
	

