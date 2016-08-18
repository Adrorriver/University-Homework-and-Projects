
# Author:   amir dror 

# Input:  integer num 
# Output: ok - if the last num have more 1 bit then the one before else - wrong
################# Data segment #####################
.data
ok: .asciiz "\nOK\n"
wrong: .asciiz "\nWRONG\n"



################# Code segment #####################
.text
.globl main
main:	# main program entry


	li $v0,5  #get a number from the user
	syscall
	beqz $v0,exit	#if num is 0 exit the program
	move $a1,$v0
loop:
	li $v0,5  #get a number from the user
	syscall
	beqz $v0,exit	#if num is 0 exit the program
	
	move $a0,$a1
	move $a1,$v0
	move $s7,$a1 # save the value of a1 for the next loop itirate
	jal pro
	
	move $a1,$s7 # load the value of a1 for the next loop itirate
	j loop	#go to the head of the loop
	
exit:	             	
	li $v0, 10	# Exit program
	syscall
	
################# Procedure segment #####################	
	
pro:
	addi  $t0,$zero,31	#loopa0 counter
	move $t1,$zero	# initialization 
	move $t2,$zero
	move $t3,$zero
	addi $t1,$zero,1 #masck
	and $t2,$a0,$t1  #chek
	add $t3,$t3,$t2 #counter
loopa0:
	srl $a0,$a0,1
	move $t1,$zero
	move $t2,$zero
	addi $t1,$zero,1 #masck
	and $t2,$a0,$t1
	add $t3,$t3,$t2 #counter
	add $t0,$t0,-1
	bnez $t0,loopa0	#go to the head of the loop 
	
      ######################################################
      	
	addi  $t0,$zero,31
	move $t1,$zero
	move $t2,$zero
	move $t4,$zero
	addi $t1,$zero,1 #masck
	and $t2,$a1,$t1
	add $t4,$t4,$t2 #counter
	
loopa1:
	srl $a1,$a1,1
	move $t1,$zero
	move $t2,$zero
	addi $t1,$zero,1 #masck
	and $t2,$a1,$t1
	add $t4,$t4,$t2 #counter
	add $t0,$t0,-1
	bnez $t0,loopa1	#go to the head of the loop 
	
	sltu $t5,$t3,$t4	#"if statment" - to decide ok or worng
	beqz $t5, else
	
	la $a0,ok	
	li $v0,4	        
	syscall		

	jr $ra

else:	la $a0,wrong	
	li $v0,4	        
	syscall		

	jr $ra

