package Assignment_lab5;

import java.io.*;
import java.util.*;
import java.util.zip.DeflaterOutputStream;

public class DoctorManager {

    private TreeMap<String, Doctor> doctorList;
    private String fname;

    public DoctorManager() {
        doctorList = new TreeMap<>();
        fname = "doctor_data.ser";
        readFile();
    }

    public void add() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter doctor ID: ");
        String id = input.nextLine();

        if (doctorList.containsKey(id)) {
            System.out.println("Doctor with ID " + id + " already exists.");
            return;
        }

        System.out.print("Enter doctor name: ");
        String name = input.nextLine();

        System.out.print("Enter doctor specialization: ");
        String specialization = input.nextLine();

        System.out.print("Enter available hours: ");
        int availHours = input.nextInt();

        Doctor doctor = new Doctor(id, name, specialization, availHours);
        doctorList.put(id, doctor);

        System.out.println("Doctor added successfully.");
    }

    public void display() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors to display.");
            return;
        }

        for (Doctor doctor : doctorList.values()) {
            System.out.println(doctor.toString());
        }
    }

    public void display(String id) {
        if (!doctorList.containsKey(id)) {
            System.out.println("Doctor with ID " + id + " not found.");
            return;
        }

        Doctor doctor = doctorList.get(id);
        System.out.println(doctor.toString());
    }

    public void readFile() {
        try {
            File file = new File(fname);

            if (file.exists()) {
                FileInputStream fileIn = new FileInputStream(fname);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                doctorList = (TreeMap<String, Doctor>) in.readObject();
                in.close();
                fileIn.close();
            }
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Doctor class not found.");
            c.printStackTrace();
        }
    }

    public void saveFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream(fname);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(doctorList);
            out.close();
            fileOut.close();
            System.out.println("Doctor data saved to " + fname);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void saveFileZip() {
        try {
            FileOutputStream fileOut = new FileOutputStream(fname + ".zip");
            DeflaterOutputStream zipOut = new DeflaterOutputStream(fileOut);
            ObjectOutputStream out = new ObjectOutputStream(zipOut);
            out.writeObject(doctorList);
            out.close();
            zipOut.close();
            fileOut.close();
            System.out.println("Doctor data saved to " + fname + ".zip");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoctorManager d = new DoctorManager();

        int choice = 0;

        do {
            System.out.println("1. Create new doctor");
            System.out.println("2. Display doctor List");
            System.out.println("3. Search doctor By Id");
            System.out.println("4. Write File.");
            System.out.println("5. Write File Zip.");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    d.add();
                    break;
                case 2:
                    d.display();
                    break;
                case 3:
                    System.out.println("Enter id: ");
                    String id = sc.nextLine();
                    d.display(id);
                    break;
                case 4:
                    d.saveFile();
                    break;
                case 5:
                    d.saveFileZip();
                    break;
                case 6:
                    System.exit(0);
                default:
                    throw new AssertionError();
            }
        } while (choice != 6);
    }
}
