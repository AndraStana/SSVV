package controller;

import repository.MemberRepository;

import model.Member;
import model.Entry;
import validators.Validator;


import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemberController {
	
    private MemberRepository mr;
    private Validator validator;
    
    public MemberController(MemberRepository newMr){
    	this.mr =newMr;
    	this.validator = new Validator();
    }

    public List<Member> getAllMembers(){
        return mr.getAllMembers();
    }
    
    public void addMember(Member aMemebr) {
        if(validator.validateName(aMemebr.getName()))
        {
            mr.addMember(aMemebr);
        }
    }

    public void addEntry(Entry oneEntry) {
        mr.addEntry(oneEntry);    	
    }

     public List<Entry> allEntries() {
        
    	
        List<Entry> allE= new ArrayList<>();
        allE = this.mr.getAllEntries();
        return allE;
    }
} 