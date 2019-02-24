package edu.byu.yc.symboltable;

/**
 * Your symbol table visitor must visit an ASTNode and return an implementation
 * of this interface. Each of the methods requires the fully qualified name of a
 * class. For example, the FQN of this interface is edu.byu.yc.symboltable.ISymbolTable.
 *
 * The first three methods return a String that should contain a type. Every
 * type is either a primitive, such as "int" or "float", or should be a fully
 * qualified name of some class or interface.
 */
public interface ISymbolTable {
    public String getFieldType(String classFQN, String fieldName);

    public String getMethodReturnType(String classFQN, String methodName);

    public String getParameterType(String classFQN, String methodName, String paramName);

    public boolean classExists(String classFQN);

    public boolean methodExists(String classFQN, String methodName);

    public boolean fieldExists(String classFQN, String fieldName);

    /**
     * The format for output will not be checked precisely. Output should include
     * each class. The output for each class should include each field name and its
     * corresponding type, as well as information about each method, its return
     * type, and the names and types of each parameter.
     */
    @Override
    public String toString();

    /**
     * This method need not be implemented in the symbol table assignment.
     */
    public ISymbolTable addLocal(String name, String type);

    /**
     * This method need not be implemented in the symbol table assignment. Depending
     * on your implementation style, you may or may not use this method. If you do
     * not, it needn't be implemented.
     */
    public ISymbolTable removeLocal(String name);
}
