# Java Practice Project

This project contains various Java classes and methods for practicing different algorithms and data structures.

## Project Structure

- `src/org/practice/question/Heap.java`: Contains methods related to heap operations.
- `src/org/practice/question/Trie.java`: Implements a Trie data structure with methods for insertion, search, and prefix matching.
- `src/org/practice/question/Array.java`: Contains various array manipulation methods.

## Classes and Methods

### Heap

- `totalCost(int[] costs, int a, int b)`: Calculates the total cost based on the given parameters.

### Trie

- `insert(String word)`: Inserts a word into the Trie.
- `search(String word)`: Searches for a word in the Trie.
- `startsWith(String prefix)`: Checks if there is any word in the Trie that starts with the given prefix.
- `suggestedProducts(String[] products, String searchWord)`: Returns a list of product suggestions based on the search word.

### Array

- `findMin(int[] nums)`: Finds the minimum value in an array.
- `findMinimumInRotatedSortedArray(int[] nums)`: Finds the minimum value in a rotated sorted array.
- `moveZeroes(int[] nums)`: Moves all zeroes in the array to the end while maintaining the order of other elements.
- `countLength(Integer num)`: Counts the number of digits in an integer.
- `compress(char[] chars)`: Placeholder method for compressing characters.
- `validPalindrome(StringBuilder st)`: Checks if a string is a valid palindrome.
- `isPalindrome(String s)`: Checks if a string is a palindrome, ignoring non-alphanumeric characters.
- `isSubsequence(String s, String t)`: Checks if `s` is a subsequence of `t`.

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Navigate to the desired class and run the `main` method to execute the code.

## .gitignore

The `.gitignore` file is configured to ignore IDE-specific files and directories for IntelliJ IDEA, Eclipse, NetBeans, and VS Code.

## License

This project is licensed under the MIT License.
