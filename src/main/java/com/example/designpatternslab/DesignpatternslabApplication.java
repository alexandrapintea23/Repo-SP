
package com.example.designpatternslab;

import com.example.designpatternslab.model.AlignCenter;
import com.example.designpatternslab.model.AlignLeft;
import com.example.designpatternslab.model.AlignRight;
import com.example.designpatternslab.model.Author;
import com.example.designpatternslab.model.Book;
import com.example.designpatternslab.model.Image;
import com.example.designpatternslab.model.ImageProxy;
import com.example.designpatternslab.model.Paragraph;
import com.example.designpatternslab.model.Section;
import com.example.designpatternslab.model.Table;

import com.example.designpatternslab.visitor.BookStatistics;
import com.example.designpatternslab.visitor.GenerateToC;
import com.example.designpatternslab.visitor.RenderContentVisitor;

import com.example.designpatternslab.difexamples.ClientComponent;
import com.example.designpatternslab.difexamples.SingletonComponent;
import com.example.designpatternslab.difexamples.TransientComponent;

import com.example.designpatternslab.repository.SectionRepository;
import com.example.designpatternslab.repository.AuthorRepository;
import com.example.designpatternslab.repository.BookRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DesignpatternslabApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(
                DesignpatternslabApplication.class, args
        );

        // =====================================
        // LAB 2 - PROXY
        // =====================================

        System.out.println("\n===== LAB 2 - PROXY =====");

        long startTime = System.currentTimeMillis();

        ImageProxy img1 = new ImageProxy("Pamela Anderson");
        ImageProxy img2 = new ImageProxy("Kim Kardashian");
        ImageProxy img3 = new ImageProxy("Kirby Griffin");

        Section section1 = new Section("Front Cover");
        section1.add(img1);

        Section section2 = new Section("Summer Girls");
        section2.add(img2);
        section2.add(img3);

        Book playboy = new Book("Playboy");
        playboy.addContent(section1);
        playboy.addContent(section2);

        long endTime = System.currentTimeMillis();

        System.out.println(
                "Creation of the content took " +
                        (endTime - startTime) + " milliseconds"
        );

        startTime = System.currentTimeMillis();
        section1.print();
        endTime = System.currentTimeMillis();

        System.out.println(
                "Printing of section 1 took " +
                        (endTime - startTime) + " milliseconds"
        );

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

        Book noapteBuna = new Book("Noapte buna, copii!");

        Author rpGheo = new Author("Radu Pavel Gheo");
        noapteBuna.addAuthor(rpGheo);

        Section cap1 = new Section("Capitolul 1");
        Section cap11 = new Section("Capitolul 1.1");
        Section cap111 = new Section("Capitolul 1.1.1");
        Section cap1111 = new Section("Subchapter 1.1.1.1");

        noapteBuna.addContent(
                new Paragraph("Multumesc celor care ...")
        );

        noapteBuna.addContent(cap1);

        cap1.add(new Paragraph("Moto capitol"));
        cap1.add(cap11);

        cap11.add(new Paragraph("Text from subchapter 1.1"));
        cap11.add(cap111);

        cap111.add(new Paragraph("Text from subchapter 1.1.1"));
        cap111.add(cap1111);

        cap1111.add(
                new ImageProxy("Image subchapter 1.1.1.1")
        );

        noapteBuna.print();

        // =====================================
        // TEMA LAB 1 - VERIFICAREA PARINTELUI
        // =====================================

        System.out.println(
                "\n===== TEST TEMA LAB 1 - PAGINA 9 ====="
        );

        Section primaSectiune = new Section("Sectiunea A");
        Section aDouaSectiune = new Section("Sectiunea B");

        Paragraph paragrafComun =
                new Paragraph("Paragraf de test");

        primaSectiune.add(paragrafComun);

        System.out.println(
                "Paragraful a fost adaugat in Sectiunea A."
        );

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
        // TEST REMOVE SI READAUGARE
        // =====================================

        System.out.println(
                "\n===== TEST REMOVE SI READAUGARE ====="
        );

        primaSectiune.remove(paragrafComun);
        aDouaSectiune.add(paragrafComun);

        System.out.println(
                "TEST REUSIT: Paragraful a fost mutat in Sectiunea B."
        );

        aDouaSectiune.print();

        // =====================================
        // LAB 2 - STRATEGY
        // =====================================

        System.out.println("\n===== LAB 2 - STRATEGY =====");

        Section strategySection = new Section("Capitolul 1");

        Paragraph p1 = new Paragraph("Paragraph 1");
        Paragraph p2 = new Paragraph("Paragraph 2");
        Paragraph p3 = new Paragraph("Paragraph 3");
        Paragraph p4 = new Paragraph("Paragraph 4");

        strategySection.add(p1);
        strategySection.add(p2);
        strategySection.add(p3);
        strategySection.add(p4);

        System.out.println("\nPrinting without Alignment");
        System.out.println();

        strategySection.print();

        p1.setAlignStrategy(new AlignCenter());
        p2.setAlignStrategy(new AlignRight());
        p3.setAlignStrategy(new AlignLeft());

        System.out.println("\nPrinting with Alignment");
        System.out.println();

        strategySection.print();

        // =====================================
        // LAB 3 - VISITOR
        // =====================================

        System.out.println("\n===== LAB 3 - VISITOR =====");

        System.out.println("\n===== RENDER CONTENT VISITOR =====");

        Section renderSection =
                new Section("Capitol pentru Visitor");

        renderSection.add(
                new Paragraph("Primul paragraf")
        );

        renderSection.add(
                new Paragraph("Al doilea paragraf")
        );

        renderSection.add(
                new Table("Tabel de exemplu")
        );

        RenderContentVisitor renderVisitor =
                new RenderContentVisitor();

        renderSection.accept(renderVisitor);

        // =====================================
        // LAB 3 - BOOK STATISTICS
        // =====================================

        System.out.println(
                "\n===== LAB 3 - BOOK STATISTICS ====="
        );

        Section statisticsSection =
                new Section("Capitolul 1");

        statisticsSection.add(new Paragraph("Paragraph 1"));
        statisticsSection.add(new Paragraph("Paragraph 2"));
        statisticsSection.add(new Paragraph("Paragraph 3"));
        statisticsSection.add(new Paragraph("Paragraph 4"));

        statisticsSection.add(
                new ImageProxy("ImageOne")
        );

        statisticsSection.add(
                new Image("ImageTwo")
        );

        statisticsSection.add(
                new Paragraph("Some text")
        );

        statisticsSection.add(
                new Table("Table 1")
        );

        BookStatistics stats = new BookStatistics();

        statisticsSection.accept(stats);
        stats.printStatistics();

        // =====================================
        // LAB 3 - GENERATE TABLE OF CONTENTS
        // =====================================

        System.out.println(
                "\n===== LAB 3 - GENERATE TOC ====="
        );

        GenerateToC tocVisitor = new GenerateToC();
        noapteBuna.accept(tocVisitor);

        // =====================================
        // LAB 3 - TEST VISITOR + PROXY
        // =====================================

        ImageProxy visitorImage =
                new ImageProxy("Visitor Test Image");

        long visitorStart = System.currentTimeMillis();

        visitorImage.accept(new RenderContentVisitor());

        long visitorEnd = System.currentTimeMillis();

        System.out.println(
                "Prima afisare prin Visitor: " +
                        (visitorEnd - visitorStart) + " ms"
        );

        visitorStart = System.currentTimeMillis();

        visitorImage.accept(new RenderContentVisitor());

        visitorEnd = System.currentTimeMillis();

        System.out.println(
                "A doua afisare prin Visitor: " +
                        (visitorEnd - visitorStart) + " ms"
        );

        System.out.println(
                "\n===== SFARSIT LAB 1, LAB 2 SI LAB 3 ====="
        );

        // =====================================
        // LAB 4 - DEPENDENCY INJECTION
        // =====================================

        System.out.println(
                "\n===== LAB 4 - DEPENDENCY INJECTION ====="
        );

        // =====================================
        // TEST TRANSIENT COMPONENT - PROTOTYPE
        // =====================================

        System.out.println(
                "\n--- TEST TRANSIENT COMPONENT ---"
        );

        TransientComponent transientBean1 =
                context.getBean(TransientComponent.class);

        transientBean1.operation();

        TransientComponent transientBean2 =
                context.getBean(TransientComponent.class);

        transientBean2.operation();

        System.out.println(
                "Transient - aceeasi instanta? " +
                        (transientBean1 == transientBean2)
        );

        // =====================================
        // TEST SINGLETON COMPONENT
        // =====================================

        System.out.println(
                "\n--- TEST SINGLETON COMPONENT ---"
        );

        SingletonComponent singletonBean1 =
                context.getBean(SingletonComponent.class);

        singletonBean1.operation();

        SingletonComponent singletonBean2 =
                context.getBean(SingletonComponent.class);

        singletonBean2.operation();

        System.out.println(
                "Singleton - aceeasi instanta? " +
                        (singletonBean1 == singletonBean2)
        );

        // =====================================
        // TEST CLIENT COMPONENT
        // =====================================

        System.out.println(
                "\n--- TEST CLIENT COMPONENT ---"
        );

        ClientComponent client1 =
                context.getBean(ClientComponent.class);

        client1.operation();

        ClientComponent client2 =
                (ClientComponent) context.getBean("clientComponent");

        client2.operation();

        System.out.println(
                "Client - aceeasi instanta? " +
                        (client1 == client2)
        );

        System.out.println(
                "\n===== SFARSIT LAB 4 - TEST DI ====="
        );

        // =====================================
        // LAB 5-6 - TEST SPRING DATA JPA
        // =====================================

        System.out.println(
                "\n===== LAB 5-6 - TEST JPA ====="
        );

        SectionRepository sectionRepository =
                context.getBean(SectionRepository.class);

        Section sectiuneJPA =
                new Section("Sectiune salvata in H2");

        sectiuneJPA.add(
                new Paragraph("Paragraf salvat prin Spring Data JPA")
        );

        Section sectiuneSalvata =
                sectionRepository.save(sectiuneJPA);

        System.out.println(
                "TEST JPA REUSIT! ID sectiune: " +
                        sectiuneSalvata.getId()
        );

        // =====================================
        // LAB 5-6 - TEST MANY TO MANY
        // =====================================

        System.out.println(
                "\n===== LAB 5-6 - TEST MANY TO MANY ====="
        );

        AuthorRepository authorRepository =
                context.getBean(AuthorRepository.class);

        BookRepository bookRepository =
                context.getBean(BookRepository.class);

        Author autor1 = new Author("Autor Test 1");
        Author autor2 = new Author("Autor Test 2");

        // Salvam mai intai autorii in H2
        authorRepository.save(autor1);
        authorRepository.save(autor2);

        // Cream o carte cu doi autori
        Book carteJPA = new Book("Carte cu doi autori");

        carteJPA.addAuthor(autor1);
        carteJPA.addAuthor(autor2);

        // Salvam cartea si asocierea ManyToMany
        Book carteSalvata = bookRepository.save(carteJPA);

        System.out.println(
                "TEST MANY TO MANY REUSIT! ID carte: " +
                        carteSalvata.getId()
        );
    }
}
