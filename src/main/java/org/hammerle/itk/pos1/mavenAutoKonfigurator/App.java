package org.hammerle.itk.pos1.mavenAutoKonfigurator;

/**
 * @author Benjamin Hammerle
 * @version 10.10.2018
 */
public class App {

    public static void main(String[]args) {
        /**
         * Objekt von Interface AutoKonfigurator
         */
        AutoKonfigurator autoKonfigurator;


        autoKonfigurator = new Menue();
        autoKonfigurator.waehlePlattform();

    }
}
