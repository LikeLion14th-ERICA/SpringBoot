package com.lielion.PBL.member.service;

import com.lielion.PBL.member.domain.role.Role;
import com.lielion.PBL.member.repository.MemberRepository;
import java.util.List;
import org.springframework.stereotype.Service;

//@Service
public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public boolean register(Role member) {
        if (repository.existsByName(member.getName())) {
            return false;
        }
        repository.save(member);
        return true;
    }

    public Role searchByName(String name) {
        return repository.findByName(name);
    }

    public List<Role> getAllMembers() {
        return repository.findAll();
    }

    public boolean isEmpty() {
        return repository.findAll().isEmpty();
    }
}
