package persistance;

import model.Boat;
import model.Member;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ph222ue (Patrik Hasselblad)
 */
public class Storage {
    private ArrayList<Member> members;
    private ObjectMapper mapper;

    public Storage() {
        this.members = new ArrayList<>();
        this.mapper = new ObjectMapper();
        loadData();
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

    public void editMember(int id, Member member) {
        for (Member currentMember : members) {

            if (currentMember.getMemberId() == id) {
                int i = members.indexOf(member);
                System.out.println("A member: " + currentMember.getFirstName());
                System.out.println(i);
                currentMember.setFirstName("Rolf");
                currentMember.setLastName("Ismärla");
                this.members.set(i, currentMember);
                //saveData();
                System.out.println("Hur många: " + members.size());
            }
        }
    }

    public void deleteMember(int memberId) {

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getMember(int memberId) {

        try {


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBoat(Boat boat) {

    }

    public void editBoat(Boat boat, int memberId) {

    }

    public void deleteBoat(Boat boat, int memberId) {

    }

    /**
     * Method that loads data from a JSON file.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void loadData() {
        File file = new File("members.json");

        try {
            members = mapper.readValue(file, new TypeReference<List<Member>>(){});
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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

}