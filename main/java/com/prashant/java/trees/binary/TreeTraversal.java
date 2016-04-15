package com.prashant.java.trees.binary;

import java.text.MessageFormat;
import java.util.Objects;

import static java.text.MessageFormat.format;

/**
 * Created by yprasha on 4/15/16.
 */
public class TreeTraversal {

    private final TreeNode root;


    public TreeTraversal(TreeNode root) {
        this.root = root;
    }

    private void postOrderTraversal() {
        traversePostOrder(root);
    }

    private void traversePostOrder(TreeNode root) {
        if(Objects.isNull(root)) {
            return;
        }
        traversePostOrder(root.getLeft());
        traversePostOrder(root.getRight());
        System.out.println(format("{0} ", root.getValue()));
    }
}
