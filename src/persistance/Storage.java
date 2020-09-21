package persistance;

import model.Member;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to handle database and storage.
 * @author ph222ue (Patrik Hasselblad)
 */
public class Storage {
    private ArrayList<Member> members;
    private final ObjectMapper mapper;
    private static Storage INSTANCE;

    public Storage() {
        this.members = new ArrayList<>();
        this.mapper = new ObjectMapper();
        loadData();
    }

    public static Storage getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Storage();
        }
        return INSTANCE;
    }

    /**
     * Adds a new member.
     * @exception IllegalArgumentException - is thrown if member already exists.
     * @param member Member to be added.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void addMember(Member member) {
        if (this.members.contains(member)) {
            throw new IllegalArgumentException("Member already exists.");
        }
            this.members.add(member);
    }

    /**
     * Returns the number of members.
     * @return int
     * @author ph222ue (Patrik Hasselblad)
     */
    public int registrySize() {
        return this.members.size();
    }
    public int createMemberId(int id) {
        int temp = Integer.toString(id).hashCode();
        if (temp < 0) {
            temp = temp * 2;
        }
        return temp;
    }

    /**
     * Method that alters a certain member's information.
     * @param id - The id of the member.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void editMember(int id, String fName, String lName, int socNr) {
        int memberId = createMemberId(id);
        for (int i = 0; i < members.size(); i ++) {

            if (members.get(i).getMemberId() == memberId) {
                members.remove(i);
                members.add(i, new Member(fName, lName, socNr));

            } else {
                throw new IllegalArgumentException("There is no such member registered.");
            }
        }
    }

    /**
     * Method that removes a member with a certain Id.
     * @param memberId - member Id to search for in the List.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void deleteMember(int memberId) {
        for (int i = 0; i < members.size(); i ++) {
            if (members.get(i).getMemberId() == memberId) {
                members.remove(i);
            }
        }
    }

    /**
     * Method to return a specific member.
     * @param memberId - the member sought for.
     * @return Member
     * @author ph222ue (Patrik Hasselblad)
     */
    public Member getMember(int memberId) {

        for (Member mem : members) {
            if (mem.getMemberId() == memberId) {
                return mem;
            }
        }
        return null;
    }

    /**
     * Method that loads data from a JSON file.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void loadData() {
        File file = new File("members.json");

        try {
            members = mapper.readValue(file, new TypeReference<List<Member>>(){});
        } catch (IOException e) {
            System.out.println("The database is empty.");
        }
    }

    /**
     * Method that saves member data to a JSON file.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void saveData() {
        try {
            mapper.writeValue(new File("members.json"), this.members);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to return a list of all members
     * @return ArrayList
     * @author ph222ue (Patrik Hasselblad)
     */
    public ArrayList<Member> getMemberList() {
        return members;
    }

    /**
     * Method that gets member with id from database(JSON file)
     * @author dd222gc (Dennis Demir)
     */
    public Member getSpecificMember(int index) {
        return this.members.get(index);
    }

}