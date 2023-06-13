package ru.netology.avia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AviaSoulsTest {

    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator timeComparator = new TicketTimeComparator();

    Ticket ticket1 = new Ticket("Москва", "Минск", 13_000, 13_00, 14_00);
    Ticket ticket2 = new Ticket("Москва", "Минск", 12_000, 14_00, 15_00);
    Ticket ticket3 = new Ticket("Москва", "Минск", 14_000, 3_00, 4_00);
    Ticket ticket4 = new Ticket("Москва", "Минск", 9_000, 8_00, 10_00);
    Ticket ticket5 = new Ticket("Москва", "Минск", 3_000, 11_00, 15_00);
    Ticket ticket6 = new Ticket("Москва", "Минск", 17_000, 12_00, 14_30);

    @Test
    void compareToIfLess() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(-1, ticket2.compareTo(ticket3));
    }

    @Test
    void compareToIfMore() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(1, ticket4.compareTo(ticket1));
    }

    @Test
    void compareToIfSame() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(0, ticket1.compareTo(ticket5));
    }

    @Test
    public void testSearchSomeTickets() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Ticket[] expected = {ticket2, ticket1, ticket5, ticket3, ticket4};
        Ticket[] actual = aviaSouls.search("Saint-Petersburg", "Toronto");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchIf1Ticket() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Ticket[] expected = {ticket6};
        Ticket[] actual = aviaSouls.search("Moscow", "Paris");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchIfNoneTickets() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Moscow", "Milan");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testComparatorToIfLess() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(-1, timeComparator.compare(ticket2, ticket4));
    }

    @Test
    void testComparatorToIfMore() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(1, timeComparator.compare(ticket3, ticket5));
    }

    @Test
    void testComparatorToIfSame() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(0, timeComparator.compare(ticket1, ticket5));
    }

    @Test
    public void testSearchAndSortComparatorIfSomeTickets() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Ticket[] expected = {ticket1, ticket5, ticket2, ticket3, ticket4};
        Ticket[] actual = aviaSouls.searchAndSortBy("Saint-Petersburg", "Toronto", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortComparatorIf1Ticket() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Ticket[] expected = {ticket6};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moscow", "Paris", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortComparatorIfNoneTickets() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moscow", "Milan", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchFindAll() {

        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Ticket[] tickets = aviaSouls.findAll();
        Arrays.sort(tickets);

        Ticket[] expected = {ticket5, ticket4};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortComparatorFindAll() {

        aviaSouls.add(ticket3);
        aviaSouls.add(ticket5);
        Ticket[] tickets = aviaSouls.findAll();
        Arrays.sort(tickets, timeComparator);

        Ticket[] expected = {ticket5, ticket3};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}