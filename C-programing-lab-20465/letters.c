#include <stdio.h>
#include <ctype.h>

/* change a string doc.
puts capital letters, bolding expretion in" ",
lowering ani other letter,prints no numbers,
a space row for eatch sentens. */
 
int main() {
	int c, upstate = 0, firstletter = 0;

	if ((c = getchar()) != EOF) /* initialization */
		putchar(toupper(c));

	while ((c = getchar()) != EOF) { /*read the file until the end */

		if (c >= '0' && c <= '9') /*no numbers */
			continue;

		
		if (c == '"') {			/* flag for " state */
			if (upstate == 0)
				upstate = 1;
			else
				upstate = 0;
		}
		
		/* state tabe for end of line */ 
		if (firstletter == 0 && (c == '.' || c == '?' || c == '!')) 
			firstletter = 1;
		else if (firstletter == 0 && (c != '.' || c != '?' || c != '!'))
			firstletter = 0;
		else if (firstletter == 1 && (c == '.' || c == '?' || c == '!'))
			firstletter = 1;
		else if (firstletter == 1 && (c == ' ' || c == '\t' || c == '\n'))
			firstletter = 2;
		else if (firstletter == 1)
			firstletter = 0;
		else if (firstletter == 2)
			firstletter = 3;
		
		if (c == '\n') {	/*print space line*/ 
			printf("\n\n");
			continue;
		}
		
		/* lowering all letters end check states */
		c = tolower(c); 

		if (upstate == 1)
			c = toupper(c);
		if (firstletter == 3) {
			c = toupper(c);
			firstletter = 0;
		}

		putchar(c);
	}

	return 0;
}



