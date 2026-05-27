package com.lielion.PBL.member.repository;

import com.lielion.PBL.member.domain.role.Role;
import java.util.List;

public interface MemberRepository {
    void save(Role member);
    Role findByName(String name);
    List<Role> findAll();
    boolean existsByName(String name);
}
