package edu.byu.yc.symboltable;

import java.util.HashMap;
import java.util.Map;

import edu.byu.yc.ClassFieldsMethodsParams;

/**
 * @author Samuel Nuttall
 *
 * Symbol Table, before creating a symbol table the qualified class visitor determines all of the
 * fully qualified class names and then a symbol table can be established
 */
public class SymbolTable implements ISymbolTable {


    private Map<String, ClassFieldsMethodsParams> classFieldsMethodsParamsMap = new HashMap<>(); //class name to fields, methods, and parameters
    private Map<String, String> classSimpleToQualifiedName;

    public SymbolTable(Map<String, String> classSimpleToQualifiedName) {
        this.classSimpleToQualifiedName = classSimpleToQualifiedName;
    }

    @Override
    public String getFieldType(String classFQN, String fieldName) {
        ClassFieldsMethodsParams classFmp = classFieldsMethodsParamsMap.get(classFQN);
        return classFmp.getFieldTypeByName(fieldName);

    }

    @Override
    public String getMethodReturnType(String classFQN, String methodName) {
        ClassFieldsMethodsParams classFpm = classFieldsMethodsParamsMap.get(classFQN);
        return classFpm.getMethodTypeByName(methodName);
    }

    @Override
    public String getParameterType(String classFQN, String methodName, String paramName) {
        ClassFieldsMethodsParams classFpm = classFieldsMethodsParamsMap.get(classFQN);
        return classFpm.getParamTypeByName(methodName, paramName);
    }

    @Override
    public boolean classExists(String classFQN) {
        return false;
    }

    @Override
    public boolean methodExists(String classFQN, String methodName) {
        return false;
    }

    @Override
    public boolean fieldExists(String classFQN, String methodName) {
        return false;
    }

    @Override
    public ISymbolTable addLocal(String name, String type) {
        return null;
    }

    @Override
    public ISymbolTable removeLocal(String name) {
        return null;
    }

    public Map<String, ClassFieldsMethodsParams> getClassFieldsMethodsParamsMap() {
        return classFieldsMethodsParamsMap;
    }

    public void addNewClass(ClassFieldsMethodsParams classFieldsMethodsParams) {
        classFieldsMethodsParamsMap.put(classFieldsMethodsParams.getClassFQN(), classFieldsMethodsParams);
    }

    public Map<String, String> getClassSimpleToQualifiedName() {
        return classSimpleToQualifiedName;
    }
}
