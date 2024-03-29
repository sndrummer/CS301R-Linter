package edu.byu.yc;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.StructuralPropertyDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Samuel Nuttall
 */
public class ASTUtilities {

    private ASTUtilities() {
    }

    private static Logger logger = LoggerFactory.getLogger(ASTUtilities.class);

    public static void logProperties(ASTNode node) {
        List list = node.structuralPropertiesForType();
        for (int i = 0; i < list.size(); i++) {
            StructuralPropertyDescriptor curr = (StructuralPropertyDescriptor) list.get(i);
            logger.debug("PROPERTY {}", curr);
        }
    }

    public static void logChildren(ASTNode node, int propId) {
        Object[] children = getChildNodes(node, propId);
        logger.debug("Children count {}", children.length);
        for (int i = 0; i < children.length; i++) {
            logger.debug("CHILD {}: {}", i, children[i]);
        }
    }

    public static Object[] getChildNodes(ASTNode node, int propId) {
        List list = node.structuralPropertiesForType();
        Object child = node.getStructuralProperty((StructuralPropertyDescriptor) list.get(propId));
        if (child instanceof List) {
            return ((List) child).toArray();
        } else if (child instanceof ASTNode) {
            return new Object[]{child};
        }
        return new Object[0];
    }


}
