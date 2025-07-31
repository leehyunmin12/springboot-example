package com.example.fisrtproject.repository;

import com.example.fisrtproject.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
