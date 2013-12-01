'''
Implementation of merge sort using python
Worst case : theta(nlogn)

This algorithm does not sort in place
Space complexity : n
@author: vasant
'''
import math
import random
import datetime

def merge(left, right):
    
    result = [] 
    i, j = 0, 0
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
                result.append(left[i])
                i += 1
        else:
                result.append(right[j])
                j += 1
    
    result.extend(left[i:])
    result.extend(right[j:])
    return result

def mergesort(unsorted):
    if len(unsorted) <= 1 :
        return unsorted
    mid = int(math.floor(len(unsorted) / 2))
    
    left = mergesort(unsorted[:mid])
    right = mergesort (unsorted[mid:])
    
    return merge(left, right)
    
def printList(lst):
    for i in lst:
        print lst[i]

def __main__():
    unsorted = []
    for i in range(10000000):
        unsorted.append(i)

    #printList(unsorted)
    startTime = datetime.datetime.now()
    mergesort(unsorted) 
    endTime = datetime.datetime.now()
    print endTime - startTime
    #printList(unsorted)

if __name__ == '__main__':  
    __main__()



             
        
    
    
    
