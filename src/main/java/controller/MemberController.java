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
import java.util.stream.Collectors;

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

    public List<Entry> getAllEntries(){
        return mr.getAllEntries();
    }

    public void addEntry(Entry oneEntry) {
        mr.addEntry(oneEntry);    	
    }

     public List<Entry> allEntries() {
        
    	
        List<Entry> allE= new ArrayList<>();
        allE = this.mr.getAllEntries();
        return allE;
    }

    public List<Entry> getAllEntriesForId(int id){
        List<Entry> allE = this.mr.getAllEntries();

        List<Entry> allErr = allE.stream().
                filter(p -> p.getIdMember() == id).collect(Collectors.toList());


        return allE.stream().
						filter(p -> p.getIdMember() == id).collect(Collectors.toList());
    }




} 