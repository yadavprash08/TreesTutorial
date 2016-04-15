package com.prashant.java.trees.binary;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
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

        return root;
    }
}
