import java.util.Scanner;
import java.util.Date;


public class App{
    private static Scanner input;
    public static void main(String[] args) {

        //Class Event
        Event event = new Event();
        input = new Scanner (System.in);

        System.out.printf("\nTítulo do evento: ");
        event.setNameEvent(input.nextLine());

        System.out.printf("\nCidade de realização: ");
        event.setCity(input.nextLine());

        System.out.printf("\nUf: ");
        event.setUf(input.nextLine());

        System.out.printf("\nData de início: ");
        event.setDateInitial(input.nextLine());

        System.out.printf("\nData de termino: ");
        event.setDateEnd(input.nextLine());
        
        System.out.printf("\nCarga horária: ");
        event.setWorkload(input.nextInt());
        
        //Class People
        People people = new People();
        Scanner input2 = new Scanner (System.in);
        
        System.out.printf("\nNome: ");
        people.setName(input2.nextLine());

        System.out.printf("\nCpf: ");
        people.setCpf(input2.nextLong());

        System.out.printf("\nEmail: ");
        people.setEmail(input2.next());       

        input.close();
        input2.close();
    }
}