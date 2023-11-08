package org.example;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer un mot : ");
        String word = scanner.nextLine().toLowerCase();

        // check if word only contains letters
        if (!word.matches("[a-z]+")) {
            System.out.println("Le mot ne doit contenir que des lettres");
            return;
        }

        System.out.println("Entrer le nombre d'erreur max : ");
        int maxError = scanner.nextInt();

        StringBuilder findWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            findWord.append("*");
        }

        String triedLetters = "";

        int nbError = 0;

        while (nbError < maxError) {

            System.out.println("Mot à trouver : " + findWord);
            System.out.println("Lettres essayées : " + triedLetters);
            System.out.println("Nombre d'erreur restantes : " + (maxError - nbError));
            System.out.println("Entrer une lettre : ");
            do {
                scanner.nextLine();
                System.out.println("Entrer une lettre : ");
            } while (!scanner.hasNext("[a-z]"));
            String letter = scanner.nextLine().toLowerCase();
            if (triedLetters.contains(letter) || word.contains(letter)) {
                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(j) == letter.charAt(0)) {
                        findWord.setCharAt(j, letter.charAt(0));
                    }
                }
                if (findWord.toString().equals(word)) {
                    System.out.println("Vous avez gagné !");
                    break;
                }
            } else {
                System.out.println(letter + " n'est pas dans le mot");
                triedLetters += letter;
                nbError++;
            }
        }
    }
}
