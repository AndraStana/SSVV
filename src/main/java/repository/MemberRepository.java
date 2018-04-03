package repository;

import java.io.*;

import model.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exceptions.InvalidBudgetException;
import exceptions.InvalidNameException;
import exceptions.InvalidTypeException;

public class MemberRepository {
	private List<Member> members = new ArrayList<Member>();
	private List<Entry> entries = new ArrayList<Entry>();

    private final static String filenameMember = "membersF.txt";
    private final static String filenameBudget ="budgetF.txt" ;

	@SuppressWarnings("resource")
	public MemberRepository() {
		readFromFile();

	}

    public MemberRepository(List<Member> members, List<Entry> entries) {
        this.members = members;
        this.entries = entries;
    }

    public void addMember(Member m){
		 members.add(m);
		 writeToFile(m);
	 }

	 private void writeToFile(Member m){

         try(FileWriter fw = new FileWriter(filenameMember, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw))
         {
             out.println(m.getName()+";"+m.getId());
             //more code

         } catch (IOException e) {
         }

	 }

	 private void readFromFile(){
         try{
             FileReader fileReader = null;
             BufferedReader bufferedReader = null;
             String currentLine = null;

             fileReader = new FileReader(filenameMember);
             bufferedReader = new BufferedReader(fileReader);

             while ((currentLine = bufferedReader.readLine()) != null) {
                 String line[] = currentLine.split(";");
                 Member m = new Member(line[0], Integer.parseInt(line[1]));

                 this.members.add(m);
             }
         }catch(Exception ex){
             System.err.println(ex.getMessage());

         }
         try{
             FileReader fileReaderEntry = null;
             BufferedReader bufferedReaderEntry = null;
             String currentLineEntry = null;

             fileReaderEntry = new FileReader(filenameBudget);
             bufferedReaderEntry = new BufferedReader(fileReaderEntry);

             while ((currentLineEntry = bufferedReaderEntry.readLine()) != null) {
                 String line[] = currentLineEntry.split(";");
                 if(line.length==3){
                 int valueEntry = Integer.parseInt(line[1]);
                 int idEntryMember = Integer.parseInt(line[2]);
                 Entry e = new Entry(line[0],valueEntry,idEntryMember);
                 this.entries.add(e);
                 }

             }
         }catch(Exception ex){
             System.err.println(ex.getMessage());
         }


//         try{
//             FileReader fileReader = null;
//             BufferedReader bufferedReader = null;
//             String currentLine = null;
//
//             fileReader = new FileReader(filenameBudget);
//             bufferedReader = new BufferedReader(fileReader);
//
//             while ((currentLine = bufferedReader.readLine()) != null) {
//                 String line[] = currentLine.split(";");
//                 Entry e = new Entry(line[0],Integer.parseInt(line[1]),Integer.parseInt(line[2]));
//                 this.addEntry(e);
//             }
//         }catch(Exception ex){
//             System.err.println(ex.getMessage());
//         }
//
//
//
//         try{
//             FileReader fileReaderEntry = null;
//             BufferedReader bufferedReaderEntry = null;
//             String currentLineEntry = null;
//
//             fileReaderEntry = new FileReader(filenameMember);
//             bufferedReaderEntry = new BufferedReader(fileReaderEntry);
//
//             while ((currentLineEntry = bufferedReaderEntry.readLine()) != null) {
//                 String line[] = currentLineEntry.split(";");
//                 int valueEntry = Integer.parseInt(line[1]);
//                 int idEntryMember = Integer.parseInt(line[2]);
//                 Entry e = new Entry(line[0],valueEntry,idEntryMember);
//                 this.entries.add(e);
//             }
//         }catch(Exception ex){
//             System.err.println(ex.getMessage());
//         }

     }

	 private void writeToFile(Entry e){
         try(FileWriter fw = new FileWriter( filenameBudget, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw))
         {
             out.println(e.getType()+";"+e.getValue()+";"+e.getIdMember());

         } catch (IOException ee) {
         }
     }


	 public void addEntry(Entry e){
            for( Member member : members){ // 1
                if(member.getId() == e.getIdMember()) //2
                {
                    entries.add(e);  //3
                    writeToFile(e); //3
                    break;
                }
            }


     } //4


	 public List<Entry> getAllEntries(){
		 
		 return entries;
	 }

    public List<Member> getAllMembers(){

        return members;
    }
}
