

package ru.netology.avia;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket("Стамбул", "Минск", 17_000, 12, 17);
        Ticket ticket2 = new Ticket("Москва", "Берлин", 23_000, 15, 18);
        Ticket ticket3 = new Ticket("Астана", "Сахалин", 52_000, 11, 16);
        Ticket ticket4 = new Ticket("Абу Даби", "Мумбаи", 9_000, 4, 5);
        Ticket ticket5 = new Ticket("Сингапур", "Бангкок", 13_000, 8, 10);

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets);
    }
}