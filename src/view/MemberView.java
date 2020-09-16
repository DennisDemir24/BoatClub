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
                "First Name: " +  member.getFirstName() +  "\n" +
                        "Member ID: " +  "\n" +
                        "Number of Boats: "
        );
    }

    /**
     * Method that display the verbose list
     * @author "dd222gc Dennis Demir"
     */
    public void displayVerboseList(Member member) {
        System.out.println(
                "First Name: " +  member.getFirstName() +  "\n" +
                        "Personal Number: " +  "\n" +
                        "Member ID: " +  "\n" +
                        "Boats: " + "\n"
        );
    }


    /**
     * Method that ask for members name
     * @author "dd222gc Dennis Demir"
     */
    public void displayMemberName() {
        System.out.println("Name: ");
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
