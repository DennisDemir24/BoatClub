package controller;

import model.Boat;
import model.Member;
import model.Register;
import model.Type;
import view.MainView;
import view.MemberView;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that handles the main controller
 * @author dd222gc (Dennis Demir) & nh222mr (Nicklas Hansson) & ph222ue (Patrik Hasselblad)
 */
public class MainController {
    private final MainView mainView;
    private final MemberController memberController;
    private final BoatController boatController;
    private final ArrayList<Member> storage;
    private final MemberView memView;
    private final Register register;
    private Scanner sc;

    public MainController() {
        this.mainView = new MainView();
        this.memView = new MemberView();
        this.memberController = new MemberController();
        this.register = new Register();
        this.storage = register.getStorageList();
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
                    System.exit(0);
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
        int members = this.storage.size();

        for (int i = 0; i < members; i++) {
            this.memberController.viewCompact(i + 1);
        }
    }

    /**
     * Method for getting member and using viewVerbose to print info
     * @author dd222gc (Dennis Demir)
     */
    private void verboseList() {
        int members = this.storage.size();

        for (int i = 0; i < members; i++) {
            this.memberController.viewVerbose(i + 1);
        }
    }

    /**
     * Method for creating a member
     * @author dd222gc (Dennis Demir) & nh222mr (Nicklas Hansson)
     */
    private void createNewMember() {
        sc = new Scanner(System.in);
        int maxDigit = 6;

        memView.displayMemberFirstName();
        String memFirstName = sc.nextLine();

        memView.displayMemberLastName();
        String memLastName = sc.nextLine();

        memView.displayMemberPersonalNumber();
        int personalNum = sc.nextInt();

        while (String.valueOf(personalNum).length() < maxDigit || String.valueOf(personalNum).length() > maxDigit) {
            memView.displayMemberPersonalNumber();
            personalNum = sc.nextInt();
        }

        register.createNewMember(memFirstName, memLastName, personalNum);
    }

    /**
     * Method to get one single member information
     * @author dd222gc (Dennis Demir)
     */
    private void viewSpecificMember() {
        sc = new Scanner(System.in);
        memView.displayMemberID();
        int memberId = sc.nextInt();

        if (memberId > 0 && memberId <= this.storage.size()) {
            this.memView.displayCompactList(storage.get(memberId - 1));
        } else {
            memView.displayMemberIdError();
        }
    }

    /**
     * Method for editing a member.
     * @author ph222ue (Patrik Hasselblad)
     */
    private void changeMemberInformation() {
        sc = new Scanner(System.in);
        int maxDigit = 6;

        memView.displayMemberID();
        int memberId = sc.nextInt();

        memView.displayMemberFirstName();
        String memFirstName = sc.next();

        memView.displayMemberLastName();
        String memLastName = sc.next();

        memView.displayMemberPersonalNumber();
        int personalNum = sc.nextInt();

        if (memberId <= storage.size()) {
            register.updateMember(memberId, memFirstName, memLastName, personalNum);
        } else {
            mainView.displayErrorMessageIfWrongUserID();
        }

    }

    /**
     * Method for deleting a member.
     * @author ph222ue (Patrik Hasselblad)
     */
    private void deleteMember() {
        sc = new Scanner(System.in);

        memView.displayMemberID();
        int memberId = sc.nextInt();

        if (memberId <= storage.size()) {
            register.deleteMember(memberId);
        } else {
            mainView.displayErrorMessageIfWrongUserID();
        }

    }

    /**
     * Method for creating a boat.
     * @author ph222ue (Patrik Hasselblad) & dd222gc (Dennis Demir).
     */
    private void createBoat() {
        sc = new Scanner(System.in);
        Type type;

        mainView.displayBoatType();
        String boatType = sc.next().toLowerCase();
        type = registerBoatType(boatType);

        while (type == null) {
            memView.displayBoatTypeError();
            mainView.displayBoatType();
            boatType = sc.next().toLowerCase();
            type = registerBoatType(boatType);
        }

        mainView.displayBoatLength();
        String temp = sc.next();
        double length = Double.parseDouble(temp);

        mainView.displayBoatNumber();
        int id = sc.nextInt();

        if (id <= storage.size()) {
            boatController.createBoat(type, length, id);
        } else {
            mainView.displayErrorMessageIfWrongUserID();
        }

    }

    /**
     * Method for editing an existing boat.
     * @author ph222ue (Patrik Hasselblad) & dd222gc (Dennis Demir).
     */
    private void editBoat() {
        sc = new Scanner(System.in);
        Type type;

        mainView.displayBoatNumber();
        int ownerId = sc.nextInt();

        mainView.displayBoatId();
        int boatId = sc.nextInt();


        if (ownerId <= storage.size()) {
            if (boatId <= storage.get(ownerId - 1).getBoatList().size()) {

                mainView.displayBoatType();
                String boatType = sc.next().toLowerCase();
                type = registerBoatType(boatType);

                while (type == null) {
                    memView.displayBoatTypeError();
                    mainView.displayBoatType();
                    boatType = sc.next().toLowerCase();
                    type = registerBoatType(boatType);
                }

                mainView.displayBoatLength();
                String temp = sc.next();
                double length = Double.parseDouble(temp);

                boatController.editBoat(ownerId, boatId, type, length);
            } else {
                mainView.displayErrorMessageForBoatID();
            }
        } else {
            mainView.displayErrorMessageIfWrongUserID();
        }


    }

    /**
     * Method for deletion of a certain boat.
     * @author ph222ue (Patrik Hasselblad) & dd222gc (Dennis Demir).
     */
    private void deleteBoat() {
        sc = new Scanner(System.in);

        mainView.displayBoatNumber();
        int ownerId = sc.nextInt();

        mainView.displayBoatId();
        int boatId = sc.nextInt();


        if (ownerId <= storage.size()) {
            if (boatId <= storage.get(ownerId - 1).getBoatList().size()) {
                boatController.removeBoat(ownerId, boatId);

            } else {
                mainView.displayErrorMessageForBoatID();
            }
        } else {
            mainView.displayErrorMessageIfWrongUserID();
        }



    }

    /**
     * Method for viewing a certain boat.
     * @author dd222gc (Dennis Demir) & ph222ue (Patrik Hasselblad).
     */
    private void viewBoat() {
        sc = new Scanner(System.in);

        mainView.displayBoatNumber();
        int ownerId = sc.nextInt();
        Member member = storage.get(ownerId - 1);

        mainView.displayBoatId();
        int boatId = sc.nextInt();


        if (ownerId <= storage.size()) {
            if (boatId <= storage.get(ownerId - 1).getBoatList().size()) {
                Boat boat = member.getBoat(boatId);
                mainView.displayBoatInfo(member, boat);
            } else {
                mainView.displayErrorMessageForBoatID();
            }
        } else {
            mainView.displayErrorMessageIfWrongUserID();
        }
    }

    /**
     * Help method to determine boat type.
     * @author ph222ue (Patrik Hasselblad).
     * @return Type
     */
    private Type registerBoatType(String boatType) {
        Type type = null;

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
        }

        return type;
    }
}