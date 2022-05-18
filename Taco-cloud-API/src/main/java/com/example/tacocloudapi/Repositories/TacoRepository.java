package com.example.tacocloudapi.Repositories;

import com.example.tacocloudapi.Model.Taco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacoRepository extends JpaRepository<Taco,Long> {
}
