import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.DataInputStream;

public class App{
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        // Auxiliar variable 
        Boolean auxAnswer = false;

        //Class Event
        Event event = new Event();
        Scanner input = new Scanner (System.in);

        System.out.printf("\n-------------GERADOR DE CERTIFICADO-------------\n");

        System.out.printf("\nTítulo do evento: ");
        event.setNameEvent(input.nextLine());
        
        try{
            // Checks if there are any event events already registered with the same name
            FileInputStream fileRead = new FileInputStream("./events/"+event.getNameEvent()+".dat");
            DataInputStream searchEvent = new DataInputStream(fileRead);
            
            // Read the contents and save in a variable
            String arquivo = searchEvent.readUTF();
            String cidade = searchEvent.readUTF();
            String uf = searchEvent.readUTF();
            
            // Asks for a confirmation
                System.out.printf("\nO evento '%s' já está registrado no sistema, foi realizado na cidade %s- %s",arquivo, cidade, uf.toUpperCase());
            do{    
                System.out.printf("\nEra esse o evento que estava procurando? (sim/nao): ");
                String answer = input.nextLine();

                if (answer == "sim"){
                    auxAnswer = true;
                }else if(answer == "nao"){
                    auxAnswer = true;
                    // Force an error, to enter the catch
                    FileInputStream forceErro = new FileInputStream("./events/forceErro.dat");
                }else if (answer != "nao" || answer != "sim"){
                    System.out.printf("\nOpção inválida, digite sim ou não\n");
                }
            }while(auxAnswer);
            searchEvent.close();

        }catch(FileNotFoundException varException){
            // Ask and Add event information
            System.out.printf("\nEsse evento ainda não foi cadastrado, abaixo digite as informações do evento:\n");
            new Thread().sleep(2000);
            System.out.printf(".");
            new Thread().sleep(1000);
            System.out.printf("\n.");
            new Thread().sleep(1000);
            System.out.printf("\n.");
            new Thread().sleep(1000);

            // Save event in file bynare
            FileOutputStream file = new FileOutputStream("./events/"+event.getNameEvent()+".dat");
            DataOutputStream saveEvent = new DataOutputStream(file);
            saveEvent.writeUTF(event.getNameEvent()); 

            System.out.printf("\nCidade de realização: ");
            event.setCity(input.nextLine());
            saveEvent.writeUTF(event.getCity());
    
            System.out.printf("\nUf: ");
            event.setUf(input.nextLine());
            saveEvent.writeUTF(event.getUf());
    
            System.out.printf("\nData de início: ");
            event.setDateInitial(input.nextLine());
            saveEvent.writeUTF(event.getDateInitial());
    
            System.out.printf("\nData de termino: ");
            event.setDateEnd(input.nextLine());
            saveEvent.writeUTF(event.getDateEnd());
    
            System.out.printf("\nResponsável pelo evento: ");
            event.setNameResponsible(input.nextLine());
            saveEvent.writeUTF(event.getNameResponsible());
    
            System.out.printf("\nCarga horária: ");
            event.setWorkload(input.nextInt());
            saveEvent.writeInt(event.getWorkload());
            
            file.close();
        }
        
        //Class People
        People people = new People();
        Scanner input2 = new Scanner (System.in);
        
        System.out.printf("\nNome:");
        people.setName(input2.nextLine());

        try{
            //checks if there are any people already registered with the same name
            FileInputStream fileRead = new FileInputStream("./peoples/"+people.getName()+".dat");
            DataInputStream searchPeople = new DataInputStream(fileRead);
            String name = searchPeople.readUTF();
            String cpf = searchPeople.readUTF();
            String email = searchPeople.readUTF();
            
            System.out.printf("\nEcontramos ' %s ' registrado no sistema\ncom email %s", name,email);
            System.out.printf("\nEra essa pessoa que procurava?\n");
            searchPeople.close();
        }catch(FileNotFoundException varException){
            // Save people in file binary
            FileOutputStream file = new FileOutputStream("./peoples/"+people.getName()+".dat");
            DataOutputStream savePeople = new DataOutputStream(file);
            savePeople.writeUTF(people.getName());

            System.out.printf("\nCpf: ");
            people.setCpf(input2.nextLong());
            savePeople.writeLong(people.getCpf());

            System.out.printf("\nEmail: ");
            people.setEmail(input2.next());
            savePeople.writeUTF(people.getEmail());

            savePeople.close();
        }    

        System.out.printf("Informações obtidas com sucesso, deseja emitir o certificado? (sim/nao)");

        input.close();
        input2.close();
    }
}