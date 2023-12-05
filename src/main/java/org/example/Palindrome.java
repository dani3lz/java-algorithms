package org.example;

public class Palindrome {
    public boolean isPalindrome(int _inputNumber) {
        return _inputNumber == reverseNumber(_inputNumber);
    }

    private int reverseNumber(int _inputNumber) {
        int _reverseNumber = 0;
        while (_inputNumber > 0) {
            _reverseNumber = _reverseNumber * 10 + (_inputNumber % 10);
            _inputNumber /= 10;
        }
        return _reverseNumber;
    }
}
