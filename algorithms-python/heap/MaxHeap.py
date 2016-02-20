import math
'''
Max heap implementaion based on
Algorithms by Sedgewick
'''

class MaxHeap:
    def __init__(self):
        self.pq=[]
        self.N=0;

    def __init__(self,keys):
        self.heapify(keys)

    def swim(self,n):
        while n!=1 and self.pq[n] > self.pq[math.floor(n/2)]:
            self.pq[n],self.pq[math.floor(n/2)] = self.pq[math.floor(n/2)],self.pq[n]
            n=math.floor(n/2)

    def sink(self,n):
        while 2*n < self.N:
            if self.pq[2*n] > self.pq[2*n+1]:
                k=n
            else:
                k=n+1
            if self.pq[n]<self.pq[k]:
                self.pq[n],self.pq[k]=self.pq[k],self.pq[n]
            else:
                continue


    def heapify(self,keys):
        self.N=0
        for n in range(keys.length):
            self.pq[n+1]=keys[n]
            self.N+=1

        for n in range(math.floor(keys.lenth/2),0):
            self.sink(n)

    def insert(self,n):
        self.N+=1
        self.pq[self.N]=n
        self.swim(n)

    def deleteMax(self,n):
        self.pq[1],self.pq[self.N] =self.pq[self.N],self.pq[1]
        self.N-=1;
        self.sink(n)

    def max(self):
        self.pq[1]







