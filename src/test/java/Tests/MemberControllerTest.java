package Tests;

import com.sun.jmx.mbeanserver.Repository;
import controller.MemberController;
import junit.framework.TestCase;
import model.Member;
import org.junit.Before;
import org.junit.Test;
import repository.MemberRepository;

import java.io.IOException;

public class MemberControllerTest extends TestCase {

    private MemberController controller;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        MemberRepository repository = new MemberRepository();
        controller = new MemberController(repository);
    }

    @Test
    public void testAddMember1() throws IOException {
        int size = controller.getAllMembers().size();

        controller.addMember(new Member("a",1));

        assertEquals(size + 1,controller.getAllMembers().size());
    }

    @Test
    public void testAddMember2() throws IOException {
        int size = controller.getAllMembers().size();

        controller.addMember(new Member("a1",1));

        assertEquals(size ,controller.getAllMembers().size());
    }

    @Test
    public void testAddMember3() throws IOException {
        int size = controller.getAllMembers().size();

        controller.addMember(new Member("a;",1));

        assertEquals(size ,controller.getAllMembers().size());
    }

    @Test
    public void testAddMember4() throws IOException {
        int size = controller.getAllMembers().size();

        controller.addMember(new Member("",1));

        assertEquals(size ,controller.getAllMembers().size());
    }

    @Test
    public void testAddMember5() throws IOException {
        int size = controller.getAllMembers().size();

        controller.addMember(new Member("1",1));

        assertEquals(size ,controller.getAllMembers().size());
    }

    @Test
    public void testAddMember6() throws IOException {
        int size = controller.getAllMembers().size();

        controller.addMember(new Member(";",1));

        assertEquals(size ,controller.getAllMembers().size());
    }
    @Test
    public void testAddMember7() throws IOException {
        int size = controller.getAllMembers().size();

        controller.addMember(new Member("Florin",1));

        assertEquals(size +1 ,controller.getAllMembers().size());
    }

    @Test
    public void testAddMember8() throws IOException {
        int size = controller.getAllMembers().size();

        controller.addMember(new Member("Florin",Integer.MAX_VALUE ));

        assertEquals(size + 1  ,controller.getAllMembers().size());
    }

    @Test
    public void testAddMember9() throws IOException {
        int size = controller.getAllMembers().size();

        controller.addMember(new Member("Florin",Integer.MIN_VALUE ));

        assertEquals(size + 1  ,controller.getAllMembers().size());
    }

}
