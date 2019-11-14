import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner k = new Scanner(System.in);
    private static ArrayList<Admin> adminDB = new ArrayList<>();
    private static ArrayList<Student> studentDB = new ArrayList<Student>();
    private static ArrayList<Faculty> facultyDB = new ArrayList<Faculty>();
    private static ArrayList<Class> classDB = new ArrayList<>();
    private static ArrayList<Link> linkDB = new ArrayList<>();
    public static boolean logIn = true;
    public static void main(String[] args){
        adminDB.add(new Admin("mina","mina123","mina123"));
        studentDB.add(new Student(1,"Mina","mina@gmail.com","abc"));
        studentDB.add(new Student(2,"Sarah","sarah@gmail.com","qwe"));
        studentDB.add(new Student(3,"Kim","kim@gmail.com", "poi"));
        studentDB.add(new Student(4,"Dave","dave@verizon.com", "mnb"));
        studentDB.add(new Student(5,"Jaime", "jaime@yahoo.com", "lkj"));

        facultyDB.add(new Faculty(1,1,"Victor","victor@MC.com", "vic"));
        facultyDB.add(new Faculty(2,3, "Betty", "betty@gmail.com","btc"));
        facultyDB.add(new Faculty(3,2,"jennifer", "aj@yahoo.com", "mnb"));

        classDB.add((new Class(1,"Java 1","begining Java")));
        classDB.add(new Class(2,"Java 2", "intermediate Java"));
        classDB.add(new Class(3,"python 1","beginner Python"));
        classDB.add(new Class(4,"C++" , "Advance C++"));

        linkDB.add(new Link(1,1,2,"2019"));
        linkDB.add(new Link(2,3,3,"2018"));
        user();
    }

    public static void user() {
        System.out.println("Welcome to Maryland's school system");
        System.out.println("Would you like to login? (Y/N) ");
        String a = k.next();
        if (a.equalsIgnoreCase("y")) {

            ArrayList<Admin> adminUsers = getadminUserLogin();
            if (adminUsers != null) {
                do {
                    for(Admin a1 : adminDB) {
                        System.out.println("Welcome " + a1.getName() + " !!");
                    }
                    System.out.println("please choose one of the options by entering the number: \n");
                    System.out.println("1 = Add Student\n" + "2 = Add Faculty\n" + "3 = Edit Student\n" + "4 = Edit Faculty\n"
                            + "5 = Add Class\n" + "6 = Edit Class\n" + "7 = Enroll Studnet\n" + "8 = Hire a Faculty\n" +
                            "9 = view all information\n" + "10 = to quit\n");
                    int a1 = k.nextInt();
                    k.nextLine();
                    switch (a1) {
                        case 1:
                            addStudent();
                            break;
                        case 2:
                            addFaculty();
                            break;
                        case 3:
                            editStudnet();
                            break;
                        case 4:
                            editFaculty();
                            break;
                        case 5:
                            addClass();
                            break;
                        case 6:
                            editClass();
                            break;
                        case 7:
                            enrollStudent();
                            break;
                        case 8:
                            hireFaculty();
                            break;
                        case 9:
                            viewAllInfo();
                        case 10:
                            logIn=false;
                            break;
                    }
                }
                while (logIn);
            }
            System.out.println("You have logged out");
        }

        }
    public static void addStudent() {
        System.out.println("would you like to add a new studnet? (y/n)");
        String answer = k.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            Student x = new Student();
            System.out.println("What is the name of this studnet?");
            String ans1 = k.nextLine();
            System.out.println("Student email address: ");
            String ans2 = k.nextLine();
            x.setName(ans1);
            x.setEmail(ans2);
            x.setId(studentDB.size() + 1);
            studentDB.add(x);
        }
        for (Student c : studentDB) {
            System.out.println(c.getName() + "  " + c.getId());
        }
    }
    public static void addFaculty() {
        System.out.println("would you like to add a new faculty? (y/n)");
        String answer = k.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            Faculty x = new Faculty();
            System.out.println("What is the name of this faculty?");
            String ans1 = k.nextLine();
            System.out.println("please choose a class Id that " + ans1 + " is going to teach: ");
            int ans2 = k.nextInt();
            x.setName(ans1);
            x.setClassId(ans2);
            x.setId(facultyDB.size() + 1);
            facultyDB.add(x);
        }
        for (Faculty f : facultyDB) {
            System.out.println("faculty name: " +f.getName() + "\n" + "faculty Id: " + f.getId() + "\n" + "faculty Class Id: " + f.getClassId()+ "\n");
        }
    }
    public static void editStudnet(){
        System.out.println("ID  name      email");
        for(Student s : studentDB){
            System.out.println( s.getId() + "   " + s.getName() + "      " + s.getEmail() );
        }
        System.out.println("please choose the id of the studnet you wish to edit?");
        Long a = k.nextLong();
        for(Student s: studentDB){
            if(s.getId() == a){
                System.out.println(s.getName() + "  " + s.getEmail());
                System.out.println("which information are you changing? name/email");
                String answer= k.next();
                if(answer.equalsIgnoreCase("name")){
                    System.out.println("please type in correct student name: ");
                    answer = k.next();
                    s.setName(answer);
                }
                else if(answer.equalsIgnoreCase("email")){
                    System.out.println("please tupe in the correct email address: ");
                    answer = k.next();
                    s.setEmail((answer));
                }
            }
        }
    }

    public static void addClass() {
        System.out.println("would you like to add a new class? (Y/N)");
        String answer = k.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            Class x = new Class();
            System.out.println("What is the name of this class?");
            String ans1 = k.nextLine();
            System.out.println("please type in description: ");
            String ans2 = k.nextLine();
            x.setName(ans1);
            x.setDescription(ans2);
            x.setId(classDB.size() + 1);
            classDB.add(x);
        }
    }
    public static void  editClass(){
        System.out.println("please choose the id of the class you wish to edit?");
        Long a = k.nextLong();
        for(Class s: classDB) {
            if(s.getId() == a){
                System.out.println(s.getName() + "   " + s.getDescription());
                System.out.println("Which information are you changing? name/description");
                String a1 = k.next();
                if(a1.equalsIgnoreCase("name")){
                    System.out.println("please type in correct class name: ");
                    a1 = k.next();
                    s.setName(a1);
                }
                else if(a1.equalsIgnoreCase("email")){
                    System.out.println("please type in correct class description: ");
                    a1 = k.next();
                    s.setName(a1);
                }
            }
        }
    }
    public static void enrollStudent() {
        Link l = new Link();
        System.out.println("would you like to enroll a studnet in a class? (Y/N)");
        String a = k.next();
        if (a.equalsIgnoreCase("y")) {
            viewAllInfo();
            System.out.println("please choose the id of the student you want to enroll: ");
            int i = k.nextInt();
            System.out.println("please choose a faculty id");
            int f = k.nextInt();
            System.out.println("please enter today's date: ");
            String d = k.next();
            l.setStudnetID(i);
            l.setFacultyID(f);
            l.setDate(d);
            l.setId(linkDB.size() + 1);
            linkDB.add(l);
        }
        DisplayMethod();
    }
    public static void editFaculty() {
        viewAllInfo();
        System.out.println("please choose the id of the faculty you wish to edit?");
        int a = k.nextInt();
        for (Faculty s : facultyDB) {
            if (s.getId() == a) {
                System.out.println("name: " + s.getName() + "\n" + "email: "  + s.getEmail() + "\n"+ "classId" + s.getClassId() + "\n" );
                System.out.println("which information are you changing? name/email/class");
                String answer = k.next();
                if (answer.equalsIgnoreCase("name")) {
                    System.out.println("please type in correct faculty name: ");
                    answer = k.next();
                    s.setName(answer);
                } else if (answer.equalsIgnoreCase("email")) {
                    System.out.println("please type in the correct email address: ");
                    answer = k.next();
                    s.setEmail((answer));
                }
                else if (answer.equalsIgnoreCase("class")) {
                    System.out.println("please type in the correct class ID: ");
                    int answer1 = k.nextInt();
                    s.setClassId((answer1));
                }
            }
        }
        for (Faculty s : facultyDB) {
            System.out.println("name: " + s.getName() + "\n" + "email: "  + s.getEmail() + "\n"+ "classId" + s.getClassId() + "\n" );
        }
    }
    public static void hireFaculty() {
        Faculty f = new Faculty();
        System.out.println("would you like to hire a faculty member? (Y/N");
        String a = k.next();
        if (a.equalsIgnoreCase("y")) {
            System.out.println("What is the name of faculty: ");
            a = k.next();
            System.out.println("Email address: ");
            String a1 = k.next();
            System.out.println("class ID: ");
            int answer1 = k.nextInt();
            f.setClassId(answer1);
            f.setName(a);
            f.setEmail(a1);
            f.setClassId(facultyDB.size() + 1);
            facultyDB.add(f);

        }
        for (Faculty s : facultyDB) {
            System.out.println("name: " + s.getName() + "\n" + "email: "  + s.getEmail() + "\n"+ "classId: " + s.getClassId() + "\n" );
        }
    }
    public static void viewAllInfo(){
        System.out.println("All the information: ");
        System.out.println("\n" +"ID" + "    " + "Name" + "     " + "Email" );

        for(Student s : studentDB){
            System.out.println(s.getId() +  "     " +s.getName() + "     " + s.getEmail());
        }
        System.out.println("\n" +"ID" + "    " + "Name" +"     "+ "Class Id" +"     " + "Email" );
        for(Faculty f : facultyDB){

            System.out.println(f.getId() + "     " +f.getName() + "     "+ f.getClassId() + "     " + f.getEmail() );
        }
        System.out.println("\n" +"ID" + "    " + "Name" + "     " + "Description" );
        for(Class c: classDB){

            System.out.println(c.getId() + "     " + c.getName()+ "     " + c.getDescription());
        }
    }
    private static ArrayList<Admin> getadminUserLogin(){
        ArrayList<Admin> adminUser = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String userName, password;
        String name = "";

        System.out.println("Enter Username: ");
        userName = input.nextLine();
        System.out.println("Enter password: ");
        password = input.nextLine();

        boolean validation = toValid(userName, password);
        if(validation) {
            //store the input data into arraylist
            adminUser.add(new Admin(name,userName, password));
            System.out.println("you are logged in!!!");
            return adminUser;
        } else {
            System.out.println("Invalid");
            return null;
        }
    }
    public static boolean toValid(String userName, String password){
        for(Admin sm: adminDB ) {
            if(userName.equalsIgnoreCase(sm.getUserName()) && password.equalsIgnoreCase(sm.getPassword())) {
                return true;
            }
        }
        return false;
    }
    public static void DisplayMethod() {
        for (Link l : linkDB) {
            for (Student s : studentDB) {
                if (l.getStudnetID() == s.getId()) {
                    System.out.println(s.getName());
                    break;
                }
            }
            for (Faculty p : facultyDB) {
                if (l.getFacultyID() == p.getId()) {
                    System.out.println(p.getName());
                    break;
                }
            }
            System.out.println(l.getDate() + "\n" );

        }
    }
}
