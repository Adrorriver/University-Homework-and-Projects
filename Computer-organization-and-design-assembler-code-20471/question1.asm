
# Author:   amir dror 

# Input:  array of words, hexa 8 digit number
# Output: prints the sum of each word 
################# Data segment #####################
.data
NumArr: .word  0x1208031a,0x03060a11,0x043875,0x12831a,0x12751a,0,0x12da3,0x12da3,0x12da3,0x12da3
space: .asciiz  "\n"




################# Code segment #####################
.text
.globl main
main:	# main program entry
	
	lw $t0,NumArr 
	beqz $t0,exit	#cheak for zero
	move $s0,$zero	#set $s0 to 0
	li $t1,9  	# loop counter
	lbu $s1,NumArr	#lood first byte
	lbu $s2,NumArr+1
	lbu $s3,NumArr+2
	lbu $s4,NumArr+3
	
	add $s1,$s1,$s2		#add the numbers
	add $s1,$s1,$s3
	add $s1,$s1,$s4
	
	move $a0,$s1	#print the sum
        li $v0,1
        syscall
        
        la $a0,space	# print space ln
	li $v0,4	
	syscall	
	

loop:
	add $s0,$s0,4 		#increment $s0 by 4 - next word
	lw $t0,NumArr,($s0)
	beqz $t0,exit
	lbu $s1,NumArr,($s0)
	lbu $s2,NumArr+1,($s0)
	lbu $s3,NumArr+2,($s0)
	lbu $s4,NumArr+3,($s0)
	
	add $s1,$s1,$s2
	add $s1,$s1,$s3
	add $s1,$s1,$s4
	
	move $a0,$s1
        li $v0,1
        syscall	
        
        la $a0,space	
	li $v0,4	
	syscall	
       
        addi $t1,$t1,-1	#sub 1 from the loop counter 
        bnez $t1,loop	#go to the head of the loop if not rechs the 9 time.
   
 exit:
       move $a0,$zero	#print 0 - the last number of the data
       li $v0,1
       syscall
                	
	li $v0, 10	# Exit program
	syscall

	