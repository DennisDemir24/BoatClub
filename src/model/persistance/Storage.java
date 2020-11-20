package model.persistance;

import model.Member;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to handle database and storage.
 * @author ph222ue (Patrik Hasselblad) & nh222mr (Nicklas Hansson)
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
     * Method that loads data from a JSON file.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void loadData() {
        File file = new File("members.json");

        try {
            members = mapper.readValue(file, new TypeReference<List<Member>>(){});
        } catch (IOException e) {
            e.printStackTrace();
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
        return new ArrayList<>(members);
    }
}