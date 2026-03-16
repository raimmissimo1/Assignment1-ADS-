#!/bin/bash

num=4

while [ $num -le 10 ]
do 
	touch task${num}.java
 	num=$(( $num +1 ))
done
	
echo "all files were successfully created"
