package Tests;

import controller.MemberController;
import junit.framework.TestCase;
import model.Entry;
import model.Member;
import org.junit.Before;
import org.junit.Test;
import repository.MemberRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class IntegrationTest extends TestCase {
    private  MemberRepository repository;
    private  MemberController controller;



    @Before
    public void setUp() throws Exception {
        super.setUp();
        repository = new MemberRepository(new ArrayList<Member>(), new ArrayList<Entry> ());
        controller = new MemberController(repository);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        repository = new MemberRepository();
        controller = new MemberController(repository);

    }
@Test
public void testAddMember1() throws IOException {
    int size = controller.getAllMembers().size();

    controller.addMember(new Member("a",1));

    assertEquals(size + 1,controller.getAllMembers().size());
}



    @Test
    public void testAddEntry2() throws IOException {

        List<Member> members=  new ArrayList<>();
        members.add(new Member("name",10));

        MemberRepository repo = new MemberRepository(members , new ArrayList<Entry>());
        repo.addEntry(new Entry("cost" , 100, 10));
        assertTrue(repo.getAllEntries().size() == 1);

    }

    @Test
    public void testFilterEntry1() throws  IOException{
        controller.addMember(new Member("name",10));
        controller.addEntry(new Entry("cost" , 100, 10));
        List<Entry> list = controller.getAllEntriesForId(10);
        assertTrue(list.size()==1);


    }



    @Test
    public void testIntegration1() throws IOException {

        controller.addMember(new Member("name",10));
        assertTrue(controller.getAllMembers().size()==1);

        controller.addEntry(new Entry("cost" , 100, 10));
        assertTrue(controller.getAllEntries().size() == 1);

        List<Entry> list = controller.getAllEntriesForId(10);
        assertTrue(list.size()==1);
    }







}
