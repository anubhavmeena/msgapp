
## Java Code Challenge

## The problem 
Implement a small message processing application that satisfies the below requirements for processing sales notification messages. You should assume that an external company will be sending you the input messages, but for the purposes of this exercise you are free to define the interfaces. 

## Sales and Messages 
♣	A sale has a product type field and a value – you should choose sensible types for these. 
♣	Any number of different product types can be expected. There is no fixed set. 
♣	A message notifying you of a sale could be one of the following types 
o Message Type 1 – contains the details of 1 sale E.g apple at 10p 
o Message Type 2 – contains the details of a sale and the number of occurrences of that sale.
E.g 20 sales of apples at 10p each. 
o Message Type 3 – contains the details of a sale and an adjustment operation to be applied to all stored sales of this product type. Operations can be add, subtract, or multiply e.g Add 20p apples would instruct your application to add 20p to each sale of apples you have recorded. 

## Processing requirements 
♣	All sales must be recorded 
♣	All messages must be processed 
♣	After every 10th message received your application should log a report detailing the number of sales of each product and their total value. 
♣	After 50 messages your application should log that it is pausing, stop accepting new messages and log a report of the adjustments that have been made to each sale type while the application was running. 


## Solution
 
The solution to this problem is implemented using Java as follows:

1. Read the input file at test/input.txt, parse the sales notification line by line for product details and message type details.
2. Call the respective Handler to process the message depending on its type.
3. Create the Product object if new else fetch from the store and update it's sales or do adjustment operations as required.
4. Check the count of notifications processed and call logger on every 10th iteration and stop on 50th printing the log of adjustments
 
## Assumptions made
 
1. The product type like apple, apples or mango, mangoes etc.. are considered as one.
2. Use on single currency only. 

   
## How to run

The main method is located in src/com/jpmc/smpa/processor/Main.java
You need to run main method in this file to start the application.

