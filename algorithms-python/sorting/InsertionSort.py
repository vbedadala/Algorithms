'''
Created on Aug 29, 2013
Insertion sort algorithm using python
Worst case : theta(n^2), sorts in place.
@author: vasant
'''
import random
import datetime

def insertionsort(unsorted):
    #start from second element. Initialize the list of sorted elements as 1
    for i in range(1,len(unsorted)):
        j = i
        temp = unsorted[i]
        #Invariant : unsorted[0..i] is always sorted. take ith element and find index j such invariant is satisfied.
        while j>=0 and temp <=unsorted[j-1]:         
            # Until we find the right place shift elements to right.
            unsorted[j] = unsorted[j-1]
            j-=1
        # when loops end, j represents the hole where we need to fill the ith element.
        unsorted[j]=temp 
        
    return unsorted

def printList(lst):
    for i in lst:
        print lst[i]
        
def __main__():
    unsorted = []
    for i in range(10):
        unsorted.append(i)
    random.shuffle(unsorted)

    printList(unsorted)
    startTime = datetime.datetime.now()
    insertionsort(unsorted) 
    endTime = datetime.datetime.now()
    print endTime - startTime
    printList(unsorted)

if __name__ == '__main__':  
    __main__()


