/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleapps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class TestScore {

    List<Integer> scoreList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void retrieve() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("value of i: " + i);
        }
    }

    public void inputScores() {
        int nextScore = 0;
        do {
            System.out.print("Enter your scores (-1 exit): ");
            nextScore = scanner.nextInt();
            if (nextScore > -1) {
                scoreList.add(nextScore);
            }
        } while (nextScore > -1);

    }

    public int compare() {
        int smallest = scoreList.get(0);
        for (int i = 1; i < scoreList.size(); i++) {
            if (scoreList.get(i) < smallest) {
                smallest = scoreList.get(i);
            }
        }
        return smallest;
    }

    public void displayAll() {
        System.out.printf("%4s %8s\n", "No.", "Score");
        for (int i = 0; i < scoreList.size(); i++) {
            System.out.printf("%3d. %6d\n", (i + 1), scoreList.get(i));

        }
    }

    public void findaverage() {
        double average = 0.0;
        int total = 0;
        for (int i = 0; i < scoreList.size(); i++) {
            total += scoreList.get(i);
        }
        average = (total* 1.0) / scoreList.size() * 1.0;
        System.out.println("Total : " + total);
        System.out.println("Average : " + average);
    }

    public static void main(String[] args) {
        TestScore testscore = new TestScore();
        testscore.inputScores();
        testscore.displayAll();
        int small = testscore.compare();
        System.out.println("Smallest value: " + small);
        testscore.findaverage();
    }
}
