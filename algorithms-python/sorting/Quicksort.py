import datetime
import random
'''
Implementation of quicksort using python
Average case : theta(nlogn)

Expected case : theta(nlogn) : This is best option for implementing quicksort as this does not
assume anything about the distribution and has expected running time of nlogn. Usually this beats
merge sort in practice.

For size of 1000000 (random with duplicates)
randomized quicksort time in secs : 0:00:08.853510
mergesort time in secs : 0:00:12.410236


For size of 1000000 (no duplicates, already sorted in asc)
randomized quicksort time in secs : 0:00:08.084461
mergesort time in secs : 0:00:07.734147
quicksort with last element as pivot:  very bad! ( O(N^2))


This algorithm does not sort in place
Space complexity : n
@author: vasant
'''

def quicksort(unsorted,first, last):
    if first < last:   
        # replace last element with random element. This is to randomize pivot!
        randomPivot = random.randint(first, last)
        unsorted[last], unsorted[randomPivot] = unsorted[randomPivot], unsorted[last] 
        #initialze pivot with last element. This is to avoid unnecessory access to last element during swap!(improves performance)       
        p = unsorted[last]
        i = first - 1
        #maintain invariant: unsorted[first...i]<=p and unsorted[i...j]>p 
        for j in range(first,last):
            if unsorted[j] <= p:
                i += 1
                unsorted[j], unsorted[i] = unsorted[i], unsorted[j]
        #put the pivot in right place.
        unsorted[i+1], unsorted[last] = unsorted[last], unsorted[i+1]                
        randomPivot = i + 1
        quicksort(unsorted,first, randomPivot-1)
        quicksort(unsorted,randomPivot + 1, last) 
        
def printList(lst):
    for i in lst:
        print lst[i]

def __main__():
    unsorted = []
    for i in range(10000000):
        unsorted.append(random.randrange(0,10000000))

    # printList(unsorted)
    startTime = datetime.datetime.now()
    quicksort(unsorted,0, len(unsorted)-1) 
    endTime = datetime.datetime.now()
    print endTime - startTime
    # printList(unsorted)

if __name__ == '__main__':  
    __main__()
