package edu.byu.yc.symboltable;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Samuel Nuttall
 */
public class SymbolTableVisitor extends ASTVisitor {
    private static Logger logger = LoggerFactory.getLogger(SymbolTableVisitor.class);

    private SymbolTable symbolTable;

    public SymbolTableVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    public boolean visit(TypeDeclaration td) {

        String declarationName = td.getName().toString();
        logger.info("Class name {}", declarationName);

        return true;
    }

    @Override
    public boolean visit(PackageDeclaration pd) {

        String packageName = pd.getName().toString();
        logger.info("Package name {}", packageName);

        return true;
    }

}