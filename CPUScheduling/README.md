# Project #2: CPU Scheduling Simulation using a Priority Queue

* Author: Senami Hodonu
* Class: CS321 Section #003
* Semester: Fall 2021

## Overview

The goal of this project was to simulate the priority-based round robin scheduling 
algorithm for assigning a CPU to a running process.In this project, a MaxHeap class 
was implemented using an array. Then, a priority queue, PriorityQueue, was implemented 
by extending the MaxHeap class. Each node in the max heap was designed to contain an 
instance of the Process class. The Process class implemented the Comparable interface 
so that the comparison between nodes in max-heap can be made by calling compareTo method. 
To implement the compareTo method, process with larger priority level has a higher 
priority. In case of a tie, process with earlier arrival time should be picked.

## Reflection

One of my main challenges working through this project was dealing with a recurring 
NullPointerException. The discripancy of the test book having a pseudo-code that had 
as heap starting index of 1 and java typically having a starting of 0, caused me a 
lot of issues working through this project. Many of the methods written in the different 
classes had to account for this difference. It was a tedius experdition identifing and 
the different lines to code that need to reflect this difference. I sincerely contemplated 
switching to using an ArrayList instead of Arrays.The debugger and the numerous tutoring 
sessions were very useful in resolving these issues.

Something I took from working on this project, was the importance of understanding a 
provided code and the pseudo-codes. The numerous issues encounted really forced me to 
delve into understanding the provided CPUScheduling class and really studying the 
pseudo-codes. Overall, working on this project was a very challenging experience for me.

## Compiling and Using

From the directory containing all source files, the driver class (and all dependencies) 
are compiled with the command:
$ javac CPUScheduling.java

Run the compiled class file with the command:

$ java CPUScheduling <maxProcessTime> <maxPriorityLevel> <timeToIncrementPriority> 
<simulationTime> <processArrivalRate> [<seed>]

The included MaxHeap test class is compiled with the command:
$ javac MaxHeapTest.java

The MaxHeap test class is run with the command:
$ java MaxHeapTest

## Results 

My simulated results were compared with 5 different provided test files. The run-test.sh
was also run to confirm that my simulated results matched the provided test outputs. 

## Sources used

My MaxHeap test class was adapted from a test class provided and used in my CS221 class. 



----------
This README template is using Markdown. To preview your README output,
you can copy your file contents to a Markdown editor/previewer such
as [https://stackedit.io/editor](https://stackedit.io/editor).
