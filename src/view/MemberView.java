package view;

import model.Member;

/**
 * Class that handles message displays.
 * @author "dd222gc Dennis Demir"
 */
public class MemberView {

    public MemberView() {
    }

    /**
     * Method that display the compact list
     * @author "dd222gc Dennis Demir"
     */
    public void displayCompactList(Member member) {
        System.out.println(
                "First Name: " + member.getFirstName() +  "\n" +
                        "Last Name: " +  member.getLastName() +  "\n" +
                        "Member ID: " + member.getMemberId() +  "\n" +
                        "Number of Boats: " + member.getBoatList().size()
        );
        System.out.println("*************");
    }

    /**
     * Method that display the verbose list
     * @author "dd222gc Dennis Demir"
     */
    public void displayVerboseList(Member member) {
        System.out.print(
                "First Name: " +  member.getFirstName() +  "\n" +
                        "Last Name: " +  member.getLastName() +  "\n" +
                        "Personal Number: " + member.getSocialSec() +  "\n" +
                        "Member ID: " + member.getMemberId() + "\n" +
                        "Boats: " + "\n"
        );

        if (member.getBoatList().size() > 0) {
            for (int i = 0; i < member.getBoatList().size(); i++) {
                System.out.println("\tID: " + member.getBoatList().get(i).getBoatId() + "\n" +
                        "\tType: " + member.getBoatList().get(i).getType() + "\n" +
                        "\tLength: " + member.getBoatList().get(i).getLength() + "\n"
                );
            }
        } else {
            System.out.println("\tNo boats registered\n");
        }
        System.out.println("*************");
    }

    /**
     * Method that ask for members name
     * @author "dd222gc Dennis Demir"
     */
    public void displayMemberFirstName() {
        System.out.println("First Name: ");
    }

    /**
     * Method that ask for members last name
     * @author "dd222gc Dennis Demir"
     */
    public void displayMemberLastName() {
        System.out.println("Last Name: ");
    }

    /**
     * Method that ask for members personal number / social security number
     * @author "dd222gc Dennis Demir"
     */
    public void displayMemberPersonalNumber() {
        System.out.println("Personal Number: ");
    }

    /**
     * Method that ask for members personal number / social security number
     * @author "dd222gc Dennis Demir"
     */
    public void displayMemberID() {
        System.out.println("Member ID: ");
    }

}
