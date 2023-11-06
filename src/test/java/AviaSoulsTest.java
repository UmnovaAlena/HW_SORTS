import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void testSortFiveTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "KUF", 500, 7, 8);//500
        Ticket ticket2 = new Ticket("MSK", "SPB", 600, 17, 18);
        Ticket ticket3 = new Ticket("MSK", "KUF", 300, 8, 10);//300
        Ticket ticket4 = new Ticket("MSK", "KUF", 200, 4, 9);//200
        Ticket ticket5 = new Ticket("SPB", "KUF", 300, 6, 16);
        Ticket ticket6 = new Ticket("MSK", "SPB", 100, 1, 2);
        Ticket ticket7 = new Ticket("MSK", "KUF", 100, 10, 13);//100
        Ticket ticket8 = new Ticket("MSK", "UFA", 500, 9, 12);
        Ticket ticket9 = new Ticket("MSK", "KUF", 200, 5, 8);//200
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = {ticket7, ticket4, ticket9, ticket3, ticket1};
        Ticket[] actual = manager.search("MSK", "KUF");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "KUF", 500, 7, 8);//500
        Ticket ticket2 = new Ticket("MSK", "SPB", 600, 17, 18);
        Ticket ticket3 = new Ticket("MSK", "KUF", 300, 8, 10);//300
        Ticket ticket4 = new Ticket("MSK", "KUF", 200, 4, 9);//200
        Ticket ticket5 = new Ticket("SPB", "KUF", 300, 6, 16);
        Ticket ticket6 = new Ticket("MSK", "SPB", 100, 1, 2);
        Ticket ticket7 = new Ticket("MSK", "KUF", 100, 10, 13);//100
        Ticket ticket8 = new Ticket("MSK", "UFA", 500, 9, 12);
        Ticket ticket9 = new Ticket("MSK", "KUF", 200, 5, 8);//200
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = {ticket8};
        Ticket[] actual = manager.search("MSK", "UFA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortZeroTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "KUF", 500, 7, 8);//500
        Ticket ticket2 = new Ticket("MSK", "SPB", 600, 17, 18);
        Ticket ticket3 = new Ticket("MSK", "KUF", 300, 8, 10);//300
        Ticket ticket4 = new Ticket("MSK", "KUF", 200, 4, 9);//200
        Ticket ticket5 = new Ticket("SPB", "KUF", 300, 6, 16);
        Ticket ticket6 = new Ticket("MSK", "SPB", 100, 1, 2);
        Ticket ticket7 = new Ticket("MSK", "KUF", 100, 10, 13);//100
        Ticket ticket8 = new Ticket("MSK", "UFA", 500, 9, 12);
        Ticket ticket9 = new Ticket("MSK", "KUF", 200, 5, 8);//200
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("NEW", "LA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortFiveTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "KUF", 500, 7, 8);//1
        Ticket ticket2 = new Ticket("MSK", "SPB", 600, 17, 18);
        Ticket ticket3 = new Ticket("MSK", "KUF", 300, 8, 10);//2
        Ticket ticket4 = new Ticket("MSK", "KUF", 200, 4, 9);//5
        Ticket ticket5 = new Ticket("SPB", "KUF", 300, 6, 16);
        Ticket ticket6 = new Ticket("MSK", "SPB", 100, 1, 2);
        Ticket ticket7 = new Ticket("MSK", "KUF", 100, 10, 13);//3
        Ticket ticket8 = new Ticket("MSK", "UFA", 500, 9, 12);
        Ticket ticket9 = new Ticket("MSK", "KUF", 200, 5, 8);//3
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket3, ticket7, ticket9, ticket4};
        Ticket[] actual = manager.searchAndSortBy("MSK", "KUF", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTicketWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "KUF", 500, 7, 8);//1
        Ticket ticket2 = new Ticket("MSK", "SPB", 600, 17, 18);
        Ticket ticket3 = new Ticket("MSK", "KUF", 300, 8, 10);//2
        Ticket ticket4 = new Ticket("MSK", "KUF", 200, 4, 9);//5
        Ticket ticket5 = new Ticket("SPB", "KUF", 300, 6, 16);
        Ticket ticket6 = new Ticket("MSK", "SPB", 100, 1, 2);
        Ticket ticket7 = new Ticket("MSK", "KUF", 100, 10, 13);//3
        Ticket ticket8 = new Ticket("MSK", "UFA", 500, 9, 12);
        Ticket ticket9 = new Ticket("MSK", "KUF", 200, 5, 8);//3
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.searchAndSortBy("SPB", "KUF", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortZeroTicketWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "KUF", 500, 7, 8);//1
        Ticket ticket2 = new Ticket("MSK", "SPB", 600, 17, 18);
        Ticket ticket3 = new Ticket("MSK", "KUF", 300, 8, 10);//2
        Ticket ticket4 = new Ticket("MSK", "KUF", 200, 4, 9);//5
        Ticket ticket5 = new Ticket("SPB", "KUF", 300, 6, 16);
        Ticket ticket6 = new Ticket("MSK", "SPB", 100, 1, 2);
        Ticket ticket7 = new Ticket("MSK", "KUF", 100, 10, 13);//3
        Ticket ticket8 = new Ticket("MSK", "UFA", 500, 9, 12);
        Ticket ticket9 = new Ticket("MSK", "KUF", 200, 5, 8);//3
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("SPB", "UFA", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}
