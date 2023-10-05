#!/bin/bash

echo "Franklin True Martin HW3 part 1"
echo "This project is created using Antlr4 Lexer/Parser, \
and will output the time it takes for the files to be parsed \
at the end."

if [[ -z $2 ]] || [[ -z  $1 ]]; then
	echo "Invalid input. Enter the input and output directories as arg1 and arg2"
	exit 2
fi

echo "Creating output directory if not already present"

mkdir $2 2>/dev/null

max_tokens=800

time (java -jar target/hw3-1-spring-boot.jar $1 $2 $max_tokens)

echo "Complete, output is in: $2" 
