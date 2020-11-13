package model.persistance;

import model.Member;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import view.MainView;

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
    private final MainView view;

    public Storage() {
        this.members = new ArrayList<>();
        this.mapper = new ObjectMapper();
        this.view = new MainView();
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
     * @author ph222ue (Patrik Hasselblad)
     */
    public void addMember(Member member) {
        if (this.members.contains(member)) {
            throw new IllegalArgumentException();
        }

        this.members.add(member);
        saveData();
        loadData();
    }

    public void boatAction() {
        saveData();
        loadData();
    }

    /**
     * Returns the number of members.
     * @return int
     * @author ph222ue (Patrik Hasselblad)
     */
    public int registrySize() {
        return this.members.size();
    }

    /**
     * Method that creates a unique member-Id based on the members-list length.
     * @return int.
     * @author ph222ue (Patrik Hasselblad)
     */
    public int createMemberId() {
        return members.size() + 1;
    }

    /**
     * Method that alters a certain member's information.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void editMember(int id, String fName, String lName, int socNr) {

        for (Member member : members) {
            if (member.getMemberId() == id) {
                member.setFirstName(fName);
                member.setLastName(lName);
                member.setSocialSec(socNr);
                saveData();
            }
        }

    }

    /**
     * Method that removes a member with a certain Id.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void deleteMember(int id) {
        for (int i = 0; i < members.size(); i ++) {
            if (members.get(i).getMemberId() == id) {
                members.remove(i);
                for (int j = 0; j < members.size(); j++) {
                    members.get(j).adjustMemberId(j + 1);
                }
                saveData();
            }
        }
    }

    /**
     * Method to return a specific member.
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

        }
    }

    /**
     * Method that saves member data to a JSON file.
     * @author ph222ue (Patrik Hasselblad)
     */
    private void saveData() {
        try {
            mapper.writeValue(new File("members.json"), this.members);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to return a list copy of all members
     * @return ArrayList
     * @author ph222ue (Patrik Hasselblad)
     */
    public ArrayList<Member> getMemberList() {
        ArrayList<Member> listCopy = new ArrayList<>(members);

        return listCopy;
    }

    /**
     * Method that gets member with id from database(JSON file)
     * @author dd222gc (Dennis Demir)
     */
    public Member getSpecificMember(int index) {
        ArrayList<Member> listCopy = new ArrayList<>(members);

        return listCopy.get(index - 1);
    }
}