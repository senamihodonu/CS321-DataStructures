# Project #3: Experiments with Hashing

* Author: Senami Hodonu
* Class: CS321 Section #003
* Semester: Fall 2021

## Overview

The goal of this project is to explore the concepts of hashing by experimenting with 
open addressing. This project explores how load factor affects the average number of probes
required by open addressing while using linear probing and double hashing for different
types of inputs. The input types used in this project were random numbers, system time, 
and a word list. A hash table was setup to be an array of HashObject. The HashObject 
class was setup to contain a generic key object, a frequency count and a probe count. 
The value for the hash table size was generated using the smallest twin primes in the 
given grange [95500 . . . 96000].

## Reflection

This project really exposed me to the usefulness of inheritance. Being able to have 
all the common hash table functionalities of my LinearProbing and DoubleHashing class
in the abstract class really helped in simplifying my code and making it consize. This is
is a practice I hope to carry into future projects. 

One minor challenge I faced was getting my generated output files to match the provided 
sample files. I spent sometime comparing the different files and I could not find any 
difference between them. I then proceeded to use an online diff checker, which reulted
in no difference detected between the generated files and the provided sample files. I 
was able to resolve this issue by including ignore all white space argument, -w, in the 
diff command.

## Compiling and Using

From the directory containing all source files, the driver class (and all dependencies) 
are compiled with the command:
$ javac HashtableTest.java

Run the compiled class file with the command:

$ java HashtableTest <input type> <load factor> [<debug level>]

where:
    input type = 1 for random numbers, 2 for system time, 3 for word list
    debug = 0 ==> print summary of experiment
    debug = 1 ==> save the two hash tables to a file at the end
    debug = 2 ==> print debugging output for each insert

The included MaxHeap test class is compiled with the command:
$ javac MaxHeapTest.java

The MaxHeap test class is run with the command:
$ java MaxHeapTest

## Results 

Output files generated from executing java HashTableTest 3 0.5 1 were compared with 
the provided sample output files on onyx with the diff commands below.

$ diff -w linear-dump.txt sample-linear-dump.txt
$ diff -w double-dump.txt sample-double-dump.txt

Input source 1: random number

alpha   linear    double
-----------------------------
0.5      1.4542    1.3572
0.6      1.7026    1.4962
0.7      2.0938    1.6856
0.8      2.9028    1.9613
0.9      6.3553    2.5133
0.95    55.2027    3.1020
0.98   497.9565    3.9456
0.99   830.5810    4.5916


Input source 2: current time

alpha        linear    double
-----------------------------
0.5          1.0       1.0
0.6          1.0       1.0
0.7          1.0       1.0
0.8          1.0       1.0
0.9          1.0       1.0
0.95     15.0902    2.8208
0.98     62.4506    3.9352
0.99     1698.86    4.4490


Input source 3: word-list

alpha   linear    double
-----------------------------
0.5      1.5969    1.3905
0.6      2.1494    1.5341
0.7      3.6039    1.7213
0.8      6.7084    2.0160
0.9     19.8149    2.5692 
0.95   110.594     3.1861 
0.98   324.2063    4.0198
0.99   471.6714    4.6956




## Sources used
Used link to review how to do a prime check
//https://www.geeksforgeeks.org/java-program-to-check-if-a-number-is-prime-or-not/
Used link to review how to do rounding in java
//https://www.programiz.com/java-programming/examples/round-number-decimal



----------
This README template is using Markdown. To preview your README output,
you can copy your file contents to a Markdown editor/previewer such
as [https://stackedit.io/editor](https://stackedit.io/editor).from 
