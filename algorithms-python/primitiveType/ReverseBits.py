'''
Created on Sep 19, 2013

@author: vasant
'''

def reverseBits(n):
    for i in range(0,16):
        if (n>>(32-i))&1 != (n>>i) &1:
            n^= (1<<32-i) | (1<<i)
    return n

def __main__():
    print "reverse:  " + str(reverseBits(1024))

if __name__ == '__main__':  
    __main__()