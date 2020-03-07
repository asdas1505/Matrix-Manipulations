# Matrix-Manipulations

Developed a data-structure for representing the 2-dimensional block matrices and perform basic matrix
operations.

## The Data Structure has following methods:

**1. buildTwoDBlockMatrix()** :-  takes a reference to a stream from which the matrix is read and a reference to the newly created
object is returned.

**2. toString()** :- Returns the String representation of a TwoDBlockMatrix object.

**3. transpose()** :- If the calling object contains a 2-dimensional matrix of size m x n . The method returns the new transposed
2-dimensional matrix of size n x m . The original matrix remains same.

**4. multiply()** :- This method takes another matrix object of type TwoDBlockMatrix. The method should return the product of two input
matrix. If the two matrices are not compatible, it throws expception.

**5. getSubBlock()** :- This method returns the sub-block of the TwoDBlockMatrix object that belongs to the slice with input rows and 
columns. It throws an exception when there is no underlying sub-block in the specified range.

**6. inverse()** :- The method returns a new TwoDBlockMatrix object containing the inverse of the given matrix. In case the inverse matrix does not exist, function raises an
exception rather than returning anything.
