'''
Created on Sep 12, 2013

@author: vbedadala
'''
import unittest
import CheckUniqueCharacters


class CheckForUniqueCharactersTest(unittest.TestCase):
     
    def testUniqueCharacters(self):
        assert CheckUniqueCharacters.checkUniqueCharactersUsingDict("ABCDEF") == True,"test failing"
        assert CheckUniqueCharacters.checkUniqueCharactersUsingBooleanArray("ABCDEF") == True,"test failing"
        
    def testDuplicateCharacters(self):
        assert CheckUniqueCharacters.checkUniqueCharactersUsingDict("AACDEF") == False,"test failing"
        assert CheckUniqueCharacters.checkUniqueCharactersUsingBooleanArray("AACDEF") == False,"test failing"
    
    def testAllDuplicateCharacters(self):
        assert CheckUniqueCharacters.checkUniqueCharactersUsingDict("AAAAAA") == False,"test failing"
        assert CheckUniqueCharacters.checkUniqueCharactersUsingBooleanArray("AAAAAA") == False,"test failing"
        
    def testSingleCharacter(self):
        assert CheckUniqueCharacters.checkUniqueCharactersUsingDict("A") == True,"test failing"
        assert CheckUniqueCharacters.checkUniqueCharactersUsingBooleanArray("A") == True,"test failing"
     
    def testAllLowerCaseCharacter(self):
        assert CheckUniqueCharacters.checkUniqueCharactersUsingDict("abcdef") == True,"test failing"
        assert CheckUniqueCharacters.checkUniqueCharactersUsingBooleanArray("abcdef") == True,"test failing"
 
    def testAllLowerCaseDuplicateCharacter(self):
        assert CheckUniqueCharacters.checkUniqueCharactersUsingDict("aaafaga") == False,"test failing"
        assert CheckUniqueCharacters.checkUniqueCharactersUsingBooleanArray("aaafaga") == False,"test failing"


if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()