package controller;

import model.Member;
import model.Type;
import persistance.Storage;
import view.MainView;
import view.MemberView;

import java.io.IOException;
import java.util.Scanner;

/**
 * A class that handles the main controller
 * @author dd222gc (Dennis Demir) & nh222mr (Nicklas Hansson) & ph222ue (Patrik Hasselblad)
 */
public class MainController {
    private final MainView mainView;
    private final MemberController memberController;
    private final BoatController boatController;
    private final Storage storage;
    private final MemberView memView;
    private Scanner sc;

    public MainController() throws IOException {
        this.mainView = new MainView();
        this.memView = new MemberView();
        this.memberController = new MemberController();
        this.storage = new Storage();
        this.boatController = new BoatController();
    }


    /**
     * Start Application method
     * @author dd222gc (Dennis Demir)
     */
    public void startMenu() {
        sc = new Scanner(System.in);

        String input;
        do {
            mainView.displayWelcomeMessage();
            input = sc.next();

            if (input == "0") {
                sc.close();
                break;
            }



            switch (input) {
                case "1":
                    compactList();
                    break;
                case "2":
                    verboseList();
                    break;
                case "3":
                    createNewMember();
                    break;
                case "4":
                    changeMemberInformation();
                    break;
                case "5":
                    deleteMember();
                    break;
                case "6":
                    viewSpecificMember();
                    break;
                case "7":
                    createBoat();
                    break;
                case "8":
                    editBoat();
                    break;
                case "9":
                    deleteBoat();
                    break;
                case "10":
                    viewBoat();
                    break;
                case "0":
                    sc.close();
                    break;
                default:
                    wrongInput(input);
            }
        } while (true);
    }

    /**
     * Method for checking that input is a number and between 1-10
     * @author dd222gc (Dennis Demir)
     */
    public void wrongInput(String input) {
        if (!input.matches("[1-10]")) {
            mainView.displayWrongInputMessage();
        }
    }

    /**
     * Method for getting member and using viewCompact to print info
     * @author dd222gc (Dennis Demir)
     */
    private void compactList() {
        storage.loadData();
        int members = this.storage.registrySize();

        for (int i = 0; i < members; i++) {
            this.memberController.viewCompact(i + 1);
        }
    }

    /**
     * Method for getting member and using viewVerbose to print info
     * @author dd222gc (Dennis Demir)
     */
    private void verboseList() {
        storage.loadData();
        int members = this.storage.registrySize();

        for (int i = 0; i < members; i++) {
            this.memberController.viewVerbose(i + 1);
        }
    }

    /**
     * Method for creating a member
     * @author dd222gc (Dennis Demir) & nh222mr (Nicklas Hansson)
     */
    public void createNewMember() {
        sc = new Scanner(System.in);

        memView.displayMemberFirstName();
        String memFirstName = sc.nextLine();

        memView.displayMemberLastName();
        String memLastName = sc.nextLine();

        memView.displayMemberPersonalNumber();
        int personalNum = sc.nextInt();

        memberController.create(memFirstName, memLastName, personalNum);
    }

    /**
     * Method to get one single member information
     * @author dd222gc (Dennis Demir)
     */
    public void viewSpecificMember() {
        sc = new Scanner(System.in);
        memView.displayMemberID();
        int memberId = sc.nextInt();

        if (memberId <= storage.getMemberList().size()) {
            this.memberController.viewCompact(memberId);
        } else {
            mainView.displayErrorMessageIfWrongUserID();
        }
    }
    //ToDo: Vi måste göra felmeddelandena aningen mer lika genom programmet.

    /**
     * Method for editing a member.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void changeMemberInformation() {
        sc = new Scanner(System.in);

        memView.displayMemberID();
        int memberId = sc.nextInt();

        memView.displayMemberFirstName();
        String memFirstName = sc.next();

        memView.displayMemberLastName();
        String memLastName = sc.next();

        memView.displayMemberPersonalNumber();
        int personalNum = sc.nextInt();

        memberController.update(memberId, memFirstName, memLastName, personalNum);
    }

    /**
     * Method for deleting a member.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void deleteMember() {
        sc = new Scanner(System.in);

        memView.displayMemberID();
        int memberId = sc.nextInt();

        memberController.delete(memberId);
    }

    /**
     * Method for creating a boat.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void createBoat() {
        sc = new Scanner(System.in);
        Type type;

        mainView.displayBoatType();
        String boatType = sc.next().toLowerCase();
        type = registerBoatType(boatType);

        mainView.displayBoatLength();
        String temp = sc.next();
        double length = Double.parseDouble(temp);

        mainView.displayBoatNumber();
        int id = sc.nextInt();

        boatController.createBoat(type, length, id);
    }

    /**
     * Method for editing an existing boat.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void editBoat() {
        sc = new Scanner(System.in);
        Type type;

        mainView.displayBoatNumber();
        int ownerId = sc.nextInt();

        mainView.displayBoatId();
        int boatId = sc.nextInt();

        mainView.displayBoatType();
        String boatType = sc.next().toLowerCase();
        type = registerBoatType(boatType);

        mainView.displayBoatLength();
        String temp = sc.next();
        double length = Double.parseDouble(temp);

        boatController.editBoat(ownerId, boatId, type, length);
    }

    /**
     * Method for deletion of a certain boat.
     */
    public void deleteBoat() {
        sc = new Scanner(System.in);

        mainView.displayBoatNumber();
        int ownerId = sc.nextInt();

        mainView.displayBoatId();
        int boatId = sc.nextInt();

        boatController.removeBoat(ownerId, boatId);
    }

    public void viewBoat() {
        sc = new Scanner(System.in);

        mainView.displayBoatNumber();
        int ownerId = sc.nextInt();
        Member member = storage.getMember(ownerId);

        mainView.displayBoatId();
        int boatId = sc.nextInt();

        mainView.displayBoatInfo(member, boatId);
    }

    /**
     * Help method to determine boat type.
     * @param boatType incoming user input.
     * @return Type
     */
    public Type registerBoatType(String boatType) {
        Type type;

        if (boatType.equals("c")) {
            type = Type.CANOE;
        } else if (boatType.equals("s")) {
            type = Type.SAILBOAT;
        } else if (boatType.equals("k")) {
            type = Type.KAYAK;
        } else if (boatType.equals("m")) {
            type = Type.MOTORSAILER;
        } else if (boatType.equals("o")) {
            type = Type.OTHER;
        } else {
            throw new IllegalStateException("Unexpected value: " + boatType);
        }

        return type;
    }
}