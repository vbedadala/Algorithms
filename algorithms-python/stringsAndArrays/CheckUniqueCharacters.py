'''
Created on Sep 12, 2013

@author: vbedadala
'''

#Uses extra space
def checkUniqueCharactersUsingDict(inputStr):
    if len(inputStr) > 256:
        return False
    charCount ={}
    for i in range(0,len(inputStr)):
        if inputStr[i] not in charCount:
            charCount[inputStr[i]] = 1
        else:
        #duplicates found
            return False
    #no duplicates found    
    return True

#Uses boolArray. Assume Ascii
def checkUniqueCharactersUsingBooleanArray(inputStr):
    if len(inputStr) > 256:
        return False
    charMatch=[False for x in range(0, 255)]
    for i in range(0,len(inputStr)):
        if charMatch[ord(inputStr[i])]==True:
            return False
        charMatch[ord(inputStr[i])]=True
    return True


        
      
