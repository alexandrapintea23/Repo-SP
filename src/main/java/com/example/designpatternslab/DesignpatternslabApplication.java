
package com.example.designpatternslab;

import com.example.designpatternslab.model.AlignCenter;
import com.example.designpatternslab.model.AlignLeft;
import com.example.designpatternslab.model.AlignRight;
import com.example.designpatternslab.model.Author;
import com.example.designpatternslab.model.Book;
import com.example.designpatternslab.model.ImageProxy;
import com.example.designpatternslab.model.Paragraph;
import com.example.designpatternslab.model.Section;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignpatternslabApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                DesignpatternslabApplication.class, args
        );

        // =====================================
        // LAB 2 - PROXY
        // =====================================

        System.out.println("\n===== LAB 2 - PROXY =====");

        long startTime = System.currentTimeMillis();

        // Cream imaginile folosind Proxy
        ImageProxy img1 = new ImageProxy("Pamela Anderson");
        ImageProxy img2 = new ImageProxy("Kim Kardashian");
        ImageProxy img3 = new ImageProxy("Kirby Griffin");

        // Prima sectiune
        Section section1 = new Section("Front Cover");
        section1.add(img1);

        // A doua sectiune
        Section section2 = new Section("Summer Girls");
        section2.add(img2);
        section2.add(img3);

        // Adaugam sectiunile intr-o carte
        Book playboy = new Book("Playboy");
        playboy.addContent(section1);
        playboy.addContent(section2);

        long endTime = System.currentTimeMillis();

        System.out.println(
                "Creation of the content took " +
                        (endTime - startTime) + " milliseconds"
        );

        // Prima afisare a sectiunii 1
        startTime = System.currentTimeMillis();

        section1.print();

        endTime = System.currentTimeMillis();

        System.out.println(
                "Printing of section 1 took " +
                        (endTime - startTime) + " milliseconds"
        );

        // A doua afisare a sectiunii 1
        startTime = System.currentTimeMillis();

        section1.print();

        endTime = System.currentTimeMillis();

        System.out.println(
                "Printing again section 1 took " +
                        (endTime - startTime) + " milliseconds"
        );

        // =====================================
        // LAB 1 - BOOK / COMPOSITE
        // =====================================

        System.out.println("\n===== LAB 1 - BOOK =====");

        // Cream cartea
        Book noapteBuna = new Book("Noapte buna, copii!");

        // Adaugam autorul
        Author rpGheo = new Author("Radu Pavel Gheo");
        noapteBuna.addAuthor(rpGheo);

        // Cream capitolul si subcapitolele
        Section cap1 = new Section("Capitolul 1");
        Section cap11 = new Section("Capitolul 1.1");
        Section cap111 = new Section("Capitolul 1.1.1");
        Section cap1111 = new Section("Subchapter 1.1.1.1");

        // Paragraful introductiv
        noapteBuna.addContent(
                new Paragraph("Multumesc celor care ...")
        );

        // Adaugam primul capitol in carte
        noapteBuna.addContent(cap1);

        // Continutul capitolului 1
        cap1.add(
                new Paragraph("Moto capitol")
        );
        cap1.add(cap11);

        // Continutul subcapitolului 1.1
        cap11.add(
                new Paragraph("Text from subchapter 1.1")
        );
        cap11.add(cap111);

        // Continutul subcapitolului 1.1.1
        cap111.add(
                new Paragraph("Text from subchapter 1.1.1")
        );
        cap111.add(cap1111);

        // Imaginea din ultimul subcapitol
        cap1111.add(
                new ImageProxy("Image subchapter 1.1.1.1")
        );

        // Afisam cartea completa
        noapteBuna.print();

        // =====================================
        // TEMA LAB 1 - PAGINA 9
        // VERIFICAREA PARINTELUI
        // =====================================

        System.out.println(
                "\n===== TEST TEMA LAB 1 - PAGINA 9 ====="
        );

        // Cream doua sectiuni diferite
        Section primaSectiune = new Section("Sectiunea A");
        Section aDouaSectiune = new Section("Sectiunea B");

        // Cream un singur paragraf
        Paragraph paragrafComun = new Paragraph("Paragraf de test");

        // Il adaugam in prima sectiune
        primaSectiune.add(paragrafComun);

        System.out.println(
                "Paragraful a fost adaugat in Sectiunea A."
        );

        // Incercam sa il adaugam si in a doua sectiune
        try {

            aDouaSectiune.add(paragrafComun);

            System.out.println(
                    "EROARE: Paragraful a fost adaugat in doua sectiuni!"
            );

        } catch (IllegalStateException e) {

            System.out.println(
                    "TEST REUSIT: " + e.getMessage()
            );
        }

        // =====================================
        // TEST SUPLIMENTAR - REMOVE
        // =====================================

        System.out.println(
                "\n===== TEST REMOVE SI READAUGARE ====="
        );

        // Scoatem paragraful din prima sectiune
        primaSectiune.remove(paragrafComun);

        // Acum il putem adauga in a doua sectiune
        aDouaSectiune.add(paragrafComun);

        System.out.println(
                "TEST REUSIT: Paragraful a fost mutat in Sectiunea B."
        );

        aDouaSectiune.print();

        // =====================================
        // LAB 2 - STRATEGY
        // =====================================

        System.out.println("\n===== LAB 2 - STRATEGY =====");

        // Cream o sectiune noua pentru Strategy
        Section strategySection = new Section("Capitolul 1");

        // Cream patru paragrafe
        Paragraph p1 = new Paragraph("Paragraph 1");
        Paragraph p2 = new Paragraph("Paragraph 2");
        Paragraph p3 = new Paragraph("Paragraph 3");
        Paragraph p4 = new Paragraph("Paragraph 4");

        // Adaugam paragrafele in sectiune
        strategySection.add(p1);
        strategySection.add(p2);
        strategySection.add(p3);
        strategySection.add(p4);

        // Afisam paragrafele fara strategii
        System.out.println("\nPrinting without Alignment");
        System.out.println();

        strategySection.print();

        // Setam strategii diferite de aliniere
        p1.setAlignStrategy(new AlignCenter());
        p2.setAlignStrategy(new AlignRight());
        p3.setAlignStrategy(new AlignLeft());

        // Afisam paragrafele cu strategii
        System.out.println("\nPrinting with Alignment");
        System.out.println();

        strategySection.print();

        // =====================================
        // FINAL
        // =====================================

        System.out.println(
                "\n===== SFARSIT LAB 1, LAB 2 PROXY SI STRATEGY ====="
        );
    }
}
