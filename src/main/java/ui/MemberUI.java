package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.sun.org.apache.xpath.internal.SourceTree;
import model.*;
import controller.MemberController;;

public class MemberUI {
	public MemberController ctrl;
	Scanner in;

	public MemberUI(MemberController ctrl) {
		this.ctrl = ctrl;
		this.in = new Scanner(System.in);
	}

	public MemberController getCtrl() {
		return this.ctrl;
	}

	public Scanner getIn() {
		return this.in;
	}

	public void setCtrl(MemberController newCtrl) {
		this.ctrl = newCtrl;
	}

	public void setIn(Scanner newIn) {
		this.in = newIn;
	}

	public void printMenu() {
		String menu;
		menu = "Budget Admin Menu: \n";
		menu += "\t 1 - to add a new member; \n";
		menu += "\t 2 - to add a new income/cost; \n";
		menu += "\t 3 - to list the current income/cost; \n";
		menu += "\t 0 - exit \n";

		System.out.println(menu);
	}


	public void Run() {
		printMenu();


		int cmd = in.nextInt();
		in.nextLine();

		while (cmd != 0) {
			if (cmd == 1) {
				System.out.println("Enter name:");
				String name = in.nextLine();
				System.out.println("Enter id:");
				String id = in.nextLine();
				Member aMemebr = new Member(name, Integer.parseInt(id));
				ctrl.addMember(aMemebr);

			}
			if (cmd == 2) {

				System.out.println("Enter type:");
				String type = in.nextLine();

				System.out.println("Enter the value:");
				String valueS = in.nextLine();
				int valueInt = Integer.parseInt(valueS);

				System.out.println("Enter the id of the member:");
				String idS = in.nextLine();
				int idInt = Integer.parseInt(idS);

				Entry e = new Entry(type, valueInt, idInt);
				ctrl.addEntry(e);

			}
			if (cmd == 3) {
				System.out.println("list the current budget of a member :");

				System.out.println("Enter the id of the member:");
				String idS = in.nextLine();
				int idInt = Integer.parseInt(idS);


//				List<Entry> allE= ctrl.allEntries();
//
//
//				allE.stream().
//						filter(p -> p.getIdMember() == idInt).forEach(System.out::println);
				List<Entry> allE = ctrl.getAllEntriesForId(idInt);
				for (Entry e : allE) {
					System.out.print(e.toString());
					System.out.print('\n');


				}

			}


				printMenu();
				cmd = in.nextInt();
				in.nextLine();
			}
		}
	}


