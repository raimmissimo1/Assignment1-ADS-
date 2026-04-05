#!/bin/bash

num=1

while [ $num -le 10 ]
do 
	touch task${num}.java
 	num=$(( $num +1 ))
done
	
echo "all files were successfully created"
