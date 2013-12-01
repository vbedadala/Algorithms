'''
Created on Sep 18, 2013

@author: vasant
'''


def bitCount(i):
    c=0
    while i :
        i= i & (i-1)
        c+=1
    return c


def __main__():
    print "No of bits set in 979868506 are " + str(bitCount(979868506))

if __name__ == '__main__':  
    __main__()
