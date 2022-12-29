//file header
    .arch armv6     //armv6 architecture
    .arm            //arm 32-bit IS
    .fpu vfp        //floating point co-processor
    .syntax unified //modern syntax

//definitions applying to the entire source file
    //.equ EXAMPLE_DEF, 0xff

    //.data         //uncomment if needed

    .text           //start of text segment

    .global fpconvert               //make fpconvert global for linking to
    .type   fpconvert, %function    //define fpconvert to be a function
    .equ 	FP_OFF, 32 	            //fp offset distance from sp (# of saved regs - 1) * 4

fpconvert:	
// function prologue - do not edit this part
    push    {r4-r10, fp, lr}    // save registers to stack
    add     fp, sp, FP_OFF      // set frame pointer to frame base

// you can use any of r0-r10 inclusive
// R0 is the parameter to the function
// the last value of R0 is the value
// returned from the function
// ==========================================================================
// YOUR CODE GOES IN THE SECTION BELOW
// ==========================================================================
	
	//checks for positive or negative zeros
	cmp r0, 0x0
	BEQ .Lposzer
	cmp r0, 0x2000
	BEQ .Lnegzer

	//calculats sign bit of converted number
	AND r1, r0, 0x2000	//r1 = sign bit
	LSL r1, r1, 18		//shifts sign bit to most significant bit

	//gets the exponent value
	AND r2, r0, 0x1f80	//r2 = exponent bits
	LSR r2, r2, 7		//shifts exponent bits to least significant bits

	//gets the mantissa bits
	AND r3, r0, 0x007f	//r3 = exponent bits in least significant bits

	//checks for infinity
	cmp r2, 0x3f		//if (E != 0b111111) {check denorm}
	BNE .Ldenorm		//else {convert_infinity}
	BL convert_infinity	
	B .Lret			//return result

.Lposzer:
	MOV r0, 0x0	
	B .Lret

.Lnegzer:
	MOV r0, 0x80000000
	B .Lret

.Ldenorm:
	cmp r2, 0x0		//if (E != 0) {convert normal value}
	BNE .Lnorm		//else {convert denormal value}
	
	MOV r2, 0x1e		//r2 = 30, or 0x1c

	MOV r4, 0xFFFFFF80	//iter variable to find first bit of mantissa
	MOV r5, 0x00000000	//variable to add to 30 for new exponent
.Ldencalc:
	ADD r5, r5, 0x1
	ASR r4, r4, 1
	AND r6, r3, r4		//finds the first bit of mantissa
	cmp r6, 0x0		//iterates to next bit
	beq .Ldencalc
	MVN r6, r6		//significant bit found, flips bits
	
	//reformats exponent
	ADD r2, r2, r5		//adds most significant mantissa bit to 30
	MVN r2, r2		//makes exponent negative
	ADD r2, r2, 0x1		
	ADD r2, r2, 0x7f	//gets exponent of converted value
	LSL r2, r2, 23

	//reformats new mantissa
	AND r3, r3, r6		//gets the new mantissa
	ADD r7, r5, 0x10	//number of bits to shift mantissa
	LSL r3, r3, r7

	MOV r0, r1		//sets sign bit
	ORR r0, r0, r2		//sets exponent bits
	ORR r0, r0, r3

	//returns
	b .Lret

.Lnorm: 
	//converts the exponent bits from 14-bit to 32-bit fp format
	ADD r2, r2, 0xffffffe1	//r2 = exponent = exponent bits - 31
	ADD r2, r2, 0x7f	//r2 = converted exponent bits = exponent + 127
	LSL r2, r2, 23		//shifts bits to exponent field of 32-bit fp format

	//reformats mantissa bits from 14-bit to 32-bit fp mantissa bits
	LSL r3, r3, 16		//shifts bits to mantissa field of 32-bit fp format
	
	//formats the conversion and stores in return result
	MOV r0, 0		//r0 = 0x00000000
	ORR r0, r0, r1		//sets sign bit
	ORR r0, r0, r2		//sets exponent bits
	ORR r0, r0, r3		//sets mantissa bits
.Lret:
// ==========================================================================
// function epilogue - do not edit
    sub	sp, fp, FP_OFF
    pop     {r4-r10, fp, lr}     // MUST MATCH LIST IN PROLOG'S PUSH
    bx      lr                   // return

// function footer
    .size fpconvert, (. - fpconvert) // set size for function

// ==========================================================================

    .global convert_infinity
    .type   convert_infinity, %function
    .equ    FP_OFF, 32
// make a 32-bit IEEE +Inf or -Inf
convert_infinity:	
// function prologue (do not edit)
    push    {r4-r10, fp, lr}    // save regs
    add     fp, sp, FP_OFF
// you can use any of r0-r10 inclusive
// R0 is the parameter to the function
// the last value of R0 is the value
// returned from the function
// r4-r10 are local to this function
// changes to these values will not be reflected
// in the main function.

// ==========================================================================
// YOUR CODE GOES IN THE SECTION BELOW
// ==========================================================================
	//calculats sign bit of converted number
	AND r1, r0, 0x2000	//r1 = sign bit
	LSL r1, r1, 18		//shifts sign bit to most significant bit

	//formats the conversion and stores in return result
	MOV r0, 0x7
	LSL r0, 4
	ORR r0, r0, 0xf
	LSL r0, 4
	ORR r0, r0, 0x8
	LSL R0, 20

	ORR r0, r0, r1

// ==========================================================================
// function epilogue (do not edit)
    sub	sp, fp, FP_OFF
    pop     {r4-r10, fp, lr}    // restore regs
    bx      lr                  // return
// function footer
    .size convert_infinity, (. - convert_infinity)

//file footer
    .section .note.GNU-stack,"",%progbits // stack/data non-exec (linker)
.end
