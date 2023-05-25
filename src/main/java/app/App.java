package app;

import java.util.Scanner;

import lib.parse.BookParser;
import lib.parse.DOIParser;
import lib.parse.Parser;
import lib.publication.Publication;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to QuickCite!");
        System.out.println("This tool was created by Kyle Huang (@brokenfloppydisk), Zachary Miller (@londonwafflez), and Berfredd Quezon (@bbq27).");

        boolean finished = false;

        while (!finished) {

            System.out.print("Enter an ISBN or DOI number to cite: ");

            Parser parser = null;

            while (parser == null || !parser.isValid()) {
                String input = scanner.nextLine();
                parser = new BookParser(input);
                if (!parser.isValid()) {
                    parser = new DOIParser(input);
                }

                if (!parser.isValid()) {
                    System.out.print("An invalid ISBN or DOI was provided.\nEnter an ISBN or DOI number to cite: ");
                }
            }

            System.out.println("Collecting data from the internet...");

            Publication publication = parser.toPublication();

            System.out.print("Select an (A)PA citation, an (M)LA citation, or (B)oth: ");

            boolean valid = false;
            while (!valid) {
                String input = scanner.nextLine();
                switch (input.charAt(0)) {
                    case 'A':
                    case 'a':
                        System.out.println(publication.toAPA());
                        valid = true;
                        break;
                    case 'B':
                    case 'b':
                        System.out.println("APA:\n" + publication.toAPA());
                        System.out.println("MLA:\n" + publication.toMLA());
                        valid = true;
                        break;
                    case 'M':
                    case 'm':
                        System.out.println(publication.toMLA());
                        valid = true;
                        break;
                    default:
                        System.out.print("Invalid input. Please try again.\nSelect an (A)PA citation, an (M)LA citation, or (B)oth: ");
                }
            }

            System.out.println("Would you like to go again? (Y/N): ");

            valid = false;
            while (!valid) {
                String input = scanner.nextLine();
                switch (input.charAt(0)) {
                    case 'Y':
                    case 'y':
                        valid = true;
                        break;
                    case 'n':
                    case 'N':
                        valid = true;
                        scanner.close();
                        System.out.println("Thank you for using QuickCite!");
                        System.exit(0);
                        return;
                    default:
                        valid = false;
                        System.out.println("Invalid input. Please try again.");
                }
            }

        }

        scanner.close();
    }
}