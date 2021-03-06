package taskFromEugene6;

import java.util.ArrayList;
import java.util.Scanner;

public class UseUserLibrary {

	private static ArrayList<UserLibrary> userLibraryList = new ArrayList<UserLibrary>();
	private static ArrayList<String> Faculty = new ArrayList<String>();
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		Faculty.add("PHYSICS");
		Faculty.add("CHEMISTRY");
		Faculty.add("HISTORY");
		Faculty.add("MATHS");
		while (true) {
			menu();
		}
	}

	public static UserLibrary enterNewUserLibrary() {
		System.out.println("Введите имя пользователя библиотеки: ");
		String name = s.nextLine();
		System.out.println("Введите фамилию пользователя библиотеки: ");
		String surname = s.nextLine();
		System.out.println("Введите отчество пользователя библиотеки: ");
		String patronymic = s.nextLine();
		System.out.println("Введите номер читательского билета пользователя библиотеки: ");
		String ticketNumber = s.nextLine();
		System.out.println("Введите дату рождения пользователя библиотеки в формате DD.MM.YYYY: ");
		String birthday = s.nextLine();
		System.out.println("Введите номер телефона пользователя библиотеки: ");
		long phoneNumber = s.nextLong();
		printFaculty();
		int facultyNumber = s.nextInt();
		String resultFaculty = Faculty.get(facultyNumber - 1);

		UserLibrary newUser = new UserLibrary(name, surname, patronymic, ticketNumber, resultFaculty, birthday,
				phoneNumber);
		s.nextLine();
		return newUser;
	}

	private static void printUsersLibrary(ArrayList<UserLibrary> userLibraryList) {
		for (UserLibrary userLibrary : userLibraryList) {
			String resultUserLibrary = usersLibraryToString(userLibrary);
			System.out.print(resultUserLibrary);
		}
	}

	private static String usersLibraryToString(UserLibrary userLibrary) {
		StringBuilder sb = new StringBuilder();
		sb.append(userLibrary.getName()).append(" ").append(userLibrary.getSurname()).append(" ")
				.append(userLibrary.getPatronymic()).append(" ").append(userLibrary.getTicketNumber()).append(" ")
				.append(userLibrary.getFaculty()).append(" ").append(userLibrary.getBirthday()).append(" ")
				.append(userLibrary.getPhoneNumber()).append("\n");
		return sb.toString();
	}

	private static void menu() {
		System.out.println("Выберите пункт меню:");
		System.out.println("1. Добавить нового пользователя библиотеки");
		System.out.println("2. Вывести на экран массив пользователей");
		System.out.println("3. Выполнить поиск с параметрами");
		System.out.println("4. Завершить выполнение программы");
		String menu1 = s.nextLine();
		switch (menu1) {
		case "1":
			userLibraryList.add(enterNewUserLibrary());
			break;
		case "2":
			printUsersLibrary(userLibraryList);
			break;
		case "3":
			System.out.println("1. Искать по фамилии");
			System.out.println("2. Искать по факультету");
			System.out.println("3. Вернуться в прошлое меню");
			System.out.println("4. Завершить выполнение программы");
			String menu2 = s.nextLine();
			ArrayList<UserLibrary> resultFind = new ArrayList<UserLibrary>();
			switch (menu2) {
			case "1":
				System.out.println("Введи фамилию:");
				String findSurname = s.nextLine();
				resultFind = findUserLibrary(findSurname, 1);
				if (resultFind != null) {
					printUsersLibrary(resultFind);
				} else {
					System.out.println("Пользователь с такой фамилией не найден");
				}
				return;
			case "2":
				printFaculty();
				int chooseFaculty = s.nextInt();
				String resultFaculty = Faculty.get(chooseFaculty - 1);
				resultFind = findUserLibrary(resultFaculty, 2);
				if (resultFind != null) {
					printUsersLibrary(resultFind);
				} else {
					System.out.println("В этом факультете нету пользователей");
				}
				return;
			case "3":
				return;
			case "4":
				exit();
				break;

			default:
				exit();
				break;
			}
		case "4":
			exit();
			break;

		default:
			exit();
			break;
		}
	}

	private static ArrayList<UserLibrary> findUserLibrary(String findValue, int сhoosingSearchOption) {
		ArrayList<UserLibrary> userLibraryListNew = new ArrayList<UserLibrary>();
		for (UserLibrary userLibrary : userLibraryList) {
			switch (сhoosingSearchOption) {
			case 1:
				if (userLibrary.getSurname().toUpperCase().equals(findValue.toUpperCase())) {
					userLibraryListNew.add(userLibrary);
				}
				break;
			case 2:
				if (userLibrary.getFaculty().toString().equals(findValue)) {
					userLibraryListNew.add(userLibrary);
				}
				break;
			}
		}
		return userLibraryListNew;
	}

	private static void exit() {
		System.out.println("Всего доброго!");
		System.exit(0);
	}

	private static void printFaculty() {
		System.out.println("Выберите факультет пользователя библиотеки: ");
		int i = 1;
		for (String faculty : Faculty) {
			System.out.println(i + ". " + faculty);
			i++;
		}
	}
}
