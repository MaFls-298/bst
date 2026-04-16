package com.bst;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BinaryTree<Association<String, String>> tree = new BinaryTree<>();

        // Leer diccionario
        InputStream inputStrDic = Main.class.getClassLoader().getResourceAsStream("diccionario.txt");
        if (inputStrDic == null) {
            
            throw new RuntimeException("No se encontro diccionario.txt");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStrDic));
        
        
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            String[] words = line.split(",");
            if (words.length == 2) {
                String eng = words[0].trim().toLowerCase();
                String es = words[1].trim().toLowerCase();

                Association<String, String> assoc = new Association<>(eng, es);
                tree.insert(assoc);
            }
        }
        br.close();

        // Mostrar ordenado
        System.out.println("Diccionario ordenado:");
        tree.inOrder();
        System.out.println("\n");

        // Leer texto
        InputStream inputStrText = Main.class.getClassLoader().getResourceAsStream("text.txt");
        if (inputStrText == null) {
            throw new RuntimeException("No se encontró text.txt en resources");
        }
        BufferedReader textReader = new BufferedReader(new InputStreamReader(inputStrText));


        String text = textReader.readLine();
        
        System.out.println(text);
        textReader.close();

        String[] words = text.split(" ");

        System.out.println("Traducción:");

        for (String word : words) {

            String cleanWord = word.toLowerCase().replaceAll("[^a-zA-Z]", "");

            Association<String, String> temp = new Association<>(cleanWord, "");
            Association<String, String> result = tree.search(temp);

            if (result != null) {
                System.out.print(result.getValue());
            } else {
                System.out.print("*" + word + "*");
            }

            System.out.print(" ");
        }
    }
}
