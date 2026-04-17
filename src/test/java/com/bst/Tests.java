package com.bst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;


public class Tests {

    @Test
    public void testInsertAndSearchSingleElement() {
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();

        Association<String, String> assoc = new Association<>("yesterday", "ayer");
        tree.insert(assoc);

        Association<String, String> result = tree.search(new Association<>("yesterday", ""));

        assertNotNull(result);
        assertEquals("ayer", result.getValue());
    }

    @Test
    public void testSearchElementNotFound() {
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();

        tree.insert(new Association<>("mushroom", "hongo"));

        Association<String, String> result = tree.search(new Association<>("asdfgh", ""));

        assertNull(result);
    }

    @Test
    public void testInsertMultipleAndSearch() {
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();

        tree.insert(new Association<>("tree", "arbol"));
        tree.insert(new Association<>("search", "buscar"));
        tree.insert(new Association<>("whale", "ballena"));

        Association<String, String> result1 = tree.search(new Association<>("tree", ""));
        Association<String, String> result2 = tree.search(new Association<>("whale", ""));

        assertEquals("arbol", result1.getValue());
        assertEquals("ballena", result2.getValue());
    }

    @Test
    public void testInsertMaintainsBSTProperty() {
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();

        tree.insert(new Association<>("m", "m"));
        tree.insert(new Association<>("ñ", "ñ"));
        tree.insert(new Association<>("z", "z"));

        assertNotNull(tree.search(new Association<>("ñ", "")));
        assertNotNull(tree.search(new Association<>("z", "")));
    }

    @Test
    public void testInsertDuplicateKey() {
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();

        tree.insert(new Association<>("bug", "bicho"));
        tree.insert(new Association<>("bug", "insecto"));

        Association<String, String> result = tree.search(new Association<>("bug", ""));

        assertNotNull(result);
        assertEquals("bicho", result.getValue());
    }
}