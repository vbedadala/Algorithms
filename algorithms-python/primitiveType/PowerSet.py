'''
Created on Sep 20, 2013

@author: vasant
'''

def powerSet(s):
    print "emptySet"
    for i in range(0,len(s)):  
        print s[i]
        for j in range(i+1,len(s)):
            for k in range(j,len(s)):
                print str(''.join(s[i:j])) + str(s[k])
                
        

def __main__():
    powerSet(['A','B','C','D','E'])

if __name__ == '__main__':  
    __main__()


