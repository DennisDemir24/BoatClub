package persistance;

import model.Member;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ph222ue (Patrik Hasselblad)
 */
public class Storage {
    private ArrayList<Member> members;
    JSONArray list = new JSONArray();

    public Storage() throws IOException {
        this.members = new ArrayList<>();
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

    public void editMember(int memberID, Member member) {

    }

    public void deleteMember() {

    }

    public void getMember() {

    }

    public void addBoat() {

    }

    public void editBoat() {

    }

    public void deleteBoat() {

    }

    /**
     * Method that loads data from a JSON file.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void loadData() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("members.json")){
            Object obj = jsonParser.parse(reader);
            JSONArray memberList = (JSONArray) obj;
            System.out.println(memberList);

            memberList.forEach(mem -> parseMemberObject( (JSONObject) mem) );


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Method that saves member data to a JSON file.
     * @param member - Member details to be saved.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void saveData(Member member) {
        JSONObject memberDetails = new JSONObject();
        JSONObject members = new JSONObject();

        memberDetails.put("firstName", member.getFirstName());
        memberDetails.put("lastName", member.getLastName());
        memberDetails.put("socialSec", member.getSocialSec());
        memberDetails.put("memberId", member.getMemberId());

        members.put("member", memberDetails);

        list.add(members);

        try (FileWriter file = new FileWriter("members.json")) {

            file.write(list.toJSONString());
            file.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that parses the JSON member objects.
     * @param members - JSON member object from file.
     * @author ph222ue (Patrik Hasselblad)
     */
    private static void parseMemberObject(JSONObject members) {
        JSONObject memberObject = (JSONObject) members.get("member");

        String firstName = (String) memberObject.get("firstName");
        String lastName = (String) memberObject.get("lastName");
        long socialSec = (long) memberObject.get("socialSec");
        long memberId = (long) memberObject.get("memberId");

        System.out.println(firstName + " " + lastName + "\n" + socialSec + "\n" + memberId + "\n");
    }

}