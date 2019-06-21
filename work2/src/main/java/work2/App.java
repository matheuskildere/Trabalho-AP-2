package work2;

import java.util.Scanner;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.DataInputStream;

public class App {
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        // Auxiliar variable
        Boolean auxAnswer = false;

        // Class Event
        Event event = new Event();
        Scanner input = new Scanner(System.in);

        System.out.printf("\n------------------GERADOR DE CERTIFICADO------------------\n");
        System.out.printf("\n-------INFORMAÇÕES DO EVENTO\n");

        System.out.printf("\nTítulo do evento: ");
        event.setNameEvent(input.nextLine());

        try {
            // Checks if there are any event events already registered with the same name
            FileInputStream fileRead = new FileInputStream("./events/" + event.getNameEvent() + ".dat");
            DataInputStream searchEvent = new DataInputStream(fileRead);

            // Read the contents and save in a variable
            String arquivo = searchEvent.readUTF();
            String cidade = searchEvent.readUTF();
            String uf = searchEvent.readUTF();

            // Asks for a confirmation
            System.out.printf("\nO evento '%s' já está registrado no sistema,\nfoi realizado na cidade %s- %s\n",
                    arquivo, cidade, uf.toUpperCase());
            do {
                System.out.printf("\nEra esse o evento que estava procurando? (sim/nao): ");
                String answer = input.nextLine().toLowerCase();

                if (answer.equals("sim")) {
                    auxAnswer = true;
                }
                if (answer.equals("nao")) {
                    auxAnswer = true;
                    // Force an error, to enter the catch
                    FileInputStream forceErro = new FileInputStream("./events/forceErro.dat");
                    forceErro.close();
                }
                if (!answer.equals("sim") && !answer.equals("nao")) {
                    System.out.printf("\nOpção inválida, digite sim ou nao\n");
                }
            } while (auxAnswer == false);
            searchEvent.close();

        } catch (FileNotFoundException varException) {
            // Ask and Add event information
            System.out.printf("\nAbaixo digite as informações do evento:\n");
            new Thread().sleep(1000);
            System.out.printf(".");
            new Thread().sleep(1000);
            System.out.printf("\n.");
            new Thread().sleep(1000);
            System.out.printf("\n.");
            new Thread().sleep(1000);

            // Save event in file bynare
            FileOutputStream file = new FileOutputStream("./events/" + event.getNameEvent() + ".dat");
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
        System.out.printf("\n------INFORMAÇÕES DO PARTICIPANTE\n");

        // Class Peopleemail
        People people = new People();
        Scanner input2 = new Scanner(System.in);

        System.out.printf("\nNome: ");
        people.setName(input2.nextLine());

        try {
            // checks if there are any people already registered with the same name
            FileInputStream filepRead = new FileInputStream("./peoples/" + people.getName() + ".dat");
            DataInputStream searchPeople = new DataInputStream(filepRead);
            String name = searchPeople.readUTF();
            String email = searchPeople.readUTF();

            System.out.printf("\nEcontramos ' %s ' registrado no sistema\ncom email %s\n", name, email);
            auxAnswer = false;
            do {
                System.out.printf("\nEsse era o participante que procurava? (sim/nao): ");
                String answer = input.nextLine().toLowerCase();

                if (answer.equals("sim")) {
                    auxAnswer = true;
                }
                if (answer.equals("nao")) {
                    auxAnswer = true;
                    // Force an error, to enter the catch
                    FileInputStream forceErro = new FileInputStream("./peoples/forceErro.dat");
                    forceErro.close();
                }
                if (!answer.equals("sim") && !answer.equals("nao")) {
                    System.out.printf("\nOpção inválida, digite sim ou nao\n");
                }
            } while (auxAnswer == false);
            searchPeople.close();
        } catch (FileNotFoundException varException) {
            // Ask and Add people information
            System.out.printf("\nAbaixo digite as informações da pessoa:\n");
            new Thread().sleep(1000);
            System.out.printf(".");
            new Thread().sleep(1000);
            System.out.printf("\n.");
            new Thread().sleep(1000);
            System.out.printf("\n.");
            new Thread().sleep(1000);

            // Save people in file binary
            FileOutputStream filePeople = new FileOutputStream("./peoples/" + people.getName() + ".dat");
            DataOutputStream savePeople = new DataOutputStream(filePeople);
            savePeople.writeUTF(people.getName());

            System.out.printf("\nEmail: ");
            people.setEmail(input2.nextLine());
            savePeople.writeUTF(people.getEmail());

            System.out.printf("\nCpf: ");
            people.setCpf(input2.nextLong());
            savePeople.writeLong(people.getCpf());
            savePeople.writeLong(people.getCpf());

            savePeople.close();
        }

        System.out.printf("\n------CONFIRMAÇÃO DO CERTIFICADO\n");
        // Help whith do/while
        auxAnswer = false;
        do {
            System.out.printf("\nInformações obtidas com sucesso,\ndeseja emitir o certificado? (sim/nao): ");
            String answer = input.nextLine().toLowerCase();

            if (answer.equals("sim")) {
                Certified certified = new Certified();
                // Time for send e-mail
                System.out.printf("\nEmitindo certificado");
                new Thread().sleep(1000);
                System.out.printf("\n.");

                // Read people files to e-mail and save in a variable
                FileInputStream filepRead = new FileInputStream("./peoples/" + people.getName() + ".dat");
                DataInputStream searchPeople = new DataInputStream(filepRead);
                String nameFile = searchPeople.readUTF();
                String emailFile = searchPeople.readUTF();

                // Read event files to e-mail and save in a variable
                FileInputStream fileRead = new FileInputStream("./events/" + event.getNameEvent() + ".dat");
                DataInputStream searchEvent = new DataInputStream(fileRead);
                String nameEventFile = searchEvent.readUTF();
                String cityFile = searchEvent.readUTF();
                String ufFile = searchEvent.readUTF();
                String dateInitialFile = searchEvent.readUTF();
                String dateEndFile = searchEvent.readUTF();
                String nameResponsibleFile = searchEvent.readUTF();
                int workloadFile = searchEvent.readInt();
                searchEvent.close();
                searchPeople.close();
                
                // Creat the certified HTML
                PrintWriter contentHtml = new PrintWriter(new File("./certifieds/"+nameFile.replace(" ", "")+".html") );
                contentHtml.write("<!DOCTYPE html><html><head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'><meta http-equiv='X-UA-Compatible' content='ie=edge'><title>Certificado</title></head><body><style>*{margin: 0;padding: 0;font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;}#container {background-image: url('background1.jpg');width:100%;height:100%;position: absolute;background-position: 55%;filter: blur(50px);}        #header {        width: 100%;        height: 10%;            position: relative;        background-color: rgba(44, 62, 71, 0.1);        text-align: center;        font-size: 25px;        line-height: 225%;     top:0;}#paper {width: 100%;height: 80%;position: relative;text-align: center;font-size: 25px;line-height: 50px;}#footer {width: 100%;height: 10%;position: absolute;background-color: rgba(1, 37, 54, 0.2);text-align: right;font-size: 85%;line-height: 150%;clear:both;bottom:0;text-decoration: none;}</style><div id = 'container'></div><div id = 'header' >Certificado</div><div id = 'paper' ><br /><br /><br /><br />Certificamos que <b>"+nameFile+"</b>,<br /> participou do evento <b>"+nameEventFile+"</b>, <br />realizado em <b> "+cityFile+" / "+ufFile.toUpperCase()+" </b>,<br /> de <b>"+dateInitialFile+"</b> a <b>"+dateEndFile+"</b>, totalizando uma carga horária de <b>"+workloadFile+"</b> horas.</div><div id = 'footer'>"+cityFile+" / "+ufFile.toUpperCase()+", "+certified.getDateTime()+" <br /> "+nameResponsibleFile+" <br />certified.getCodeUnit() <br /> </div></div></body></html>");
                contentHtml.flush();
                contentHtml.close();
                // Creat the e-mail on HTML and send
                String emailInstitution = "geradordecertificado94@gmail.com";
                String passwordEmail = "geradordecertificado1";
                SimpleEmail email = new SimpleEmail();
                email.setHostName("smtp.gmail.com");
                email.setSmtpPort(465);
                email.setAuthenticator(new DefaultAuthenticator(emailInstitution, passwordEmail));
                email.setSSLOnConnect(true);
                try {
                    email.setFrom(emailInstitution);
                    // E-mail subject
                    email.setSubject("CERTIFICADO DO EVENTO " + nameEventFile.toUpperCase());
                    email.setMsg("Olá " + nameFile
                            + ".\nSegue abaixo o link para acessar o seu certificado onde consta sua partipação no evento "+nameEventFile+ ".\nLink para acesso: https://matheuskildere.github.io/Trabalho-AP-2/certifieds/"+nameFile.replace(" ", "")+".html");
                            
                    // People e-mail
                    email.addTo(emailFile);
                    email.send();

                    System.out.printf("\n.");
                    new Thread().sleep(1000);
                    System.out.printf("\n.");
                    new Thread().sleep(1000);
                    System.out.printf("\nCertificado emitido em %s\n", certified.getDateTime());
                    
                } catch (Exception e) {
                    // Catch mensage
                    System.out.print(
                            "Erro no dominio do email ou na sua conexão.\nPor favor, realize o processo novamente!");
                }
                // Leave do/while
                auxAnswer = true;
            }
            if (answer.equals("nao")) {
                // Leave do/while
                auxAnswer = true;
            }
            // If the answer is invalid
            if (!answer.equals("sim") && !answer.equals("nao")) {
                System.out.printf("\nOpção inválida, digite sim ou nao\n");
            }
        } while (auxAnswer == false);

        System.out.printf("\n------------------FIM DO PROGRAMA------------------\n");
        
        input.close();
        input2.close();

    }
}