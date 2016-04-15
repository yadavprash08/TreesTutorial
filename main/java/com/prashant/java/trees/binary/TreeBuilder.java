package com.prashant.java.trees.binary;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.copyOfRange;
import static java.util.Objects.isNull;

/**
 * Created by yprasha on 4/15/16.
 */
public class TreeBuilder {

    private final File inputFile;

    public TreeBuilder(File inputFile) {
        this.inputFile = inputFile;
    }

    public TreeNode readTree() throws IOException {
        TreeNode root = null;

        List<String> lines = Files.readAllLines(Paths.get(inputFile.toURI()));
        String preOrderTraversal = lines.get(0);
        String inOrderTraversal = lines.get(1);

        String[] inOrders = inOrderTraversal.split(" ");
        String[] preOrders = preOrderTraversal.split(" ");

        root = parseTree(inOrders, preOrders);

        return root;
    }

    private TreeNode parseTree(String[] inOrders, String[] preOrders) {
        if (isNull(inOrders) || isNull(preOrders)) {
            return null;
        }
        if (0 == inOrders.length || 0 == preOrders.length) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(preOrders[0]));
        int searchIndex = findIndex(inOrders, preOrders);
        int preorderTo = preOrders.length - 1;
        if (searchIndex > 0) {
            int to = searchIndex - 1;
            node.setLeft(parseTree(copyOfRange(inOrders, 0, to), copyOfRange(preOrders, 1, preorderTo)));
        }

        int inOrderTo = inOrders.length - 1;
        if (searchIndex != inOrderTo) {
            int from = searchIndex + 1;
            node.setRight(parseTree(copyOfRange(inOrders, from, inOrderTo), copyOfRange(preOrders, 1, preorderTo)));
        }

        return node;
    }

    private int findIndex(String[] inOrders, String[] preOrders) {
        for (int i = 0; i < preOrders.length; i++) {
            if (Objects.equals(inOrders[i], preOrders[0])) {
                return i;
            }
        }
        return 0;
    }
}
