package com.example.signin.repository;

import com.example.signin.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member save);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
