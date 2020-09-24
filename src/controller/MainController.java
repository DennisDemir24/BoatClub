package controller;

import model.Member;
import model.Type;
import persistance.Storage;
import view.MainView;
import view.MemberView;

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

    public MainController() {
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

    /**
     * Method for editing a member.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void changeMemberInformation() {
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

        if (memberId <= storage.getMemberList().size()) {
            memberController.update(memberId, memFirstName, memLastName, personalNum);
        } else {
            mainView.displayErrorMessageIfWrongUserID();
        }

    }

    /**
     * Method for deleting a member.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void deleteMember() {
        sc = new Scanner(System.in);

        memView.displayMemberID();
        int memberId = sc.nextInt();

        if (memberId <= storage.getMemberList().size()) {
            memberController.delete(memberId);
        } else {
            mainView.displayErrorMessageIfWrongUserID();
        }

    }

    /**
     * Method for creating a boat.
     * @author ph222ue (Patrik Hasselblad) & dd222gc (Dennis Demir).
     */
    public void createBoat() {
        sc = new Scanner(System.in);
        Type type;

        mainView.displayBoatType();
        String boatType = sc.next().toLowerCase();
        type = registerBoatType(boatType);

        while (type == null) {
            System.out.println("Error: \"" + boatType + "\" is not a correct boat type.");
            mainView.displayBoatType();
            boatType = sc.next().toLowerCase();
            type = registerBoatType(boatType);
        }

        mainView.displayBoatLength();
        String temp = sc.next();
        double length = Double.parseDouble(temp);

        mainView.displayBoatNumber();
        int id = sc.nextInt();

        if (id <= storage.getMemberList().size()) {
            boatController.createBoat(type, length, id);
        } else {
            mainView.displayErrorMessageIfWrongUserID();
        }

    }

    /**
     * Method for editing an existing boat.
     * @author ph222ue (Patrik Hasselblad) & dd222gc (Dennis Demir).
     */
    public void editBoat() {
        sc = new Scanner(System.in);
        Type type;

        mainView.displayBoatNumber();
        int ownerId = sc.nextInt();

        mainView.displayBoatId();
        int boatId = sc.nextInt();


        if (ownerId <= storage.getMemberList().size()) {
            if (boatId <= storage.getMember(ownerId).getBoatList().size()) {

                mainView.displayBoatType();
                String boatType = sc.next().toLowerCase();
                type = registerBoatType(boatType);

                while (type == null) {
                    System.out.println("Error: \"" + boatType + "\" is not a correct boat type.");
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
    public void deleteBoat() {
        sc = new Scanner(System.in);

        mainView.displayBoatNumber();
        int ownerId = sc.nextInt();

        mainView.displayBoatId();
        int boatId = sc.nextInt();


        if (ownerId <= storage.getMemberList().size()) {
            if (boatId <= storage.getMember(ownerId).getBoatList().size()) {
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
    public void viewBoat() {
        sc = new Scanner(System.in);

        mainView.displayBoatNumber();
        int ownerId = sc.nextInt();
        Member member = storage.getMember(ownerId);

        mainView.displayBoatId();
        int boatId = sc.nextInt();


        if (ownerId <= storage.getMemberList().size()) {
            if (boatId <= storage.getMember(ownerId).getBoatList().size()) {
                mainView.displayBoatInfo(member, boatId);
            } else {
                mainView.displayErrorMessageForBoatID();
            }
        } else {
            mainView.displayErrorMessageIfWrongUserID();
        }
    }

    /**
     * Help method to determine boat type.
     * @param boatType incoming user input.
     * @author ph222ue (Patrik Hasselblad).
     * @return Type
     */
    public Type registerBoatType(String boatType) {
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