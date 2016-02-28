class IndexMinHeap:
    def __init__(self, N):
        self.pq=[] # position of element on heap
        self.N=N
        self.qp=[-1 for x in  range(self.N)]
        self.keys=[]



    def swim(self,n):
        while n!=1 and self.less(n,n//2):
            self.exch(n,n//2)
            n=n//2

    def sink(self,n):
        k=0
        while 2*n<self.N:
            if self.less(2*n,2*n + 1):
                k=n
            else:
                k=n+1
            if self.less(n,k):
                self.exch(n,k)
                n=k
            else:
                break



    def exch(self,i,j):
        self.pq[i],self.pq[j] = self.pq[j], self.pq[i]
        self.qp[self.pq[i]]=i
        self.qp[self.pq[j]]=j

    def less(self,i,j):
        if self.keys[self.pq[i]]< self.keys[self.pq[j]]:
            True
        else:
            False

    def insert(self,i,key):
         self.N+=1
         self.pq[self.N]=i
         self.keys[self.N]=key
         self.qp[i]=self.N
         self.swim(self.N)

    def delete(self,i,key):
        heapIndex=self.qp[i];
        self.exch(1,heapIndex)
        self. N-=1
        self.sink(self.N)

    def changekey(self,i,key):
        heapIndex=self.qp[i]
        self.keys[i] =key
        #can be greater or smaller
        self.swim(heapIndex)
        self.sink(heapIndex)

    def decreaseKey(self,i,key):
        heapIndex=self.pq[i]
        self.keys[i]=key;
        self.swim(heapIndex)


    def contains(self,i):
        if i <1 or i>self.N:
            raise ValueError("Index out of bound")
        else:
            self.qp[i]!=-1












