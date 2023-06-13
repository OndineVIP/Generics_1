package ru.netology.avia;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSouls {

    private ru.netology.avia.Ticket[] tickets = new ru.netology.avia.Ticket[0];

    /**
     * Вспомогательный метод для имитации добавления элемента в массив
     *
     * @param current Массив, в который мы хотим добавить элемент
     * @param ticket  Элемент, который мы хотим добавить
     * @return Возвращает новый массив, который выглядит как тот что мы передали,
     * но с добавлением нового элемента в конец
     */
    private ru.netology.avia.Ticket[] addToArray(ru.netology.avia.Ticket[] current, ru.netology.avia.Ticket ticket) {
        ru.netology.avia.Ticket[] tmp = new ru.netology.avia.Ticket[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = ticket;
        return tmp;
    }

    /**
     * Метод добавления билета в менеджер
     *
     * @param ticket Добавляемый билет
     */
    public void add(ru.netology.avia.Ticket ticket) {
        tickets = addToArray(tickets, ticket);
    }

    public ru.netology.avia.Ticket[] findAll() {
        return tickets;
    }

    /**
     * Метод поиска билетов по маршруту
     *
     * @param from Откуда вылетаем
     * @param to   Куда прилетаем
     * @return Массив из подходящих билетов
     */
    public ru.netology.avia.Ticket[] search(String from, String to) {
        ru.netology.avia.Ticket[] result = new ru.netology.avia.Ticket[0]; // массив для ответа
        for (ru.netology.avia.Ticket ticket : tickets) { // перебираем все билеты
            if (ticket.getFrom().equals(from)) { // совпадает аэропорт вылета
                if (ticket.getTo().equals(to)) { // совпадает аэропорт прилёта
                    result = addToArray(result, ticket); // добавляем его в массив ответа
                }
            }
        }
        Arrays.sort(result);
        return result;
    }

    public ru.netology.avia.Ticket[] searchAndSortBy(String from, String to, Comparator<ru.netology.avia.Ticket> comparator) {
        ru.netology.avia.Ticket[] result = new ru.netology.avia.Ticket[0]; // массив для ответа
        for (ru.netology.avia.Ticket ticket : tickets) { // перебираем все билеты
            if (ticket.getFrom().equals(from)) { // совпадает аэропорт вылета
                if (ticket.getTo().equals(to)) { // совпадает аэропорт прилёта
                    result = addToArray(result, ticket); // добавляем его в массив ответа
                }
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }
}