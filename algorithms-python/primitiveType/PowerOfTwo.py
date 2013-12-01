'''
Created on Sep 18, 2013

@author: vasant
'''

def powerOfTwo(i):
    if i and not(i & (i-1)):
        return True
    return False

def __main__():
    print "power of two:  " + str(powerOfTwo(1024))

if __name__ == '__main__':  
    __main__()
