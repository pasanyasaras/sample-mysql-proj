package com.pasanyasara.testmysqlproj.repository;

import com.pasanyasara.testmysqlproj.model.Association;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AssociationRepository extends CrudRepository<Association,Integer> {

//    @Query("SELECT a FROM Association a WHERE a.RC_Num=?1")//where cnie_collab=<path_variable>
//    List<Association> sqlAssociationbyrc(int rc_num);

    @Query("SELECT a FROM Association a WHERE a.CNIE_Collab=?1")
    List<Association> sqlAssociationByCnie(String cnie_Collab);
}
