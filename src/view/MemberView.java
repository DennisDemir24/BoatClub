package view;

import model.Member;

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
                        "Number of Boats: " + member.getBoatList()
        );
        System.out.println("*************");
    }

    /**
     * Method that display the verbose list
     * @author "dd222gc Dennis Demir"
     */
    public void displayVerboseList() {
        System.out.println(
                "First Name: " +  "" +  "\n" +
                        "Last Name: " +  "" +  "\n" +
                        "Personal Number: " +  "\n" +
                        "Member ID: " +  "\n" +
                        "Boats: " + "\n"
        );
        System.out.println("*************");
    }


    /**
     * Method that ask for members name
     * @author "dd222gc Dennis Demir"
     */
    public void displayMemberFirstName() {
        System.out.println("First Name: ");
    }

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
