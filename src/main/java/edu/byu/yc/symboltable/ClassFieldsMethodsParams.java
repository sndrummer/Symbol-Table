package edu.byu.yc.symboltable;


import org.eclipse.jdt.core.dom.AST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.byu.yc.symboltable.ASTNameType;

/**
 * @author Samuel Nuttall
 *
 * ClassFieldsMethodsParams contains an individual class' fields, methods, and params types and names
 * This class is an integral part of the symbol table and holds all the relevent information for an
 * a class that has been visited by the symbol table visitor.
 */
public class ClassFieldsMethodsParams {

    private String classFQN;

    private List<ASTNameType> fields;
    private Map<ASTNameType, List<ASTNameType>> methodParamsMap;

    public ClassFieldsMethodsParams(String classFQN) {
        this.classFQN = classFQN;
        fields = new ArrayList<>();

        methodParamsMap = new HashMap<>();

    }

    public String getFieldTypeByName(String fieldName) {
        String type = null;
        for (ASTNameType nameType : fields) {
            if (nameType.getName().equals(fieldName))
                type = nameType.getType();
        }
        return type;
    }

    public String getMethodTypeByName(String methodName) {
        String type = null;
        for (Map.Entry<ASTNameType, List<ASTNameType>> entry: methodParamsMap.entrySet()) {
            if (entry.getKey().getName().equals(methodName))
                type = entry.getKey().getType();
        }
        return type;
    }

    public String getParamTypeByName(String methodName, String paramName) {
       String type = "";
        List<ASTNameType> params = methodParamsMap.get(methodName);

        for (ASTNameType nameType : params) {
            if (nameType.getName().equals(paramName))
                type = nameType.getType();
        }
        return type;
    }

    public String getClassFQN() {
        return classFQN;
    }

    public List<ASTNameType> getFields() {
        return fields;
    }

    public Map<ASTNameType, List<ASTNameType>> getMethodParamsMap() {
        return methodParamsMap;
    }

    public void addField(ASTNameType fieldNameTypes) {
        fields.add(fieldNameTypes);
    }

    public void addMethod(ASTNameType methodNameType, List<ASTNameType> paramNameTypes) {
        methodParamsMap.put(methodNameType, paramNameTypes);
    }

    @Override
    public String toString() {
        return "ClassFieldsMethodsParams{" +
                "classFQN='" + classFQN + '\'' +
                ", fields=" + fields +
                ", methodParamsMap=" + methodParamsMap +
                '}';
    }
}
