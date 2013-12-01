'''
Created on Sep 18, 2013

@author: vasant
'''

def swapBits(n,i,j):
    #swap bits only if i and j are not equal
    
    if n >>i & 1 != n>>j & 1:
        n ^= (1 <<i) | (1<<j)
    return n

def __main__():
    print "swaping bits :  " + str(swapBits(12, 2, 0))

if __name__ == '__main__':  
    __main__()

        
        

        
        