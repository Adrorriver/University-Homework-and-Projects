
# Author:   amir dror 

# Input:  command and 2 operends
# Output: the resulte of the command - integer


# assumption: the inputnumbers are not 0 -    by hanita lidor website
# 	      the input is num or a char in the right place- no char in wrong place - by ram bosani class

################# Data segment #####################
.data

msg1: .asciiz "\n Please enter a  command- \n add,sub,mul,div,and,or,stop :   "
msg2: .asciiz "\n Please enter first operend- not 0:   "
msg3: .asciiz "\n Please enter secound operend- not 0:   "
msg4: .asciiz "\n Wrong command \n"

chadd:   .asciiz "add"
chsub:   .asciiz "sub"
chmul:   .asciiz "mul"
chdiv:   .asciiz "div"
chand:   .asciiz "and"
chor:    .asciiz "or"
chstop:  .asciiz "stop"
theString: .asciiz


################# Code segment #####################
.text
.globl main
main:	# main program entry

loop:
	move $a0,$zero # initialization 
	move $a1,$zero
	move $v0,$zero
	move $t0,$zero
	move $t1,$zero
	move $t2,$zero
	move $t3,$zero
	move $t4,$zero
	move $t5,$zero
	move $t6,$zero
	move $t7,$zero
	move $s0,$zero
	move $s1,$zero
	move $s2,$zero
	move $s3,$zero
	move $s4,$zero
	move $s5,$zero
	move $s6,$zero
	move $s7,$zero

	la $a0,msg1	# Please enter a  command- \n add,sub,mul,div,and,or,stop :
	li $v0,4	
	syscall			
	
	li $v0,8  	# read a strig
	la $a0, theString
	li $a1, 5
	syscall

	lbu $s7,theString   # segmentation of the string
	lbu $s6,theString+1
	lbu $s5,theString+2
	lbu $s4,theString+3
	
	lbu $t7,chstop		#cheak for stop command
	lbu $t6,chstop+1
	lbu $t5,chstop+2
	lbu $t4,chstop+3

	bne $s7,$t7,operends
	bne $s6,$t6,operends
	bne $s5,$t5,operends
	beq $s4,$t4,exit
	
	
########################read numbers#########################
operends:
	la $a0,msg2	# Please enter first operend- not 0:
	li $v0,4	
	syscall	
	
	li $v0,5  #
	syscall
	move $s0,$v0
	
	la $a0,msg3	# Please enter secound operend- not 0:  
	li $v0,4	
	syscall	
	
	li $v0,5  #
	syscall
	move $s1,$v0
	
		
################################################			###########################################	
cheakadd:

	lbu $t7,chadd
	lbu $t6,chadd+1
	lbu $t5,chadd+2
	li $t4,10 	# the enter key

	bne $s7,$t7,cheaksub	#chaek if the string is add
	bne $s6,$t6,cheaksub
	bne $s5,$t5,cheaksub
	bne $s4,$t4 cheaksub 
	add $a0,$s0,$s1		#the add command
	li $v0,1
        syscall

	j loop	#go to the head of the loop
	
cheaksub:	#same algoritme like add
	
	lbu $t7,chsub
	lbu $t6,chsub+1
	lbu $t5,chsub+2
	li $t4,10 	# the enter key

	bne $s7,$t7,cheakmul
	bne $s6,$t6,cheakmul
	bne $s5,$t5,cheakmul
	bne $s4,$t4 cheakmul 
	
	sub $a0,$s0,$s1
	li $v0,1
        syscall

	j loop	#go to the head of the loop
	
cheakmul:

	lbu $t7,chmul
	lbu $t6,chmul+1
	lbu $t5,chmul+2
	li $t4,10 	# the enter key

	bne $s7,$t7,cheakdiv
	bne $s6,$t6,cheakdiv
	bne $s5,$t5,cheakdiv
	bne $s4,$t4 cheakdiv 
	
	mul $a0,$s0,$s1
	li $v0,1
        syscall

	j loop	#go to the head of the loop

cheakdiv:

	lbu $t7,chdiv
	lbu $t6,chdiv+1
	lbu $t5,chdiv+2
	li $t4,10 	# the enter key

	bne $s7,$t7,cheakand
	bne $s6,$t6,cheakand
	bne $s5,$t5,cheakand
	bne $s4,$t4 cheakand 
	
	div  $a0,$s0,$s1
	li $v0,1
        syscall

	j loop	#go to the head of the loop

cheakand:

	lbu $t7,chand
	lbu $t6,chand+1
	lbu $t5,chand+2
	li $t4,10 	# the enter key

	bne $s7,$t7,cheakor
	bne $s6,$t6,cheakor
	bne $s5,$t5,cheakor
	bne $s4,$t4 cheakor 
	
	and  $a0,$s0,$s1
	li $v0,1
        syscall

	j loop	#go to the head of the loop


cheakor:

	lbu $t7,chor
	lbu $t6,chor+1
	li $t5,10 	# the enter key


	bne $s7,$t7,wrong
	bne $s6,$t6,wrong
	bne $s5,$t5 wrong

	
	or  $a0,$s0,$s1
	li $v0,1
        syscall

	j loop	#go to the head of the loop



wrong:	#the difult if the string dont mach any command

	la $a0,msg4	
	li $v0,4		
	syscall	
	j loop	#go to the head of the loop
	
exit:	             	
	li $v0, 10	# Exit program
	syscall

