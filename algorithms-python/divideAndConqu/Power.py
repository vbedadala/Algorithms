'''
Created on Sep 18, 2013

@author: vasant
'''

memory = dict()
def powerOfN(x,n):
    if n==0:
        return 1
    if n==1:
        return x
    else:
        if n%2==0:
            val = powerOfN(x,n/2)
            return val * val
        else:
            val = powerOfN(x,(n-1)/2)
            return val * val * x
    



def __main__():
    print "2 Power 10000 is " + str(powerOfN(2, 1000000))

if __name__ == '__main__':  
    __main__()
