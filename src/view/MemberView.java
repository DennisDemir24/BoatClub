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
                        "Number of Boats: " + member.getBoatListSize()
        );
        System.out.println("*************");
    }

    /**
     * Method that display the verbose list
     * @author "dd222gc Dennis Demir"
     */
    public void displayVerboseList(Member member) {
        String s = "";
        System.out.println(
                "First Name: " + member.getFirstName()  +  "\n" +
                        "Last Name: " +  member.getLastName() +  "\n" +
                        "Personal Number: " + member.getSocialSec() +  "\n" +
                        "Member ID: " + member.getMemberId() +  "\n" +
                        "Boats: " + "\n"
        );
        for (int i = 0; i < member.getBoatListSize(); i++) {
            s += "Type: " +  member.getBoatIndex(i).getType() + " - " +
                    "Length: " + member.getBoatIndex(i).getLength() + ", ";
        }
        System.out.println(s);
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
