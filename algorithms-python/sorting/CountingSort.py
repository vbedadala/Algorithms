'''
Counting sort ( Used when input is distributed with in some range ( 0 .. k)

Running time : Theta(n)

Fast algorithm if the input is within range.

Ex : 10 bit 10 million integers can be sorted in 5 seconds. Quick sort takes

@author: vasant
'''
import random
import datetime

def countingsort(unsorted,k):
    counter =[0 for i in range(0,k)]
    sortedArray=[0 for i in range(0,len(unsorted))]
    
    for j in range(0,len(unsorted)):
        counter[unsorted[j]]+=1
 
#rank computation
    for j in range(1,k):
        counter[j] = counter[j] + counter[j-1] 
    
    j=len(unsorted)-1
    
    while j >= 0 :
            counter[unsorted[j]]-=1   
            sortedArray[counter[unsorted[j]]] = unsorted[j]
            j-=1 
    return sortedArray

        
def printList(lst):
    for i in range(0,len(lst)):
        print lst[i]

def __main__():
    unsorted = []
    for i in range(10000000):
        unsorted.append(random.randrange(0,1024))

   # printList(unsorted)
    startTime = datetime.datetime.now()
    unsorted=countingsort(unsorted,1024) 
    endTime = datetime.datetime.now()
    print endTime - startTime
   # printList(unsorted)

if __name__ == '__main__':  
    __main__()